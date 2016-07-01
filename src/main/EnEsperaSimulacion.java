package main;

import MapaContexto.Mapa;
import java.awt.Point;
import javax.swing.JSlider;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Diego
 */
public class EnEsperaSimulacion extends BasicGameState
{
    private Image imageObstaculo, imageLibre, imgPuntoFinal, imgPuntoInicial;
    private Image imageCargado, imageSincargar;
    private Image imageSeleccionado;
    
    public static int mat[][];
    private static boolean blocked = true;
    
    public static Point puntoInicial, puntoFinal;
    private static Point puntoObstaculoInicial, puntoObstaculoFinal;
            
    private boolean mouseLeftPressed;
    private boolean isSelectedPuntoInicio, isSelectedPuntoFinal;
    
    private static final float tamanoMapaEnSimulacion= 413;
    public static float imgResizedEnSimulacion;
    public static float imgScaleEnSimulacion;
    private final float xOffset, yOffset;
    
    private int i,j;
    public EnEsperaSimulacion() 
    {
        setMatPorDefecto();
        
        mouseLeftPressed = false;
        yOffset = 60;
        xOffset = (Game.width-tamanoMapaEnSimulacion) /2;
        
        isSelectedPuntoInicio = isSelectedPuntoFinal = false;
    }
    
    private static void setImgTamanosyEscalas(int tamano)
    {
        imgResizedEnSimulacion = ((float) tamanoMapaEnSimulacion)/tamano;
        imgScaleEnSimulacion = imgResizedEnSimulacion / Game.imgTamanoOriginal;
    }
    
    public static void bloquearEdicion(boolean isblocked)
    {
        blocked = isblocked;
    }

    public static void setMat(int tam) 
    {
        mat = new int[tam][tam];
        
        for (int i = 0; i < tam; i++)
            for (int j = 0; j < tam; j++) 
                mat[i][j]=0;
            
        Game.setImgTamanosyEscalas(tam);
        setImgTamanosyEscalas(tam);
        
        puntoFinal = puntoInicial = puntoObstaculoFinal = puntoObstaculoInicial =null;
    }
    
    public static void setMat(String l, JSlider slTam) 
    {
        puntoFinal = puntoInicial = puntoObstaculoFinal = puntoObstaculoInicial =null;
        
        int tam = l.split("\n").length;
        
        slTam.setValue(tam);
        
        for (int i = 0; i < tam; i++)
            for (int j = 0; j < tam; j++) 
            {
                int obj = Character.getNumericValue( l.split("\n")[i].charAt(j) );
                
                switch(obj)
                {
                    case Mapa.obstaculo:
                        mat[i][j] = Mapa.obstaculo;
                    break;
                        
                    case Mapa.inicio:
                        mat[i][j] = Mapa.inicio;
                        puntoInicial = new Point(j, i);
                    break;
                        
                    case Mapa.fin:
                        mat[i][j] = Mapa.fin;
                        puntoFinal = new Point(j, i);
                    break;     
                }
                
            }
        
        System.out.println("llego");
    }
    
    
    public static void setMatPorDefecto()
    {
     int matAux[][] =   {{1,1,1,1,1,1,1,1}
                        ,{1,0,0,0,0,0,3,1}
                        ,{1,0,1,1,1,0,0,1}
                        ,{1,0,1,1,0,1,0,1}
                        ,{1,0,1,0,1,1,0,1}
                        ,{1,0,0,1,1,1,0,1}
                        ,{1,2,0,0,0,0,0,1}
                        ,{1,1,1,1,1,1,1,1}
                        };
      
       setImgTamanosyEscalas(matAux.length);
       puntoInicial = new Point(1, 6);
       puntoFinal = new Point(6, 1);
         
      EnEsperaSimulacion.mat = matAux;
    }
    
