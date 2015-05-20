/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agentes;

import static Agentes.AgenteVirtual.girar180;
import MapaContexto.ArcoGrafoFeromona;
import MapaContexto.ArcoVecino;
import MapaContexto.CuadroMapa;
import MapaContexto.Mapa;
import java.util.ArrayList;
import main.Game;
import org.newdawn.slick.geom.Point;

/**
 *
 * @author diego_juliao
 */
public class Agente 
{
    public static final int norte=0;
    public static final int noreste=1;
    public static final int este=2;
    public static final int sureste=3;   
    public static final int sur=4;
    public static final int suroeste=5;
    public static final int oeste=6;
    public static final int noroeste=7;
    
    protected static final int rangoDeVision = 5;
    
    protected int idAgente;
    protected boolean estoyBuscandoLaLlegada;
    
    protected int mirada;
    
    protected final ArrayList<ArcoGrafoFeromona> arcosVisitados;
    
   protected CuadroMapa posActual;
   
   protected Mapa mapa;
   
   
   protected Point posCanvas;

    
    public Agente(int ID, CuadroMapa posInicial, int mirada)
    {
        
        this.posCanvas = new Point(Game.imgResized*posActual.getX(), 
                                   Game.imgResized*posActual.getY());
        
        
        arcosVisitados = new ArrayList<>();
        
        estoyBuscandoLaLlegada = true;
        this.posActual = posInicial;
        
        this.idAgente = ID;
        this.mirada = mirada;
        
        this.mapa = Game.mapa;
    }
    
    protected float anguloDeVision()
    {
        return mirada*45;
    }
    
    protected boolean isVisionHorizontaloVertical()
    {
        return mirada % 2 == 0;
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
    
    protected CuadroMapa haciaDondeLlegoSiAvanzoEnXDireccion(int mirada)
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
    
     protected ArrayList<ArcoVecino> getPosiblesArcos()
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
    
    protected void caminarYdepositar(int mirada)
    {
        this.mirada = mirada;
        CuadroMapa proximoMovimiento = haciaDondeLlegoSiAvanzoEnXDireccion(mirada);
        arcosVisitados.add( mapa.getGrafoFeromonas().getArcoGrafoFeromona(proximoMovimiento.getID(), posActual.getID()) );
        posActual = proximoMovimiento;          
    }
    
    protected void depositarFeromona()
    {
       mapa.getGrafoFeromonas().segregarFeromona( arcosVisitados );
       arcosVisitados.clear();
    }
    
       //simplemente si llego al punto destino girar 180°
   protected void AlternarPuntoObjetivo()
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
    
}
