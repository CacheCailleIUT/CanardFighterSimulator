package canardfighter;

public enum TypeCanard {

    EAU, // 0
    FEU, // 1
    GLACE, // 2
    VENT; // 3

    private final double[][] matriceEff =
            new double[][] {
                    {0, 0, 1.0},
                    {0, 1, 1.5},
                    {0, 2, 0.5},
                    {0, 3, 0.5},

                    {1, 0, 0.5},
                    {1, 1, 1.0},
                    {1, 2, 1.5},
                    {1, 3, 1.0},

                    {2, 0, 1.0},
                    {2, 1, 0.5},
                    {2, 2, 1.0},
                    {2, 3, 1.5},

                    {3, 0, 1.5},
                    {3, 1, 1.0},
                    {3, 2, 0.5},
                    {3, 3, 1.0},


            };
    // TODO Multiplicateur d'attaque
    public static double getMultiplicateur(TypeCanard attaquant, TypeCanard cible) {
        return 0.0; // Stub
    }
}
