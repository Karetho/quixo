package multi;

import model.Jeu;
import model.Joueurs.Humains.Humains;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

/**
 * Created by Skygi_000 on 11/02/2016.
 */
public class ServeurTCP {

    private static ObjectInputStream ois;
    private static ObjectOutputStream oos;

    private static ServerSocket serverSocket;
    private static Socket clientSocket;

    private Jeu jeu;

    private static int portServer;

    public ServeurTCP(int port, Jeu jeu) {
        //Constructeur ServerTCP
        portServer = port;
        this.jeu = jeu;
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
        oos = null;
        ois = null;
        try {
            oos = new ObjectOutputStream(clientSocket.getOutputStream());
            ois = new ObjectInputStream(new BufferedInputStream(clientSocket.getInputStream()));
            System.out.println("Flux créés");
        } catch (IOException e) {
            System.err.println("Erreur lors de la création des flux entrée/sortie");
        }

        //Boucle principale
        while (true) {
            try {
                oos.writeObject(jeu.getPlateau());
                System.out.println("Plateau de jeu initial : ");
                for (int i = 0; i < jeu.getPlateau().getDimension_i(); i++) {
                    for (int j = 0; j < jeu.getPlateau().getDimension_j(); j++) {
                        System.out.print(jeu.getPlateau().getPlateauIJ(i, j).getFigure() + "|");
                    }
                    System.out.println("");
                }

                System.out.println("au tour du joueur 1");
                jeu.getPlateau().getPlateauIJ(0, 0).setFigure(1);
                oos.writeObject(jeu.getPlateau());
                for (int i = 0; i < jeu.getPlateau().getDimension_i(); i++) {
                    for (int j = 0; j < jeu.getPlateau().getDimension_j(); j++) {
                        System.out.print(jeu.getPlateau().getPlateauIJ(i, j).getFigure() + "|");
                    }
                    System.out.println("");
                }
                System.out.println("joueur 1 a joué, au tour du joueur 2 ");
                ois.readObject();
                System.out.println("Plateau de jeu : ");
                for (int i = 0; i < jeu.getPlateau().getDimension_i(); i++) {
                    for (int j = 0; j < jeu.getPlateau().getDimension_j(); j++) {
                        System.out.print(jeu.getPlateau().getPlateauIJ(i, j).getFigure() + "|");
                    }
                    System.out.println("");
                }
            }catch (Exception e) {
                e.getStackTrace();
            }
        }
    }

    private void deconnexion() {
        //Fermeture des flux et des sockets
        try {
            if (oos != null) {
                oos.close();
            }
            if (ois != null) {
                ois.close();
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
        ServeurTCP serveurTCP = new ServeurTCP(5000,new Jeu(new Humains("bob"),new Humains("alice")));

        serveurTCP.start();
    }
}
