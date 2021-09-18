package com.example.test_job_javafx;

import com.example.test_job_javafx.model.Notes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

public class DeleteNotesController {

    @FXML
    private Button yesDelete;
    @FXML
    private Button noDelete;
    private final ListView<String> listViewNotes = new ListView<String>();
    private ObservableList<Notes> notesData = FXCollections.observableArrayList();

    public void showWindow() throws IOException {
        final FXMLLoader loader = new FXMLLoader(getClass().getResource("delete-notes-view.fxml"));
        final Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        stage.setMinHeight(100);
        stage.setMinWidth(300);
        stage.setMaxHeight(100);
        stage.setMaxWidth(300);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Delete Notes");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void deleteNotes(AppController appController){
        /*
        System.out.println(appController.listViewNotes.getItems());
        System.out.println(appController.notesData.addAll());

        for (int i = 0; i < appController.listViewNotes.getItems().size(); i++){
            this.listViewNotes.getItems().add(appController.listViewNotes.getItems().get(i));
            System.out.println(this.listViewNotes.getItems().get(i));
        }

        this.listViewNotes.setItems(appController.listViewNotes.getItems());
        System.out.println(this.listViewNotes);
        this.notesData = appController.notesData;
         */
    }

    public void  yesDelete(){
        int selectedID = this.listViewNotes.getSelectionModel().getSelectedIndex();
        System.out.println("selectedID: " + selectedID);
        this.listViewNotes.getItems().remove(selectedID);
        this.notesData.remove(selectedID);
    }

    public void noDelete(ActionEvent event){
        ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
    }
}
