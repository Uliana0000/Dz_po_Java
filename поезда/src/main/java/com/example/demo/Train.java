package com.example.demo;
public class Train {  //создается класс курс
    private String name;
    private String type;
    private String wagons;
    private String seats;
    private String freeseats;
    public Train(String name, String type, String wagons, String seats, String freeseats) {
        this.name = name;
        this.type = type;
        this.wagons = wagons;
        this.seats = seats;
        this.freeseats = freeseats;
    }
    public Train() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWagons() {
        return wagons;
    }

    public void setWagons(String wagons) {
        this.wagons = wagons;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getFreeseats() {
        return freeseats;
    }

    public void setFreeseats(String freeseats) {
        this.freeseats = freeseats;
    }
}