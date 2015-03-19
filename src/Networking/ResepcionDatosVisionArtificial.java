/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Networking;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author diego_juliao
 */
public class ResepcionDatosVisionArtificial extends DataRecibe
{
    private int INT_mat[][];
    private float distanciaEntreCuadros;
    private JLabel etapa;
    
    private String Prefijo_Mat;
    private String Prefijo_Dist;
    
    public ResepcionDatosVisionArtificial(JLabel etapa) 
    {
        super(Puertos.Recibe_sistemaVisionAritificial, "Recepción del mapa y distancia entre cuadros por parte del modulo de visión artificial");
        
        Prefijo_Dist = "Dist";
        Prefijo_Mat = "Mat";
        
        this.etapa = etapa;
    }

    @Override
    public void AnalizadorDeMensajes(String msj) 
    {
        String vec[] = msj.split( Msjdivisor );
        
        String Mat,dist;
        
        if(vec[0].contains(Prefijo_Mat) == true)
        {
            Mat = vec[0].split(Prefijo_Mat)[1];
            dist = vec[1].split(Prefijo_Dist)[1];
        }
        else
        {
            Mat = vec[1].split(Prefijo_Mat)[1];
            dist = vec[0].split(Prefijo_Dist)[1];
        }
        
        construir_IntMat(Mat);
        distanciaEntreCuadros = Float.valueOf(dist);
        
        System.out.println(INT_mat);
        System.out.println("****************");
        System.out.println(distanciaEntreCuadros);
          
        etapa.setIcon( new ImageIcon("../../../src/Media/Img/cargado.png") );
    }   
    
    
    private void construir_IntMat(String sMat)
    {
        String fila[],columna[];
        
        int j,n;        
        fila=sMat.split("\n");
        n=fila.length;
        
        INT_mat = new int[n][n];
        
        for (int i = 0; i < n; i++)        
            for (columna = fila[i].split(""), j= 0; j < columna.length; j++) 
                INT_mat[i][j] = columna[j].charAt(0) - 48;
    }

}