package com.adventure.xp.controllers;


import com.adventure.xp.dao.DButil.Util;
import com.adventure.xp.dao.repositories.ActivitiesRepo;
import com.adventure.xp.dao.repositories.EventRepo;
import com.adventure.xp.models.Activity;
import com.adventure.xp.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
        Event event = new Event();
        if(name!=null){
            model.addAttribute("id", name);
            event = eventRepo.read(name);
        } else {
            model.addAttribute("id", 0);
        }
        model.addAttribute("event", event);
        return "event";
    }

    @RequestMapping(value="/createEvent", method=RequestMethod.POST)
    public String createEvent(@ModelAttribute Event event, @RequestParam String method, @RequestParam int id, Model model) {
        if(method.equals("Create")){

            model.addAttribute("event", eventRepo.create(event));
            Activity activity = util.getActivityByName(event.getTitle());
            int lastCreatedEvent = eventRepo.readLastCreatedEventId();
            util.addEventActivityJoin(lastCreatedEvent, activity);
        }
        if(method.equals("Update")){
            model.addAttribute("event", eventRepo.update(event));
        }

        return "redirect:/calendar";
    }


    @RequestMapping (value = "/deleteEvent", method = RequestMethod.GET)
    String deleteEvent (@RequestParam("id") String id, Model model) {
        eventRepo.delete(Integer.parseInt(id));
        return "redirect:/calendar";
    }
}
