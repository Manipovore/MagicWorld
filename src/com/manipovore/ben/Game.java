package com.manipovore.ben;

import com.manipovore.ben.personage.Magus;
import com.manipovore.ben.personage.Personage;
import com.manipovore.ben.personage.Prowler;
import com.manipovore.ben.personage.Warrior;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class is responsible for internizing heros by the createGame class.
 * Then she starts the game with her attacking system that loops as long as a player is not dead.
 */
public class Game {

    private CreateGame createGame= new CreateGame();
    private Scanner sc = new Scanner(System.in);
    public int nbTotalPlayer = 2;
    private List<Personage> hero = new ArrayList<>();
    private int[] tempSkills;
    private int tempSelectTypeHero;

    /**
     * Init skills to player for a game.
     */
    private void initSkill(){
        do{
            int level = createGame.askValueSkills("Niveau");
            int strong = createGame.askValueSkills("Force");
            int agility = createGame.askValueSkills("Agilité");
            int intelligence = createGame.askValueSkills("Intelligence");

            int totalSkills = strong + agility + intelligence;

            if(totalSkills <= level){
                this.tempSkills = new int[]{level, strong, agility, intelligence};
                break;
            }
            System.out.println("En additionnant les points de compétences, ils doivent être inférieur au niveau du personnage.");
        }while(true);
    }

    /**
     * initHero Instantiates the Personage child class - Warrior, Prowler or Magus
     * @param idPlayer the player's number
     */
    private void initHero(int idPlayer) {
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
     * Initialize process for a game.
     */
    public void initGame() {
        for (int i = 0; i < this.nbTotalPlayer ; i++){
            //display asking hero type and select it then save in temp property hero selected.
            tempSelectTypeHero =  createGame.displayAndSelectHero(i + 1);

            //Init the skills hero
            this.initSkill();

            //Init hero
            this.initHero(i + 1);

            //Cry of hero
            this.hero.get(i).cry();
            //refresh variable temp;
            this.tempSelectTypeHero = 0;
            this.tempSkills = new int[4];
        }
    }


    /**
     * System of player selection, display and fight
     * @param idPlayer the player's number
     */
    public void displaySelectAttack(int idPlayer){
            Personage personage = this.hero.get(idPlayer);
            Personage enemy;
            if(idPlayer == 0){
                enemy = this.hero.get(1);
            } else {
                enemy = this.hero.get(0);
            }
            System.out.println("Joueur " + personage.getIdPlayer() + "(" + personage.getHealth() + " Vitalité) veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale)");
            int valueAttack = sc.nextInt();
            personage.attack(personage, enemy, valueAttack);
    }

    /**
     * Attack loop as long as a player does not die
     */
    public void loopAttack(){
        boolean isDead = false;
        while(!isDead){
            for (int i = 0; i < this.nbTotalPlayer ; i++){
                this.displaySelectAttack(i);
                if (!this.hero.get(0).isAlive() || !this.hero.get(1).isAlive()){
                    isDead = true;
                    break;
                }
            }
        }
    }

    /**
     * Start the game adn run it
     */
    public void runGame(){
        this.initGame();
        this.loopAttack();
        for(Personage hero : this.hero) {
            if(!hero.isAlive()){
                System.out.println("Joueur "  + hero.getIdPlayer() + " a perdu !");
            }
        }
    }
}
