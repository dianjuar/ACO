package Networking;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class DataServer extends Thread
{
    protected int puerto;
    protected ServerSocket Ssocket;
    protected Socket socket;
    protected String nombreConexion;
    protected boolean pararHilo;
    
    protected static final String Msjdivisor = "-";
    protected static final String MsjConnect = "connect";
    protected static final String MsjDefault_test ="test";
    
    private  DataInputStream in;
    
    public DataServer(int puerto, String nombreConexion) 
    {        
        pararHilo = false;
        this.puerto = puerto;
        this.nombreConexion = nombreConexion;
        
        try 
        {
            Ssocket = new ServerSocket(puerto);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(DataServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
            socket.close();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(DataServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void run()
    {
        System.out.println("Esperando conexión entrante por el puerto "+puerto+". Conexion de "+nombreConexion);
        String msj = null;
        System.out.println("Esperando Conexion...");
        
        try 
        {
            socket = Ssocket.accept();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(DataServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Conectado");
        
        while(!pararHilo)
        {
            try 
            {                
                in = new DataInputStream(socket.getInputStream());
                
                byte bytesReaded[] = new byte[65535];

                int numberOfBytes = in.read(bytesReaded);
                msj = new String(bytesReaded,0, numberOfBytes);

                System.out.println("*******************");
                System.out.println("String recibido...");
                System.out.println(msj);
                System.out.println("*******************");
                
                if(msj.compareToIgnoreCase( MsjDefault_test )!=0)
                    AnalizadorDeMensajes(msj);
                else
                {
                    in.close();
                    socket.close();
                    socket = Ssocket.accept();
                } 
            }
            catch (IOException ex)
            {                
                Logger.getLogger(DataServer.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
    }
    
    public abstract void AnalizadorDeMensajes(String msj);
    
}
