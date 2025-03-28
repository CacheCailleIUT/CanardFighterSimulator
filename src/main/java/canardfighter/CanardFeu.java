package canardfighter;

public class CanardFeu extends Canard {

    public CanardFeu(String _nom, int _pv, int _atk) {
        super(_nom, _pv, _atk, TypeCanard.FEU);
    }

    @Override
    public void activerCapaciteSpeciale() {
        // TODO Capacité spéciale
        if (!usedCapacite) {

        }
        usedCapacite = true;
    }
}
