/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agentes;

import MapaContexto.CuadroMapa;
import MapaContexto.Mapa;
import Networking.Conexion_SMA;
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
    private Conexion_SMA conexSMA;

    public AgenteFisico(int ID, Conexion_SMA conexSMA)
    {
        super(ID);
    }
    
    public void EnviarNuevaDireccion()
    {
        conexSMA.enviarNuevaDireccion( idAgente, mirada,  isVisionHorizontaloVertical() ? Mapa.longitudArcoHorizontal: Mapa.longitudArcoDiagonal );
    }

    @Override
    public void render(Image Agente, float imgResized, float imgScale) throws SlickException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
