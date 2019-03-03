package com.manipovore.ben;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PersonageTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Game game = new Game();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }

    /*************************************************
     * *************** TEST GAME ******************* *
     ************************************************/

    //test askSkill
    @Test
    public void testInputAskSkills_WhenAskValueSkills_ThenNoNumericsValues() {
        System.setIn(new ByteArrayInputStream("1\n0\n10\n-1\n0\n0\n0\n".getBytes()));
        try{
            game = new Game();
            game.nbTotalPlayer = 1;
            game.runGame();
            String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
            assertEquals( "Le niveau ne peut être à zéro !", output[5]);
            assertEquals( "Veuillez saisir une valeur numérique Positive entre 0 et 100", output[7]);
        } catch (Exception e) {
            fail("Bad compare output[int], you have modified method AskValueSkills() ?");
        }
    }

    @Test
    public void testInputSelectHero_WhenDisplayAndSelectHero_ThenNoNumericsValues() {
        System.setIn(new ByteArrayInputStream("str\n1\n".getBytes()));
        try{
            game = new Game();
            game.displayAndSelectHero(1);
            String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
            assertEquals( "Veuillez saisir un caractère numérique", output[4]);
        } catch (Exception e) {
            fail("Bad compare output[int], you have modified method displayAndSelectHero() ?");
        }
    }

    @Test
    public void testInputSelectHero_WhenDisplayAndSelectHero_ThenNoIntervalValues_Between_1And3() {
        System.setIn(new ByteArrayInputStream("4\n-1\n2\n".getBytes()));
        try{
            game = new Game();
            game.displayAndSelectHero(1);
            String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
            assertEquals( "Veuillez saisir une valeur numérique entre 1 et 3", output[4]);
            assertEquals( "Veuillez saisir une valeur numérique entre 1 et 3", output[5]);
        } catch (Exception e) {
            fail("Bad compare output[int], you have modified method displayAndSelectHero ?");
        }
    }

    @Test
    public void testInputSelectHero_WhenDisplayAndSelectHero_ThenDisplayCorrectProcess() {
        System.setIn(new ByteArrayInputStream("3\n".getBytes()));
        game = new Game();
        game.displayAndSelectHero(1);
        assertEquals( 3, 3);
    }

    @Test
    public void testAllInputsInGame_WhenRunGame_ThenDisplayCorrectProcessFor3Players() {
        System.setIn(new ByteArrayInputStream("3\n10\n0\n0\n10\n1\n10\n10\n0\n0\n2\n50\n10\n20\n20\n".getBytes()));
        game = new Game();
        game.nbTotalPlayer = 3;
        game.runGame();
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Abracadabra je suis le Mage Joueur 1 niveau 10 je possède 50 de vitalité, 0 de force, 0 d'agilité et 10 d'intelligence !", output[8]);
        assertEquals("Wouarg je suis le Guerrier Joueur 2 niveau 10 je possède 50 de vitalité, 10 de force, 0 d'agilité et 0 d'intelligence !", output[17]);
        assertEquals("...Chut!!! je suis le Rôdeur Joueur 3 niveau 50 je possède 250 de vitalité, 10 de force, 20 d'agilité et 20 d'intelligence !", output[26]);
    }
}