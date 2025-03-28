package canardfighter;

public class CanardVent extends Canard {

    public CanardVent(String _nom, int _pv, int _atk) {
        super(_nom, _pv, _atk, TypeCanard.VENT);
    }

    @Override
    public void activerCapaciteSpeciale() {
        // TODO Capacité spéciale
        if (!usedCapacite) {

        }
        usedCapacite = true;
    }
}
