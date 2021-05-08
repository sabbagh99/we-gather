package com.WeGather.WeGather.controllers;

import com.WeGather.WeGather.models.ApplicationUsers;
import com.WeGather.WeGather.models.Comments;
import com.WeGather.WeGather.repositories.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.Date;

@Controller
public class CommentsController {

    @Autowired
    CommentsRepository commentsRepository;


    @PostMapping("/addComment")
    public RedirectView addComment(@RequestParam(value = "body") String body, @RequestParam(value = "workId") Long workId, @RequestParam(value = "status") int status, Principal p) {
        ApplicationUsers userDetails = (ApplicationUsers) ((UsernamePasswordAuthenticationToken) p).getPrincipal();
        String commenterName = userDetails.getUser()
                                          .getFirstName() + " " + userDetails.getUser()
                                                                             .getLastName();

//        System.out.println(id);
        Date date = new Date();

        Comments comments = new Comments(userDetails.getId(), commenterName, date, body, workId, status);
        commentsRepository.save(comments);
        String redirectViewWork = "/viewRaisedWork/" + workId;
        String redirectViewFund = "/RaisedFundDetail/" + workId;

        if (status == 1) {
            return new RedirectView(redirectViewWork);
        } else {

            return new RedirectView(redirectViewFund);

        }

    }

}
