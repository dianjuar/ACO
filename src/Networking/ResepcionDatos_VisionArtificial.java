/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Networking;

import Networking.base.DataServer;
import Networking.base.Encabezado_Mensajes;
import Networking.base.Puertos;
import javax.swing.JLabel;
import main.InicioRobots;

/**
 *
 * @author diego_juliao
 */
public class ResepcionDatos_VisionArtificial extends DataServer
{
    private int INT_mat[][];
    private float distanciaEntreCuadros;
    private JLabel etapa;
    
    private static final String Prefijo_Mat = "Mat";
    private static final String Prefijo_Dist = "Dist";
    
    InicioRobots i;
    
    
    public ResepcionDatos_VisionArtificial(JLabel etapa, InicioRobots i) 
    {
        super(Puertos.Recibe_sistemaVisionAritificial, "Recepción del mapa y distancia entre cuadros por parte del modulo de visión artificial");
        
        this.etapa = etapa;
        this.i = i;
    } 
   
    @Override
    public void AnalizadorDeMensajesSERVER(String msj) 
    {
        String vec[] = msj.split( Encabezado_Mensajes.Msj_divisor );
        
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
        
        cerrarConexioServer();
        
        construir_IntMat(Mat);
        distanciaEntreCuadros = Float.valueOf(dist);
        
        System.out.println(INT_mat);
        System.out.println("****************");
        System.out.println(distanciaEntreCuadros);
          
        Tools.GestionLabels.CambiarLabel_correcto25x25(etapa);
        i.faseCompletada();
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
