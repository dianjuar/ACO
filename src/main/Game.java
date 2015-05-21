package main;

import MapaContexto.Mapa;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;


public class Game extends StateBasedGame
{
public static final String gamaename = "Ant Colony Optimization (ACO) - O"
                                       + "ptimizacón por Colonia de Hormigas";
public static final int STATE_EnEspera = 0;
public static final int STATE_Ejecucion = 1;

private final GameState GameEnEspera;
private final Simulacion GameSimulacion;

public static int width;

public static float imgTamanoOriginal=50, imgResized, imgSacale;

public static Mapa mapa;

    public Game(int width, boolean isEnEsperaRobots)
    {
        super(gamaename);
                        
        this.width = width;
        
        if(isEnEsperaRobots)
            this.GameEnEspera= new EnEsperaRobots();
        else
            this.GameEnEspera = new EnEsperaSimulacion();
        
        this.GameSimulacion = new Simulacion();
        
        this.addState(GameEnEspera);
        this.addState(GameSimulacion);
    }
    
    
    @Override
    public void initStatesList(GameContainer gc) throws SlickException 
    {
        this.getState(STATE_EnEspera).init(gc, this);
        this.getState(STATE_Ejecucion).init(gc, this);
        this.enterState(STATE_EnEspera);
        gc.setShowFPS(false);
    }

    public EnEsperaRobots getGameEnEsperaRobots() 
    {
        return (EnEsperaRobots) GameEnEspera;
    }
    
    public EnEsperaSimulacion getGameEnEsperaSimulacion() 
    {
        return (EnEsperaSimulacion) GameEnEspera;
    }

    public Simulacion getGameSimulacion() {
        return GameSimulacion;
    }

    public static void setImgTamanosyEscalas(int tamano) 
    {
        imgResized = ((float) Game.width)/tamano;
        
        imgSacale = imgResized / imgTamanoOriginal;
    }

    public static void setMapa(Mapa mapa) {
        Game.mapa = mapa;
    }
}
