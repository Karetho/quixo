package multi;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Skygi_000 on 11/02/2016.
 */
public class ServeurTCP {

    private static BufferedReader br;
    private static PrintStream ps;

    private static ServerSocket serverSocket;
    private static Socket clientSocket;

    private static int portServer;

    public ServeurTCP(int port) {
        //Constructeur ServerTCP
        portServer = port;
    }

    public void start() {
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
        ps = null;
        try {
            br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            ps = new PrintStream(clientSocket.getOutputStream());
            System.out.println("clientSocket = " + clientSocket.getLocalPort());
            System.out.println("serverSocket = " + serverSocket.getLocalPort());
            System.out.println("Flux créés");
        } catch (IOException e) {
            System.err.println("Erreur lors de la création des flux entrée/sortie");
        }

        //Boucle principale
        while (true) {

            String message = "";

            try {
                message = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

                if (message != null && !message.isEmpty()) {
                    System.out.println("message = " + message);
                    ps.println("J'ai bien recu votre message\n"+message);
                }

            ps.println("Bienvenu client");
            try {
                System.out.println(br.readLine());
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

    public static void main(String[] args) {
        ServeurTCP serveurTCP = new ServeurTCP(5000);

        serveurTCP.start();
    }
}
