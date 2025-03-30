package canardfighter;

public class CanardGlace extends Canard {

    public CanardGlace(String _nom, int _pv, int _atk) {
        super(_nom, _pv, _atk, TypeCanard.GLACE);
    }

    @Override
    public void activerCapaciteSpeciale(Canard cible) {
        if (peCapa != 0) {
            cible.etatCanard = EtatCanard.GELE;
            peCapa--;
            cible.nbEtatTour = 0;
        }
    }

    @Override
    public void comportementPostCapaciteSpeciale(Canard cible) {
        if (cible.nbEtatTour == 2 && cible.etatCanard == EtatCanard.GELE) {
            cible.etatCanard = EtatCanard.NORMAL;
        }
    }
}
