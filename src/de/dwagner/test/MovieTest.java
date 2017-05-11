package de.dwagner.test;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by D065058 on 04.05.2017.
 */
public class MovieTest {

    private Movie testMovie;


    @Before
    public void setUp() throws Exception {
        testMovie = new Movie("testMovie",Movie.REGULAR);
    }

    @Test
    public void getPriceCode() throws Exception {
        assertEquals(Movie.REGULAR,testMovie.getPriceCode());
    }

    @Test
    public void setPriceCode() throws Exception {
        testMovie.setPriceCode(Movie.CHILDRENS);
        assertEquals(Movie.CHILDRENS,testMovie.getPriceCode());
    }

    @Test
    public void getTitle() throws Exception {
        assertEquals("testMovie",testMovie.getTitle());
    }

}