package com.manipovore.ben.behavior;

import com.manipovore.ben.personage.Personage;

public class PersonageAttack implements InterfaceAttack {

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

    public void fatalAttack(Personage enemy){
        if ( enemy.getHealth() <= 0 )
            System.out.println("Joueur " + enemy.getIdPlayer() + " est mort");
    }
}
