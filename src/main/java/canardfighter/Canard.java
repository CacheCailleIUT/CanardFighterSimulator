package canardfighter;

public abstract class Canard {

    /**
     * Nom du Canard
     */
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
    private final int atkBase;

    /**
     * Type du canard
     */
    private final TypeCanard typeCanard;

    /**
     * Vitesse du canard pour déterminer qui attaque en premier au début de chaque tour
     */
    private int vitesse;



    /**
     * Capacité spéciale une seule fois par combat.
     * Vérifie si elle a déjà été utilisé
     */
    protected boolean usedCapacite = false;
    protected int tourCapacite = 0;

    protected EtatCanard etatCanard;
    protected int nbEtatTour = 0;

    public Canard(String _nom, int _pv, int _atk, TypeCanard _typeCanard) {
        this.nom = _nom;
        this.pv = _pv;
        this.pvBase = _pv;
        this.atk = _atk;
        this.atkBase = _atk;
        this.typeCanard = _typeCanard;
        this.etatCanard = EtatCanard.NORMAL;
        this.vitesse = 1;
    }

    public int attaquer(Canard cible) {
        return (int) (atk*TypeCanard.getMultiplicateur(typeCanard,cible.typeCanard));
    }

    public void subirDegats(int degats) {
        this.pv = Math.max(this.pv - degats, 0);
    }

    public boolean estKO() {
        return pv <= 0 ;
    }

    public abstract void activerCapaciteSpeciale(Canard cible);

    public abstract void comportementPostCapaciteSpeciale(Canard cible);

    public String getNom() {
        return nom;
    }

    public int getPv() {
        return pv;
    }

    protected void setPv(int pv) {
        this.pv = pv;
    }

    public int getPvBase() {
        return pvBase;
    }

    public int getAtk() {
        return atk;
    }

    protected void setAtk(int atk) {
        this.atk = atk;
    }



    public int getAtkBase() {
        return atkBase;
    }

    public int getVitesse() {
        return vitesse;
    }

    protected void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }


    public TypeCanard getTypeCanard() {
        return typeCanard;
    }

    public EtatCanard getEtatCanard() {
        return etatCanard;
    }

    public void resetCanard() {
        this.etatCanard = EtatCanard.NORMAL;
        this.usedCapacite = false;
        this.nbEtatTour = 0;
        this.tourCapacite = 0;
        this.pv = this.pvBase;
        this.atk = this.atkBase;
    }

    @Override
    public String toString() {
        return "Nom : " + nom + ", PV : " + pv + ", ATK : " + atk + ", Type : " + typeCanard;
    }
}
