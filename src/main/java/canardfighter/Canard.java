package canardfighter;

public class Canard {

    private String nom;

    /**
     * Points de vie d'un Canard.
     * Si les points sont à 0 alors le Canard est KO
     * Les PV de base sont strictement positifs (> 0)
     */
    private int pv;

    /**
     * Points d'attaque d'un Canard
     * L'attaque d'un Canard est strictement positive (>= 0)
     */
    private int atk;

    private TypeCanard typeCanard;

    public int attaquer(Canard cible) {
        return 0; // stub
    }

    public void subirDegats(int degats) {
        this.pv -= degats;
    }

    public boolean estKO() {
        return pv == 0 ;
    }

    public String getNom() {
        return nom;
    }

    public int getPv() {
        return pv;
    }

    public int getAtk() {
        return atk;
    }

    public TypeCanard getTypeCanard() {
        return typeCanard;
    }
}
