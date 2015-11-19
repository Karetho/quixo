package model.Joueurs.Humains;


import model.Joueurs.Joueurs;

/**
 * Created by Skygix on 12/11/2015.
 */
public class Humains extends Joueurs {

    public Humains() {
        super("Humain");
        typeId = HUMAIN;
    }

    public int getTypeIdJoueur() { return super.getTypeIdJoueur(); }

    public boolean isAlignees() { return super.isAlignees(); }

    public void setCasesAlignees(boolean valeur) {
        super.setCasesAlignees(valeur);
    }

    public String getNomJoueur() { return super.getNomJoueur();}

    public void setNomJoueur(String nomJoueur) { super.setNomJoueur(nomJoueur); }
}
