package gui;

import domain.MovieList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

import java.io.IOException;

public class Controller {

    @FXML
private TableView<MovieList> movies;

    @FXML
    private void btnMainAdd() {
        try {
            SceneManager.getInstance().loadAddMovieScene();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void btnLogin(){
        try {
            SceneManager.getInstance().loadLoginScene();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void btnDelete(){
        try{
            SceneManager.getInstance().loadDeleteMovieScene();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
