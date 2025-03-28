package canardfighter;

public enum TypeCanard {

    EAU(0), // 0
    FEU(1), // 1
    GLACE(2), // 2
    VENT(3); // 3

    public final int value;

    TypeCanard(int value) {
        this.value = value;
    }

    private final static double[][] matriceEff =
            new double[][] {
                    {1.0, 1.5, 0.5, 0.5}, // EAU

                    {0.5, 1.0, 1.5, 1.0}, // FEU

                    {1.0, 0.5, 1.0, 1.5}, // GLACE

                    {1.5, 1.0, 0.5, 1.0} // VENT
            };

    public static double getMultiplicateur(TypeCanard attaquant, TypeCanard cible) {
        return matriceEff[attaquant.value][cible.value];
    }

    public static boolean isEnum(int type) {
        try {
            return matriceEff[type].length > 0;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }
}
