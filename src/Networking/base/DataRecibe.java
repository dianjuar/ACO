/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Networking.base;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego_juliao
 */
public abstract class DataRecibe extends Thread
{
    protected Socket socket;
    protected boolean pararHilo;

    private  DataInputStream in;
    
    public DataRecibe(Socket s) 
    {        
        pararHilo = false;
        
        socket = s;        
        
        try 
        {
            in = new DataInputStream(s.getInputStream());
        } 
        catch (IOException ex)
        {
            Logger.getLogger(DataRecibe.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        iniciarHilo();
    }
    
    public void pararHilo()
    {
        pararHilo = true;
    }
    
    public void iniciarHilo()
    {
        pararHilo = false;
        start();
    }
    
    public void cerrarConexion()
    {
        pararHilo();
        
        try 
        {
            in.close();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(DataServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void run()
    {
        String msj = null;
        
        while(!pararHilo)
        {
            try 
            {                
                byte bytesReaded[] = new byte[65535];

                int numberOfBytes = in.read(bytesReaded);
                msj = new String(bytesReaded,0, numberOfBytes);

                System.out.println("*******************");
                System.out.println("String recibido...");
                System.out.println(msj);
                System.out.println("*******************");
                AnalizadorDeMensajes(msj); 
            }
            catch (IOException ex)
            {                
                Logger.getLogger(DataServer.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
    }
    
    public abstract void AnalizadorDeMensajes(String msj);   
}
