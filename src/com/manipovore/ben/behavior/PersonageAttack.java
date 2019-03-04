package com.manipovore.ben.behavior;

import com.manipovore.ben.personage.Personage;

public abstract class PersonageAttack implements InterfaceAttack {

    /**
     * Display of attack and damage process
     * @param personage
     * @param enemy
     * @param attackName
     * @param damage
     */
    public void displayAttack(Personage personage, Personage enemy, String attackName, int damage){
        System.out.println("Joueur " + personage.getIdPlayer() + " utilise " + attackName + " et inflige " + damage + " dommages." );
        System.out.println("Joueur " + enemy.getIdPlayer() + " perd " + damage + " points de vie." );
        this.fatalAttack(enemy);
    }

    public void basicAttack(Personage personage, Personage enemy, String attackName) {
        this.displayAttack( personage, enemy, attackName, personage.getStrong());
    }

    public void specialAttack(Personage personage, Personage enemy, String attackName) {
        this.displayAttack( personage, enemy, attackName, personage.getStrong() * 2);
    }

    /**
     * Displays a message if the player is dead
     * @param enemy
     */
    public void fatalAttack(Personage enemy){
        if ( enemy.getHealth() <= 0 )
            System.out.println("Joueur " + enemy.getIdPlayer() + " est mort");
    }
}
