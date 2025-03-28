package canardfighter;

import java.util.List;
import java.util.Scanner;

public class Main {

    private List<Canard> canardCrees;

    public static void main(String[] args) {
        System.out.println("1. Créer des canards\n2. Lancer une bataille\n3. Quitter");
        Scanner scan = new Scanner(System.in);
        System.out.print("Votre choix : ");
        while (!scan.hasNextInt()) {
            scan.next();
        }
        int choix = scan.nextInt();
        switch (choix) {
            case 1:
                System.out.println("Comment s'appelle votre canard ?");

                System.out.print("Nom : ");
                String nom = scan.nextLine();

                System.out.println("Combien de points de vie à votre canard ?");
                while (!scan.hasNextInt() && scan.nextInt() <= 0) {
                    scan.next();
                    System.out.println("Veuillez entrer un entier strictement positif");
                    System.out.print("PV : ");
                }
                int pv = scan.nextInt();

                System.out.println("Combien de points d'attaque à votre canard ?");
                while (!scan.hasNextInt() && scan.nextInt() <= 0) {
                    scan.next();
                    System.out.println("Veuillez entrer un entier strictement positif");
                    System.out.print("ATK : ");
                }
                int atk = scan.nextInt();

                System.out.println("Quel est le type de votre canard ?\n(Type accepté : EAU, FEU, GLACE, VENT)");
                System.out.print("Type : ");
                String type = scan.nextLine();
                while (!TypeCanard.isEnum(type)) {
                    System.out.println("Veuillez entrer un type correct\n(Type accepté : EAU, FEU, GLACE, VENT)");
                    System.out.print("Type : ");
                    type = scan.nextLine().trim();
                }


                break;
            case 2:
                break;
            case 3:
                System.out.println("Merci d'avoir joué");
            default:
                System.exit(0);
        }
    }

    private Canard createNewCanard(String nom, int pv, int atk, String type) {
        switch (type) {
            case "EAU":
                return new CanardEau(nom, pv, atk);
        }
    }
}

