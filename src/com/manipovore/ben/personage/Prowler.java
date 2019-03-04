package com.manipovore.ben.personage;

import com.manipovore.ben.behavior.ProwlerAttack;

public class Prowler extends Personage {

    //Instanciate behavior
    protected ProwlerAttack prowlerAttack = new ProwlerAttack();

    public Prowler(int idPlayer, int[] tempSkills) {
        super(idPlayer, tempSkills);
        this.name = "Rôdeur";
        this.slogan = "...Chut!!!";
    }

    @Override
    protected void basicAttack(Personage personage, Personage enemy) {
        prowlerAttack.basicAttack( personage, enemy, "Tir à l'Arc" );
    }

    @Override
    protected void specialAttack(Personage personage, Personage enemy) {
        prowlerAttack.specialAttack( personage, enemy, "Concentration" );
    }
}
