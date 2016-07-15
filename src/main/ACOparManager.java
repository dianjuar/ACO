/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import static java.lang.Math.toIntExact;

/**
 *
 * @author dianjuar
 */
public class ACOparManager 
{
   
    /**
     * Hace referencia a la tasa de evaporación de la feromona
     */
    private int tasaEV;
    /**
     * JsonKey de TasaEV
     */
    private final String tasaEV_JKey;
    
    /**
     * Parametros que influyen sobre la toma de desiciones de los agentes
     * a la hora de escoger un camino
     */
    private int alfa, beta;
    /**
     * JsonKey de alfa y beta
     */
    private final String alfa_JKey, beta_JKey;
    
    /**
     * Cantidad de feromona segregada
     */
    private int q;
    /**
     * JsonKey de TasaEV
     */
    private final String q_JKey;
    
    /**
     * Velocidad de los agentes virtuales
     */
    private int velocidad;
    /**
     * JsonKey de velocidad
     */
    private final String velocidad_JKey;
    
    /**
     * Numero de agentes implicados
     */
    private int nAgentes;
    /**
     * JsonKey de Nagentes
     */
    private final String nAgentes_JKey;

    /**
     * Nombre del archivo donde se guardan los parametros
     */
    private final String archivoJson;
    
    
    public ACOparManager() 
    {
        tasaEV_JKey = "TasaDeEvaporacion";
        alfa_JKey = "Alfa";
        beta_JKey = "Beta";
        q_JKey = "Q";
        velocidad_JKey = "VelocidadAgentesVirtuales";
        nAgentes_JKey = "N_AgentesVirtuales";
        
        loadDefault();
        
        archivoJson = "/tmp/parametrosACO.json";
        
        //loadVaraibles( openFile() );
    }
    
    public void loadDefault()
    {
        tasaEV = 10;
        alfa = 150;
        beta = -20;
        q = 50;
        velocidad = 10;
        nAgentes = 10;
    }
    
    public void loadSliders( JSlider tasaEV_jslider,
                                JSlider alfa_jslider,
                                JSlider beta_jslider,
                                JSlider q_jslider,
                                JSlider velocidad_jslider,
                                JComboBox nAgentes_jcomboBox)
    {
        changeJslider( tasaEV_jslider,  tasaEV);
	changeJslider( alfa_jslider,  alfa);
	changeJslider( beta_jslider,  beta);
	changeJslider( q_jslider,  q);
	changeJslider( velocidad_jslider,  velocidad);
        
        nAgentes_jcomboBox.setSelectedIndex( nAgentes );
    }
    
    public void saveVariables( JSlider tasaEV_jslider,
                                JSlider alfa_jslider,
                                JSlider beta_jslider,
                                JSlider q_jslider,
                                JSlider velocidad_jslider,
                                JComboBox nAgentes_jcomboBox)
    {
        
        this.tasaEV = tasaEV_jslider.getValue(); 
        this.alfa = alfa_jslider.getValue(); 
        this.beta = beta_jslider.getValue(); 
        this.q = q_jslider.getValue(); 
        this.velocidad = velocidad_jslider.getValue(); 
        this.nAgentes = nAgentes_jcomboBox.getSelectedIndex();
        
        /*changeJslider( tasaEV_jslider,  tasaEV);
	changeJslider( alfa_jslider,  alfa);
	changeJslider( beta_jslider,  beta);
	changeJslider( q_jslider,  q);
	changeJslider( velocidad_jslider,  velocidad);
        
        nAgentes_jcomboBox.setSelectedIndex( nAgentes );*/
        
        saveVariablesInFile();
    }
    
    private void changeJslider( JSlider slider, int value )
    {
        slider.setValue(value);
        slider.repaint();
    }
    
    private JSONObject openFile() throws IOException, ParseException
    {
        JSONParser parser = new JSONParser();
     
        Object obj = parser.parse(new FileReader(archivoJson));
        JSONObject jsonObject = (JSONObject) obj;

        return jsonObject;
 
    }
    
    public boolean loadStoredVaraibles()
    {
        JSONObject jo;
        
        try
        {
            jo = openFile();
        } 
        catch (Exception ex) 
        {
            System.out.println("Error al leer");
            return false;
        }
        
        tasaEV = toIntExact( (long) jo.get( tasaEV_JKey ) );
        
        alfa = toIntExact( (long) jo.get( alfa_JKey ) );
        beta = toIntExact( (long) jo.get( beta_JKey ) );        
        q = toIntExact( (long) jo.get( q_JKey ) );
        
        velocidad = toIntExact( (long) jo.get( velocidad_JKey ) );
        nAgentes = toIntExact( (long) jo.get( nAgentes_JKey ) );   
        
        return true;
    }
    
    private void saveVariablesInFile()
    {        
        JSONObject obj = new JSONObject();
        obj.put(tasaEV_JKey, tasaEV);
        obj.put(alfa_JKey, alfa);
        obj.put(beta_JKey, beta);
        obj.put(q_JKey, q);
        obj.put(velocidad_JKey, velocidad);
        obj.put(nAgentes_JKey, nAgentes);

        // try-with-resources statement based on post comment below :)
        try (FileWriter file = new FileWriter(archivoJson))
        {
            file.write(obj.toJSONString());
            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("\nJSON Object: " + obj);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(ACOparManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public int getTasaEV() {
        return tasaEV;
    }

    public int getAlfa() {
        return alfa;
    }

    public int getBeta() {
        return beta;
    }

    public int getQ() {
        return q;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public int getnAgentes() {
        return nAgentes;
    }
    
   
}
