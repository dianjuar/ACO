/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agentes;

import MapaContexto.Mapa;
import Networking.Conexion_SMA;
import java.awt.Point;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author diego_juliao
 */
public class AgenteFisico extends Agente
{
    private static Conexion_SMA conexSMA;
    public static float velocidad;

    public AgenteFisico(int ID, Conexion_SMA conexSMA)
    {
        super(ID);
        this.conexSMA = conexSMA;
        this.avanzarAutomaticamente = false;
    }
    
    public void EnviarNuevaDireccion()
    {
        conexSMA.enviarNuevaDireccion( idAgente, mirada, 
                                       isVisionHorizontaloVertical() ? Mapa.longitudArcoHorizontal: Mapa.longitudArcoDiagonal,
                                       this.posActual.getPosActualPoint());
    }
    
    public static void EnviarNuevaVelocidad()
    {
        conexSMA.enviarNuevaVelocidad(velocidad);
    }

    public static void setConexSMA(Conexion_SMA conexSMA)
    {
        AgenteFisico.conexSMA = conexSMA;
    }
}
