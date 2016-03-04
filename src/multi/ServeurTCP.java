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

    private static DataInputStream dis;
    private static DataOutputStream dos;

    private static ServerSocket serverSocket;
    private static Socket clientSocket;

    private static int coordi,coordj;
    private Jeu jeu;

    private static int portServer;

    public ServeurTCP(int port, Jeu jeu) {
        //Constructeur ServerTCP(int port , Jeu jeu)
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
        dos = null;
        dis = null;
        try {
            dos = new DataOutputStream(clientSocket.getOutputStream());
            dis = new DataInputStream(clientSocket.getInputStream());
            System.out.println("Flux créés");
        } catch (IOException e) {
            System.err.println("Erreur lors de la création des flux entrée/sortie");
        }

        //Boucle principale
        while (true) {
            try {
                System.out.println("Plateau de jeu initial : ");
                for (int i = 0; i < jeu.getPlateau().getDimension_i(); i++) {
                    for (int j = 0; j < jeu.getPlateau().getDimension_j(); j++) {
                        System.out.print(jeu.getPlateau().getPlateauIJ(i, j).getFigure() + "|");
                    }
                    System.out.println("");
                }

                System.out.println("au tour du joueur 1");
                jeu.getPlateau().getPlateauIJ(0,0).setFigure(1);
                dos.writeInt(0);
                dos.writeInt(0);
                for (int i = 0; i < jeu.getPlateau().getDimension_i(); i++) {
                    for (int j = 0; j < jeu.getPlateau().getDimension_j(); j++) {
                        System.out.print(jeu.getPlateau().getPlateauIJ(i, j).getFigure() + "|");
                    }
                    System.out.println("");
                }
                System.out.println("joueur 1 a joué, au tour du joueur 2 ");
                coordi = dis.readInt();
                coordj = dis.readInt();
                jeu.getPlateau().getPlateauIJ(coordi,coordj).setFigure(2);
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
            if (dis != null) {
                dis.close();
            }
            if (dos != null) {
                dos.close();
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
