package com.adventure.xp.controllers;


import com.adventure.xp.dao.repositories.ActivitiesRepo;
import com.adventure.xp.dao.repositories.EventRepo;
import com.adventure.xp.models.Event;
import com.adventure.xp.models.EventForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class BookingController {

    @Autowired
    private EventRepo eventRepo;

    @Autowired
    private ActivitiesRepo activityRepo;

    @RequestMapping(value="/event", method= RequestMethod.GET)
    public String eventForm(@RequestParam(name="id", required = false) Integer name, Model model) {
        model.addAttribute("activities", activityRepo.readAll());
        EventForm eventForm = new EventForm();
        if(name!=null){
            model.addAttribute("id", name);
            Event event = eventRepo.read(name);
            eventForm.setActivity(event.getTitle());
            eventForm.setStartDate(event.getStart());
            eventForm.setEndDate(event.getEnd());
        } else {
            model.addAttribute("id", 0);
        }
        model.addAttribute("eventForm", eventForm);
        return "event";
    }

    @RequestMapping(value="/createEvent", method=RequestMethod.POST)
    public String createEvent(@ModelAttribute EventForm eventForm, @RequestParam String method, @RequestParam int id, Model model) {
        System.out.println(method);
        System.out.println(id);
        if(method.equals("Create")){
            Event event = createEventFromForm(eventForm);

            eventRepo.create(event);

            model.addAttribute("eventForm", eventForm);
        }
        if(method.equals("Update")){
            Event event = eventRepo.read(id);
            event.setStart(eventForm.getStartDate());
            event.setEnd(eventForm.getEndDate());
            event.setTitle(eventForm.getActivity());
            event.setColor(activityRepo.getColorByTitle(event.getTitle()));
            event.setDescription(activityRepo.getDescriptionByTitle(event.getTitle()));

            eventRepo.update(event);
        }

        return "redirect:/calendar";
    }


    private Event createEventFromForm(EventForm eventForm) {
        int eventId =  0; // Event gets an ID when entry in database
        String url = "/event"; // The url gonna get the database ID concatenated

        Date start = eventForm.getStartDate();
        Date end = eventForm.getEndDate();
        String title = eventForm.getActivity();

        String color = activityRepo.getColorByTitle(title);
        String description = activityRepo.getDescriptionByTitle(title);

        return new Event(eventId, url, start, end, title, color, description);
    }

    @RequestMapping (value = "/deleteEvent", method = RequestMethod.GET)
    String deleteEvent (@RequestParam("id") String id, Model model) {
        eventRepo.delete(Integer.parseInt(id));
        return "redirect:/calendar";
    }
}
