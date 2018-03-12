package com.adventure.xp.controllers;

import com.adventure.xp.dao.DButil.Util;
import com.adventure.xp.dao.repositories.ActivitiesRepo;
import com.adventure.xp.dao.repositories.EventRepo;
import com.adventure.xp.dao.repositories.ReservationRepo;
import com.adventure.xp.models.Event;
import com.adventure.xp.models.EventForm;
import com.adventure.xp.models.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
public class BookingController {



    @Autowired
    private ReservationRepo reservationRepo;

    @Autowired
    private EventRepo eventRepo;

    @Autowired
    private ActivitiesRepo activityRepo;


    @RequestMapping(value="/booking", method=RequestMethod.GET)
    public String eventForm(Model model){
        model.addAttribute("eventForm", new EventForm());
        return "booking";
    }




    @RequestMapping(value="/createEvent", method=RequestMethod.POST)
    public String createEvent(@ModelAttribute EventForm eventForm, Model model){


        System.out.println("Woop Woop we created a Event!!");

        Event event = createEventFromForm(eventForm);
        eventRepo.create(event);


        model.addAttribute("eventForm", eventForm);
        return "calendar";
    }


    private Event createEventFromForm(EventForm eventForm){
        int eventId =  0; // Event gets an ID when entry in database
        String url = "/booking?i="; // The url gonna get the database ID concatenated

        Date start = eventForm.getStartDate();
        Date end = eventForm.getEndDate();
        String title = eventForm.getActivity();

        String color = activityRepo.getColorByTitle(title);
        String description = activityRepo.getDescriptionByTitle(title);

        return new Event(eventId, url, start, end, title, color, description);
    }
}
