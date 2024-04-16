
package za.ac.cput.studentenrolmentsystem;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonard
 */
public class ClientConnection 
{
    public ObjectInputStream in;
    public ObjectOutputStream out;
    public Socket socket;
    
    public void connectToServer()
    {
        try
        {
            socket = new Socket("localhost",5679);
            getStreams();
        }
        catch(IOException e)
        {
           JOptionPane.showMessageDialog(null,e.getMessage());
        }

    }
      
    public void getStreams()
    {
        try
        {
            out = new ObjectOutputStream(socket.getOutputStream());
            out.flush();
            in = new ObjectInputStream(socket.getInputStream());
           
        }
        catch(IOException e)
        {
           JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    public  void closeConnection() 
    {
        try
        {
            out.writeObject("Exit");
            out.flush();
            
            String response = (String)in.readObject();
            
            if(response.equals("Exit"))
            {
                in.close();
                out.close();
                socket.close();
                System.exit(0);
            }
            
        }
        catch(ClassNotFoundException | IOException cnfe)
        {
            JOptionPane.showMessageDialog(null,cnfe.getMessage());
        }

    }
}
