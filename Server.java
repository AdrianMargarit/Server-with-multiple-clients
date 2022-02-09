package ServerClienti;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Server {
    Socket individualServer = null;
    static String portNumber = null;
    public static List<DataOutputStream> OUTALL 
            = new ArrayList<DataOutputStream>();
    synchronized public static void add(DataOutputStream opStream){
        OUTALL.add(opStream);
    }
     synchronized public static void remove(DataOutputStream opStream) {
        OUTALL.remove(opStream);
    }
    synchronized  public static void sendToAll(String msg){
        for(DataOutputStream dop:OUTALL){
            try {
                dop.writeUTF(msg);
            }
            catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }    
    }
    public static void main(String[] args) {
        Server listener = new Server();  
        listener.setUp();
       	new InterfataServer();
        listener.Conversations(Integer.parseInt(portNumber));
    }
    private void setUp() {
         portNumber = JOptionPane.showInputDialog("Enter the port number to start the server: ");
    }
    private void Conversations(int port) {
        try {
            try (ServerSocket ss = new ServerSocket(port)) {
				InterfataServer.Conversations.setText("Server port number : " + port + "\n\n");
				while(true) {
				        individualServer = ss.accept();
				        Thread clientThread = new Thread(new ClientNou(individualServer));
				        clientThread.start();
				}
			}
        }
        catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}