package com.example.demo;
import java.sql.*;
public class Connector extends Configs{  //создание соединения с базой данных
    Connection dbConnectoin;
    public Connection getDbConnectoin() throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://"+dbHost +":" + dbPort + "/"+dbName;
        Class.forName("com.mysql.jdbc.Driver");
        dbConnectoin = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnectoin;
    }
    public void signUpCourse(Course course) throws SQLException, ClassNotFoundException { //добавляет новый курс
        String insert = "INSERT INTO " + Constant.USER_TABLE + "(" + Constant.USERS_NAME + ","+Constant.USERS_STARTDATE+ ","
                +Constant.USERS_PEOPLE +","+Constant.USERS_HOURS +","+Constant.USERS_AUTHOR + ")"+"VALUES(?,?,?,?,?)";
        PreparedStatement prSt = getDbConnectoin().prepareStatement(insert);
        prSt.setString(1, course.getName());
        prSt.setString(2, course.getDate());
        prSt.setString(3, course.getPeople());
        prSt.setString(4, course.getHours());
        prSt.setString(5, course.getAuthor());
        prSt.executeUpdate();
    }

    public ResultSet getCourse(Course course){   //возвращает курс по его названию
        ResultSet resSet = null;
        String select = "SELECT * FROM " + Constant.USER_TABLE + " WHERE " + Constant.USERS_NAME + "= ?";
        try{
            PreparedStatement prSt = getDbConnectoin().prepareStatement(select);
            prSt.setString(1, course.getName());
            resSet = prSt.executeQuery();
        } catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        return resSet;
    }
}