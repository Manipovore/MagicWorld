package com.manipovore.ben;

public abstract class Personage {

    protected int idPlayer;
    protected int level;
    protected int health;
    protected int strong;
    protected int agility;
    protected int intelligence;

    protected String name;
    protected String slogan;

    Personage(int idPlayer, int arg[] ) {
        this.idPlayer = idPlayer;
        this.level = arg[0];
        this.health = this.level * 5;
        this.strong = arg[1];
        this.agility = arg[2];
        this.intelligence = arg[3];
    }

    public void cry(){
        System.out.println(
                slogan + " je suis le " + name  + " Joueur " + idPlayer + " niveau " + level + " je possède " + health + " de vitalité, " + strong + " de force, " + agility + " d'agilité et " + intelligence + " d'intelligence !"
        );
    }
}
