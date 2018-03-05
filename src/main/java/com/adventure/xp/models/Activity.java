package com.adventure.xp.models;

public class Activity {
    private int id;
    private String name;
    private int ageLimit;
    private double price;

    public Activity(int id, String name, int ageLimit, double price) {
        this.id = id;
        this.name = name;
        this.ageLimit = ageLimit;
        this.price = price;
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

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ageLimit=" + ageLimit +
                ", price=" + price +
                '}';
    }
}
