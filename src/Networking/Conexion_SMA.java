/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Networking;

import Agentes.AgenteFisico;
import Networking.base.DataServer;
import Networking.base.Encabezado_Mensajes;
import Networking.base.Puertos;
import main.InicioRobots_RecepsionDeDatos;
import javax.swing.JLabel;
import main.FormRobots;

/**
 *
 * @author diego_juliao
 */
public class Conexion_SMA extends DataServer
{
    private JLabel estado;
    InicioRobots_RecepsionDeDatos recepsionDeDatos;
    
    private int Nagentes;
    private float VelocidadMaxima;
    private float VelocidadInicial;
    
    public Conexion_SMA(JLabel estado, InicioRobots_RecepsionDeDatos i) 
    {
        super(Puertos.Recibe_SMA, "conexion con SMA");
        
        this.estado = estado;        
        this.recepsionDeDatos = i;
    }

    @Override
    public void AnalizadorDeMensajesSERVER(String msj) 
    {  
        String encabezado = msj.split( Encabezado_Mensajes.Msj_divisor )[0];
        String cuerpo = msj.split( Encabezado_Mensajes.Msj_divisor )[1];

        if( encabezado.equals( Encabezado_Mensajes.Msj_PInicio_SMAtoACO ) )
        {
            /*
             String vec[] = cuerpo.split( Encabezado_Mensajes.Msj_divisor_2 );

                Nagentes = Integer.valueOf(vec[0].split( Encabezado_Mensajes.Msj_PInicio_SMAtoACO_HowMany )[1]);
                maxVel = Float.valueOf(vec[1].split( Encabezado_Mensajes.Msj_PInicio_SMAtoACO_VelMax )[1]);
            */
            
            String vec[] = cuerpo.split( Encabezado_Mensajes.Msj_divisor_2 );

            System.out.println(cuerpo);
            Nagentes = Integer.valueOf( vec[0].split(Encabezado_Mensajes.Msj_PInicio_SMAtoACO_HowMany)[1] );
            VelocidadMaxima = Float.valueOf( vec[1].split(Encabezado_Mensajes.Msj_PInicio_SMAtoACO_VelMax)[1] );
            VelocidadInicial = Float.valueOf( vec[2].split(Encabezado_Mensajes.Msj_PInicio_SMAtoACO_VelIni)[1] );

            

            Tools.GestionLabels.CambiarLabel_correcto25x25(estado);
            recepsionDeDatos.faseCompletada();
        }
        else if( encabezado.equals( Encabezado_Mensajes.Msj_nextStep ) )
        {
            /*Encabezado_Mensajes.Msj_nextStep + Encabezado_Mensajes.Msj_divisor + 
                robotID;*/
            
            int robotID = Integer.valueOf( cuerpo );
            
            if( isAgenteNuevo(robotID) )
                FormRobots.aFisico.add( new AgenteFisico( robotID, this ) );
            
            calcularNuevosMovimientos(robotID);
        }
    }
    
    private void calcularNuevosMovimientos(int robotID)
    {
        for (AgenteFisico aFisico : FormRobots.aFisico) 
            if (aFisico.getIdAgente() == robotID) 
            {
                aFisico.Avanzar();
                //dibujar
                aFisico.EnviarNuevaDireccion();
            }
    }
    
    public void enviarNuevaDireccion(int ID, int mirada, float distancia)
    {
        String sms = Encabezado_Mensajes.Msj_nextStep + Encabezado_Mensajes.Msj_divisor+
                ID + Encabezado_Mensajes.Msj_divisor_2 + mirada + Encabezado_Mensajes.Msj_divisor_2 + distancia;
        
        D_s.enviar(sms);
    }
    
    
    public void enviarNuevaVelocidad(int v)
    {
        String sms = Encabezado_Mensajes.Msj_ACOtoSMA_setVelocidad + Encabezado_Mensajes.Msj_divisor + v;
        
        D_s.enviar(sms);
    }
    
    private boolean isAgenteNuevo(int ID)
    {
        for (AgenteFisico aFisico : FormRobots.aFisico) 
            if (aFisico.getIdAgente() == ID) 
                return false;
        
        return true;
    }

    public int getNagentes() {
        return Nagentes;
    }

    public float getVelocidadMaxima() {
        return VelocidadMaxima;
    }

    public float getVelocidadInicial() {
        return VelocidadInicial;
    }

}
