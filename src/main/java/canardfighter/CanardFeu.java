package canardfighter;

public class CanardFeu extends Canard {

    public CanardFeu(String _nom, int _pv, int _atk) {
        super(_nom, _pv, _atk, TypeCanard.FEU);
    }

    @Override
    public void activerCapaciteSpeciale(Canard cible) {
        if (peCapa != 0) {
            int atk = getAtk();
            setAtk(atk *2);
            peCapa--;
            tourCapacite = 0;
        }

    }

    @Override
    public void comportementPostCapaciteSpeciale(Canard cible) {
        if (tourCapacite == 2) {
            setAtk(getAtkBase());
        }
        tourCapacite++;
    }
}
