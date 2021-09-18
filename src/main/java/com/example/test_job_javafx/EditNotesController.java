package com.example.test_job_javafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

public class EditNotesController {

    @FXML
    private Button yesEdit;
    @FXML
    private Button noEdit;

    public void showWindow() throws IOException {
        final FXMLLoader loader = new FXMLLoader(getClass().getResource("edit-notes-view.fxml"));
        final Scene scene = new Scene(loader.load(), 400, 370);
        Stage stage = new Stage();
        stage.setMinHeight(370);
        stage.setMinWidth(400);
        stage.setMaxHeight(370);
        stage.setMaxWidth(400);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Edit Notes");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}
