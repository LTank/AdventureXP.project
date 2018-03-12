package com.adventure.xp.models;

public class Activity {
    private int id;
    private String name;
    private int ageLimit;
    private int heightLimit;
    private int maxAttendants;
    private double price;
    private String calendarColor;
    private String description;

    public Activity(int id, String name, int ageLimit, int heightLimit, int maxAttendants, double price, String calendarColor, String description) {
        this.id = id;
        this.name = name;
        this.ageLimit = ageLimit;
        this.heightLimit = heightLimit;
        this.maxAttendants = maxAttendants;
        this.price = price;
        this.calendarColor = calendarColor;
        this.description = description;
    }

    public Activity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public int getHeightLimit() {
        return heightLimit;
    }

    public void setHeightLimit(int heightLimit) {
        this.heightLimit = heightLimit;
    }

    public int getMaxAttendants() {
        return maxAttendants;
    }

    public void setMaxAttendants(int maxAttendants) {
        this.maxAttendants = maxAttendants;
    }

    public String getCalendarColor() {
        return calendarColor;
    }

    public void setCalendarColor(String calendarColor) {
        this.calendarColor = calendarColor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", name='" + name +
                ", ageLimit=" + ageLimit +
                ", price=" + price +
                ", heightLimit=" + heightLimit +
                ", maxAttendants=" + maxAttendants +
                ", calendarColor=" + calendarColor +
                ", description=" + description +
                '}';
    }


}