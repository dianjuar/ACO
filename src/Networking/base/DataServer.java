package Networking.base;

import Networking.base.DataRecibe;
import Networking.base.DataSend;
import Networking.base.Encabezado_Mensajes;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class DataServer extends Thread
{
    private int puerto;
    private ServerSocket Ssocket;
    private Socket socket;
    
    private DataRecibe D_r;
    protected DataSend D_s;
    
    private String nombreConexion;
    private boolean pararHilo;
    
    
    private boolean connected;
    
    
    public DataServer(int puerto, String nombreConexion) 
    {        
        this.puerto = puerto; 
        this.nombreConexion = nombreConexion;
        
        connected = false;
        
        pararHilo = false;
        
        try 
        {
            Ssocket = new ServerSocket(puerto);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(DataServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        start();
    }
    
    public void pararHilo()
    {
        pararHilo = true;
        cerrarConexioServer();
    }
    
    public void cerrarConexioServer()
    {   
        try 
        {
            D_r.cerrarConexion();
            D_s.cerrarConexion();
            socket.close();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(DataServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.resume();
    }
    
    public boolean isConnected(){ return connected; }
    
    public void run()
    {
        while(!pararHilo)
        {
            System.out.println("Esperando conexión entrante por el puerto "+puerto+". Conexion de "+nombreConexion);
            System.out.println("Esperando Conexion...");
            
            try 
            {
                socket = Ssocket.accept();
                connected = true;
                
                System.out.println("Conectado");

                D_s = new DataSend(socket);
                D_r = new DataRecibe(socket)
                {  
                    @Override
                    public void AnalizadorDeMensajes(String msj) 
                    {
                        if( msj.equalsIgnoreCase( Encabezado_Mensajes.Msj_cerrar ) )
                            cerrarConexioServer();
                        else
                            AnalizadorDeMensajesSERVER(msj);
                    }
                };
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(DataServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        this.suspend();
        }
        
        System.out.println("mori");
        
    }
    
    public abstract void AnalizadorDeMensajesSERVER(String msj);
    
}
