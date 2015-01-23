package Agentes;

import MapaContexto.CuadroMapa;
import MapaContexto.Mapa;

public class AgenteFisico extends Agente
{
    public static float velocidad;//se mide en metros por segundo (m/s)
    
    public AgenteFisico(int id, float velocidad, CuadroMapa posActual, Mapa mapa)
    {
        super(id, posActual);
        
        this.velocidad = velocidad;
    }

}
