package database;

import domain.Movie;
import domain.MovieList;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MovieCRUD {

public boolean addMovieDB(MovieList movieList, Movie movie){

    try {
        String sql = "INSERT INTO movies VALUES('" + movie.getTitle() +"', " +
                "'" + movie.getDirector() +"',  '" + movie.getDes() +"', '" + movie.getDuration() +"');";

        Connection con = DBconnection.getConnection();
        Statement stmt = con.createStatement();
        stmt.executeUpdate(sql);
        con.close();
        movieList.getTheMovieList().add(movie);
        return true;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }

}
}
