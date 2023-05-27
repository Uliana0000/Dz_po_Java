/**
 * Контроллер для главного окна приложения.
 */
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

public class MainController {
    @FXML
    private Button AddR;
    @FXML
    private Button AddTrain;
    @FXML
    private Button Information;
    @FXML
    private Button Trains;
    @FXML
    private Button WillR;

    /**
     * Инициализация контроллера.
     */
    @FXML
    void initialize() {
        AddR.setOnAction(event -> {   //кнопка перехода в окно курсов
            AddR.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("AddNewRoute.fxml"));
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

        AddTrain.setOnAction(event -> {   //кнопка перехода в окно аттестации
            AddTrain.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("AddNewTrain.fxml"));
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

        Trains.setOnAction(event -> {  //кнопка перехода в окно ВУЗов-партнёров
            Trains.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Trains.fxml"));
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

        WillR.setOnAction(event -> {  //кнопка перехода в окно информации об авторе
            WillR.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Routes.fxml"));
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

        Information.setOnAction(event -> {  //кнопка перехода на мой гит
            try {
                Desktop.getDesktop().browse(new URI("https://github.com/Uliana0000"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            StackPane root = new StackPane();
            root.getChildren().add(Information);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
    }

}

