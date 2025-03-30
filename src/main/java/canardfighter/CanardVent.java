package canardfighter;

public class CanardVent extends Canard {

    public CanardVent(String _nom, int _pv, int _atk) {
        super(_nom, _pv, _atk, TypeCanard.VENT);
    }

    @Override
    public void activerCapaciteSpeciale(Canard cible) {
        if (peCapa != 0) {
            setVitesse(2);
            tourCapacite = 0;
            peCapa--;
        }
    }

    @Override
    public void comportementPostCapaciteSpeciale(Canard cible) {
        if (tourCapacite == 2) {
            setVitesse(1);
        }
        tourCapacite++;
    }
}
