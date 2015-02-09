/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Networking;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author diego_juliao
 */
public class ResepcionMapa extends DataRecibe
{
    private int INT_mat[][];
    private JLabel etapa;

    public ResepcionMapa(JLabel etapa) 
    {
        super(Puertos.mapaRecibe, "Recepción del mapa por parte del modulo de visión artificial");
        
        this.etapa = etapa;
    }

    @Override
    public void AnalizadorDeMensajes(String msj) 
    {
        construir_IntMat(msj);
                 
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
