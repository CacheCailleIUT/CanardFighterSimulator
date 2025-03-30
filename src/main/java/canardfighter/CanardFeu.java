package canardfighter;

public class CanardFeu extends Canard {

    public CanardFeu(String _nom, int _pv, int _atk) {
        super(_nom, _pv, _atk, TypeCanard.FEU);
    }

    @Override
    public void activerCapaciteSpeciale(Canard cible) {
        if (!usedCapacite) {
            int atk = getAtk();
            setAtk(atk *2);
        }
        usedCapacite = true;
    }

    @Override
    public void comportementPostCapaciteSpeciale(Canard cible) {
        if (usedCapacite && tourCapacite == 2) {
            setAtk(getAtkBase());
        }
        tourCapacite++;
    }
}
