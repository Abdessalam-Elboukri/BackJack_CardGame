package app.Classes;

public class Card {

    private int hauteur;
    private int couleur;

    public Card( int hauteur, int couleur) {
        this.hauteur = hauteur;
        this.couleur = couleur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public int getCouleur() {
        return couleur;
    }

    public void setCouleur(int couleur) {
        this.couleur = couleur;
    }
}

