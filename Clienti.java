package ServerClienti;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Clienti {
	public static DataOutputStream OUT = null;
        static Socket client = null;
        static DataInputStream IN = null;
    public static void main(String[] args) {
        Clienti chatter = new Clienti();
      	chatter.setUp();
      	chatter.letsChat();
    }
    private void setUp() {
        try {
            String ipOfserver = JOptionPane.showInputDialog("Enter the Server IP address: ");
            String portNo = JOptionPane.showInputDialog("Enter port number: ");
            client = new Socket(ipOfserver,Integer.parseInt(portNo));
            OUT = new DataOutputStream(client.getOutputStream());
            IN = new DataInputStream(client.getInputStream());
        }
        catch (UnknownHostException ex) {
            Logger.getLogger(Clienti.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) {
            Logger.getLogger(Clienti.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void letsChat() {
        new InterfataClienti();
        Thread listenFromServer = new Thread(new Listener());
        listenFromServer.start();
    }
}