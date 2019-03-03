package com.manipovore.ben;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Game {

    private Scanner sc = new Scanner(System.in);
    public int nbTotalPlayer = 2;
    private List<Personage> hero = new ArrayList<>();
    private int[] tempSkills;
    private int tempSelectTypeHero;

    /**
     * Display all available heros in the game and select it.
     * @params idPlayer Select hero warrior/Prowler/Magus - 1 , 2 or 3
     */
    public int displayAndSelectHero(int idPlayer){
        int hero = -1;
        boolean responseIsGood;
        System.out.println("---------------------------------------------");
        System.out.println("Création du personnage du Joueur " + idPlayer);
        System.out.println("---------------------------------------------");
        System.out.println("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)");
        do {
            try{
                hero = sc.nextInt();
                responseIsGood = true;
                if(hero < 1 || hero > 3){
                    System.out.println("Veuillez saisir une valeur numérique entre 1 et 3");
                    responseIsGood = false;
                }
            } catch( InputMismatchException e){
                sc.next();
                System.out.println("Veuillez saisir un caractère numérique");
                responseIsGood = false;
                //return 0;
            }
        } while(!responseIsGood);

        return this.tempSelectTypeHero = hero;
    }

    /**
     * Display all available skills heros in the game.
     * @params categorySkill The sentence for display the skill - level, strong ...
     * @return valueSkill
     */
    private int askValueSkills(String categorySkill){
        System.out.println(categorySkill + " du personnage ?");
        int valueSkill = 0;
        boolean responseIsGood;

        do {
            try{
                valueSkill = sc.nextInt();
                responseIsGood = true;
            } catch( InputMismatchException e){
                sc.next();
                System.out.println("Veuillez saisir une valeur numérique");
                responseIsGood = false;
            }
            if(valueSkill < 0 || valueSkill > 100){
                System.out.println("Veuillez saisir une valeur numérique Positive entre 0 et 100");
                responseIsGood = false;
            }
            if(categorySkill == "Niveau" && valueSkill == 0){
                System.out.println("Le niveau ne peut être à zéro !");
                responseIsGood = false;
            }
        } while(!responseIsGood);

        return valueSkill;
    }

    /**
     * Init skills to player for a game.
     * @params index access Personage in List ????
     */
    private void initSkill(){
        do{
            int level = this.askValueSkills("Niveau");
            int strong = this.askValueSkills("Force");
            int agility = this.askValueSkills("Agilité");
            int intelligence = this.askValueSkills("Intelligence");

            int totalSkills = strong + agility + intelligence;

            if(totalSkills <= level){
                this.tempSkills = new int[]{level, strong, agility, intelligence};
                break;
            }
            System.out.println("En additionnant les points de compétences, ils doivent être inférieur au niveau du personnage.");
        }while(true);
    }

    /**
     * CreateHero Instanciate class of type Personage
     */
    private void CreateHero(int idPlayer) {
        switch (tempSelectTypeHero) {
            case 1:
                this.hero.add( new Warrior(idPlayer, this.tempSkills) );
                break;
            case 2:
                this.hero.add( new Prowler(idPlayer, this.tempSkills) );
                break;
            case 3:
                this.hero.add( new Magus(idPlayer, this.tempSkills) );
                break;
            default:
                System.out.println("Vous n'avez pas choisi de personnage parmi les choix proposés");
                break;
        }
    }

    /**
     * Init asking process for a game.
     * @params index access Personage in List
     */
    private void initGame(int index) {
            //display asking hero type and select it then save in temp property hero selected.
            this.displayAndSelectHero(index + 1);

            //Init the skills hero
            this.initSkill();

            //Create hero
            this.CreateHero(index + 1);

        this.hero.get(index).cry();
    }

    /**
     * Init the game adn run it
     */
    public void runGame(){
        for (int i = 0; i < this.nbTotalPlayer ; i++){
            this.initGame(i);

            //refresh variable temp;
            this.tempSelectTypeHero = 0;
            this.tempSkills = new int[4];
        }
    }

}
