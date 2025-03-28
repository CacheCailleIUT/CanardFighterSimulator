package canardfighter;

public abstract class Canard {

    private final String nom;

    /**
     * Points de vie d'un Canard.
     * Si les points sont à 0 alors le Canard est KO
     * Les PV de base sont strictement positifs (> 0)
     */
    private int pv;

    private final int pvBase;

    /**
     * Points d'attaque d'un Canard
     * L'attaque d'un Canard est strictement positive (>= 0)
     */
    private int atk;

    /**
     * Type du canard
     */
    private final TypeCanard typeCanard;

    /**
     * Capacité spéciale une seule fois par combat.
     * Vérifie si elle a déjà été utilisé
     */
    protected boolean usedCapacite = false;

    public Canard(String _nom, int _pv, int _atk, TypeCanard _typeCanard) {
        this.nom = _nom;
        this.pv = _pv;
        this.pvBase = _pv;
        this.atk = _atk;
        this.typeCanard = _typeCanard;
    }

    public int attaquer(Canard cible) {
        return (int) (atk*TypeCanard.getMultiplicateur(typeCanard,cible.typeCanard));
    }

    public void subirDegats(int degats) {
        this.pv -= degats;
    }

    public boolean estKO() {
        return pv <= 0 ;
    }

    public abstract void activerCapaciteSpeciale();

    public String getNom() {
        return nom;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getPvBase() {
        return pvBase;
    }

    public int getAtk() {
        return atk;
    }

    public TypeCanard getTypeCanard() {
        return typeCanard;
    }

    @Override
    public String toString() {
        return "Nom : " + nom + ", PV : " + pv + ", ATK : " + atk + ", Type : " + typeCanard;
    }
}
