package com.WeGather.WeGather.controllers;

import com.WeGather.WeGather.models.UserContactInfo;
import com.WeGather.WeGather.repositories.UserContactInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserContactInfoController {

    @Autowired
    UserContactInfoRepository userContactInfoRepository;


    @GetMapping("/contact_info")
    public String getContact_info() {

        return "ContactInfo.html";
    }

    @PostMapping("/contact_info")
    public RedirectView addContact_info(@RequestParam (value="phoneNumber") String phoneNumber,
                                        @RequestParam (value="address") String address,
                                        @RequestParam (value="email") String email,
                                        @RequestParam (value="governorate") String governorate,
                                        @RequestParam (value="district") String district,
                                        @RequestParam (value="suburb")String suburb){
        UserContactInfo userContactInfo = new UserContactInfo(phoneNumber,address,governorate,district,suburb);

        userContactInfoRepository.save(userContactInfo);

        return new  RedirectView("/");

    }
}
