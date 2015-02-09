package Networking;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class DataRecibe extends Thread
{
    protected int puerto;
    protected ServerSocket Ssocket;
    protected Socket socket;
    protected String nombreConexion;

    public DataRecibe(int puerto, String nombreConexion) 
    {
        this.puerto = puerto;
        this.nombreConexion = nombreConexion;
        
        try 
        {
            Ssocket = new ServerSocket(puerto);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(DataRecibe.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void run()
    {
        System.out.println("Esperando conexión entrante por el puerto "+puerto+". Conexion de "+nombreConexion);
        
        try 
        {
            socket = Ssocket.accept();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(DataRecibe.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        funcion();
    }
    
    public abstract void funcion();
    
}
