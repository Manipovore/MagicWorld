package com.manipovore.ben.behavior;

import com.manipovore.ben.personage.Personage;

public class MagusAttack extends PersonageAttack {

    public void basicAttack(Personage personage, Personage enemy, String attackName) {
        enemy.setHealth( personage.getIntelligence() );
        this.displayAttack( personage, enemy, attackName, personage.getIntelligence());
    }

    public void specialAttack(Personage personage, Personage enemy, String attackName) {
        int addHealth = personage.getIntelligence() * 2;
        int maxHealth = personage.getLevel() * 5;
        int totalLife = addHealth + personage.getHealth();
        int substractMaxHealth = maxHealth - personage.getHealth();

        if(totalLife < maxHealth){
            personage.setHealth(-addHealth);
            System.out.println("Joueur " + personage.getIdPlayer() + " utilise Soin et gagne " + addHealth + " en vitalité.");
        }else{
            personage.restartHealth();
            System.out.println("Joueur " + personage.getIdPlayer() + " utilise Soin et gagne deed" + substractMaxHealth  + " en vitalité." );
        }
        this.fatalAttack(enemy);
    }
}
