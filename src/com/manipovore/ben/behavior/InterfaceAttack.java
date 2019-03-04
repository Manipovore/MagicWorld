package com.manipovore.ben.behavior;

import com.manipovore.ben.personage.Personage;

public interface InterfaceAttack {

    /**
     * Process for the basic attack of a character
     * @param personage The character who gives the attack
     * @param enemy The character who receives the attack
     * @param attackName
     */
    void basicAttack(Personage personage, Personage enemy, String attackName);

    /**
     * Process for the special attack of a character
     * @param personage
     * @param enemy
     * @param attackName
     */
    void specialAttack(Personage personage, Personage enemy, String attackName);
}
