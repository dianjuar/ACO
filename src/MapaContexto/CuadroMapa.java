package MapaContexto;

import java.awt.Point;
import java.util.ArrayList;

public class CuadroMapa
{    
    private final int valor;
    private final int x,y;
    private final int ID;
    
    private final ArrayList<ArcoVecino> listaArcosVecinos;
    private boolean unrecheable;
    
    public CuadroMapa (int valor,int x, int y, int ID)
    {
        this.valor = valor;
        this.ID = ID;
        this.x = x;
        this.y = y;
        unrecheable = false;
        
        if(valor != Mapa.obstaculo)
        listaArcosVecinos = new ArrayList<>();
        else
        listaArcosVecinos = null;
    }    
    
    public void setUnrecheable()
    {
        unrecheable = true;
    }
    
    public void agregarArcoVecino(ArcoVecino arco)
    {
        listaArcosVecinos.add(arco);
    }
    
    public boolean isObstaculo() {
        return valor == Mapa.obstaculo;
    }

    public boolean isUnrecheable() {
        return unrecheable;
    }
    
    public boolean isInicio() {
        return valor == Mapa.inicio;
    }

    public boolean isFin() {
        return valor == Mapa.fin;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point getPosActualPoint()
    {
        return new Point(x, y);
    }
    
    public int getID() {
        return ID;
    }

    public int getValor() {
        return valor;
    }

    public ArrayList<ArcoVecino> getListaArcosVecinos() 
    {
        return listaArcosVecinos;
    }
    
   
    
    
}
