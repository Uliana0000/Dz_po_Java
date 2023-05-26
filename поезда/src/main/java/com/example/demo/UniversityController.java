package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;

public class UniversityController {
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Button UFinans;
    @FXML
    private Button UHightS;
    @FXML
    private Button USechenov;
    @FXML
    private Button backMain;
    @FXML
    void initialize() {

        USechenov.setOnAction(event -> { //кнопка перехода на сайт Сеченовского университета
            try {
                Desktop.getDesktop().browse(new URI("https://www.sechenov.ru"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        StackPane root = new StackPane();
        root.getChildren().add(USechenov);
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        });

        UHightS.setOnAction(event -> { //кнопка перехода на сайт Высшей школы экономики
            try {
                Desktop.getDesktop().browse(new URI("https://www.hse.ru"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            StackPane root = new StackPane();
            root.getChildren().add(UHightS);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        UFinans.setOnAction(event -> { //кнопка перехода на сайт Финансового университета
            try {
                Desktop.getDesktop().browse(new URI("http://www.fa.ru"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            StackPane root = new StackPane();
            root.getChildren().add(UFinans);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        backMain.setOnAction(event -> {   //кнопка перехода в гавное меню
            backMain.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("hello-view.fxml"));
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
    }

}
