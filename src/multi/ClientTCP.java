package multi;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Skygi_000 on 11/02/2016.
 */
public class ClientTCP extends Thread {

    private static Socket socket;

    private static BufferedReader br;
    private static BufferedWriter bw;

    private static int portClient;
    private static String iperveur;

    public ClientTCP(int port, String ip) {
        //Constructeur ClientTCP
        portClient = port;
        iperveur = ip;
    }

    public void run() {
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
        bw = null;
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            System.out.print("flux créés");
        } catch (IOException e) {
            System.err.println("Erreur création flux" + e);
        }

        while (true) {
            String message = "Bonjour Serveur";
            System.out.println("message = " + message);
            try {
                bw.write(message);
                System.out.print(br.readLine());
                System.out.print(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void deconnexion() {
        //Fermeture des flux et des sockets
        try {
            if (br != null) {
                br.close();
            }
            if (bw != null) {
                bw.close();
            }
           if (socket != null) {
               socket.close();
           }
        } catch (IOException e) {
            System.err.println("Erreur Fermeture flux et sockets");
        }
    }

    public static void main(String[] args) {

        ClientTCP clientTCP = new ClientTCP(5000,"localhost");


        clientTCP.start();
        //clientTCP.deconnexion();
    }
}
