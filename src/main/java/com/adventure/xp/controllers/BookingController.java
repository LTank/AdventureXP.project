package com.adventure.xp.controllers;

import com.adventure.xp.dao.repositories.ReservationRepo;
import com.adventure.xp.models.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookingController {



    @Autowired
    private ReservationRepo reservationRepo;



    @GetMapping(value="/createEvent")
    public String createNewEvent(Model model, @ModelAttribute Reservation reservation){
        model.addAttribute("reservation", reservation);
        return "booking";
    }




    @RequestMapping(value = "/createEvent", method= RequestMethod.POST)
    public String createEvent(Model model, Reservation reservation){

        reservationRepo.create(reservation);
        model.addAttribute("reser")



        return "calendar";
    }
}
