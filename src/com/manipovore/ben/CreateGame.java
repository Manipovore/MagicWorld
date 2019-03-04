package com.manipovore.ben;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class is responsible for displaying the processes for creating players and skills at the beginning of the game
 */
public class CreateGame {

    private Scanner sc = new Scanner(System.in);

    /**
     * Check a value between a min and max interval
     * @param min interval min
     * @param max interval min
     */
    public int checkValue(int min, int max){
        boolean responseIsGood;
        int scanValue = 0;
        do {
            try {
                scanValue = sc.nextInt();
                responseIsGood = true;
                if (scanValue < min || scanValue > max) {
                    System.out.println("Veuillez saisir une valeur numérique entre " + min + " et " + max);
                    responseIsGood = false;
                }
            } catch (InputMismatchException e) {
                sc.next();
                System.out.println("Veuillez saisir un caractère numérique");
                responseIsGood = false;
            }
        }while(!responseIsGood);
        return scanValue;
    }

    /**
     * Display in console all available heroes
     * @param idPlayer  The player's number - joueur 1, joueur 2
     */
    public void displaySelectHero(int idPlayer){
        System.out.println("---------------------------------------------");
        System.out.println("Création du personnage du Joueur " + idPlayer);
        System.out.println("---------------------------------------------");
        System.out.println("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)");
    }

    /**
     * After method displaySelectHero() select an hero with scanner.
     * @param idPlayer  The player's number
     * @return hero : int - Hero selection - 1, 2 or 3
     */
    public int displayAndSelectHero(int idPlayer){
        this.displaySelectHero(idPlayer);
        return checkValue(1,3);
    }

    /**
     * Display all available skills of the hero in the game.
     * @params categorySkill The sentence for display the skill - level, strong ...
     * @return valueSkill
     */
    public int askValueSkills(String categorySkill){
        System.out.println(categorySkill + " du personnage ?");
        int valueSkill;

        do {
            valueSkill = checkValue(0,100);
            if(valueSkill < 0 || valueSkill > 100){
                System.out.println("Veuillez saisir une valeur numérique Positive entre 0 et 100");
            }
            else if(categorySkill == "Niveau" && valueSkill == 0){
                System.out.println("Le niveau ne peut être à zéro !");

            }else{
                break;
            }
        } while(true);

        return valueSkill;
    }
}
