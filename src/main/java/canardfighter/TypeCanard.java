package canardfighter;

public enum TypeCanard {

    EAU,
    FEU,
    GLACE,
    VENT;

    // TODO Multiplicateur d'attaque
    public static double getMultiplicateur(TypeCanard attaquant, TypeCanard cible) {
        return 0.0; // Stub
    }
}
