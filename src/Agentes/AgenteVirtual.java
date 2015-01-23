package Agentes;

import static Agentes.Agente.este;
import static Agentes.Agente.noreste;
import static Agentes.Agente.noroeste;
import static Agentes.Agente.norte;
import static Agentes.Agente.oeste;
import static Agentes.Agente.sur;
import static Agentes.Agente.sureste;
import static Agentes.Agente.suroeste;
import MapaContexto.CuadroMapa;
import MapaContexto.Mapa;
import main.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;


public class AgenteVirtual extends Agente
{
   public static float velocidad;//se mide en metros por segundo (m/s)

   
   public AgenteVirtual(int ID, float velocidad, CuadroMapa posInicial)
   {
       super(ID, posInicial);       

       acumDist = 0;
       this.velocidad = velocidad;
       
       Avanzar();
   }
     
   /** Devuelve true si el camino escojido es horizontal y false si es diagonal */
   /*private void Avanzar()
   {
       Movimiento posiblesMovimientos[] = new Movimiento[rangoDeVision];
       
       for (int i = 0, posibleDireccion = mirada-(rangoDeVision/2) ; i < rangoDeVision; i++, posibleDireccion++) 
       {
           posibleDireccion = ValidarCampoDeVision(posibleDireccion);   
           
           float feromonaDelposibleMov =  FeromonaDelPosibleMovimiento(posibleDireccion);
                    
           if(feromonaDelposibleMov != -1)
           posiblesMovimientos[i] = new Movimiento(posibleDireccion, feromonaDelposibleMov);           
       }
       
           posiblesMovimientos = purgarPosiblesMovimientos(posiblesMovimientos);
           
           if(posiblesMovimientos.length ==0)//callejón sin salida
              mirada = girar180(mirada);
           else
           {
                ACO.CalculosACO.calcularProbabilidadDelMovimiento(posiblesMovimientos);

                mirada = EscojerCamino(posiblesMovimientos);
                CuadroMapa proximoMovimiento = haciaDondeLlegoSiAvanzoEnXDireccion(mirada);

                depositarFeromona(posActual,proximoMovimiento, mirada % 2 == 0);

                posActual = proximoMovimiento;
                AlternarPuntoObjetivo();
           }    
   }
   
   private Movimiento[] purgarPosiblesMovimientos(Movimiento vec[])           
   {
       Movimiento vectorPurgado[];
       
       int posicionesValidas=0;
       
       for (int i = 0; i < vec.length; i++) 
       {
           if(vec[i]!=null)
               posicionesValidas++;
       }
       
       vectorPurgado = new Movimiento[posicionesValidas];
       
       for (int i = 0, j=0; i < vec.length; i++) 
       {
            if(vec[i]!=null)
            {
               vectorPurgado[j++]=vec[i];
            }
       }
       
      return vectorPurgado;
   }
  

   
   /** Retorna hacia donde debe ir*/
 /*  private int EscojerCamino(Movimiento posiblesMovimientos[])
   {
       if(posiblesMovimientos.length == 1)
           return posiblesMovimientos[0].getDireccion();       
       
       MetodosDeOrdenamiento<Movimiento> inserSort = new MetodosDeOrdenamiento( posiblesMovimientos ) 
       {
           @Override
           public boolean menorQue(Object temp, Object vec) 
           {
               Movimiento a = (Movimiento) temp;
               Movimiento b = (Movimiento) vec;
               
               return a.getProbabilidad() < b.getProbabilidad();
           }
       };
              
       //aqui se ordenan las probabilidades
       inserSort.InsertionSort();
       
       float lineaDeProb[] = new float[posiblesMovimientos.length-1];       
       
       for (int i = 0; i < lineaDeProb.length; i++) 
       {
           for (int j = i; j >= 0; j--)
           lineaDeProb[i] += posiblesMovimientos[j].getProbabilidad();
       }
       
       float NumeroAleatorio = (float) (Math.random()*1);
       
       for (int i = 0; i < lineaDeProb.length; i++) 
       {
            if(i==0 && NumeroAleatorio < lineaDeProb[i])
            {
               return  posiblesMovimientos[i].getDireccion();
            }
            else
            {
                if(i== lineaDeProb.length - 1 &&  NumeroAleatorio >= lineaDeProb[i] )
                    return posiblesMovimientos[i].getDireccion();
            }
           
            if( NumeroAleatorio >= lineaDeProb[i] && NumeroAleatorio < lineaDeProb[i+1] )
                return posiblesMovimientos[i+1].getDireccion();           
       }
       
        return -1;
    }
 */

   
   /** si esta fuoncion retorna -1 quiere decir que no se puede dirigir hacia ese destino,
    ya sea xq hay un obstáculo o está fuera de los límites*/
   /*private float FeromonaDelPosibleMovimiento(int posibleVision)
   {
       float feromona = -1;
       CuadroMapa posMov = haciaDondeLlegoSiAvanzoEnXDireccion(posibleVision);
       
       if(posMov != null )       
           feromona = mapa.getGrafoFeromonas().obtenerFeromona(posActual.getID(), posMov.getID());
       
       return feromona;
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
   */

   
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
   
   
   
   
  /* public void run()
   {
       while (true) 
       {           
          boolean isHorizontal = Avanzar();
          
          int tiempo;
          
          if( isHorizontal )         
            tiempo = (int) ((Mapa.longitudArcoHorizontal/velocidad)*1000);
          else
            tiempo = (int) ((Mapa.longitudArcoHorizontal/velocidad)*1000);
          
              
           System.out.println(tiempo);
           try {
               Thread.sleep(tiempo);
           } catch (InterruptedException ex) {
               Logger.getLogger(AgenteVirtual.class.getName()).log(Level.SEVERE, null, ex);
           }
           
       }
      
   }*/

   
   
}


