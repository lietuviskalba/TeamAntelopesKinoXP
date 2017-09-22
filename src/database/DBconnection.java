package database;

import domain.Movie;
import domain.MovieList;

import java.sql.*;

public class DBconnection {
    private final static String url = "jdbc:mysql://localhost:3306/";
    //    private final static String url = "jdbc:mysql://52.29.93.75:3306/";
    private final static String DB_NAME = "kinoxp";
    private final static String USER = "root";
    private final static String PASS = "";

    private Connection conn = null;



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

    public ResultSet makeQuery(String query) throws SQLException {
        Connection conn = getConnection();
        Statement st = conn.createStatement();
        ResultSet res = st.executeQuery(query);
        return res;
    }

    public void closeConnection(){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loadMovies(MovieList movieList) {
        try {
            ResultSet result = makeQuery("select * from movies");
            while(result.next()){
                Movie toAdd= new Movie(result.getString("title"),"", result.getString("description"), 0);
                movieList.getTheMovieList().add(toAdd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //closeConnection();
        //TODO remove, this is just for debugging
        for(Movie m: movieList.getTheMovieList()){
            System.out.println(m.getDes());
        }
    }
    public boolean addMovie(MovieList movieList, String title, String des) {
        int res = 0;
        try {

            Movie newMovie= new Movie(title, "",des, 0);
            res = makeUpdate("INSERT INTO movies(title, description) VALUES ('"+title+"','"+des+"')");
            if(res==1) {
                movieList.getTheMovieList().add(newMovie);
            }
        } catch (Exception e ) {
            e.printStackTrace();
        }
        return res==1;
    }
}
