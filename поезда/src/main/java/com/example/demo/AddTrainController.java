package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AddTrainController {
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
        backHome.setOnAction(event -> {  //кнопка перехода в окно курсов
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

        create.setOnAction(event -> {     //кнопка создания курса
            CreateNewCourse();
        });
    }

    private boolean CreateNewCourse() {
        Connector dbconnector = new Connector();   //принимает информацию о  курсе
        String name = courseName.getText().trim();
        String date = coursedate.getText().trim();
        String people = coursepeople.getText().trim();
        String hours = coursehours.getText().trim();
        String author = courseauthor.getText().trim();
        //проверка информации
        if (!name.equals("") && !people.equals("") && !date.equals("") && !hours.equals("")&& !author.equals("")) {
            if (isNumeric(people) && isNumeric(hours)){
                LocalDate coursedate = LocalDate.parse(date);
                if(!coursedate.isBefore(LocalDate.now())){
                    Course course = new Course(name, date, people, hours, author);
                    try {
                        dbconnector.signUpCourse(course);   //отправляет информацию на сервер, гдесоздаётся новый курс
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

