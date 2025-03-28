package canardfighter;

public class CanardGlace extends Canard {

    public CanardGlace(String _nom, int _pv, int _atk) {
        super(_nom, _pv, _atk, TypeCanard.GLACE);
    }

    @Override
    public void activerCapaciteSpeciale() {
        if (!usedCapacite) {

        }
        usedCapacite = true;
    }
}
