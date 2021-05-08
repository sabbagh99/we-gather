package com.WeGather.WeGather.controllers;

import com.WeGather.WeGather.models.UserConfiguration;
import com.WeGather.WeGather.models.Users;
import com.WeGather.WeGather.repositories.UserConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class UserConfigurationController {

    @Autowired
    UserConfigurationRepository userConfigurationRepository;

    @GetMapping("/UserConfiguration")
    public String getUserConfigPage(){
        return "userConfiguration.html";
    }

    @PostMapping("/user_Configuration")
    public RedirectView getUserConfiguration(
            @RequestParam(value = "language") String language
            , @RequestParam(value = "timeZone") String timeZone
            , @RequestParam(value = "currency") String currency
            , Principal p
            ) {
        Users user = (Users) ((UsernamePasswordAuthenticationToken) p).getPrincipal();
        UserConfiguration userConfiguration = new UserConfiguration(language,timeZone,currency,user);
        userConfigurationRepository.save(userConfiguration);
        return new RedirectView("/userConfiguration");
    }


}
