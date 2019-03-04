package com.manipovore.ben.personage;

public abstract class Personage {

    protected int idPlayer;
    protected int level;
    protected int health;
    protected int strong;
    protected int agility;
    protected int intelligence;

    protected String name;
    protected String slogan;

    Personage() {}

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

    public boolean isAlive(){
        if(health<=0)
            return false;
        return true;
    }

    public void restartHealth(){ }

    protected abstract void basicAttack(Personage personage, Personage enemy);

    protected abstract void specialAttack(Personage personage, Personage enemy);

    public void attack(Personage personage, Personage enemy, int attackChoices){
        int attackValue = 0;
        switch (attackChoices){
            case 1:
                this.basicAttack(personage, enemy);
                break;
            case 2:
                this.specialAttack(personage, enemy);
                break;
        }
    }

    public int getIdPlayer() {
        return idPlayer;
    }

    public int getLevel() {
        return level;
    }

    public int getHealth() {
        return health;
    }

    public int getStrong() {
        return strong;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setHealth(int dammage) {
        this.health -= dammage;
    }

    public void setLevel(int level) {
        this.level += level;
        this.health = this.level * 5;
    }
}
