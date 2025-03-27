package canardfighter;

public class CanardEau extends Canard {

    public CanardEau(String _nom, int _pv, int _atk) {
        super(_nom, _pv, _atk, TypeCanard.EAU);
    }

    @Override
    public void activerCapaciteSpeciale() {
        // TODO Capacité spéciale
    }
}
