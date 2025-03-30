package canardfighter;

public class CanardEau extends Canard {

    private final int REGEN_CAPA = 20;

    public CanardEau(String _nom, int _pv, int _atk) {
        super(_nom, _pv, _atk, TypeCanard.EAU);
    }

    @Override
    public void activerCapaciteSpeciale(Canard cible) {
        if (peCapa != 0) {
            int pvActuelle = getPv();
            pvActuelle += REGEN_CAPA;
            if (pvActuelle >= getPvBase()) {
                pvActuelle = getPvBase();
            }
            System.out.println(getNom() + " s'est soigné de " + (pvActuelle - getPv()) + " PV.\n" + getNom() + " a " + pvActuelle + " PV restants.");
            setPv(pvActuelle);
            peCapa--;
        } else {
            System.out.println("Capacité spécial déjà utilisé pour ce combat !");
        }

    }

    @Override
    public void comportementPostCapaciteSpeciale(Canard cible) {

    }
}
