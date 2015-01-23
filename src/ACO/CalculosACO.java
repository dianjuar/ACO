package ACO;

import MapaContexto.ArcoGrafoFeromona;
import MapaContexto.ArcoVecino;
import MapaContexto.Mapa;
import java.util.ArrayList;


public class CalculosACO 
{
    public static boolean debug = false;

    public static void calcularProbabilidadDelMovimiento(ArrayList<ArcoVecino> list) 
    {   
        float denominador = 0;
        float numerodores[] = new float[list.size()];
        
        for (int i = 0; i < list.size(); i++) 
        {
            numerodores[i] = (float) (Math.pow(list.get(i).getArcoVecino().getFeromona(),VariablesACO.Alfa));
            
            
            //si es un movimiento en diagonal
            if(list.get(i).getDondeQueda()%2 != 0)
                numerodores[i] = (float) (numerodores[i]
                                 *
                                 Math.pow( 1/Mapa.longitudArcoDiagonal , VariablesACO.Beta));
            else
                numerodores[i] = (float) (numerodores[i]
                                 *
                                 Math.pow( 1/Mapa.longitudArcoHorizontal , VariablesACO.Beta));
            
            
            denominador +=  numerodores[i];
        }
        
        if(debug)
            System.out.println("***************************\n***************************");
        
        for (int i = 0; i < list.size(); i++) 
        {
            list.get(i).setProbabilidad( numerodores[i] / denominador);
            
            if(debug)
            {
                System.out.println("Arco Nº:"+list.get(i).getArcoVecino().getIdArco()+" "+list.get(i).getStringDondeQueda());
                System.out.println(" -Feromona:"+list.get(i).getArcoVecino().getFeromona());
                System.out.println(" -Probabilidad:"+list.get(i).getProbabilidad());
            }
        }
    }
    
    public static float evaporarFeromona(float feromona)
    {
        feromona = (1-VariablesACO.TasaDeEvaporacionFeromona)*feromona;
  
        return feromona;
    }
    
    public static float segregarFeromona(ArrayList<ArcoGrafoFeromona> arcosRecorridos)
    {
           /* if(isHorizontal)
                feromona += VariablesACO.Q/Mapa.longitudArcoHorizontal;
            else
                feromona += VariablesACO.Q/Mapa.longitudArcoDiagonal;
        
            if (feromona > 100)
                feromona = 100;*/
        
        float acumDist = 0;
        
        for (ArcoGrafoFeromona arcoRecorrido : arcosRecorridos) 
        {
            if(arcoRecorrido.isIsHorizontalOVertical() )
                acumDist += Mapa.longitudArcoHorizontal;
            else
                acumDist += Mapa.longitudArcoDiagonal;
        }
            
        return VariablesACO.Q/acumDist;        
    }
    
}
