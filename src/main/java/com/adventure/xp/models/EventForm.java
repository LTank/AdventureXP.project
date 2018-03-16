package com.adventure.xp.models;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class EventForm {


    @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
    private Date startDate;

    @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
    private Date endDate;
    private String activity;

    public EventForm(){

    }

    public EventForm(Date startDate, Date endDate, String activity){
        this.startDate = startDate;
        this.endDate = endDate;
        this.activity = activity;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

}
