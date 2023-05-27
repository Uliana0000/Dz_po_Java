package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class AddTrainController {
    @FXML
    private TextField Freeseats;
    @FXML
    private Button backHome;
    @FXML
    private Button create;
    @FXML
    private TextField numberW;
    @FXML
    private TextArea resultOfCreate;
    @FXML
    private TextField seats;
    @FXML
    private TextField trainName;
    @FXML
    private TextField trainType;
    @FXML
    void initialize() {
        backHome.setOnAction(event -> {  //кнопка перехода на главную страницу
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

        create.setOnAction(event -> {     //кнопка создания поезда
            CreateNewTrain();
        });
    }

    private boolean CreateNewTrain() {
        Connector dbconnector = new Connector();   //принимает информацию о поезде
        String name = trainName.getText().trim();
        String type = trainType.getText().trim();
        String wagon = numberW.getText().trim();
        String seat = seats.getText().trim();
        String freeseats = Freeseats.getText().trim();
        if (!name.equals("") && !type.equals("") && !wagon.equals("") && !seat.equals("")&& !freeseats.equals("")) {
            if (isNumeric(wagon) && isNumeric(seat) && isNumeric(freeseats)){
                Train course = new Train(name, type, wagon, seat, freeseats);
                try {
                    dbconnector.signUpTrain(course);   //создаёт новый поезд
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                resultOfCreate.setText("Поезд успешно добавлен!");
            }
            else{
                resultOfCreate.setText("Некорректно заполнены данные");
            }
        }
        else{
            resultOfCreate.setText("Некорректно заполнены данные");
        }
        return false;
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

}

