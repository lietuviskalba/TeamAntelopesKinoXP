import javafx.event.ActionEvent;

/**
 * Created by ADMIN on 18/09/2017.
 */
public class AddMovieController {

    public void addMovieButton(ActionEvent event){
        if(event.getSource().equals(addMovieButton);{
            Motorhome byeMotorhome = motorhomesTable.getSelectionModel().getSelectedItem();
            if(!db.deleteMotorhome(fleet,byeMotorhome))
                System.out.println("Could not delete Motorhome right now.");
            else
                System.out.println("Motorhome deleted from records.");

        }
    }
}
