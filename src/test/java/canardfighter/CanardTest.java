package canardfighter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CanardTest {

    private static Canard canardEau;

    @BeforeEach
    void setUp() {
        canardEau = new CanardEau("Tiplouf",120,25);
    }

    @Test
    void testAttaquerFort() {
        // Given un Canard de Type Eau et un Canard de type Feu
        Canard canardFeu = new CanardFeu("Salameche", 120, 25);
        // When le canard de type eau attaque le canard de type feu
        int dgt = canardEau.attaquer(canardFeu);
        // Then le canard de type eau fera 25*1.5 (37) dégats
        Assertions.assertEquals(37,dgt);
    }
    @Test
    void testAttaquerNeutre() {
        // Given un Canard de Type Eau
        // When le canard de type eau attaque un canard de type eau
        int dgt = canardEau.attaquer(canardEau);
        // Then le canard de type eau fera 25*1 dégats
        Assertions.assertEquals(25,dgt);
    }

    @Test
    void testAttaquerFaible() {
        // Given un Canard de Type Feu et un Canard de type eau
        Canard canardFeu = new CanardFeu("Salameche", 120, 30);
        // When le canard de type feu attaque le canard de type eau
        int dgt = canardFeu.attaquer(canardEau);
        // Alors le canard de type feu fera 30*0.5 dégats
        Assertions.assertEquals(15,dgt);
    }

    @Test
    void testSubirDegats() {
        // Given un canard avec 120 PV
        // When il prend 30 de dégats
        canardEau.subirDegats(30);
        // Then il lui reste 90 PV
        Assertions.assertEquals(90, canardEau.getPv());
    }

    @Test
    void testEstKO() {
        // Given un canard ayant < 0 PV
        canardEau.subirDegats(300);
        // Then le canard est KO
        Assertions.assertTrue(canardEau.estKO());
    }

    @Test
    void testResetCanard() {
        // Given un canard ayant pris des dégats et étant gelé
        canardEau.subirDegats(20);
        canardEau.etatCanard = EtatCanard.GELE;
        // When le combat est fini
        // Then le canard est réinitialisé
        canardEau.resetCanard();
        Assertions.assertEquals(canardEau.getPvBase(), canardEau.getPv());
        Assertions.assertEquals(EtatCanard.NORMAL, canardEau.getEtatCanard());
    }

    @Test
    void testToString() {
        // Given un canard de type eau
        // When on veut afficher le canard
        String toString = canardEau.toString();
        // Then son nom, ses PV, ses PA et son type sont affichés
        Assertions.assertEquals("Nom : " + canardEau.getNom() + ", PV : " + canardEau.getPv()
                + ", ATK : " + canardEau.getAtk() + ", Type : " + canardEau.getTypeCanard(), toString);
    }
}