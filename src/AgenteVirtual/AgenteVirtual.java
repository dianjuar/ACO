package AgenteVirtual;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;
import static AgenteVirtual.AgenteVirtual.girar180;
import MapaContexto.ArcoGrafoFeromona;
import MapaContexto.ArcoVecino;
import MapaContexto.CuadroMapa;
import MapaContexto.Mapa;
import java.util.ArrayList;
import main.Game;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Point;


public class AgenteVirtual
{
   public static final int norte=0;
   public static final int noreste=1;
   public static final int este=2;
   public static final int sureste=3;   
   public static final int sur=4;
   public static final int suroeste=5;
   public static final int oeste=6;
   public static final int noroeste=7;
   
   private boolean debug = false;
   
   protected static final int rangoDeVision = 5;
   protected int mirada;
   
   protected CuadroMapa posActual;
   protected Mapa mapa;
   protected int idAgente;
   
   protected Point posCanvas;
   protected float acumDist;
   
   protected final ArrayList<ArcoGrafoFeromona> arcosVisitados;
   protected boolean estoyBuscandoLaLlegada;

   public static  float velocidad;
   
   public AgenteVirtual(int ID, float velocidad, CuadroMapa posInicial)
   {
        acumDist =0;
        
        this.mirada = -1;
        this.posActual = posInicial;
        this.mapa = Game.mapa;
        this.idAgente = ID;
        
        this.posCanvas = new Point(Game.imgResized*posActual.getX(), 
                                   Game.imgResized*posActual.getY());
        
        arcosVisitados = new ArrayList<>();
        estoyBuscandoLaLlegada = true;

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
    
    private float anguloDeVision()
    {
        return mirada*45;
    }
    
    protected boolean isVisionHorizontaloVertical()
    {
        return mirada % 2 == 0;
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
   
   protected int ValidarCampoDeVision(int posibleVision)
   {
        switch (posibleVision)
           {
               case -2:
                   posibleVision = oeste;
               break;
                   
               case -1:
                   posibleVision = noroeste;
               break;
                   
               case 8:
                   posibleVision = norte;
               break;    
           }
       
       return posibleVision;
   }
    
    private ArrayList<ArcoVecino> getPosiblesArcos()
    {
        if(mirada == -1)
            return posActual.getListaArcosVecinos();
        
        ArrayList<ArcoVecino> ret = new ArrayList<>();
        
        
        for (int i = 0, posibleDireccion = mirada-(rangoDeVision/2) ; i < rangoDeVision; i++, posibleDireccion++) 
        {
           posibleDireccion = ValidarCampoDeVision(posibleDireccion);   
           
                for (int j = 0; j < posActual.getListaArcosVecinos().size(); j++)
                {
                    if(posActual.getListaArcosVecinos().get(j).getDondeQueda() == posibleDireccion)
                    {
                        ret.add( posActual.getListaArcosVecinos().get(j) ); 
                        break;
                    }
                }   
        }

        return ret;
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
    
    private void caminarYdepositar(int mirada)
    {
        this.mirada = mirada;
        CuadroMapa proximoMovimiento = haciaDondeLlegoSiAvanzoEnXDireccion(mirada);
        arcosVisitados.add( mapa.getGrafoFeromonas().getArcoGrafoFeromona(proximoMovimiento.getID(), posActual.getID()) );
        posActual = proximoMovimiento;          
    }
    
    private void depositarFeromona()
    {
       mapa.getGrafoFeromonas().segregarFeromona( arcosVisitados );
       arcosVisitados.clear();
    }
    
       //simplemente si llego al punto destino girar 180°
   private void AlternarPuntoObjetivo()
   {
       if(estoyBuscandoLaLlegada && posActual.isFin())
       {
           depositarFeromona();
           girar180(mirada);
           estoyBuscandoLaLlegada = !estoyBuscandoLaLlegada;
       }
       else
       {
           if(!estoyBuscandoLaLlegada && posActual.isInicio())
           {
               depositarFeromona();
               girar180(mirada);
               estoyBuscandoLaLlegada = !estoyBuscandoLaLlegada;
           }
       }
   }
    
   private CuadroMapa haciaDondeLlegoSiAvanzoEnXDireccion(int mirada)
   {
       CuadroMapa posibleMovimiento = null;
       
       try 
       {
            switch (mirada)
            {
               case norte:
                  posibleMovimiento = mapa.getMapa()[posActual.getY()-1][posActual.getX()];
               break;

               case sur:
                   posibleMovimiento  = mapa.getMapa()[posActual.getY()+1][posActual.getX()];
               break;

               case este:
                   posibleMovimiento = mapa.getMapa()[posActual.getY()][posActual.getX()+1];
               break;

               case oeste:
                   posibleMovimiento = mapa.getMapa()[posActual.getY()][posActual.getX()-1];
               break;

               case noreste:
                   posibleMovimiento = mapa.getMapa()[posActual.getY()-1][posActual.getX()+1];
               break;

               case noroeste:
                   posibleMovimiento = mapa.getMapa()[posActual.getY()-1][posActual.getX()-1];
               break;

               case sureste:
                   posibleMovimiento  = mapa.getMapa()[posActual.getY()+1][posActual.getX()+1];
               break;

               case suroeste:
                   posibleMovimiento  = mapa.getMapa()[posActual.getY()+1][posActual.getX()-1];
               break;
               
            } 
       } 
       catch (ArrayIndexOutOfBoundsException e) 
       {
           return null;
       }
       
       //System.out.println(getName()+" - "+mirada);
       
       if(posibleMovimiento.isObstaculo())
           return null;
       
       return posibleMovimiento;
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