package com.adventure.xp.controllers;

import com.adventure.xp.dao.repositories.ReservationRepo;
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





    @RequestMapping(value = "/createEvent", method= RequestMethod.POST)
    public String createEvent(Model model, @ModelAttribute("booking") Reservation booking){

        reservationRepo.create(booking);
        model.addAttribute("reservation", booking);



        return "calendar";
    }
}
