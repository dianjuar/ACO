package MapaContexto;

import ACO.CalculosACO;
import Agentes.AgenteVirtual;
import static MapaContexto.Mapa.longitudArcoHorizontal;
import java.awt.Point;
import java.util.ArrayList;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class GrafoFeromonas //extends Thread
{
    private final ArcoGrafoFeromona grafo[][];
    private final int tamano;
    
    private final ArrayList<ArcoGrafoFeromona> listaArcosValidos;
    private final int nuemroArcosValidos;
    private final CuadroMapa mapa[][];
    
    public static final int arcoHorizontal = 0;
    public static final int arcoVertical = 1;
    public static final int arcoDiagonalPositivo = 2;
    public static final int arcoDiagonalNegativo = 3;
    
    private int acumDeltaTime;
    
    public GrafoFeromonas(int tamano, int cantidadDeHormigas, CuadroMapa mapa[][]) 
    {
        this.tamano = tamano;
        this.mapa = mapa;
        acumDeltaTime = 0;
        
        grafo = new ArcoGrafoFeromona[tamano*tamano][tamano*tamano];
        float feromonaInicial = feromonaInicial(cantidadDeHormigas);
        
        listaArcosValidos = new ArrayList<>();
        
        int idArco=0;
            for (int i = 0; i < grafo.length; i++)
            {   
                 Point a;
                
                for (int j = 0; j < grafo[0].length; j++) 
                {
                    a = obtenerPuntosDelArco(i);
                    Point b = obtenerPuntosDelArco(j);
                       
                    if(arcosValidos(a, b) && i!=j)
                    {                        
                        if(grafo[i][j]==null)
                        {
                        int tipoDeArco = tipoDeArco(a, b);
                            
                        ArcoGrafoFeromona x = new ArcoGrafoFeromona(feromonaInicial, 
                                                                    a, b,
                                                                    i,j,
                                                                    idArco++,
                                                                    tipoDeArco);    
                            
                        grafo[i][j] = x;
                        grafo[j][i] = x;            

                        listaArcosValidos.add(x);
                        
                        int direccionDelArco = posicionDelArco(a, b, tipoDeArco);
                        
                        mapa[a.y][a.x].agregarArcoVecino( new ArcoVecino(x, direccionDelArco));
                        mapa[b.y][b.x].agregarArcoVecino( new ArcoVecino(x, AgenteVirtual.girar180( direccionDelArco )));
                        }                        
                    }
                    
                    /*Collections.sort(mapa[a.y][a.x].getListaArcosVecinos(), new Comparator<ArcoVecino>() {

                        @Override
                        public int compare(ArcoVecino o1, ArcoVecino o2) {
                            return Integer.compare(o1.getDondeQueda(), o2.getDondeQueda());
                        }
                    });*/
                    
                    
                }
            }
            
                        
            nuemroArcosValidos = idArco;
            
            //start(); 
    }
    
    private Point obtenerPuntosDelArco(int idPuntoGrado)
    {
        Point p = new Point(idPuntoGrado%Mapa.longitudMapa, idPuntoGrado/Mapa.longitudMapa);
        
        return p;
    }
    
    private boolean arcosValidos(Point a, Point b)
    {
        if( mapa[b.y][b.x].isObstaculo() || mapa[a.y][a.x].isObstaculo())
            return false;
        
        if(a.x-b.x ==0  && a.y-b.y ==0)
            return false;
        
        return Math.abs(a.x-b.x)<=1 && Math.abs(a.y-b.y)<=1;
    }
        
    private int tipoDeArco(Point a, Point b)
    {
        if( Math.abs(a.x-b.x) != 0 && a.y-b.y ==0)
            return arcoHorizontal;
        
        if( Math.abs(a.y-b.y) != 0 && a.x-b.x ==0)
            return arcoVertical;
        
        if( b.x == (a.x+1) && b.y == (a.y+1) )        
        return arcoDiagonalNegativo;
        
        return arcoDiagonalPositivo;
    }
    
    private int posicionDelArco(Point a, Point b, int tipoDeArco)
    {
        switch ( tipoDeArco )
        {
            case arcoHorizontal:
                if(a.x < b.x)
                    return AgenteVirtual.este;
                else
                    return AgenteVirtual.oeste;
                
            case arcoVertical:
                if(a.y < b.y)
                    return AgenteVirtual.sur;
                else
                    return AgenteVirtual.norte;
                
            case arcoDiagonalPositivo:
                if(a.x < b.x)
                    return AgenteVirtual.noreste;
                else
                    return AgenteVirtual.suroeste;
                
            case arcoDiagonalNegativo:
                if(a.x < b.x)
                    return AgenteVirtual.sureste;
                else
                    return AgenteVirtual.noroeste;
            default:
                return -1;
        }
    }
    
    public float obtenerFeromona(int idCuadroA, int idCuadroB)
    {
        float feromona = grafo[idCuadroA][idCuadroB].getFeromona();
        
        return feromona;
    }
    
    public ArcoGrafoFeromona getArcoGrafoFeromona(int idCuadroA, int idCuadroB)
    {
        return grafo[idCuadroA][idCuadroB];
    }
    
    public void segregarFeromona(ArrayList<ArcoGrafoFeromona> arcosVisitados)
    {
        float feromonaNueva = ACO.CalculosACO.segregarFeromona( arcosVisitados);
        
        for (ArcoGrafoFeromona arcoVisitado : arcosVisitados) 
            arcoVisitado.agregarFeromona(feromonaNueva);
        
    }
    
    /** Hay una formula que recomienda cual debe ser el valor inicial de la 
     * feromonas en todo el mapa. La cual Está regida por la cantidad de hormigas
     * presentes y la longitud entre dos estaciones aleatoriamente.
     * 
     * Cuando la distancia entre los nodos es 0, al a feromona del arco se le asignará 
     * un valor muy bajo.
     */
    private float feromonaInicial(int cantidadDeHormigas)
    {        
        float feromonaInicial;
        
        if (longitudArcoHorizontal == 0)
            feromonaInicial = 0.01f;
        else
            feromonaInicial = cantidadDeHormigas / longitudArcoHorizontal;
        
        return feromonaInicial;
    }

    public int getTamano() {
        return tamano;
    }

    public ArrayList<ArcoGrafoFeromona> getListaArcosValidos() {
        return listaArcosValidos;
    }

    public int getNumeroArcosValidos() {
        return nuemroArcosValidos;
    }
    

	/***
     *
     * @param delta. Tiempo en que entró por última vez a la funcion expresado en milisegundos.
     * @throws SlickException 
     */
    public void updateFeromonas(int deltaTime) throws SlickException 
    {
    	//Acumdelta es un acumulador para saber cuando ha pasado 1 segundo
        //1000ms = 1seg
        int exedenteDeltaTime= -1;

        if(acumDeltaTime >= 1000)
    /***
     * 
     * @param delta. Tiempo en que entró por última vez a la funcion expresado en milisegundos.
     * @throws SlickException 
     */
    public void updateFeromonas(int delta) throws SlickException 
    {
        //Acumdelta es un acumulador para saber cuando ha pasado 1 segundo
        //1000ms = 1seg

        int exedenteDelta= -1;
        
        /***
         * Dado el caso que se pegue algo y demore en entrar más de 1segundo
         */
        if(acumDelta >= 1000)
        {
            exedenteDeltaTime = acumDeltaTime-1000;
            acumDeltaTime = 0;
        }
            
        for (ArcoGrafoFeromona ArcoValido : listaArcosValidos) 
        {
            ArcoValido.setDeltaFeromona( CalculosACO.evaporarFeromona( ArcoValido.getFeromona() ) );
            
            if(acumDeltaTime == 0)            
                ArcoValido.setFeromona(  ArcoValido.getDeltaFeromona()*exedenteDeltaTime/1000 );
            
            ArcoValido.setFeromona( ArcoValido.getDeltaFeromona()*deltaTime/1000 );   
            
            if(ArcoValido.getFeromona() <= 0)
                ArcoValido.setFeromona(Float.MIN_VALUE);
        }
        
        acumDeltaTime += deltaTime; 
    }
}
