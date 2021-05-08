package com.WeGather.WeGather.controllers;


import com.WeGather.WeGather.models.*;
//import com.WeGather.WeGather.repositories.ApplicationUsersRepository;
import com.WeGather.WeGather.repositories.*;
import com.WeGather.WeGather.services.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public
class MainControllerController {

    @Autowired
    UsersRepository usersRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UploadFileService uploadFileService;
    @Autowired
    CharityFundContributorsRepository charityRepository ;
    @Autowired
    RasisdFundProjectRepositorise rasisdFundProjectRepositorise;
    @Autowired
    RaisedWorkProjectRepository raisedWorkProjectRepository;
    @Autowired
    CharityWorkContributorsRepository charityWorkContributorsRepository;

//    @Autowired
//    ApplicationUsersRepository applicationUsersRepository;

    @GetMapping("/")
    public String home(Principal p,Model m) {
        Iterable<RaisedFundProject> df =rasisdFundProjectRepositorise.findAll() ;
        m.addAttribute("user",df);
        Integer amount = 0;
        int counter=0;
        ArrayList<Integer> array=new ArrayList<>();
        array.add(0);
        ArrayList<Integer> arraycount=new ArrayList<>();
        for (RaisedFundProject don : df)
        {
            Long id=don.getId();
            List<CharityFundContributors> donate = charityRepository.findByFundRaiserId(id);
            for (CharityFundContributors donTow : donate)
            {
                amount+=donTow.getAmountPaid();
                counter++;
            }
            array.add(amount);
            arraycount.add(counter);
            amount=0;
            counter=0;

        }
        m.addAttribute("amountArray",array);
        m.addAttribute("arraycount",arraycount);



        Iterable<RaisedWorkProject> allRaisedWork =raisedWorkProjectRepository.findAll() ;

        m.addAttribute("user2",allRaisedWork);
        Integer amount2 = 0;
        ArrayList<Integer> array2=new ArrayList<>();

        for (RaisedWorkProject singleRaisedWork : allRaisedWork)
        {
            Long id=singleRaisedWork.getId();
            List<CharityWorkContributors> contributors = charityWorkContributorsRepository.findByUserWorkRaiserId(id);
            for (CharityWorkContributors donTow : contributors)
            {
                amount+=donTow.getAvailableContAmount();
            }
            array2.add(amount2);
            amount2=0;
        }
        m.addAttribute("amountArray",array);
        return "index.html";
    }



    @GetMapping("/login")
    public String login() {

        return "login.html";
    }

    @PostMapping("/login")
    public RedirectView login(@RequestParam(value="username") String username, @RequestParam(value="password") String password, Model m, Principal p) {

        Users user = usersRepository.findByUsername(username);

        if (user == null) {
            return  new RedirectView("/login");
        }
        Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
        SecurityContextHolder.getContext()
                .setAuthentication(authentication);
        return  new RedirectView("/");
    }




    @GetMapping("/signup")
    public String signup() {

        return "signup.html";
    }



    @PostMapping("/signup")
    public RedirectView addNewUser(@RequestParam(value = "username") String username,
                                   @RequestParam(value = "email") String email,
                                   @RequestParam(value = "firstName") String firstName,
                                   @RequestParam(value = "lastName") String lastName,
                                   @RequestParam(value = "password") String password,
                                   @RequestParam(value = "middleName") String middleName,
                                   @RequestParam(value = "profilePictures") MultipartFile profilePictures,
                                   @RequestParam(value = "nationalNumber") String nationalNumber,
                                   @RequestParam(value = "nationalCardNumber") String nationalCardNumber,
                                   @RequestParam(value = "passportNumber") String passportNumber,
                                   @RequestParam(value = "nameWrittenInPassport") String nameWrittenInPassport) {



        List<String> images=new ArrayList();
        String fileName=uploadFileService.uploadFile(profilePictures);

        if (fileName!=null) {
            images.set(0,fileName);
        }else{

            images.set(0,"default.jpg");

        }

        Date date = new Date();
        Users user = new User(username,
                passwordEncoder.encode(password),
                firstName,
                middleName,
                lastName,
                nationalNumber,
                nationalCardNumber,
                passportNumber,
                nameWrittenInPassport,
                images,
                date,
                null, email);
        ApplicationUsers applicationUsers = new ApplicationUsers(user);
        usersRepository.save(user);
        return new RedirectView("/");
    }



    @GetMapping("/navbar")
    public String navbar() {

        return "navbar.html";
    }

    @GetMapping("/footer")
    public String footer() {

        return "footer.html";
    }


}
