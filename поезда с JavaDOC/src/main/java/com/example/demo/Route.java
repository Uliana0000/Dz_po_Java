package com.example.demo;

public class Route {
    public String town1;
    public String town2;
    public String date1;
    public String time1;
    public String date2;
    public String time2;
    public String price;
    public String trainName;

    public Route(String town1, String town2, String date1, String time1, String date2, String time2, String price, String trainName) {
        this.town1 = town1;
        this.town2 = town2;
        this.date1 = date1;
        this.time1 = time1;
        this.date2 = date2;
        this.time2 = time2;
        this.price = price;
        this.trainName = trainName;
    }

    public String getTown1() {
        return town1;
    }

    public void setTown1(String town1) {
        this.town1 = town1;
    }

    public String getTown2() {
        return town2;
    }

    public void setTown2(String town2) {
        this.town2 = town2;
    }

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public String getDate2() {
        return date2;
    }

    public void setDate2(String date2) {
        this.date2 = date2;
    }

    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }
}
