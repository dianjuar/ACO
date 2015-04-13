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
public class Conexion_SMA extends DataServer
{
    private JLabel estado;
    InicioRobots i;
    
    private int Nagentes;
    private float maxVel;
    
    public Conexion_SMA(JLabel estado, InicioRobots i) 
    {
        super(Puertos.Recibe_SMA, "conexion con SMA");
        this.estado = estado;
        
        this.i = i;
    }

    @Override
    public void AnalizadorDeMensajesSERVER(String msj) 
    {  
        String encabezado = msj.split( Encabezado_Mensajes.Msj_divisor )[0];
        String cuerpo = msj.split( Encabezado_Mensajes.Msj_divisor )[1];

        if( encabezado.equals( Encabezado_Mensajes.Msj_PInicio_SMAtoACO ) )
        {
            String vec[] = cuerpo.split( Encabezado_Mensajes.Msj_divisor_2 );

            System.out.println(cuerpo);
            System.out.println(vec[0]);
            System.out.println(vec[1]);

            if(vec[0].contains(Encabezado_Mensajes.Msj_PInicio_SMAtoACO_HowMany))
            {
                Nagentes = Integer.valueOf(vec[0].split( Encabezado_Mensajes.Msj_PInicio_SMAtoACO_HowMany )[1]);
                maxVel = Float.valueOf(vec[1].split( Encabezado_Mensajes.Msj_PInicio_SMAtoACO_VelMax )[1]);
            }
            else
            {
                Nagentes = Integer.valueOf(vec[1].split( Encabezado_Mensajes.Msj_PInicio_SMAtoACO_HowMany )[1]);
                maxVel = Float.valueOf(vec[0].split( Encabezado_Mensajes.Msj_PInicio_SMAtoACO_VelMax )[1]);
            } 

            Tools.GestionLabels.CambiarLabel_correcto25x25(estado);
            i.faseCompletada();
        }
        
        
    }

    public int getNagentes() {
        return Nagentes;
    }

    public float getMaxVel() {
        return maxVel;
    }
    
}