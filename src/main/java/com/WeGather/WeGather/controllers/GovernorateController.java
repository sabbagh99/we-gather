package com.WeGather.WeGather.controllers;
import com.WeGather.WeGather.repositories.GovernorateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class GovernorateController {

    @Autowired
    GovernorateRepository governorateRepository;
}
