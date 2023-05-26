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
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class FindController {
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Button backtoCourses;
    @FXML
    private TextArea courseInformation;
    @FXML
    private TextField courseName;
    @FXML
    private Button findCourse;

    @FXML
    void initialize() {
        backtoCourses.setOnAction(event -> {  //кнопка перехода в окно курсов
            backtoCourses.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("courses1.fxml"));
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

        findCourse.setOnAction(event -> {      //кнопка поиска курса
            String course_name = courseName.getText().trim();
            if(!course_name.equals("")){
                NameCourse(course_name);
            }
        });


    }

    private void NameCourse(String courseName) {  //принимает информацию о названии курса
        Connector dbconnecror = new Connector();
        Course course = new Course();
        course.setName(courseName);
        ResultSet result = dbconnecror.getCourse(course);  //отправка информации на сервер

        int count = 0;
        //получение и обработка ответа сервера
        try{
            while(result.next()){
                count++;
                String nameC = result.getString("Name");
                String dateC = result.getString("StartDate");
                String peopleC = result.getString("NumberofPeople");
                String hoursC = result.getString("Hours");
                String authorG = result.getString("Author");
                courseInformation.setText(nameC+" начнется "+dateC + "\nВозможное количество участников " +peopleC+"\nКоличество часов "
                        +hoursC +"\nАвтор "+ authorG);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        if(count < 1){
            courseInformation.setText("Курс не найден! \nВведите название еще раз!");
        }
    }

}
