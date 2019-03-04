package com.manipovore.ben.personage;
import com.manipovore.ben.behavior.*;

public class Warrior extends Personage {

    //Instanciate behavior
    protected WarriorAttack warriorAttack = new WarriorAttack();

    public Warrior(int idPlayer, int[] tempSkills) {
        super(idPlayer, tempSkills);
        this.name = "Guerrier";
        this.slogan = "Wouarg";
    }

    @Override
    public void basicAttack(Personage personage, Personage enemy) {
        warriorAttack.basicAttack(personage, enemy, "Coup d'épée");
    }

    @Override
    public void specialAttack(Personage personage, Personage enemy) {
        warriorAttack.specialAttack(personage, enemy, "Coup de Rage");
    }


}
