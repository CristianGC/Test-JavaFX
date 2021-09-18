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

    public final ObservableList<Notes> notesData = FXCollections.observableArrayList();
    @FXML
    private ListView<String> listViewNotes;
    @FXML
    private Label heading;
    @FXML
    private Label timeOfCreation;
    @FXML
    private Button createNotes;
    @FXML
    private Button editNotes;
    @FXML
    private Button deleteNotes;
    @FXML
    private TextArea textArea;
    private List<String> stringList = new ArrayList<String>();

    public AppController() {
        // В качестве образца добавляем некоторые данные
        notesData.add(new Notes("Hans", " Opisania Muster"));
        notesData.add(new Notes("Ruth", " Opisania Mueller"));
        notesData.add(new Notes("Heinz", " Opisania Kurz"));
        notesData.add(new Notes("Hans", " Opisania Ghinea"));
        notesData.add(new Notes("Ruth", " Opisania Saaa"));
        notesData.add(new Notes("Heinz", " Opisania GAgsa"));
    }

    @FXML
    protected void onCreateNotesClick() throws IOException {
        CreateNotesController createNotesController = new CreateNotesController();
        createNotesController.showWindow();
        createNotesController.setMainApp(this);
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

        if (1 <= listViewNotes.getItems().size()) {
            int selectedID = this.listViewNotes.getSelectionModel().getSelectedIndex();
            this.listViewNotes.getItems().remove(selectedID);
            this.notesData.remove(selectedID);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        for (int i = 0; i < notesData.size(); i++) {
            this.stringList.add(this.notesData.get(i).getHeading());
            System.out.println("stringList: " + this.stringList);
            this.listViewNotes.getItems().add(this.stringList.get(i));
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
