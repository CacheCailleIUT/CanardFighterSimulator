package canardfighter;

public class CanardEau extends Canard {

    private final int REGEN_CAPA = 20;

    public CanardEau(String _nom, int _pv, int _atk) {
        super(_nom, _pv, _atk, TypeCanard.EAU);
    }

    @Override
    public void activerCapaciteSpeciale() {
        if (!usedCapacite) {
            int pvActuelle = getPv();
            pvActuelle += REGEN_CAPA;
            if (pvActuelle >= getPvBase()) {
                pvActuelle = getPvBase();
            }
            setPv(pvActuelle);
        }
        usedCapacite = true;
    }
}
