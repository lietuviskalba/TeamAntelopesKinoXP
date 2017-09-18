package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    private final static String url = "jdbc:mysql://localhost:3306/";
    //    private final static String url = "jdbc:mysql://52.29.93.75:3306/";
    private final static String DB_NAME = "teamantelopeskinoxp";
    private final static String USER = "root";
    private final static String PASS = "%password%";



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
}
