
package com.WeGather.WeGather.controllers;

import com.WeGather.WeGather.models.*;

import com.WeGather.WeGather.repositories.*;

import com.WeGather.WeGather.services.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.*;

@Controller
public class RaisedWorkProjectController<T> {

    @Autowired
    UsersRepository usersRepository;
    @Autowired
    RaisedWorkProjectRepository raisedWorkProjectRepository;
    @Autowired
    CharityWorkContributorsRepository charityWorkContributorsRepository;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    CommentsRepository commentsRepository;


    @Autowired
    UploadFileService uploadFileService;
    @GetMapping(value = "/AddWork")
    public String getRaisedWork() {
        return "AddRaisedWorkProject.html";
    }
//
    @PostMapping(value = "/AddWork")
    public RedirectView addRaisedWork(@RequestParam(value = "startFrom") String startFrom,
                                      @RequestParam(value = "endAt") String endAt,
                                      @RequestParam(value = "image") MultipartFile image,
                                      @RequestParam(value = "topic") String topic,
                                      @RequestParam(value = "requiredContAmount") Integer requiredContAmount,
                                      @RequestParam(value = "description") String description,

                                      @RequestParam(value = "longitude") String longitude,
                                      @RequestParam(value = "latitude") String latitude,
                                      @RequestParam(value = "locationDescription") String locationDescription
//                                      @RequestParam(value = "governorate_id") Long governorate_id,
//                                      @RequestParam(value = "district_id") Long district_id,
//                                      @RequestParam(value = "suburb_id") Long suburb_id
            , Principal p) {


//        LocalDateTime now = LocalDateTime.now();
//        DateTimeFormatter createdAt = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
//        //Date createAt = now.format(format);


        List<String> images=new ArrayList();
        String fileName=uploadFileService.uploadFile(image);

        if (fileName!=null) {
            images.add(fileName);
        }else{
            images.add("default.jpg");
        }

        Location location = new Location(longitude, latitude, locationDescription);

        String loggedInUserName = p.getName();
        locationRepository.save(location);

        Users loggedInUser = usersRepository.findByUsername(loggedInUserName);


        RaisedWorkProject raisedWorkProject = new RaisedWorkProject(startFrom, endAt, images, topic, requiredContAmount, description, location, loggedInUser);

        raisedWorkProjectRepository.save(raisedWorkProject);

        return new RedirectView("/viewRaisedWork");

    }


    @GetMapping(value = "/viewRaisedWork")
    public String getAllRaisedWork(Principal p, Model m) {

        Iterable<RaisedWorkProject> allRaisedWork =raisedWorkProjectRepository.findAll() ;

        m.addAttribute("user",allRaisedWork);
        Integer amount = 0;
        ArrayList<Integer> array=new ArrayList<>();
 array.add(0);
        for (RaisedWorkProject singleRaisedWork : allRaisedWork)
        {
            Long id=singleRaisedWork.getId();
            List<CharityWorkContributors> contributors = charityWorkContributorsRepository.findByUserWorkRaiserId(id);
            for (CharityWorkContributors donTow : contributors)
                {
                    amount+=donTow.getAvailableContAmount();
                }
            array.add(amount);
            amount=0;
        }
            System.out.println("This is the array:"+array);
        m.addAttribute("amountArray",array);
        return "ViewRaisedWork.html";

    }


    @GetMapping(value = "/viewRaisedWork/{id}")
    public String displayRaisedWork(@PathVariable Long id, Model m, Principal p) {
        Object principal = SecurityContextHolder.getContext(). getAuthentication(). getPrincipal();
        RaisedWorkProject raisedWorkProject = raisedWorkProjectRepository.findById(id)
                                                                         .get();
        m.addAttribute("raisedWorkProject", raisedWorkProject);
        m.addAttribute("isAllow",true);
        if(principal instanceof UserDetails) {
            String loggedInUserName = p.getName();
            Users loggedInUser = usersRepository.findByUsername(loggedInUserName);
            m.addAttribute("userId", loggedInUser.getId());
            //-------------------
            List<Integer> contributorsIds = charityWorkContributorsRepository.findContributorsIds(id);
//            System.out.println("contributorsIds: "+ contributorsIds);
            Integer loggedInIntegerUserId = Math.toIntExact(loggedInUser.getId());
            boolean showingButtonCond =  contributorsIds.contains(loggedInIntegerUserId);
//            System.out.println("Condition: "+showingButtonCond);
            if (showingButtonCond){
//                System.out.println("Inside is contains");
                m.addAttribute("isAllow",false);
            }else {
//                System.out.println("Inside is NOT contains");
                m.addAttribute("isAllow",true);
            }
            System.out.println("loggedIn userId: "+ loggedInUser.getId());
        }


        List<Comments> allComments =  commentsRepository.findComment(id,1L);

        List<CharityWorkContributors> contributes = charityWorkContributorsRepository.findByWorkRaiserId(id);


//contributes.containsAll();
//        System.out.println(contributes.contains());
        m.addAttribute("AllComment",allComments);

        m.addAttribute("contributes" ,contributes);
        return "ViewRaisedWorkDetail.html";
    }

//    @GetMapping("/displayCards")
//    public String  displayPost(Principal p,Model m){
//        Iterable<RaisedFundProject> df =rasisdFundProjectRepositorise.findAll() ;
//        m.addAttribute("user",df);
//        Integer amount = 0;
//        ArrayList<Integer> array=new ArrayList<>();
//        for (RaisedFundProject don : df)
//        {
//            Long id=don.getId();
//            List<CharityFundContributors> donate = charityRepository.findByUserFundRaiserId(id);
//            for (CharityFundContributors donTow : donate)
//            {
//                amount+=donTow.getAmountPaid();
//            }
//            array.add(amount);
//            amount=0;
//        }
//        m.addAttribute("amountArray",array);
//        return "ViewRaisedFund.html";
//    }

    @PostMapping(value = "/addContributors")
    public RedirectView addContribute(@RequestParam(value = "workedRaised_id") Long workedRaised_id,
                                      @RequestParam(value = "userWorkRaiser_id") Long userWorkRaiser_id,
                                      @RequestParam(value = "status") Integer status,Principal p ) {

        ApplicationUsers userDetails = (ApplicationUsers) ((UsernamePasswordAuthenticationToken) p).getPrincipal();
        String contributorName = userDetails.getUser().getFirstName() + " " +userDetails.getUser().getLastName();
        CharityWorkContributors charityWorkContributors = new CharityWorkContributors(workedRaised_id, userWorkRaiser_id, 1, status,contributorName);
        charityWorkContributorsRepository.save(charityWorkContributors);

        return new RedirectView("/viewRaisedWork/"+workedRaised_id);
    }


}
