package com.WeGather.WeGather.controllers;


import com.WeGather.WeGather.models.Feedback;
import com.WeGather.WeGather.models.UserConfiguration;
import com.WeGather.WeGather.models.Users;
import com.WeGather.WeGather.repositories.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Date;

@Controller
public class FeedbackController {

    @Autowired
    FeedbackRepository feedbackRepository;

    @GetMapping("/feedback")
    public String getFeedbackPage(){
        return "feedback.html";
    }

    @PostMapping("/feedback")
    public RedirectView getUserConfiguration( @RequestParam(value = "language") String language
            , @RequestParam(value = "title") String title
            , @RequestParam(value = "body") String body
            , @RequestParam(value = "timeStamp") Date timeStamp
            , @RequestParam(value = "email") String email){

        Feedback feedback = new Feedback(title,body,timeStamp,email);
        feedbackRepository.save(feedback);
        return new RedirectView("/feedback");
    }


}
