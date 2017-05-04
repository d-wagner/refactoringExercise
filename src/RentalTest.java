import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by D065058 on 04.05.2017.
 */
public class RentalTest {

    Rental testRental;
    Movie testMovie;

    @Before
    public void setUp() throws Exception {
        testMovie = new Movie("my Movie",Movie.REGULAR);
        testRental = new Rental(testMovie,25);
    }

    @Test
    public void getDaysRented() throws Exception {
        assertEquals(25,testRental.getDaysRented());
    }

    @Test
    public void getMovie() throws Exception {
        assertEquals(testMovie,testRental.getMovie());
    }

}