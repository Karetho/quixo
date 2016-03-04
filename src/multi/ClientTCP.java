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

    private static DataInputStream dis;
    private static DataOutputStream dos;

    private static  int coordiJ1,coordjJ1;

    private static int portClient;
    private static String iperveur;

    private static Plateau plateau;

    public ClientTCP(String ip) {
        //Constructeur ClientTCP(String ip) => ip correspond à l'adresse ip du Client
        portClient = 5000;
        iperveur = ip;
        plateau = new Plateau();
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
                System.err.println("Erreur Création socket" + e);
            }
        }

        //Création flux entrée/sortie
        dis = null;
        dos = null;
        try {
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
            System.out.println("flux créés");
        } catch (IOException e) {
            System.err.println("Erreur création flux" + e);
        }

        while (true) {
            try {
                System.out.println("Plateau de jeu initial : ");
                for (int i = 0; i < plateau.getDimension_i(); i++) {
                    for (int j = 0; j < plateau.getDimension_j(); j++) {
                        System.out.print(plateau.getPlateauIJ(i, j).getFigure() + "|");
                    }
                    System.out.println("");
                }

                System.out.println("Au tour du joueur 1 ");
                coordiJ1 = dis.readInt();
                coordjJ1 = dis.readInt();
                plateau.getPlateauIJ(coordiJ1,coordjJ1).setFigure(1);
                for (int i = 0; i < plateau.getDimension_i(); i++) {
                    for (int j = 0; j < plateau.getDimension_j(); j++) {
                        System.out.print(plateau.getPlateauIJ(i, j).getFigure() + "|");
                    }
                    System.out.println("");
                }
                System.out.println("Le joueur 1 a joué, au tour du joueur 2");
                plateau.getPlateauIJ(1,1).setFigure(2);
                dos.writeInt(1);
                dos.writeInt(1);
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
            }
        }
        deconnexion();
    }

   private void deconnexion() {
        //Fermeture des flux et des sockets
        try {
            if (dos != null) {
                dos.close();
            }
            if (dis != null) {
                dis.close();
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
