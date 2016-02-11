package multi;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Skygi_000 on 11/02/2016.
 */
public class ServeurTCP extends Thread {

    private static BufferedReader br;
    private static BufferedWriter bw;

    private static ServerSocket serverSocket;
    private static Socket clientSocket;

    private static int portServer;

    public ServeurTCP(int port) {
        //Constructeur ServerTCP
        portServer = port;
    }

    public void run() {
        //Création de la socket du serveur
        serverSocket = null;
        try {
            serverSocket = new ServerSocket(portServer);
            System.out.println("Serveur opérationnel");
        } catch (IOException e) {
            System.err.println("Création de la socket du serveur impossible");
        }

        //Attente d'un client
        clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
            System.out.println("Client connécté");
        } catch (IOException e) {
            System.err.println("Erreur lors connexion du client");
        }

        if (clientSocket == null) {
            return;
        }

        //Création flux entrée/sortie
        br = null;
        bw = null;
        try {
            br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            bw = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            System.out.println("Flux créés");
        } catch (IOException e) {
            System.err.println("Erreur lors de la création des flux entrée/sortie");
        }

        //Boucle principale
        while (true) {

            String message = "";

            try {
                message = br.readLine();
                System.out.println("message = " + message);
                bw.write("Bienvenu client");
                if (!message.isEmpty())
                    bw.write("J'ai bien recu votre message\n"+message);

            } catch (IOException e) {
                System.err.println("Erreur lors de la lecture du message");
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
            if (clientSocket != null) {
                clientSocket.close();
            }
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (IOException e) {
            System.err.println("Erreur Fermeture flux et sockets");
        }
    }

    public static BufferedReader getBr() {
        return br;
    }

    public static void setBr(BufferedReader br) {
        ServeurTCP.br = br;
    }

    public static BufferedWriter getBw() {
        return bw;
    }

    public static void setBw(BufferedWriter bw) {
        ServeurTCP.bw = bw;
    }

    public static int getPortServer() {
        return portServer;
    }

    public static void main(String[] args) {
        ServeurTCP serveurTCP = new ServeurTCP(5000);

        serveurTCP.start();
        //serveurTCP.deconnexion();
    }
}