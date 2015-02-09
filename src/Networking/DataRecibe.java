package Networking;

import java.io.DataInputStream;
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
    
    private boolean msjImportante;
    private String MsjDefault_test;

    public DataRecibe(int puerto, String nombreConexion) 
    {
        MsjDefault_test = "test";
        msjImportante = false;
        
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
        String msj = null;
        
        while(!msjImportante)
        {
            DataInputStream in;
            try 
            {
                System.out.println("Esperando Conexion...");
                socket = Ssocket.accept();
                System.out.println("Conectado");
                
                in = new DataInputStream(socket.getInputStream());
                
                byte bytesReaded[] = new byte[65535];

                int numberOfBytes = in.read(bytesReaded);
                msj = new String(bytesReaded,0, numberOfBytes);

                System.out.println(numberOfBytes);

                if(msj.compareToIgnoreCase( MsjDefault_test )!=0)
                {
                    msjImportante=true;
                    in.close();
                    socket.close();
                }                
            }
            catch (IOException ex)
            {                
                Logger.getLogger(DataRecibe.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        
        AnalizadorDeMensajes(msj);
    }
    
    public abstract void AnalizadorDeMensajes(String msj);
    
}
