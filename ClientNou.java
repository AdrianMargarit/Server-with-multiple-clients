package ServerClienti;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientNou implements Runnable{
    Socket newClient;
    DataInputStream IN;
    DataOutputStream OUT;
    public ClientNou(Socket s){
    	this.newClient = s;
	}
    @Override
    public void run() {
        try {
            try {
                IN = new DataInputStream(newClient.getInputStream());
                OUT = new DataOutputStream(newClient.getOutputStream());
                String hostName = newClient.getInetAddress().getHostName();
                Server.add(OUT);
                String str;
                try{
                    while((str = IN.readUTF())!=null)
                    {
                    InterfataServer.Conversations.append("\n"+hostName+"::"+str);
                    Server.sendToAll(hostName+"::"+str);
                    }
                }catch(Exception ex){System.out.println(ex);} 
                }catch (IOException ex) {
                Logger.getLogger(ClientNou.class.getName()).log(Level.SEVERE, null, ex);
            } 
        Server.remove(OUT);
                IN.close();
                OUT.close();
                newClient.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientNou.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
}