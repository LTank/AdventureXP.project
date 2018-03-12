package com.adventure.xp.models;


import java.util.Date;

public class Reservation {
    private int id;
    private Date date;
    private int numberOfCustomers;
    private int status;

    public Reservation(int id, Date date, int numberOfCustomers, int status) {
        this.id = id;
        this.date = date;
        this.numberOfCustomers = numberOfCustomers;
        this.status = status;
    }

    public Reservation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNumberOfCustomers() {
        return numberOfCustomers;
    }

    public void setNumberOfCustomers(int numberOfCustomers) {
        this.numberOfCustomers = numberOfCustomers;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", date=" + date +
                ", numberOfCustomers=" + numberOfCustomers +
                ", status=" + status +
                '}';
    }
}
