package gui;

import database.DBconnection;
import javafx.fxml.FXML;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static javax.swing.JOptionPane.NO_OPTION;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;

public class DeleteMoviesSceneController {

    @FXML
    void btnDeleteMovie() throws SQLException {
        String titleDel = "a Film";

        String message = "Do you wish to delete the selected film?";

        Object[] options = {"Yes",
                "No"};

        final JOptionPane optionPane = new JOptionPane(                 //40-45 & 53-56  = dialogue popup
                "Do you wish to delete the selected film",
                JOptionPane.QUESTION_MESSAGE,
                YES_NO_OPTION);
        int dialogue = JOptionPane.showOptionDialog(optionPane, message, "Warning!", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        if (dialogue == YES_OPTION) {
            Connection con = DBconnection.getConnection();
            PreparedStatement prepstmt = con.prepareStatement("DELETE FROM `teamantelopeskinoxp`.`movies`" +
                    "WHERE  `Title`= ?");
            prepstmt.setString(1, titleDel);
            prepstmt.execute();
            con.close();

        } else if (dialogue == NO_OPTION) {
            System.out.println("Cancelled");

        }
    }
    @FXML
    void btnMenu(){
        try{
            SceneManager.getInstance().loadMainScene();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
