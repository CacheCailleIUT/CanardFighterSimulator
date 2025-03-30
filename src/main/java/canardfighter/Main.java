package canardfighter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Canard> canardCrees = new ArrayList<>();

    private static List<Canard> canardEnCombat = new ArrayList<>();

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
                    System.out.println("------------------------------------------------\n\t\t\t\t\tCANARDEX\n");
                    afficherListeCanard();
                    System.out.println("------------------------------------------------");
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
            System.out.println("Veuillez entrer un des choix présentés (1, 2, 3 ou 4)");
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
        if (canardCrees.isEmpty()) {
            System.out.println("Vous n'avez pas assez de Canard pour commencer une bataille !");
            return;
        }
        System.out.println("Veuillez choisir le premier canard :\n(Entrer 1 pour le premier, 2 pour le deuxième, ...) ");
        afficherListeCanard();
        System.out.print("Choix : ");
        Canard premierCanard = null;
        while (premierCanard == null) {
            premierCanard = choixCanard(scan);
        }

        System.out.println("Veuillez choisir le deuxième canard :\n(Entrer 1 pour le premier, 2 pour le deuxième, ...) ");
        afficherListeCanard();
        System.out.print("Choix : ");
        Canard deuxiemeCanard = null;
        while (deuxiemeCanard == null) {
            deuxiemeCanard = choixCanard(scan);
        }

        canardEnCombat.add(premierCanard);
        canardEnCombat.add(deuxiemeCanard);

        System.out.println("Début du combat !\nLa bataille de canard oppose " + premierCanard.getNom() + " à " + deuxiemeCanard.getNom());
        int comptTour = 1;
        while (true) {
            System.out.println("----------------------------------\n\t\t\tTour n°" + comptTour);
            int attaquant = choixPremierAttaquant(canardEnCombat); // 1 ou 0

            action(scan, canardEnCombat.get(attaquant), canardEnCombat.get(1-attaquant));

            if(deuxiemeCanard.estKO()) {
                System.out.println(deuxiemeCanard.getNom() + " est KO !");
                System.out.println(premierCanard.getNom() + " a gagné " + (int) (Math.random()*1000) + " exp.");
                break;
            }
            action(scan, canardEnCombat.get(1-attaquant), canardEnCombat.get(attaquant));
            if(premierCanard.estKO()) {
                System.out.println(premierCanard.getNom() + " est KO !");
                System.out.println(deuxiemeCanard.getNom() + " a gagné " + (int) (Math.random()*1000) + " exp.");
                break;
            }
            comptTour++;
        }
        resetPostCombat(premierCanard,deuxiemeCanard);
        canardEnCombat.clear();
    }

    private static void resetPostCombat(Canard premierCanard, Canard deuxiemeCanard) {
        premierCanard.resetCanard();
        deuxiemeCanard.resetCanard();
    }


    private static int choixPremierAttaquant(List<Canard> canardEnCombat) {
        if (canardEnCombat.get(0).getVitesse() == canardEnCombat.get(1).getVitesse()) {
            return (int) (Math.random()*2);
        } else {
            return canardEnCombat.get(0).getVitesse() > (canardEnCombat.get(1).getVitesse()) ? 0 : 1;
        }
    }


    private static void action(Scanner scan, Canard canard, Canard cible) {
        System.out.println("###\n" + canard.getNom() +" doit choisir une action :");
        if (!checkEtat(canard)) {
            return;
        }
        System.out.println("1. Attaquer ("+canard.getAtk()+" PA)");
        if (canard.usedCapacite) {
            System.out.println("   Capacité spéciale déjà utilisée");
        } else {
            System.out.println("2. Capacité spéciale");
        }

        int action = 0;
        while (action == 0) {
            System.out.print("Choix : ");
            action = choixAction(scan, canard.usedCapacite);
        }
        if (action == 1) {
            int dgt = canard.attaquer(cible);
            cible.subirDegats(dgt);
            System.out.println(canard.getNom() + " inflige "
                    + dgt + " degats à " + cible.getNom() + ".\n"
                    + cible.getNom() + " a " + cible.getPv() + " PV restants.");
            canard.comportementPostCapaciteSpeciale(cible);
        } else if (action == 2) {
            canard.activerCapaciteSpeciale(cible);
        }

    }

    private static boolean checkEtat(Canard canard) {
        switch (canard.getEtatCanard()) {
            case GELE:
                System.out.println(canard.getNom() + " est gelé !");
                canard.nbEtatTour++;
                return false;
            case NORMAL:
            default:
                return true;
        }
    }

    private static int choixAction(Scanner scan, boolean usedCapacite) {
        while (!scan.hasNextInt()) {
            scan.next();
            System.out.println("Veuillez choisir une action existante ");
            System.out.print("Choix : ");
        }
        int action = scan.nextInt();
        if (action <= 0 || (usedCapacite && action == 2)) {
            System.out.println("Action invalide");
            action = 0;
        }
        return action;
    }
    private static Canard choixCanard(Scanner scan) {
        try {
            while (!scan.hasNextInt() && (scan.nextInt() > canardCrees.size() || scan.nextInt() <= 0) ) {
                scan.next();
                System.out.println("Veuillez choisir un canard existant ");
                System.out.print("Choix : ");
            }
            int choixCanard = scan.nextInt();
            Canard premierCanard = canardCrees.get(choixCanard-1);
            System.out.println("Canard choisi : " + premierCanard);
            return premierCanard;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ce canard n'existe pas");
            return null;
        }
    }

    private static void afficherListeCanard() {
        int count = 1;
        for (Canard canard : canardCrees) {
            System.out.println(count+". " + canard);
            count++;
        }
    }
}

