package multi;


import model.Plateau;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Skygi_000 on 11/02/2016.
 */
public class ClientTCP{

    private static Socket socket;

    private static ObjectInputStream ois;
    private static ObjectOutputStream oos;

    private static int portClient;
    private static String iperveur;

    private static Plateau plateau;

    public ClientTCP(String ip) {
        //Constructeur ClientTCP
        portClient = 5000;
        iperveur = ip;
        plateau = null;
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
        ois = null;
        oos = null;
        try {
            ois = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
            oos = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("flux créés");
        } catch (IOException e) {
            System.err.println("Erreur création flux" + e);
        }

        while (true) {
            try {
                plateau = (Plateau) ois.readObject();
                System.out.println("Plateau de jeu initial : ");
                for (int i = 0; i < plateau.getDimension_i(); i++) {
                    for (int j = 0; j < plateau.getDimension_j(); j++) {
                        System.out.print(plateau.getPlateauIJ(i, j).getFigure() + "|");
                    }
                    System.out.println("");
                }

                System.out.println("Au tour du joueur 1 ");
                plateau = (Plateau) ois.readObject();
                for (int i = 0; i < plateau.getDimension_i(); i++) {
                    for (int j = 0; j < plateau.getDimension_j(); j++) {
                        System.out.print(plateau.getPlateauIJ(i, j).getFigure() + "|");
                    }
                    System.out.println("");
                }
                System.out.println("Le joueur 1 a joué, au tour du joueur 2");
                plateau.getPlateauIJ(1,1).setFigure(2);
                oos.writeObject(plateau);
                System.out.println("Plateau de jeu : ");
                for (int i = 0; i < plateau.getDimension_i(); i++) {
                    for (int j = 0; j < plateau.getDimension_j(); j++) {
                        System.out.print(plateau.getPlateauIJ(i, j).getFigure() + "|");
                    }
                    System.out.println("");
                }
                if (socket.isClosed()) {
                    deconnexion();
                }
                break;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        deconnexion();
    }

   private void deconnexion() {
        //Fermeture des flux et des sockets
        try {
            if (ois != null) {
                ois.close();
            }
            if (oos != null) {
                oos.close();
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
