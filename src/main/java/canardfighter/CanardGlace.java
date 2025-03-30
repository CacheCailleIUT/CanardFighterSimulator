package canardfighter;

public class CanardGlace extends Canard {

    public CanardGlace(String _nom, int _pv, int _atk) {
        super(_nom, _pv, _atk, TypeCanard.GLACE);
    }

    @Override
    public void activerCapaciteSpeciale(Canard cible) {
        if (!usedCapacite) {
            cible.etatCanard = EtatCanard.GELE;
        }
        usedCapacite = true;
    }

    @Override
    public void comportementPostCapaciteSpeciale(Canard cible) {
        if (usedCapacite && cible.nbEtatTour == 2 && cible.etatCanard == EtatCanard.GELE) {
            cible.etatCanard = EtatCanard.NORMAL;
        }
    }
}
