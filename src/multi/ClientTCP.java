package multi;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Skygi_000 on 11/02/2016.
 */
public class ClientTCP{

    private static Socket socket;

    private static BufferedReader br;
    private static PrintStream ps;

    private static int portClient;
    private static String iperveur;

    public ClientTCP(String ip) {
        //Constructeur ClientTCP
        portClient = 5000;
        iperveur = ip;
    }

    public void start() {
        //Création socket
        socket = null;

        while (socket == null) {
            try {
                socket = new Socket(iperveur,portClient);
                System.out.println("Connexion au serveur");
                break;
            } catch (UnknownHostException e) {
                System.err.println("Erreur hôte" + e);
            } catch (IOException e) {
                System.err.println("Erreur Créatioon socket" + e);
            }
        }

        //Création flux entrée/sortie
        br = null;
        ps = null;
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            ps = new PrintStream(socket.getOutputStream());
            System.out.println("flux créés");
        } catch (IOException e) {
            System.err.println("Erreur création flux" + e);
        }

        while (true) {
            String message = "Bonjour Serveur";
            System.out.println("message = " + message);
            try {
                ps.println(message);
                System.out.println(br.readLine());
                System.out.println(br.readLine());
                message = "Au revoir serveur";
                System.out.println(message);
                ps.print(message);
                deconnexion();
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

   private void deconnexion() {
        //Fermeture des flux et des sockets
        try {
            if (br != null) {
                br.close();
            }
            if (ps != null) {
                ps.close();
            }
           if (socket != null) {
               socket.close();
           }
        } catch (IOException e) {
            System.err.println("Erreur Fermeture flux et sockets");
        }
    }

    public static void main(String[] args) {

        ClientTCP clientTCP = new ClientTCP("localhost");


        clientTCP.start();

    }
}
