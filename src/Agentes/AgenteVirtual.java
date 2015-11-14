package Agentes;

import org.newdawn.slick.GameContainer; 
import org.newdawn.slick.state.StateBasedGame;
import MapaContexto.CuadroMapa;
import MapaContexto.Mapa;
import main.Game;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Image;

public class AgenteVirtual extends Agente
{
    public static float velocidad;
    
    public AgenteVirtual(int ID, CuadroMapa posInicial, int mirada, float velocidad)
    {    
        super(ID);
        this.velocidad = velocidad;

        Avanzar();
    }
    
}