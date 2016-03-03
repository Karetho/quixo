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
            ois = new ObjectInputStream(clientSocket.getInputStream());
            System.out.println("Flux créés");
        } catch (IOException e) {
            System.err.println("Erreur lors de la création des flux entrée/sortie");
        }

        //Boucle principale
        while (true) {

            System.out.println("Plateau de jeu : ");
            for (int i = 0; i < jeu.getPlateau().getDimension_i(); i++) {
                for (int j = 0; j < jeu.getPlateau().getDimension_j(); j++) {
                    System.out.print(jeu.getPlateau().getPlateauIJ(i, j).getFigure() + "|");
                }
                System.out.println("");
            }
            String message = "";

            /*try {
                message = ois.readUTF();
                if (message != null && !message.isEmpty()) {
                    System.out.println("message = " + message);
                    if (Objects.equals(message, "Au revoir serveur")) {
                        break;
                    }
                    else {
                        try {
                            oos.writeChars("J'ai bien recu votre message\n" + message);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }*/


            /*try {
                oos.writeChars("Bienvenu client");
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                System.out.println(ois.readUTF());
                deconnexion();
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }*/

            try {
                oos.writeObject(jeu.getPlateau());
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("au tour du joueur 1");
            jeu.getPlateau().getPlateauIJ(0,0).setFigure(1);
            try {
                oos.writeObject(jeu.getPlateau());
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("joueur 1 a joué, au tour du joueur 2 ");
            try {
                ois.readObject();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            deconnexion();
            System.out.println("Plateau de jeu : ");
            for (int i = 0; i < jeu.getPlateau().getDimension_i(); i++) {
                for (int j = 0; j < jeu.getPlateau().getDimension_j(); j++) {
                    System.out.print(jeu.getPlateau().getPlateauIJ(i, j).getFigure() + "|");
                }
                System.out.println("");
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
