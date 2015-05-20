package Agentes;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;
import static Agentes.AgenteVirtual.girar180;
import MapaContexto.ArcoGrafoFeromona;
import MapaContexto.ArcoVecino;
import MapaContexto.CuadroMapa;
import MapaContexto.Mapa;
import java.util.ArrayList;
import main.Game;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Point;


public class AgenteVirtual extends Agente
{  
   
   
   protected float acumDist;
   

   public static float velocidad;
   
   public AgenteVirtual(int ID, float velocidad, CuadroMapa posInicial, int mirada)
   {    
        super(ID, posInicial, mirada);

       acumDist = 0;
       this.velocidad = velocidad;
       
       Avanzar();
   }
   
   public void render(Image Agente, float imgResized, float imgScale) throws SlickException 
    {
        Agente.setCenterOfRotation( Agente.getWidth()*imgScale/2, Agente.getWidth()*imgScale/2);
        
        Agente.setRotation( anguloDeVision() );
        
        Agente.draw(posCanvas.getX(), posCanvas.getY(), 
                    imgScale);        
    }
    
   public static int girar180(int mirada)           
   {
       switch (mirada)
        {
            case sur:
                mirada = norte;
            break;

            case suroeste:
                mirada = noreste;
            break;

            case oeste:
                mirada = este;
            break;

            case noroeste:
                mirada = sureste;
            break;

            default:
                mirada += 4;
            break;
        }
       
       return mirada;
   }
    
   
   
    /** Esta funcion rectifica el campo de vision cuando se hacen los calculos 
    de manera que no aprezcan resultados no comprendido*/
    protected void Avanzar()
    {        
        ArrayList<ArcoVecino> posiblesCaminos = getPosiblesArcos();
        
        if(posiblesCaminos.isEmpty())            
        {
            caminarYdepositar(girar180(mirada));
        }
        else        
        {
            if(posiblesCaminos.size() == 1)
            {
                caminarYdepositar(posiblesCaminos.get(0).getDondeQueda());
            }
            else
            {
               ACO.CalculosACO.calcularProbabilidadDelMovimiento(posiblesCaminos);

               
               float lineaDeProb[] = new float[posiblesCaminos.size()-1];       

               for (int i = 0; i < lineaDeProb.length; i++) 
               {
                   for (int j = i; j >= 0; j--)
                   lineaDeProb[i] += posiblesCaminos.get(j).getProbabilidad();
               }

               float NumeroAleatorio = (float) (Math.random()*1);

                if(ACO.CalculosACO.debug)
                    System.out.println("------"+NumeroAleatorio);
                
               for (int i = 0; i < lineaDeProb.length; i++) 
               {
                    if(i==0 && NumeroAleatorio < lineaDeProb[i])
                    {   
                       caminarYdepositar(posiblesCaminos.get(i).getDondeQueda());
                       //AlternarPuntoObjetivo();
                    }
                    else
                    {
                        if(i== lineaDeProb.length - 1 &&  NumeroAleatorio >= lineaDeProb[i] )
                        {
                           caminarYdepositar(posiblesCaminos.get( posiblesCaminos.size()-1 ).getDondeQueda());
                           //AlternarPuntoObjetivo();
                        }
                        else
                        {
                            if( NumeroAleatorio >= lineaDeProb[i] && NumeroAleatorio < lineaDeProb[i+1] )
                            {
                                caminarYdepositar(posiblesCaminos.get(i+1).getDondeQueda());
                                //AlternarPuntoObjetivo();
                            }
                        }
                    }
               }    
            }
        }
        
        AlternarPuntoObjetivo();
    }
    
    
    
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException
    {
        
        float dis = distanciaAvanzada(delta);
        acumDist += dis;    
        
        switch (mirada)
        {
           case norte:
              posCanvas.setY( posCanvas.getY()-dis);
           break;

           case sur:
               posCanvas.setY( posCanvas.getY()+dis);
           break;

           case este:
               posCanvas.setX( posCanvas.getX()+dis);
           break;

           case oeste:
               posCanvas.setX( posCanvas.getX()-dis);
           break;

           case noreste:
               posCanvas.setY( posCanvas.getY()-dis );
               posCanvas.setX( posCanvas.getX()+dis );
           break;

           case noroeste:
               posCanvas.setY( posCanvas.getY()-dis );
               posCanvas.setX( posCanvas.getX()-dis);
           break;

           case sureste:
               posCanvas.setY( posCanvas.getY()+dis);
               posCanvas.setX( posCanvas.getX()+dis );
           break;

           case suroeste:
               posCanvas.setY( posCanvas.getY()+dis);
               posCanvas.setX( posCanvas.getX()-dis);
           break;
        } 
        
        if( isVisionHorizontaloVertical() )
        {
            if( acumDist >= Mapa.longitudArcoHorizontal*(Game.imgResized/Mapa.longitudArcoHorizontal))
            {
                acumDist =0;
                
                if(mirada == norte || mirada == sur)                
                    posCanvas.setY( posActual.getY()*Game.imgResized );
                else
                    posCanvas.setX( posActual.getX()*Game.imgResized );
                
             Avanzar();
                
            }
        }
        else
        {
            if( acumDist >= Mapa.longitudArcoDiagonal*(Game.imgResized/Mapa.longitudArcoDiagonal) )
            {
                acumDist =0;
                
                posCanvas.setY( posActual.getY()*Game.imgResized );
                posCanvas.setX( posActual.getX()*Game.imgResized );
                
                Avanzar();
            }
        }
        
        
    }

   private float distanciaAvanzada(int delta)
   {
       if(!isVisionHorizontaloVertical())
            return (velocidad * delta/1000)* (Game.imgResized/Mapa.longitudArcoDiagonal);
       
       return (velocidad * delta/1000)* (Game.imgResized/Mapa.longitudArcoHorizontal);
   }
  
   
}