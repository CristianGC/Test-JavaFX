package com.example.test_job_javafx;

import com.example.test_job_javafx.model.Notes;
import com.example.test_job_javafx.note.Note;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CreateNotesController implements Initializable {

    @FXML
    private TextField noteTitle;
    @FXML
    private TextArea textAreaNotes;
    @FXML
    private Label timeOfCreation;
    @FXML
    private Button yesCreate;
    @FXML
    private Button noCreate;
    private List<Note> noteList = new ArrayList<Note>();
    private ListView<Notes> listView;
    // Ссылка на главное приложение.
    private AppController appController;

    public CreateNotesController() {
    }

    public void setMainApp(AppController appController) {
        this.appController = appController;
    }

    public void showWindow() throws IOException {
        final FXMLLoader loader = new FXMLLoader(getClass().getResource("create-notes-view.fxml"));
        final Scene scene = new Scene(loader.load(), 400, 370);
        final Stage stage = new Stage();
        stage.setMinHeight(370);
        stage.setMinWidth(400);
        stage.setMaxHeight(370);
        stage.setMaxWidth(400);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Create Note");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void yesCreateNotesClick() throws IOException {
        TextField noteTitle = this.noteTitle;
        TextArea textAreaNotes = this.textAreaNotes;
        System.out.println("yesCreateNotesClick");
        System.out.println("noteTitle : " + noteTitle.getText());
        System.out.println("textAreaNotes : " + textAreaNotes.getText());
    }

    @FXML
    protected void noCreateNotesClick(ActionEvent event) throws IOException {
        System.out.println("noCreateNotesClick");
        ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
