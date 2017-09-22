package gui;

import database.MovieCRUD;
import domain.Movie;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;



/**
 * Created by ADMIN on 18/09/2017.
 */
public class AddMovieController {

    private final MovieCRUD movieList = new MovieCRUD();

    @FXML
    private TextField titleInput;

    @FXML
    private TextArea descInput;


    @FXML
    private void btnAddMovie(){

        String title = titleInput.getText();
        String desc = descInput.getText();

            if(title.isEmpty() || desc.isEmpty()) {
                SceneManager.getInstance().displayError("Missing Info", null, "Please fill all fields");
            }else{
                 movieList.addMovieDB(new Movie(title, desc));
                titleInput.clear();
                descInput.clear();
                SceneManager.getInstance().displayInformation("Movie saved!", null, "Movie has been saved!");
            }
    }

        }

