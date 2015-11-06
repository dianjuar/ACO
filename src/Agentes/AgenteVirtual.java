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
   
   @Override
    public void render(Image Agente, float imgResized, float imgScale) throws SlickException 
    {
        Agente.setCenterOfRotation( Agente.getWidth()*imgScale/2, Agente.getWidth()*imgScale/2);
        
        Agente.setRotation( anguloDeVision() );
        
        Agente.draw(posCanvas.getX(), posCanvas.getY(), imgScale);        
    }
    
   @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException
    {    
        float dis = distanciaAvanzada(delta);
        acumDist += dis;    
        
        switch (mirada)
        {
           case norte:
              posCanvas.setY( posCanvas.getY()-dis);
           break;

           case sur:
               posCanvas.setY( posCanvas.getY()+dis);
           break;

           case este:
               posCanvas.setX( posCanvas.getX()+dis);
           break;

           case oeste:
               posCanvas.setX( posCanvas.getX()-dis);
           break;

           case noreste:
               posCanvas.setY( posCanvas.getY()-dis );
               posCanvas.setX( posCanvas.getX()+dis );
           break;

           case noroeste:
               posCanvas.setY( posCanvas.getY()-dis );
               posCanvas.setX( posCanvas.getX()-dis);
           break;

           case sureste:
               posCanvas.setY( posCanvas.getY()+dis);
               posCanvas.setX( posCanvas.getX()+dis );
           break;

           case suroeste:
               posCanvas.setY( posCanvas.getY()+dis);
               posCanvas.setX( posCanvas.getX()-dis);
           break;
        } 
        
        if( isVisionHorizontaloVertical() )
        {
            if( acumDist >= Mapa.longitudArcoHorizontal*(Game.imgResized/Mapa.longitudArcoHorizontal))
            {
                acumDist =0;
                
                if(mirada == norte || mirada == sur)                
                    posCanvas.setY( posActual.getY()*Game.imgResized );
                else
                    posCanvas.setX( posActual.getX()*Game.imgResized );
                
             Avanzar();
                
            }
        }
        else
        {
            if( acumDist >= Mapa.longitudArcoDiagonal*(Game.imgResized/Mapa.longitudArcoDiagonal) )
            {
                acumDist =0;
                
                posCanvas.setY( posActual.getY()*Game.imgResized );
                posCanvas.setX( posActual.getX()*Game.imgResized );
                
                Avanzar();
            }
        }
        
        
    }
    
}