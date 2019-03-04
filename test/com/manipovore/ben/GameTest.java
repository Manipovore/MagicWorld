package com.manipovore.ben;

import com.manipovore.ben.personage.Magus;
import com.manipovore.ben.personage.Prowler;
import com.manipovore.ben.personage.Warrior;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Game game = new Game();

    private Warrior warrior = new Warrior(1, new int[]{10, 10, 0, 0});
    private Prowler prowler = new Prowler(2, new int[]{10, 5, 5, 0});
    private Magus magus = new Magus(2, new int[]{10, 0, 0, 10});

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    void displaySelectAttack() {
        do {
            warrior.attack(warrior, prowler, 1);
            prowler.attack(prowler, warrior, 1);
        } while (!warrior.isAlive() || !prowler.isAlive());
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Joueur 1 utilise Coup d'épée et inflige 10 dommages.", output[0]);
        assertEquals("Joueur 2 utilise Tir à l'Arc et inflige 5 dommages.", output[2]);
    }

    @Test
    void displaySelectAttack1() {
        do {
            warrior.attack(warrior, magus, 1);
            magus.attack(magus, warrior, 1);
        } while (!warrior.isAlive() || !prowler.isAlive());
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Joueur 1 utilise Coup d'épée et inflige 10 dommages.", output[0]);
        assertEquals("Joueur 2 perd 10 points de vie.", output[1]);
        assertEquals("Joueur 2 utilise Boule de Feu et inflige 10 dommages.", output[2]);
        assertEquals("Joueur 1 perd 10 points de vie.", output[3]);
    }

    @Test
    void initGame() {
        System.setIn(new ByteArrayInputStream("3\n10\n0\n0\n10\n1\n10\n10\n0\n0\n".getBytes()));
        game = new Game();
        game.initGame();
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("---------------------------------------------", output[0]);
        assertEquals("Abracadabra je suis le Mage Joueur 1 niveau 10 je possède 50 de vitalité, 0 de force, 0 d'agilité et 10 d'intelligence !", output[8]);
        assertEquals("Wouarg je suis le Guerrier Joueur 2 niveau 10 je possède 50 de vitalité, 10 de force, 0 d'agilité et 0 d'intelligence !", output[17]);
    }
}