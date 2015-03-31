/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Networking;

import Networking.base.DataServer;
import Networking.base.Encabezado_Mensajes;
import Networking.base.Puertos;
import main.InicioRobots;
import javax.swing.JLabel;

/**
 *
 * @author diego_juliao
 */
public class Connect_SMA extends DataServer
{
    private JLabel estado;
    InicioRobots i;
    
    public Connect_SMA(JLabel estado, InicioRobots i) 
    {
        super(Puertos.Recibe_SMA, "conexion con SMA");
        this.estado = estado;
        
        this.i = i;
    }

    @Override
    public void AnalizadorDeMensajesSERVER(String msj) 
    {
        if(msj.equalsIgnoreCase(Encabezado_Mensajes.Msj_conectado) )  
        {
            Tools.GestionLabels.CambiarLabel_correcto25x25(estado);
            i.faseCompletada();
        }
        
    }
    
}
