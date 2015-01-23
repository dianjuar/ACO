
package Agentes;


public class Movimiento {
    
    private final int direccion;
    private float probabilidad;
    private final float feromona;

    public Movimiento(int direccion, float feromona) {
        this.direccion = direccion;
        this.probabilidad = -1;
        this.feromona = feromona;
    }

    public int getDireccion() {
        return direccion;
    }

    public float getProbabilidad() {
        return probabilidad;
    }

    public float getFeromona() {
        return feromona;
    }

    public void setProbabilidad(float probabilidad) {
        this.probabilidad = probabilidad;
    }
    
    
    
}
