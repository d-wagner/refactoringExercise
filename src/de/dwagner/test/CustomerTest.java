package de.dwagner.test;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by D065058 on 04.05.2017.
 */
public class CustomerTest {
    private Customer testCustomer;
    private Rental testRental;
    private Movie testMovie;

    @Before
    public void setUp() throws Exception {
        testCustomer = new Customer("testCustomer");
        testMovie = new Movie("testMovie",Movie.REGULAR);
        testRental = new Rental(testMovie,25);
    }

    @Test
    public void addRental() throws Exception {
        testCustomer.addRental(testRental);
        assertTrue(testCustomer.statement().contains(testMovie.getTitle()+"\t\t"+testRental.getDaysRented()));
    }

    @Test
    public void getName() throws Exception {
        assertEquals("testCustomer",testCustomer.getName());
    }

    @Test
    public void statement() throws Exception {
        testCustomer.addRental(testRental);
        assertTrue(testCustomer.statement().contains("de.dwagner.test.Rental Record for testCustomer")&&
        testCustomer.statement().contains("testMovie\t\t25"));
    }

    @Test
    public void amountFor() throws Exception {
        assertEquals(new Double(36.5),new Double(testRental.getCharge()));
        assertEquals(new Double(1.5),new Double(new Rental(new Movie("asdf",Movie.CHILDRENS),1).getCharge()));
        assertEquals(new Double(27.0),new Double(new Rental(new Movie("asdf",Movie.CHILDRENS),20).getCharge()));
        assertEquals(new Double(3),new Double(new Rental(new Movie("asdf",Movie.NEW_RELEASE),1).getCharge()));
        assertEquals(new Double(60),new Double(new Rental(new Movie("asdf",Movie.NEW_RELEASE),20).getCharge()));
        assertEquals(new Double(2.0),new Double(new Rental(new Movie("asdf",Movie.REGULAR),1).getCharge()));

    }

}