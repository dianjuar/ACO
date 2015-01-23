package MapaContexto;

import Agentes.Agente;

public class ArcoVecino 
{
    private final ArcoGrafoFeromona ArcoVecino;
    private final int dondeQueda;
    private float probabilidad;
    private final String stringDondeQueda;

    public ArcoVecino(ArcoGrafoFeromona ArcoVecino, int dondeQueda) {
        this.ArcoVecino = ArcoVecino;
        this.dondeQueda = dondeQueda;
        probabilidad = -1;
        
        switch (dondeQueda)
        {
            case Agente.norte:
                stringDondeQueda = "norte";
            break;
            case Agente.sur:
                stringDondeQueda = "sur";
            break;
            case Agente.este:
                stringDondeQueda = "este";
            break;
            case Agente.oeste:
                stringDondeQueda = "oeste";
            break;
            case Agente.noreste:
                stringDondeQueda = "noreste";
            break;
            case Agente.noroeste:
                stringDondeQueda = "noroeste";
            break;
            case Agente.sureste:
                stringDondeQueda = "sureste";
            break;
            case Agente.suroeste:
                stringDondeQueda = "suroeste";
            break;
            default:
                stringDondeQueda = "No espicificado";
            break;
        }
    }

    public String getStringDondeQueda() {
        return stringDondeQueda;
    }
    
    public ArcoGrafoFeromona getArcoVecino() {
        return ArcoVecino;
    }

    public int getDondeQueda() {
        return dondeQueda;
    }

    public void setProbabilidad(float provabilidad) {
        this.probabilidad = provabilidad;
    }

    public float getProbabilidad() {
        return probabilidad;
    }

    
    
    
}
