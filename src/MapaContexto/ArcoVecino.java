package MapaContexto;

import Agentes.AgenteVirtual;

public class ArcoVecino 
{
    private final ArcoGrafoFeromona ArcoVecino;
    private final int dondeQueda;
    private double probabilidad;
    private final String stringDondeQueda;

    public ArcoVecino(ArcoGrafoFeromona ArcoVecino, int dondeQueda) {
        this.ArcoVecino = ArcoVecino;
        this.dondeQueda = dondeQueda;
        probabilidad = -1;
        
        switch (dondeQueda)
        {
            case AgenteVirtual.norte:
                stringDondeQueda = "norte";
            break;
            case AgenteVirtual.sur:
                stringDondeQueda = "sur";
            break;
            case AgenteVirtual.este:
                stringDondeQueda = "este";
            break;
            case AgenteVirtual.oeste:
                stringDondeQueda = "oeste";
            break;
            case AgenteVirtual.noreste:
                stringDondeQueda = "noreste";
            break;
            case AgenteVirtual.noroeste:
                stringDondeQueda = "noroeste";
            break;
            case AgenteVirtual.sureste:
                stringDondeQueda = "sureste";
            break;
            case AgenteVirtual.suroeste:
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

    public void setProbabilidad(double provabilidad) {
        this.probabilidad = provabilidad;
    }

    public double getProbabilidad() {
        return probabilidad;
    }

    
    
    
}
