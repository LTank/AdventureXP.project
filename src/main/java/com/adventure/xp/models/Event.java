package com.adventure.xp.models;

import java.util.Date;

public class Event {

    private int id;
    private String url;
    private Date start;
    private Date end;
    private String description;
    private int numberOfCustomers;
    private String customerName;
    private String activityName;
    private String color;

    public Event() {
    }

    public Event(int id, String url, Date start, Date end, String description, int numberOfCustomers, String customerName, String activityName, String color) {
        this.id = id;
        this.url = url;
        this.start = start;
        this.end = end;
        this.description = description;
        this.numberOfCustomers = numberOfCustomers;
        this.customerName = customerName;
        this.activityName = activityName;
        this.color = color;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberOfCustomers() {
        return numberOfCustomers;
    }

    public void setNumberOfCustomers(int numberOfCustomers) {
        this.numberOfCustomers = numberOfCustomers;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", description='" + description + '\'' +
                ", numberOfCustomers=" + numberOfCustomers +
                ", customerName='" + customerName + '\'' +
                ", activityName='" + activityName + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}