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
import java.awt.Point;
import java.util.ArrayList;
import java.util.Vector;
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
    
    private String infoMap;
    
    private Vector<Point> unrecheablePath;
    
    public Conexion_SMA(JLabel estado, InicioRobots_RecepsionDeDatos i) 
    {
        super(Puertos.Recibe_SMA, "conexion con SMA");
        
        this.estado = estado;        
        this.recepsionDeDatos = i;
       
        unrecheablePath = new Vector<Point>();
        
        infoMap = null;
    }

    public Vector<Point> getUnrecheablePath() 
    {
        return unrecheablePath;
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
            Nagentes = Integer.valueOf( vec[0].split(Encabezado_Mensajes.Msj_PInicio_SMAtoACO_HowMany)[1] );
            VelocidadMaxima = Float.valueOf( vec[1].split(Encabezado_Mensajes.Msj_PInicio_SMAtoACO_VelMax)[1] )/100;
            VelocidadInicial = Float.valueOf( vec[2].split(Encabezado_Mensajes.Msj_PInicio_SMAtoACO_VelIni)[1] )/100;
            
            if(infoMap != null)
                enviarInformacionEntornoGrafico(infoMap);
            
            Tools.GestionLabels.CambiarLabel_correcto25x25(estado);
            recepsionDeDatos.faseCompletada();
        }
        else if( encabezado.equals( Encabezado_Mensajes.Msj_nextStep ) )
        {
            int robotID = Integer.valueOf( cuerpo );
            
            if( isAgenteNuevo(robotID) )
                FormRobots.aFisico.add( new AgenteFisico( robotID, this ) );
            
            calcularNuevosMovimientos(robotID);
        }
        else if( encabezado.equals(Encabezado_Mensajes.SMAtoMe_UnrecheableSteps ) )
        {
            if( !cuerpo.equals( Encabezado_Mensajes.SMAtoMe_NONEUnrecheableSteps ) )
            {
                String vec[] = cuerpo.split( Encabezado_Mensajes.Msj_divisor_2 );

                //each unrecheable step X#X
                for (int i = 0; i < vec.length; i++)
                {
                    int x = Integer.valueOf( vec[i].split( Encabezado_Mensajes.Msj_divisor_3 )[0] );
                    int y = Integer.valueOf( vec[i].split( Encabezado_Mensajes.Msj_divisor_3 )[1] );

                    Point p = new Point( x, y);

                    unrecheablePath.add(p);
                }
            }
            recepsionDeDatos.faseCompletada();
            
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
    
    public void enviarNuevaDireccion(int ID, int mirada, float distancia, Point posicionDigital)
    {
        String sms = Encabezado_Mensajes.Msj_nextStep + Encabezado_Mensajes.Msj_divisor+
                ID + Encabezado_Mensajes.Msj_divisor_2 +
                mirada + Encabezado_Mensajes.Msj_divisor_2 + 
                distancia + Encabezado_Mensajes.Msj_divisor_2 + 
                posicionDigital.x + Encabezado_Mensajes.Msj_divisor_2 + posicionDigital.y;
        
        D_s.enviar(sms);
    }
    
    
    public void enviarNuevaVelocidad(float v)
    {
        String sms = Encabezado_Mensajes.Msj_ACOtoSMA_setVelocidad + Encabezado_Mensajes.Msj_divisor + v;
        
        D_s.enviar(sms);
    }
    
    public void enviar_avisoDeInicio() 
    {
        D_s.enviar( Encabezado_Mensajes.Msj_ACotoSMA_Inicio );
    }
    
    public void enviarInformacionEntornoGrafico(String msj)
    {
        D_s.enviar( Encabezado_Mensajes.Msj_ACOtoSMA_EnviromentInfo  + Encabezado_Mensajes.Msj_divisor + msj);
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

    void setInforGrafica(String infoMap) 
    {
        this.infoMap = infoMap;
    }

}
