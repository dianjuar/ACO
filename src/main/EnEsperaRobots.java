package main;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Diego
 */
public class EnEsperaRobots extends BasicGameState
{
    private Image fondo;

    public EnEsperaRobots() 
    {
    }
    
    

    @Override
    public int getID() 
    {
        return Game.STATE_EnEspera;   
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        fondo = new Image( "Media\\Img\\FondoDeEspera.jpg" );
    
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
    
        //grphcs.drawImage(fondo, 0, 0);
        grphcs.drawImage(fondo, 0, 0, Game.width, Game.width, 0, 0, fondo.getWidth(), fondo.getHeight());
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
    
    }
    
}
