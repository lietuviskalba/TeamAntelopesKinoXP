package gui;

import domain.Movie;
import domain.MovieList;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private MovieList moviess = MovieList.getInstance();
    private ObservableList<Movie> movieList = moviess.getTheMovieList();

    @FXML
    public TableColumn<Movie , String> movieName;
    @FXML
    public TableColumn<Movie , String> movieDes;
    @FXML
    private Button mainAdd;
    @FXML
    private Button mainDelete;
    @FXML
    public TableView<Movie> movies;


    public void initializeMovieTable() {

        movies.setEditable(true);
        movieName.setCellValueFactory(new PropertyValueFactory<>("title"));
        movieDes.setCellValueFactory(new PropertyValueFactory<>("des"));
        movies.setItems(movieList);

    }

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        initializeMovieTable();

        }

    }

