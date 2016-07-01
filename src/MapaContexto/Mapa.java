package MapaContexto;

import java.util.ArrayList;
import java.util.List;

public class Mapa
{
    private CuadroMapa mapa[][];
    public static int longitudMapa;
    
    private GrafoFeromonas grafoFeromonas;
    
    
    private final int width, height; 
   
    public static final int libre=0;
    public static final int obstaculo=1;   
    public static final int inicio=2;
    public static final int fin=3;
   
    public static float longitudArcoHorizontal, longitudArcoDiagonal;

    public static CuadroMapa cuadroInicial, cuadroFinal;
   
    
    public Mapa( int mat[][])
    {
        this.longitudMapa = mat.length;
               
        this.width = mat.length;
        this.height = mat[0].length;
        
        inicializarMapa(mat);
        
    }
    

    public static void setLongitudArcoHorizontal(float longitudArcoHorizontal) 
    {
        Mapa.longitudArcoHorizontal = longitudArcoHorizontal;
        
        //Ecuación de pitagoras para hayar la hipotenusa.
        longitudArcoDiagonal = (float) Math.sqrt( Math.pow(longitudArcoHorizontal,2) +
                                                  Math.pow(longitudArcoHorizontal,2) );
    }
    
    public void inicializarGrafoFeromonas(int cantidadDeAgentes)
    {
        grafoFeromonas = new GrafoFeromonas(mapa.length,  cantidadDeAgentes, mapa);
        
        //prueba();
    }
     
    private void inicializarMapa(int mat[][])
    {
        mapa = new CuadroMapa[height][width];
        
        for (int i = 0, id=0; i < height; i++)  
        {
            for (int j = 0; j < width; j++)  
            {
                mapa[i][j] = new CuadroMapa(mat[i][j],j, i, id++);
                
                if(mat[i][j]==inicio)
                    cuadroInicial = mapa[i][j];
                else if(mat[i][j]==fin)
                    cuadroFinal = mapa[i][j];
            }
        }
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }

    public CuadroMapa[][] getMapa() {
        return mapa;
    }

    public GrafoFeromonas getGrafoFeromonas() {
        return grafoFeromonas;
    }
        
    public CuadroMapa getCuadro(int i, int j)
    {
        return mapa[i][j];
    }
    
    private void imprimirArcosVecinos()
    {
        for (CuadroMapa[] cuadroArr : mapa) 
        {
            for (CuadroMapa cuadro : cuadroArr) 
            {
                if(!cuadro.isObstaculo())
                {
                    System.out.println("---------------------------");
                    System.out.println("Punto A:"+cuadro.getID());

                    for (int i = 0; i < cuadro.getListaArcosVecinos().size(); i++) 
                    {
                        System.out.print(cuadro.getListaArcosVecinos().get(i).getArcoVecino().getIdPuntoA()+"-");
                        System.out.print(cuadro.getListaArcosVecinos().get(i).getArcoVecino().getIdPuntoB()+" : ");
                        System.out.print( cuadro.getListaArcosVecinos().get(i).getStringDondeQueda()+"-" );
                    System.out.println(cuadro.getListaArcosVecinos().get(i).getDondeQueda());
                    }
                }
            }
        }
    }
    
}
