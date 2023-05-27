/**
 * Контроллер для добавления нового рейса в систему.
 */
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

public class AddRouteController {

    @FXML
    private Button backHome;

    @FXML
    private Button create;

    @FXML
    private TextField date1;

    @FXML
    private TextField date2;

    @FXML
    private TextField price;

    @FXML
    private TextArea resultOfCreate;

    @FXML
    private TextField time1;

    @FXML
    private TextField time2;

    @FXML
    private TextField town1;

    @FXML
    private TextField town2;

    @FXML
    private TextField train;

    /**
     * Инициализация контроллера.
     */
    @FXML
    void initialize() {
        // Обработчик нажатия кнопки "Назад"
        backHome.setOnAction(event -> {
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

        // Обработчик нажатия кнопки "Создать"
        create.setOnAction(event -> {
            CreateNewRoute();
        });
    }

    /**
     * Создание нового рейса в системе.
     *
     * @return true, если рейс успешно создан, иначе - false.
     */
    private boolean CreateNewRoute() {
        Connector dbconnector = new Connector();
        String town_1 = town1.getText().trim();
        String town_2 = town2.getText().trim();
        String date_1 = date1.getText().trim();
        String time_1 = time1.getText().trim();
        String date_2 = date2.getText().trim();
        String time_2 = time2.getText().trim();
        String basicprice = price.getText().trim();
        String trainname = train.getText().trim();
        if (!town_1.equals("") && !town_2.equals("") && !date_1.equals("") && !time_1.equals("")&& !date_2.equals("") && !time_2.equals("") && !basicprice.equals("")&& !trainname.equals("")) {
            if (isNumeric(basicprice)){
                Route course = new Route(town_1, town_2, date_1, time_1, date_2, time_2, basicprice, trainname);
                try {
                    dbconnector.signUpRoute(course);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                resultOfCreate.setText("Рейс успешно добавлен!");
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

    /**
     * Проверка, является ли строка числом.
     *
     * @param str проверяемая строка.
     * @return true, если строка является числом, иначе - false.
     */
    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}