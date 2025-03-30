package canardfighter;

public class CanardVent extends Canard {

    public CanardVent(String _nom, int _pv, int _atk) {
        super(_nom, _pv, _atk, TypeCanard.VENT);
    }

    @Override
    public void activerCapaciteSpeciale(Canard cible) {
        // TODO Capacité spéciale
        if (!usedCapacite) {
            setVitesse(2);
        }
        usedCapacite = true;
    }

    @Override
    public void comportementPostCapaciteSpeciale(Canard cible) {
        if (usedCapacite && tourCapacite == 2) {
            setVitesse(1);
        }
        tourCapacite++;
    }
}
