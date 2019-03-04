package com.manipovore.ben.behavior;

import com.manipovore.ben.personage.Personage;

public class WarriorAttack extends PersonageAttack {

    public void basicAttack(Personage personage, Personage enemy, String attackName) {
        enemy.setHealth( personage.getStrong() );
        this.displayAttack( personage, enemy, attackName, personage.getStrong());
    }

    public void specialAttack(Personage personage, Personage enemy, String attackName) {
        int stronger = personage.getStrong() * 2;
        int lessHealth =  personage.getStrong() / 2;
        enemy.setHealth(stronger);
        personage.setHealth(lessHealth);

        this.displayAttack( personage, enemy, attackName, stronger);
        System.out.println("Joueur " + personage.getIdPlayer() + " perd " + lessHealth + " points de vie." );
    }

}
