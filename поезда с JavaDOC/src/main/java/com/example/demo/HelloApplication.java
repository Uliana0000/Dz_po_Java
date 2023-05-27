/**
 * HelloApplication class главный класс программы
 * На основе JavaFX Application.
 */
package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    /**
     * Метод start вызывается при запуске приложения.
     * @param stage Основной этап для этого приложения.
     * @throws IOException, если файл FXML не может быть загружен по какой-либо причине.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 400);
        stage.setTitle("поезда и рейсы");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Это точка входа приложения.
     * Он запускает приложение.
     * @param args Массив аргументов командной строки для приложения.
     */
    public static void main(String[] args) {
        launch();
    }
}

