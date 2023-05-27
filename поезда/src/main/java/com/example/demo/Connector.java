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
    public void signUpTrain(Train train) throws SQLException, ClassNotFoundException { //добавляет новый поезд
        String insert = "INSERT INTO " + Constant.USER_TABLE1 + "(" + Constant.USERS_NAME + ","+Constant.USERS_TYPE+ ","
                +Constant.USERS_WAGONS +","+Constant.USERS_SEATS +","+Constant.USERS_FREESEATS + ")"+"VALUES(?,?,?,?,?)";
        PreparedStatement prSt = getDbConnectoin().prepareStatement(insert);
        prSt.setString(1, train.getName());
        prSt.setString(2, train.getType());
        prSt.setString(3, train.getWagons());
        prSt.setString(4, train.getSeats());
        prSt.setString(5, train.getFreeseats());
        prSt.executeUpdate();
    }


    public void signUpRoute(Route route) throws SQLException, ClassNotFoundException { //добавляет новый рейс
        String insert = "INSERT INTO " + Constant.USER_TABLE2 + "(" + Constant.USERS_DEPART + ","+Constant.USERS_ARRIVAL+ ","
                +Constant.USERS_DEPDATE +","+Constant.USERS_DEPTIME +","+Constant.USERS_ARRDATE +","+Constant.USERS_ARRTIME+","
                +Constant.USERS_PRICE+","+Constant.USERS_TRAIN+ ")"+"VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement prSt = getDbConnectoin().prepareStatement(insert);
        prSt.setString(1, route.getTown1());
        prSt.setString(2, route.getTown2());
        prSt.setString(3, route.getDate1());
        prSt.setString(4, route.getTime1());
        prSt.setString(5, route.getDate2());
        prSt.setString(6, route.getTime2());
        prSt.setString(7, route.getPrice());
        prSt.setString(8, route.getTrainName());
        prSt.executeUpdate();
    }

    public String getTrainList(){   //возвращает список поездов
        String sql = "SELECT Name, Type, Number_of_wagons, Seats FROM train";
        String ss=new String();
        try (PreparedStatement statement = getDbConnectoin().prepareStatement(sql)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String name = resultSet.getString("Name");// Получаем информацию о поезде
                    String type = resultSet.getString("Type");
                    String numberOfWagons = resultSet.getString("Number_of_wagons");
                    String seats = resultSet.getString("Seats");
                    ss+=(name+"-"+type + " " +numberOfWagons+ " " +seats +"\n");
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return ss;
    }

    public String getRouteList(){   //возвращает список рейсов
        String sql = "SELECT * FROM the_path_of_following";
        String ss=new String();
        try (PreparedStatement statement = getDbConnectoin().prepareStatement(sql)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String town1 = resultSet.getString("departure");// Получаем информацию о рейск
                    String town2 = resultSet.getString("arrival");
                    String date1 = resultSet.getString("departure_date");
                    String time1 = resultSet.getString("departure_time");
                    String date2 = resultSet.getString("arrival_date");
                    String time2 = resultSet.getString("arrival_time");
                    String price_ = resultSet.getString("price");
                    String train_ = resultSet.getString("train");
                    ss+=(town1+"-"+town2 + " " +date1+ " " +time1+ "__" +date2+" "+time2+" "+price_+
                            " "+train_+"\n");
                }

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return ss;
    }
}