/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Networking;

/**
 *
 * @author diego_juliao
 */
public class ResepcionMapa extends DataRecibe
{

    public ResepcionMapa() 
    {
        super(Puertos.mapaRecibe, "Recepción del mapa por parte del modulo de visión artificial");
    }

    @Override
    public void funcion() 
    {
        
    }
    
}
