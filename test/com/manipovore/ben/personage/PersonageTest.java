package com.manipovore.ben.personage;

import com.manipovore.ben.Game;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PersonageTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private Warrior warrior = new Warrior(1, new int[]{10, 10, 0, 0});
    private Prowler prowler = new Prowler(2, new int[]{10, 5, 5, 0});
    private Magus magus = new Magus(3, new int[]{10, 0, 0, 10});

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    void Warrior_Cry_DisplayCorrectProcess() {
        warrior.cry();
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Wouarg je suis le Guerrier Joueur 1 niveau 10 je possède 50 de vitalité, 10 de force, 0 d'agilité et 0 d'intelligence !", output[0]);
    }

    @Test
    void Prowler_Cry_DisplayCorrectProcess() {
        prowler.cry();
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("...Chut!!! je suis le Rôdeur Joueur 2 niveau 10 je possède 50 de vitalité, 5 de force, 5 d'agilité et 0 d'intelligence !", output[0]);
    }

    @Test
    void Magus_Cry_DisplayCorrectProcess() {
        magus.cry();
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Abracadabra je suis le Mage Joueur 3 niveau 10 je possède 50 de vitalité, 0 de force, 0 d'agilité et 10 d'intelligence !", output[0]);
    }

    @Test
    void Personage_IsAlive_Health_0_CorectProcess() {
        prowler.setHealth(50);
        boolean isDead = prowler.isAlive();
        assertFalse(isDead);
    }

    @Test
    void Personage_IsAliveHealth_Negative_ErrorProcess() {
        magus.setHealth(150);
        boolean isDead = magus.isAlive();
        assertFalse(isDead);
    }

    @Test
    void Personage_IsAliveHealth_Positive_CorrectProcess() {
        warrior.setHealth(49);
        boolean isDead = warrior.isAlive();
        assertTrue(isDead);
    }

    @Test
    void Personage_AttackBasic_WarriorAndMagus_CorrectProcess() {
        do {
            warrior.attack(warrior, magus, 1);
            magus.attack(magus, warrior, 1);
        } while (!warrior.isAlive() || !magus.isAlive());
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Joueur 1 utilise Coup d'épée et inflige 10 dommages.", output[0]);
        assertEquals("Joueur 3 utilise Boule de Feu et inflige 10 dommages.", output[2]);
    }

    @Test
    void Personage_AttackSpecial_WarriorAndProwler_CorrectProcess() {
        do {
            warrior.attack(warrior, prowler, 2);
            prowler.attack(prowler, warrior, 1);
            warrior.attack(warrior, prowler, 2);
            prowler.attack(prowler, warrior, 2);
        } while (!warrior.isAlive() || !magus.isAlive());
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Joueur 1 utilise Coup de Rage et inflige 20 dommages.", output[0]);
        assertEquals("Joueur 2 perd 20 points de vie.", output[1]);
        assertEquals("Joueur 1 perd 5 points de vie.", output[2]);
        assertEquals("Joueur 2 utilise Tir à l'Arc et inflige 5 dommages.", output[3]);
        assertEquals("Joueur 1 perd 5 points de vie.", output[4]);
    }

    @Test
    void Personage_AttackSpecial_WarriorAndMagus_CorrectProcess() {
        do {
            warrior.attack(warrior, magus, 2);
            magus.attack(magus, warrior, 1);
            warrior.attack(warrior, magus, 1);
            magus.attack(magus, warrior, 2);
        } while (!warrior.isAlive() || !magus.isAlive());
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Joueur 1 utilise Coup de Rage et inflige 20 dommages.", output[0]);
        assertEquals("Joueur 3 perd 20 points de vie.", output[1]);
        assertEquals("Joueur 1 perd 5 points de vie.", output[2]);
        assertEquals("Joueur 3 utilise Boule de Feu et inflige 10 dommages.", output[3]);
        assertEquals("Joueur 1 perd 10 points de vie.", output[4]);
        assertEquals("Joueur 1 utilise Coup d'épée et inflige 10 dommages.", output[5]);
        assertEquals("Joueur 3 perd 10 points de vie.", output[6]);
        assertEquals("Joueur 3 utilise Soin et gagne 20 en vitalité.", output[7]);
    }
}