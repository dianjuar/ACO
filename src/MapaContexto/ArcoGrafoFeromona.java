package MapaContexto;

import java.awt.Point;
import java.util.ArrayList;

public class ArcoGrafoFeromona
{
    private float feromona;
    private final Point puntoA;
    private final Point puntoB;
    private final int idArco;
    
    private final int idPuntoA, idPuntoB;
    
    private float deltaFeromona;
    
    /** Indica si el arco es verticalm horizontal, diagonal positivo o doagonal negativo*/
    private final int tipoDeArco;
    
    private final boolean isHorizontalOVertical;
    

    public ArcoGrafoFeromona(float feromona, Point puntoA, Point puntoB, 
                               int idPuntoA, int idPuntoB,
                               int idArco,
                               int tipoDeArco)
    {        
        this.feromona = feromona;
        this.puntoA = puntoA;
        this.puntoB = puntoB;
        this.idArco = idArco;
        
        this.tipoDeArco = tipoDeArco;
        
        this.idPuntoA = idPuntoA;
        this.idPuntoB = idPuntoB;
        
        if(tipoDeArco == GrafoFeromonas.arcoHorizontal || tipoDeArco == GrafoFeromonas.arcoVertical)
            isHorizontalOVertical = true;
        else
            isHorizontalOVertical = false;
    }

    public float getDeltaFeromona() {
        return deltaFeromona;
    }

    public void setDeltaFeromona(float deltaFeromona) {
        this.deltaFeromona = deltaFeromona;
    }
    
    public void agregarFeromona(float feromonaNueva)
    {        
        feromona += feromonaNueva;    
    }

    public float getFeromona() {
        return feromona;
    }

    public Point getPuntoA() {
        return puntoA;
    }

    public Point getPuntoB() {
        return puntoB;
    }

    public int getIdArco() {
        return idArco;
    }

    public void setFeromona(float feromona) {
        this.feromona = feromona;
    }

    /** Indica si el arco es verticalm horizontal, diagonal positivo o doagonal negativo*/
    public int getTipoDeArco() {
        return tipoDeArco;
    }

    public int getIdPuntoA() {
        return idPuntoA;
    }

    public int getIdPuntoB() {
        return idPuntoB;
    }

    public boolean isIsHorizontalOVertical() {
        return isHorizontalOVertical;
    }
    
}
