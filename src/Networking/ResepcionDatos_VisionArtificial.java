/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Networking;

import Networking.base.DataServer;
import Networking.base.Encabezado_Mensajes;
import Networking.base.Puertos;
//import Networking.base.Puertos;
import javax.swing.JLabel;
import main.InicioRobots_RecepsionDeDatos;

/**
 *
 * @author diego_juliao
 */
public class ResepcionDatos_VisionArtificial extends DataServer
{
    private int INT_mat[][];
    private float distanciaEntreCuadros;
    private JLabel etapa;
    
    private InicioRobots_RecepsionDeDatos recepsionDeDatos;
    
    private String infoMap;

    public int[][] getINT_mat() {
        return INT_mat;
    }

    public float getDistanciaEntreCuadros() {
        return distanciaEntreCuadros;
    }    
    
    public ResepcionDatos_VisionArtificial(JLabel etapa, InicioRobots_RecepsionDeDatos i) 
    {
        super(Puertos.Recibe_sistemaVisionAritificial, "Recepción del mapa y distancia entre cuadros por parte del modulo de visión artificial");
        
        this.etapa = etapa;
        this.recepsionDeDatos = i;
    } 
   
    @Override
    public void AnalizadorDeMensajesSERVER(String msj) 
    {
        String vec[] = msj.split( Encabezado_Mensajes.Msj_divisor );
        
        String Mat,dist;
        
        Mat = vec[0];
        dist = vec[1];
      
        cerrarConexioServer();
        
        construir_IntMat(Mat);
        distanciaEntreCuadros = Float.valueOf(dist);
        
        infoMap = msj;
        
        if(recepsionDeDatos.cSMA.isConnected())
            recepsionDeDatos.cSMA.enviarInformacionEntornoGrafico(msj);
        else
            recepsionDeDatos.cSMA.setInforGrafica(infoMap);
        
        System.out.println(INT_mat);
        System.out.println("****************");
        System.out.println(distanciaEntreCuadros);
          
        Tools.GestionLabels.CambiarLabel_correcto25x25(etapa);
        recepsionDeDatos.faseCompletada();
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
