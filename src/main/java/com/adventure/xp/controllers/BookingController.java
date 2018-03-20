package com.adventure.xp.controllers;


import com.adventure.xp.dao.DButil.Util;
import com.adventure.xp.dao.repositories.ActivitiesRepo;
import com.adventure.xp.dao.repositories.EventRepo;
import com.adventure.xp.models.Activity;
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

    @Autowired
    private Util util;

    @RequestMapping(value="/event", method= RequestMethod.GET)
    public String eventForm(@RequestParam(name="id", required = false) Integer name, Model model) {
        model.addAttribute("activities", activityRepo.readAll());
        EventForm eventForm = new EventForm();
        Event event = new Event();
        if(name!=null){
            model.addAttribute("id", name);
            event = eventRepo.read(name);
            eventForm.setActivity(event.getTitle());
            eventForm.setStartDate(event.getStart());
            eventForm.setEndDate(event.getEnd());
        } else {
            model.addAttribute("id", 0);
        }
        model.addAttribute("eventForm", eventForm);
        model.addAttribute("event", event);
        return "event";
    }

    @RequestMapping(value="/createEvent", method=RequestMethod.POST)
    public String createEvent(@ModelAttribute Event event, @RequestParam String method, @RequestParam int id, Model model) {
        if(method.equals("Create")){
//           event = createEventFromForm(eventForm);

            model.addAttribute("event", eventRepo.create(event));
//            eventRepo.create(event);

            Activity activity = util.getActivityByName(event.getTitle());

            int lastCreatedEvent = eventRepo.readLastCreatedEventId();

            util.addEventActivityJoin(lastCreatedEvent, activity);

//            model.addAttribute("eventForm", eventForm);
        }
        if(method.equals("Update")){
            event = eventRepo.read(id);
            System.out.println("Update event before: " + event);
//            event.setStart(eventForm.getStartDate());
//            event.setEnd(eventForm.getEndDate());
//            event.setColor(activityRepo.getColorByTitle(event.getTitle()));
//            event.setDescription(activityRepo.getDescriptionByTitle(event.getTitle()));

//            eventRepo.update(event);
            model.addAttribute("event", eventRepo.update(event));
            System.out.println("Update event after: " + event);
        }

        return "redirect:/calendar";
    }


//    private Event createEventFromForm(Event event) {
//        int eventId =  0; // Event gets an ID when entry in database
//        String url = "/event"; // The url gonna get the database ID concatenated
//
//        Date start = event.getStart();
//        Date end = event.getEnd();
//        String title = event.getTitle();
//
//        String color = activityRepo.getColorByTitle(title);
//        String description = activityRepo.getDescriptionByTitle(title);
//
//        int numberOfCustomers = 1;
//        String customerName = "Anders";
//
//
//        return new Event(eventId, url, start, end, description, numberOfCustomers, customerName, title, color);
//    }

    @RequestMapping (value = "/deleteEvent", method = RequestMethod.GET)
    String deleteEvent (@RequestParam("id") String id, Model model) {
        eventRepo.delete(Integer.parseInt(id));
        return "redirect:/calendar";
    }
}