    @Override
    public int getID() 
    {
        return Game.STATE_EnEspera;   
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException 
    {
        imageLibre = new Image( "Media\\Img\\Mapa\\libre.png" );
        imageObstaculo = new Image( "Media\\Img\\Mapa\\obstaculo.png" );
        imgPuntoFinal = new Image( "Media\\Img\\Mapa\\puntoFinal.png" );
        imgPuntoInicial = new Image( "Media\\Img\\Mapa\\puntoInicial.png" );
        
        imageCargado= new Image( "Media\\Img\\cargado.png" );
        imageSincargar = new Image( "Media\\Img\\sincargar.png" );
        imageSeleccionado = new Image( "Media\\Img\\seleccionado.png" );
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        
        for (int i = 0; i < mat.length; i++) 
        {
            for (int j = 0; j < mat[0].length; j++) 
            {  
                if(mat[i][j] == Mapa.obstaculo)                    
                    imageObstaculo.draw(j*imgResizedEnSimulacion + xOffset, i*imgResizedEnSimulacion + yOffset, imgScaleEnSimulacion, Color.darkGray);
                else                    
                    imageLibre.draw(j*imgResizedEnSimulacion + xOffset, i*imgResizedEnSimulacion + yOffset, imgScaleEnSimulacion, Color.darkGray);
            }
        }
          
        renderObstaculosMomentaneos();
        renderPuntosFinalIncial();
        renderPanelInformativo(grphcs);
    }
    
    private void renderPuntosFinalIncial()
    {
        if(puntoInicial != null)
        imgPuntoInicial.draw(puntoInicial.x*imgResizedEnSimulacion + xOffset, puntoInicial.y*imgResizedEnSimulacion + yOffset, imgScaleEnSimulacion, Color.darkGray);
        
        if(puntoFinal != null)
        imgPuntoFinal.draw(puntoFinal.x*imgResizedEnSimulacion + xOffset, puntoFinal.y*imgResizedEnSimulacion + yOffset, imgScaleEnSimulacion, Color.darkGray);
    }
    
    private void renderObstaculosMomentaneos()
    {
        if(mouseLeftPressed &&  !isSelectedPuntoFinal && !isSelectedPuntoInicio && puntoObstaculoInicial != null && puntoObstaculoFinal != null)
        {
            boolean ahorroDeCodigoY = puntoObstaculoInicial.y <= puntoObstaculoFinal.y;
            boolean ahorroDeCodigoX = puntoObstaculoInicial.x <= puntoObstaculoFinal.x;


            for (int k = ahorroDeCodigoY ? puntoObstaculoInicial.y:puntoObstaculoInicial.y ; (ahorroDeCodigoY && k <= puntoObstaculoFinal.y) || (!ahorroDeCodigoY && k >= puntoObstaculoFinal.y); k = ahorroDeCodigoY? k+1:k-1)               
                for (int l = ahorroDeCodigoX ? puntoObstaculoInicial.x:puntoObstaculoInicial.x ; (ahorroDeCodigoX && l <= puntoObstaculoFinal.x) || (!ahorroDeCodigoX && l >= puntoObstaculoFinal.x); l = ahorroDeCodigoX? l+1:l-1)
                    if(mat[k][l]==Mapa.obstaculo)
                        imageLibre.draw(l*imgResizedEnSimulacion + xOffset, k*imgResizedEnSimulacion + yOffset, imgScaleEnSimulacion, Color.lightGray);
                    else
                        imageObstaculo.draw(l*imgResizedEnSimulacion + xOffset, k*imgResizedEnSimulacion + yOffset, imgScaleEnSimulacion, Color.lightGray);
        }
    }
   
    private void renderPanelInformativo( Graphics grphcs)
    {
        if(isSelectedPuntoInicio)
            imageSeleccionado.draw(0, 8);
        imgPuntoInicial.draw(0, 8);
        
        grphcs.drawString("Punto Inicial", 50, 23);
        
        if(puntoInicial == null)
            imageSincargar.draw(170,7);
        else
            imageCargado.draw(170,7);
        
        
        if(isSelectedPuntoFinal)
            imageSeleccionado.draw(263, 8);
        imgPuntoFinal.draw(263, 8);
        grphcs.drawString("Punto Final", 313, 23);
        
        if(puntoFinal == null)
            imageSincargar.draw(418,7);
        else
            imageCargado.draw(418,7);
    }
    
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
    
        if(!blocked)
        {
            if (gc.getInput().isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) 
            {
               int iAux = (int) ((gc.getInput().getMouseY() - yOffset)/imgResizedEnSimulacion);
               int jAux = (int) ((gc.getInput().getMouseX() - xOffset)/imgResizedEnSimulacion);
                
                i = iAux >= mat.length ? mat.length -1 : iAux;
                j = jAux >= mat.length ? mat.length -1 : jAux;
            }
            
            presionoPuntosFinales(gc);
            
            if(!isSelectedPuntoFinal && !isSelectedPuntoInicio)
            {
                if (gc.getInput().isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) 
                {
                    if(puntoObstaculoFinal == null || (puntoObstaculoFinal.x != j || puntoObstaculoFinal.y != i) )
                        puntoObstaculoFinal =  new Point(j,i);        

                    mouseLeftPressed = true;
                }
                else
                {
                    if(mouseLeftPressed && puntoObstaculoFinal != null && puntoObstaculoInicial != null)
                    {
                       mouseLeftPressed = false;

                       boolean ahorroDeCodigoY = puntoObstaculoInicial.y <= puntoObstaculoFinal.y;
                       boolean ahorroDeCodigoX = puntoObstaculoInicial.x <= puntoObstaculoFinal.x;

                        for (int k = ahorroDeCodigoY ? puntoObstaculoInicial.y:puntoObstaculoInicial.y ; (ahorroDeCodigoY && k <= puntoObstaculoFinal.y) || (!ahorroDeCodigoY && k >= puntoObstaculoFinal.y); k = ahorroDeCodigoY? k+1:k-1)               
                            for (int l = ahorroDeCodigoX ? puntoObstaculoInicial.x:puntoObstaculoInicial.x ; (ahorroDeCodigoX && l <= puntoObstaculoFinal.x) || (!ahorroDeCodigoX && l >= puntoObstaculoFinal.x); l = ahorroDeCodigoX? l+1:l-1)
                                if(mat[k][l]!=Mapa.libre )
                                {
                                    if(mat[k][l] == Mapa.inicio)
                                    {
                                        puntoInicial = null;
                                        mat[k][l] = Mapa.obstaculo;
                                    }
                                    else
                                        if(mat[k][l] == Mapa.fin)
                                        {
                                            puntoFinal = null;
                                            mat[k][l] = Mapa.obstaculo;
                                        }
                                        else
                                            mat[k][l]=Mapa.libre;
                                }
                                else
                                    mat[k][l]=Mapa.obstaculo;
                        
                        puntoObstaculoFinal = puntoObstaculoInicial = null;
                    }
                }
            }
            
            if(gc.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON))
            {
                if(isSelectedPuntoInicio)
                {
                    if(puntoInicial != null)
                        mat[puntoInicial.y][puntoInicial.x] = Mapa.libre;
                    
                    if(mat[i][j] == Mapa.fin)
                        puntoFinal = null;
                    
                    puntoInicial = new Point(j,i);
                    isSelectedPuntoInicio = false;
                    mat[i][j] = Mapa.inicio;
                }
                else
                {
                    if(isSelectedPuntoFinal)
                    {
                        if(puntoFinal != null)
                            mat[puntoFinal.y][puntoFinal.x] = Mapa.libre;
                        
                        if(mat[i][j] == Mapa.inicio)
                            puntoInicial = null;
                        
                        puntoFinal = new Point(j, i);
                        isSelectedPuntoFinal = false;
                        mat[i][j] = Mapa.fin;
                    }
                    else
                        puntoObstaculoInicial = new Point(j,i);
                }
            }
            
        }
    }
    
    private boolean presionoPuntosFinales(GameContainer gc)
    {
        if(gc.getInput().isKeyPressed( Input.KEY_END ))
        {
            isSelectedPuntoFinal = true;
            isSelectedPuntoInicio =false;
            
            return true;
        }

        if(gc.getInput().isKeyPressed( Input.KEY_HOME ))
        {
            isSelectedPuntoInicio= true;
            isSelectedPuntoFinal = false;
            
            return true;
        }
        
        return false;
    }
    
    
}
