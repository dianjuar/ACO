/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Networking.base;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego_juliao
 */
public class DataSend 
{
    private Socket soc;
    private DataOutputStream dos;

    public DataSend(Socket soc) 
    {
        this.soc = soc;
        try 
        {
            dos = new DataOutputStream( soc.getOutputStream() );
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(DataSend.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void enviar(byte sms[])
    {
        try 
        {
            dos.write( sms );
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(DataSend.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void enviar(String sms)
    {
        try 
        {
            dos.write( sms.getBytes() );
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(DataSend.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cerrarConexion()
    {
        try 
        {
            dos.close();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(DataSend.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
