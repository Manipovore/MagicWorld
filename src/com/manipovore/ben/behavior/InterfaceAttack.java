package com.manipovore.ben.behavior;

import com.manipovore.ben.personage.Personage;

public interface InterfaceAttack {

    public void basicAttack(Personage personage, Personage enemy, String attackName);

    public void specialAttack(Personage personage, Personage enemy, String attackName);
}
