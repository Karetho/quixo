package model.Joueurs;

/**
 * Created by Skygix on 12/11/2015.
 */
public abstract class Joueurs {

    public static final int HUMAIN = 0;
    public static final int BOT = 1;




    //Nom du joueur
    protected String nomJoueur;

    //Alignement des cases
    protected boolean casesAlignees;

    //ID du joueur : 0 = humain | 1 = bot
    protected int typeId;

    public Joueurs(String nomJoueur) {
        this.nomJoueur = nomJoueur;
        casesAlignees = false;
    }

    public  abstract void prendreCube(int i, int j);

    public  abstract void placerCube(int i, int j);

    public  abstract void bougerPiece(int i, int j);

    public int getTypeIdJoueur() { return typeId; }

    public boolean isAlignees() { return casesAlignees; }

    public void setCasesAlignees(boolean valeur) {
        casesAlignees = valeur;
    }

    public String getNomJoueur() { return nomJoueur;}

    public void setNomJoueur(String nomJoueur) { this.nomJoueur = nomJoueur; }

}
