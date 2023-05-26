package com.example.demo;
public class Course {  //создается класс курс
    private String name;
    private String date;
    private String people;
    private String hours;
    private String author;
    public Course(String name, String date, String people, String hours, String author) {
        this.name = name;
        this.date = date;
        this.people = people;
        this.hours = hours;
        this.author = author;
    }
    public Course() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String notFound() {
        return null;
    }
}