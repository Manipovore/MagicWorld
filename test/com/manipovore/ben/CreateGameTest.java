package com.manipovore.ben;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CreateGameTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    CreateGame createGame = new CreateGame();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @BeforeEach
    void setUp() { }


    @AfterEach
    void tearDown() {
    }


    @Test
    void testDisplayStart_WhenDisplaySelectHero_ThenLaunchMethod() {
        createGame.displaySelectHero(1);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals( "Création du personnage du Joueur 1", output[1]);
        assertEquals( "Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)", output[3]);
    }

    @Test
    void testInputSelectHero_WhenDisplayAndSelectHero_ThenNoNumericsValues() {
        System.setIn(new ByteArrayInputStream("str\n1\n".getBytes()));
        try{
            CreateGame createGame = new CreateGame();
            createGame.displayAndSelectHero(1);
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
            CreateGame createGame = new CreateGame();
            createGame.displayAndSelectHero(1);
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
        CreateGame createGame = new CreateGame();
        int selectMagusHero = createGame.displayAndSelectHero(1);
        assertEquals( 3, selectMagusHero);
    }

    @Test
    void askValueSkills() {
    }

    @Test
    public void testInputAskSkillsLevel_WhenAskValueSkills_ThenBadValues_NegativeAndZero() {
        System.setIn(new ByteArrayInputStream("0\n-1\n1".getBytes()));
        try{
            CreateGame createGame = new CreateGame();
            createGame.askValueSkills("Niveau");
            String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
            assertEquals( "Le niveau ne peut être à zéro !", output[1]);
            assertEquals( "Veuillez saisir une valeur numérique Positive entre 0 et 100", output[2]);
        } catch (Exception e) {
            fail("Bad compare output[int], you have modified method AskValueSkills() ?");
        }
    }

    @Test
    public void testInputAskSkillsStrong_WhenAskValueSkills_ThenBadValues_Alphanumerics() {
        System.setIn(new ByteArrayInputStream("str\n10\n".getBytes()));
        try{
            CreateGame createGame = new CreateGame();
            createGame.askValueSkills("Force");
            String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
            assertEquals( "Veuillez saisir une valeur numérique", output[1]);
        } catch (Exception e) {
            fail("Bad compare output[int], you have modified method AskValueSkills() ?" + e);
        }
    }
}