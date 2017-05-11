package de.dwagner.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Created by D065058 on 04.05.2017.
 */
public class ProgramTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void main() throws Exception {
        Program.main(null);
        assertEquals(("Welcome to the de.dwagner.test.Movie Store\n" +
                "Let's get the Statement\n" +
                "de.dwagner.test.Rental Record for joe\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "\tmovie1\t\t10\t30.0\n" +
                "\tmovie2\t\t5\t4.5\n" +
                "Amount owed is 34.5\n" +
                "You earned 3 frequent renter points\n").replaceAll("\\s+"," "),outContent.toString().replaceAll("\\s+"," "));
    }

}