package database;

import domain.Movie;
import domain.MovieList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    private final static String url = "jdbc:mysql://localhost:3306/";
    //    private final static String url = "jdbc:mysql://52.29.93.75:3306/";
    private final static String DB_NAME = "kinoxp";
    private final static String USER = "root";
    private final static String PASS = "";



    public static Connection getConnection(){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url +
                            DB_NAME,
                    USER,
                    PASS);

            return con;
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public int makeUpdate(String s) throws SQLException {
        Connection conn = getConnection();
        int val =conn.createStatement().executeUpdate(s);
        if(val==1)
            System.out.println("Successfully inserted value");
        conn.close();
        return val;
    }

    public boolean addMovie(MovieList movieListt, String title, String des) {
        int res = 0;
        try {

            Movie newMovie= new Movie(title,des);
            res = makeUpdate("INSERT INTO movielist(title, description) VALUES ('"+title+"','"+des+"')");
            if(res==1) {
                movieListt.movies.add(newMovie);
            }
        } catch (Exception e ) {
            e.printStackTrace();
        }
        return res==1;
    }
}
