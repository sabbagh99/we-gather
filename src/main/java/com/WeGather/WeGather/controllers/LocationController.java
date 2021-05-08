package com.WeGather.WeGather.controllers;
import com.WeGather.WeGather.models.Location;
import com.WeGather.WeGather.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LocationController {

    @Autowired
    LocationRepository locationRepository;

    @GetMapping("/location")
    public String getLocation(){

        return "location.html";
    }

//    public Location(long longitude, long latitude, String description) {

    @PostMapping("/postLocation")
    public RedirectView addLocation(@RequestParam(value = "longitude") String longitude, @RequestParam(value = "latitude") String latitude, @RequestParam(value = "description") String description){
        Location newLocation = new Location(longitude,latitude,description);
        System.out.println(newLocation.toString());
        locationRepository.save(newLocation);
        return new RedirectView("/raisedWork");

    }
    


}
