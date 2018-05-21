package com.example.admin.tourmatemodule1;

public class Events {
    private String eventName;
    private String startLocation;
    private String destination;
    private String date;
    private int budget;

    public Events() {
    }

    public Events(String eventName, String startLocation, String destination, String date, int budget) {
        this.eventName = eventName;
        this.startLocation = startLocation;
        this.destination = destination;
        this.date = date;
        this.budget = budget;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
}
