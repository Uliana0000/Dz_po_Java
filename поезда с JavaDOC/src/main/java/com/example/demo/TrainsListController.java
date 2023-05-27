package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;


public class TrainsListController {
    @FXML
    private Button backHome;
    @FXML
    private TextArea trainsList;
    @FXML
    private Button see;
    @FXML
    void initialize() {
        backHome.setOnAction(event -> {  //кнопка перехода на главную страницув
            backHome.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("main-view.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        see.setOnAction(event -> {  //кнопка просмотра списка
            Connector connector= new Connector();
            trainsList.setText(connector.getTrainList());
        });

    }

}



