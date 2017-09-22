package gui;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by Mantas_MSI on 22-Sep-17.
 */
public class EditMoviesTest {
    EditMovies editMovies    = new EditMovies("EditMovies");

    @Test
    public  void className() throws  Exception{
        assertEquals("EditMovies", editMovies.getName());
    }

    @Test
    public  void getMovieTitle() throws  Exception{
        //get the movie title from DB

        assertEquals(1, 1);
    }

}
