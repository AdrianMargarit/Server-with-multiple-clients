package ServerClienti;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

class Listener implements Runnable {
    public Listener() {
    }
    String inString;
    @Override
    public void run() {
        try {
            while (true) {
                inString = Clienti.IN.readUTF();
                InterfataClienti.convoArea.append("\n" + inString);
            }
        }
        catch (IOException ex) {
            Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Clienti.IN.close();
            Clienti.OUT.close();
            Clienti.client.close();
        }
        catch (IOException ex) {
            Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}