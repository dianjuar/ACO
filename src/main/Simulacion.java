package main;

import Agentes.AgenteFisico;
import Agentes.AgenteVirtual;
import MapaContexto.GrafoFeromonas;
import MapaContexto.ArcoGrafoFeromona;
import MapaContexto.ArcoVecino;
import MapaContexto.Mapa;
import java.awt.Point;
import java.util.ArrayList;
import static main.Game.imgResized;
import static main.Game.imgSacale;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Simulacion extends BasicGameState
{
    private final ArrayList<Image> listaImgTipoArco;
    private final ArrayList<Point> listaCuadrosSeleccionados;
    
    private Image imgAVirtual, imgAFisico;
    private Image imgPuntoInicial, imgPuntoFinal;
    private Image libre, obstaculo;
    private Image imgCuadroLibreSeleccionado,imgCuadroExtremoSeleccionado;

    private AgenteVirtual[] aVirtual;
    private ArrayList<AgenteFisico> aFisico;

    public Simulacion() 
    {
        listaImgTipoArco = new ArrayList<>();
        listaCuadrosSeleccionados = new ArrayList<>();
    }
    
    @Override
    public int getID() 
    {
        return Game.STATE_Ejecucion;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException 
    {
      /*libre=0;
        obstaculo=1;   
        inicio=2;
        fin=3;*/        
        libre = new Image( "Media\\Img\\Mapa\\libre.png" );
        obstaculo = new Image( "Media\\Img\\Mapa\\obstaculo.png" );
        imgPuntoFinal = new Image( "Media\\Img\\Mapa\\puntoFinal.png" );
        imgPuntoInicial = new Image( "Media\\Img\\Mapa\\puntoInicial.png" );
        
        imgAVirtual = new Image("Media\\Img\\Agentes\\ant.png");
        imgAFisico = new Image("Media\\Img\\Agentes\\NXT_ICON.png");
      
        imgCuadroLibreSeleccionado = new Image("Media\\Img\\Mapa\\libreSeleccionado.png");
        imgCuadroExtremoSeleccionado = new Image("Media\\Img\\Mapa\\ExtremoSeleccionado.png");
        
                
        /*arcoHorizontal = 0;
          arcoVertical = 1;
          arcoDiagonalPositivo = 2;
          arcoDiagonalNegativo = 3;*/
        listaImgTipoArco.add(new Image( "Media\\Img\\Feromonas\\Horizontal.png" ));
        listaImgTipoArco.add(new Image( "Media\\Img\\Feromonas\\Vertical.png" ));
        listaImgTipoArco.add(new Image( "Media\\Img\\Feromonas\\DiagonalPositivo.png" ));
        listaImgTipoArco.add(new Image( "Media\\Img\\Feromonas\\DiagonalNegativo.png" ));        
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException 
    {
        for (int i = 0; i < Game.mapa.getMapa().length; i++) 
        {
            for (int j = 0; j < Game.mapa.getMapa()[0].length; j++) 
            {  
                if(Game.mapa.getCuadro(j, i).getValor() == Mapa.obstaculo)                    
                    obstaculo.draw(i*imgResized, j*imgResized, imgSacale);
                else                    
                    libre.draw(i*imgResized, j*imgResized, imgSacale);
            }
        }
        
        renderArcosFeromona();
        renderPuntosFinalIncial();        
        renderCuadrosSeleccionados(g);
        renderAgentesVirtuales(imgAVirtual, imgResized, imgSacale);
        renderAgentesFisicos(imgAFisico, imgResized, imgSacale);
        
    }
    
    private void renderCuadrosSeleccionados(Graphics g) throws SlickException
    {
        for (Point cuadro : listaCuadrosSeleccionados) 
        {
            if(!Game.mapa.getCuadro( cuadro.y , cuadro.x).isObstaculo())
            {
                if((Mapa.cuadroFinal.getX() == cuadro.x && Mapa.cuadroFinal.getY() == cuadro.y) ||
                   (Mapa.cuadroInicial.getX() == cuadro.x && Mapa.cuadroInicial.getY() == cuadro.y))
                        imgCuadroExtremoSeleccionado.draw(cuadro.x*imgResized,cuadro.y*imgResized,imgSacale);
                else
                        imgCuadroLibreSeleccionado.draw(cuadro.x*imgResized,cuadro.y*imgResized,imgSacale);

                renderToolTips(g, cuadro.x, cuadro.y);
            }
        }
    }
    
    private void renderToolTips(Graphics g,int x, int y)
    {
        System.out.println("*******************************");
        System.out.println("Cuadro Nº: "+Game.mapa.getCuadro(y, x).getID());
            
        for (ArcoVecino arcoVecino : Game.mapa.getCuadro(y, x).getListaArcosVecinos()) 
            System.out.println("   -ID:"+arcoVecino.getArcoVecino().getIdArco()+"  Feromona:"+
                               arcoVecino.getArcoVecino().getFeromona()+"  "+arcoVecino.getStringDondeQueda());        
        System.out.println("*******************************");
    }
    
    private void renderPuntosFinalIncial()
    {
        imgPuntoInicial.draw(Mapa.cuadroInicial.getX()*imgResized, Mapa.cuadroInicial.getY()*imgResized, imgSacale);
        imgPuntoFinal.draw(Mapa.cuadroFinal.getX()*imgResized, Mapa.cuadroFinal.getY()*imgResized, imgSacale);
    }
    
    private void renderAgentesVirtuales(Image imgAVirtual, float imgResized, float imgSacale) throws SlickException
    {
        for (AgenteVirtual Avir : aVirtual) 
            Avir.render(imgAVirtual, imgResized, imgSacale);
    }   
    
    private void renderAgentesFisicos(Image imgAFisico, float imgResized, float imgSacale) throws SlickException 
    {
        for (AgenteFisico Afis : aFisico) 
            Afis.render(imgAFisico, imgResized, imgSacale);
    }
    
    private void renderArcosFeromona()
    {
      
        for (ArcoGrafoFeromona arcoValido : Game.mapa.getGrafoFeromonas().getListaArcosValidos()) 
        {
            Image img = listaImgTipoArco.get( arcoValido.getTipoDeArco() );
            
            img.setAlpha( arcoValido.getFeromona()/100 );
            
            switch (arcoValido.getTipoDeArco())
            {
                case GrafoFeromonas.arcoHorizontal:
                    img.draw( imgResized/2 + arcoValido.getPuntoA().x*imgResized,
                              (imgResized/2-5*imgSacale) + arcoValido.getPuntoA().y*imgResized,
                              imgSacale);
                break;
                    
                case GrafoFeromonas.arcoVertical:
                    img.draw( (imgResized/2-5*imgSacale) + arcoValido.getPuntoA().x*imgResized,
                              (imgResized/2) + arcoValido.getPuntoA().y*imgResized,
                              imgSacale);
                break;
                
                case GrafoFeromonas.arcoDiagonalPositivo:
                    img.draw( imgResized/2 + (arcoValido.getPuntoA().x-1)*imgResized,
                              imgResized/2 + arcoValido.getPuntoA().y*imgResized,
                              imgSacale);
                break;
                    
                case GrafoFeromonas.arcoDiagonalNegativo:
                    img.draw( imgResized/2 + arcoValido.getPuntoA().x*imgResized,
                              imgResized/2 + (arcoValido.getPuntoA().y)*imgResized,
                              imgSacale);
                break;
            }
        }
    }
    
    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException 
    {
        for (AgenteVirtual aVir : aVirtual) 
            aVir.update(container, game, delta, AgenteVirtual.velocidad);
        
        for (AgenteFisico aFis : aFisico ) 
            aFis.update(container, game, delta, AgenteFisico.velocidad);
        
        Game.mapa.getGrafoFeromonas().updateFeromonas(container, game, delta);
        
        if(container.getInput().isMousePressed( Input.MOUSE_LEFT_BUTTON ))
        {
            int x = (int) (container.getInput().getMouseX()/Game.imgResized);
            int y = (int) (container.getInput().getMouseY()/Game.imgResized);
            
            Point xy = new Point(x, y);
            
            if(listaCuadrosSeleccionados.contains(xy))
                listaCuadrosSeleccionados.remove(xy);
            else
                listaCuadrosSeleccionados.add(xy);
        }
        
    }

    public void setaVirtual(AgenteVirtual[] aVirtual) {
        this.aVirtual = aVirtual;
    }

    public void setaFisico(ArrayList<AgenteFisico> aFisico) {
        this.aFisico = aFisico;
    }
}
