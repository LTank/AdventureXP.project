package com.adventure.xp.controllers;

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

@Controller
public class BookingController {



    @Autowired
    private ReservationRepo reservationRepo;


    @RequestMapping(value="/booking", method=RequestMethod.GET)
    public String eventForm(Model model){
        model.addAttribute("eventForm", new EventForm());
        return "booking";
    }




    @RequestMapping(value="/createEvent", method=RequestMethod.POST)
    public String createEvent(@ModelAttribute EventForm eventForm, Model model){


        System.out.println("Woop Woop we created a Event!!");







        model.addAttribute("eventForm", eventForm);
        return "calendar";
    }
}
