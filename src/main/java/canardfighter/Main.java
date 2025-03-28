package canardfighter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Canard> canardCrees = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Créer des canards\n2. Lancer une bataille\n3. Afficher les canards\n4. Quitter");
            Scanner scan = new Scanner(System.in);
            System.out.print("Votre choix : ");
            while (!scan.hasNextInt()) {
                scan.next();
            }
            int choix = scan.nextInt();
            switch (choix) {
                case 1:
                    dialogNewCanard(scan);
                    break;
                case 2:
                    battle(scan);
                    break;
                case 3:
                    canardCrees.forEach(System.out::println);
                    break;
                case 4:
                    System.out.println("Merci d'avoir joué");
                default:
                    System.exit(0);
            }
        }

    }

    private static Canard createNewCanard(String nom, int pv, int atk, int type) {
        return switch (type) {
            case 0 -> new CanardEau(nom, pv, atk);
            case 1 -> new CanardFeu(nom, pv, atk);
            case 2 -> new CanardGlace(nom, pv, atk);
            case 3 -> new CanardVent(nom, pv, atk);
            default -> null;
        };
    }

    private static void dialogNewCanard(Scanner scan) {
        System.out.println("Comment s'appelle votre canard ?");

        System.out.print("Nom : ");
        String nom = scan.next();
        scan.nextLine();

        int pv = 0;
        System.out.println("Combien de points de vie à votre canard ? (Supérieur à 0)");
        while (pv <= 0) {
            System.out.print("PV : ");
            pv = askPV(scan);
        }

        System.out.println("Combien de points d'attaque à votre canard ? (Supérieur à 0)");
        int atk = 0;
        while (atk <= 0) {
            System.out.print("ATK : ");
            atk = askAtk(scan);
        }
        /*System.out.println("Quel est le type de votre canard ?\n(Type accepté : EAU, FEU, GLACE, VENT)");
        System.out.print("Type : ");
        String type = scan.next().trim();
        scan.nextLine();
        while (!TypeCanard.isEnum(type)) {
            System.out.println("Veuillez entrer un type correct\n(Type accepté : EAU, FEU, GLACE, VENT)");
            System.out.print("Type : ");
            type = scan.next().trim();
        }*/
        System.out.println("Quel est le type de votre canard ?\n1. EAU\n2. FEU\n3. GLACE\n4. VENT");
        int typeChoix = -1;
        while (typeChoix == -1) {
            System.out.print("Type : ");
            typeChoix = askType(scan);
        }

        canardCrees.add(createNewCanard(nom,pv,atk,typeChoix));
        System.out.println("Recap Canard : " + canardCrees.getLast());
    }

    private static int askPV(Scanner scan) {
        while (!scan.hasNextInt()) {
            scan.next();
            System.out.println("Veuillez entrer un entier strictement positif");
            System.out.print("PV : ");
        }
        int pv = scan.nextInt();
        if (pv <= 0) {
            System.out.println("Veuillez entrer un entier strictement positif");
        }
        return pv;
    }

    private static int askAtk(Scanner scan) {
        while (!scan.hasNextInt()) {
            scan.next();
            System.out.println("Veuillez entrer un entier strictement positif");
            System.out.print("ATK : ");
        }
        int atk = scan.nextInt();
        if (atk <= 0) {
            System.out.println("Veuillez entrer un entier strictement positif");
        }
        return atk;
    }

    private static int askType(Scanner scan) {
        while (!scan.hasNextInt()) {
            scan.next();
            System.out.println("Veuillez entrer un des choix présentés");
            System.out.print("Type : ");
        }
        int type = scan.nextInt() -1;
        if (!TypeCanard.isEnum(type)) {
            System.out.println("Le choix n'existe pas");
            type = -1;
        }
        return type;
    }

    private static void battle(Scanner scan) {
        if (canardCrees.size() < 2) {
            System.out.println("Vous n'avez pas assez de Canard pour commencer une bataille !");
        }
        System.out.println("Veuillez choisir le premier canard :\n(Entrer 1 pour le premier, 2 pour le deuxième, ...) ");
        int count = 1;
        for (Canard canard : canardCrees) {
            System.out.println(count+". " + canard);
            count++;
        }
        System.out.print("Choix : ");
        while (!scan.hasNextInt() && (scan.nextInt() > canardCrees.size() || scan.nextInt() <= 0) ) {
            scan.next();
            System.out.println("Veuillez choisir un canard existant ");
            System.out.print("Choix : ");
        }
        int choixCanard = scan.nextInt();
        Canard premierCanard = canardCrees.get(choixCanard-1);
        System.out.println("Canard choisi : " + premierCanard);
        premierCanard.activerCapaciteSpeciale();


        System.out.println("Veuillez choisir le deuxième canard :\n(Entrer 1 pour le premier, 2 pour le deuxième, ...) ");
        count = 1;
        for (Canard canard : canardCrees) {
            System.out.println(count+". " + canard);
            count++;
        }
        System.out.print("Choix : ");
        while (!scan.hasNextInt() && (scan.nextInt() > canardCrees.size() || scan.nextInt() <= 0) ) {
            scan.next();
            System.out.println("Veuillez choisir un canard existant ");
            System.out.print("Choix : ");
        }
        choixCanard = scan.nextInt();
        Canard deuxiemeCanard = canardCrees.get(choixCanard-1);
        System.out.println("Canard choisi : " + deuxiemeCanard);
        deuxiemeCanard.activerCapaciteSpeciale();
    }
}

