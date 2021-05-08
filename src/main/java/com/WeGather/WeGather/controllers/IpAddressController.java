package com.WeGather.WeGather.controllers;

import com.WeGather.WeGather.models.UserConfiguration;
import com.WeGather.WeGather.models.Users;
import com.WeGather.WeGather.models.UsersIpAddresses;
import com.WeGather.WeGather.repositories.UsersIpAddressesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.List;

@Controller
public class IpAddressController {

    @Autowired
    UsersIpAddressesRepository  UsersIpAddressesRepository;

    @GetMapping("/IpAddress")
    public String getIpAddressesPage(){
        return "ipAddresses.html";
    }

    @PostMapping("/IpAddress")
    public RedirectView getIpAddress(
            @RequestParam(value = "IpAddress") List<String> IpAddress
            , Principal p){
        Users user = (Users) ((UsernamePasswordAuthenticationToken) p).getPrincipal();
        UsersIpAddresses usersIpAddresses = new UsersIpAddresses(IpAddress,user);
        UsersIpAddressesRepository.save(usersIpAddresses);
        return new RedirectView("/IpAddress");

    }


}
