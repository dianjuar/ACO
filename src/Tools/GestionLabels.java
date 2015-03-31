/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author diego_juliao
 */
public class GestionLabels 
{
    public static final String ruta_correcto25x25 = "../../../src/Media/Img/cargado.png";
    public static final String ruta_incorrecto25x25 = "../../../src/Media/Img/sincargar.png";
    public static final String ruta_esperando25x25 = "../../../src/Media/Img/connecting45x45.gif"; 

    public static void CambiarLabel_esperando25x25(JLabel l)
    {
        l.setIcon( new ImageIcon( ruta_esperando25x25 ) );
    }
    
    public static void CambiarLabel_correcto25x25(JLabel l)
    {
        l.setIcon( new ImageIcon( ruta_correcto25x25 ) );
    }
    
    public static void CambiarLabel_incorrecto25x25(JLabel l)
    {
        l.setIcon( new ImageIcon( ruta_incorrecto25x25 ) );
    }
    
}
