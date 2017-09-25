package gui;

import database.DBconnection;
import domain.Movie;
import domain.MovieList;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private MovieList moviess = MovieList.getInstance();
    private ObservableList<Movie> movieList = moviess.getTheMovieList();
    DBconnection db = new DBconnection();

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
        movieName.setCellFactory(TextFieldTableCell.forTableColumn());
        movieDes.setCellValueFactory(new PropertyValueFactory<>("des"));
        movieDes.setCellFactory(TextFieldTableCell.forTableColumn());
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
        Movie byeMovie = movies.getSelectionModel().getSelectedItem();
        if(!db.deleteMovie(moviess,byeMovie));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        initializeMovieTable();

        }

    }

