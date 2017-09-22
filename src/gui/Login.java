package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;


public class Login {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "kinoXP";

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    private boolean loginOk(String username, String password) {
        return (USERNAME.equals(username) && PASSWORD.equals(password));
    }

    @FXML
    private void btnLogin() {
        String user = username.getText();
        String pass = password.getText();
        try {
            if (loginOk(user, pass)) {
                SceneManager.getInstance().loadMainScene();
            } else {
                Alert wrongCredentials = new Alert(Alert.AlertType.ERROR);
                wrongCredentials.setTitle("Invalid login");
                wrongCredentials.setHeaderText("Invalid username or password.");
                wrongCredentials.setContentText(null);
                wrongCredentials.showAndWait();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
