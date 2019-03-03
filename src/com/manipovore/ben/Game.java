package com.manipovore.ben;

public class Game {

    public int nbTotalPlayer = 2;

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

        return 0;
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

        return valueSkill;
    }

    /**
     * Init skills to player for a game.
     */
    private void initSkill(){
        return;
    }

    /**
     * CreateHero Instanciate class of type Personage
     */
    private void CreateHero(int idPlayer) {
        return;
    }

    /**
     * Init asking process for a game.
     * @params index access Personage in List
     */
    private void initGame(int index) {
        return;
    }

    /**
     * Init the game adn run it
     */
    public void runGame(){
        for (int i = 0; i < this.nbTotalPlayer ; i++){
            this.initGame(i);
        }
    }

}
