package com.example.test_job_javafx;

import com.example.test_job_javafx.model.Notes;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AppController implements Initializable {

    /**
     * Данные, в виде наблюдаемого списка адресатов.
     */
    public final ObservableList<Notes> notesData = FXCollections.observableArrayList();

    @FXML
    public ListView<String> listViewNotes;
    public Label heading;
    public Label timeOfCreation;
    public Button createNotes;
    public Button editNotes;
    public Button deleteNotes;
    public TextArea textArea;

    public AppController() {
        // В качестве образца добавляем некоторые данные
        notesData.add(new Notes("Hans", " Opisania Muster"));
        notesData.add(new Notes("Ruth", " Opisania Mueller"));
        notesData.add(new Notes("Heinz", " Opisania Kurz"));
    }

    @FXML
    protected void onCreateNotesClick() throws IOException {
        CreateNotesController createNotesController = new CreateNotesController();
        createNotesController.showWindow();
        createNotesController.setMainApp(this);
        //createNotesController.addElemnt(listViewNotes);
    }

    @FXML
    protected void onEditNotesClick() throws IOException {
        EditNotesController editNotesController = new EditNotesController();
        editNotesController.showWindow();
    }

    @FXML
    protected void onDeleteNotesClick() throws IOException {
      /*
        DeleteNotesController deleteNotesController = new DeleteNotesController();
        deleteNotesController.showWindow();
        deleteNotesController.deleteNotes(this);
       */

        if (1 <= listViewNotes.getItems().size()){
            int selectedID = this.listViewNotes.getSelectionModel().getSelectedIndex();
            this.listViewNotes.getItems().remove(selectedID);
            this.notesData.remove(selectedID);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
/*
        listViewNotes.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends MyDataModel> observable, MyDataModel oldValue, MyDataModel newValue) {
                // Your action here
                System.out.println("Selected item: " + newValue);
            }
        });
 */

       this.notesData.addAll(
                new Notes("Hans", " Opisania Ghinea"),
                new Notes("Ruth", " Opisania Saaa"),
                new Notes("Heinz", " Opisania GAgsa")
        );

        List<String> stringList = new ArrayList<String>();

        for (int i = 0; i < notesData.size(); i++){
            stringList.add(this.notesData.get(i ).getHeading());
            System.out.println("stringList: " + stringList);
            this.listViewNotes.getItems().add(stringList.get(i));
        }

        this.listViewNotes.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                // Your action here
                System.out.println("Selected item: " + newValue + oldValue);

                int selectedID = listViewNotes.getSelectionModel().getSelectedIndex();
                heading.setText(notesData.get(selectedID).getHeading());
                textArea.setText(notesData.get(selectedID).getText());
            }
        });
    }
}
