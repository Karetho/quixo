package model.Joueurs;

/**
 * Created by Skygix on 12/11/2015.
 */
public abstract class Joueurs {

    //type du figure du joueur (rond, croix) rond = 1 croix = 2
    protected int figure;

    //Nom du joueur
    protected String nomJoueur;

    //ID du joueur : 0 = humain | 1 = bot
    protected int typeId;

    public Joueurs(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

    public  abstract void prendreCube(int i, int j);

    public  abstract void placerCube(int i, int j);

    public  abstract void bougerPiece(int i, int j);

    public String getNomJoueur() { return nomJoueur;}

    public void setNomJoueur(String nomJoueur) { this.nomJoueur = nomJoueur; }

}
