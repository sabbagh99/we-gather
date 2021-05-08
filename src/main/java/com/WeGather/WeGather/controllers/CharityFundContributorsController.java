
package com.WeGather.WeGather.controllers;

import com.WeGather.WeGather.models.*;
import com.WeGather.WeGather.repositories.CharityFundContributorsRepository;
import com.WeGather.WeGather.repositories.CommentsRepository;
import com.WeGather.WeGather.repositories.RasisdFundProjectRepositorise;
import com.WeGather.WeGather.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class CharityFundContributorsController {

    @Autowired
    RasisdFundProjectRepositorise rasisdFundProjectRepositorise;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    CharityFundContributorsRepository charityFundContributorsRepository;

    @Autowired
    CharityFundContributorsRepository charityRepository ;

    @Autowired
    CommentsRepository commentsRepository;
    @GetMapping("/RaisedFundDetail/{id}")
    public String displayContributors(@PathVariable(value = "id") Long id, Model m, Principal p) {

        Object principal = SecurityContextHolder.getContext(). getAuthentication(). getPrincipal();

        m.addAttribute("raisedFund", rasisdFundProjectRepositorise.findById(id).get());



        if(principal instanceof UserDetails) {
            String user =  p.getName();
            Users loggedInUser = usersRepository.findByUsername(user);
            m.addAttribute("loggedInUser", loggedInUser);
        }
        List<Comments> raisedWorkFundComments =  commentsRepository.findRaisedWorkFundId(id);
        List<Comments> allComments =  commentsRepository.findComment(id,2L);
        m.addAttribute("AllComment",allComments);


        List<CharityFundContributors> findAllData = charityFundContributorsRepository.findAllData();
        m.addAttribute("findAllData",findAllData);
        System.out.println(findAllData);


        return "ViewRaisedFundDetail.html";
    }




    @PostMapping("/donate")
    public RedirectView AddContributors(@RequestParam(value = "amountPAid") Integer amountPAid,
                                        @RequestParam(value = "fundRaisedId") Long fundRaisedId,
                                        @RequestParam(value = "loggedInUser") Long loggedInUser,
                                  Integer status, Principal p,Model m) {

        ApplicationUsers userDetails = (ApplicationUsers) ((UsernamePasswordAuthenticationToken) p).getPrincipal();
        String donorName = userDetails.getUser().getFirstName() + " " +userDetails.getUser().getLastName();
        CharityFundContributors charityFundContributors = new CharityFundContributors(fundRaisedId, loggedInUser, amountPAid, 1,donorName);
        charityFundContributorsRepository.save(charityFundContributors);
        return new RedirectView("/viewRaisedFund");
    }


    @GetMapping("/yourContributions")
    public String  userFundRaiserId(Principal p,Model m){
        String userName= ((UsernamePasswordAuthenticationToken)p).getName();
        Users userMe =usersRepository.findByUsername(userName);
        Integer amount = 0,size=0;

        ArrayList<Integer> arrayContributions=new ArrayList<>();
        ArrayList<Integer> countArray=new ArrayList<>();
        ArrayList<String> arrayTopic=new ArrayList<>();
        ArrayList<String> arrayDescription=new ArrayList<>();

        List<CharityFundContributors> donate = charityRepository.findByUserFundRaiserId(userMe.getId());

        for (CharityFundContributors donTow : donate)
        {
            Optional<RaisedFundProject> userDetails =rasisdFundProjectRepositorise.findById(donTow.getRaisedFundId()) ;
            countArray.add(size);
            arrayTopic.add(userDetails.get().getTopic());
            arrayDescription.add(userDetails.get().getDescription());
            arrayContributions.add(donTow.getAmountPaid());
            size++;
        }
        m.addAttribute("amountArray",arrayContributions);
        m.addAttribute("arrayTopic",arrayTopic);
        m.addAttribute("arrayDescription",arrayDescription);
        m.addAttribute("countArray",countArray);

        return "/yourContributions.html";
    }

}

