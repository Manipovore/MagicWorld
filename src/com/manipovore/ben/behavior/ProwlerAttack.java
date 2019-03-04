package com.manipovore.ben.behavior;

import com.manipovore.ben.personage.Personage;

public class ProwlerAttack extends PersonageAttack {

    public void basicAttack(Personage personage, Personage enemy, String attackName) {
        enemy.setHealth( personage.getAgility() );
        this.displayAttack( personage, enemy, attackName, personage.getAgility());
    }

    public void specialAttack(Personage personage, Personage enemy, String attackName) {
        int addLevel = personage.getAgility() / 2;
        personage.setLevel(addLevel);

        System.out.println("Joueur " + personage.getIdPlayer() + " gagne en niveau (level +" + addLevel + ") - ( Nouvelle Vitalité " + personage.getHealth() + " )" );
        this.fatalAttack(enemy);
    }
}
