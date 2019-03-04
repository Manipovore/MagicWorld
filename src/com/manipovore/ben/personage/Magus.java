package com.manipovore.ben.personage;

import com.manipovore.ben.behavior.MagusAttack;

public class Magus extends Personage {

    protected MagusAttack magusAttack = new MagusAttack();

    public Magus(int idPlayer, int[] tempSkills) {
        super(idPlayer, tempSkills);
        this.name = "Mage";
        this.slogan = "Abracadabra";
    }

    @Override
    protected void basicAttack(Personage personage, Personage enemy) {
        magusAttack.basicAttack(personage, enemy, "Boule de Feu");
    }

    @Override
    protected void specialAttack(Personage personage, Personage enemy) {
        magusAttack.specialAttack(personage, enemy, "Soin");
    }

    @Override
    public void restartHealth(){
        this.health = this.level * 5;
    }

}
