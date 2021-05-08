package com.WeGather.WeGather.controllers;
import com.WeGather.WeGather.repositories.SuburbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SuburbController {

    @Autowired
    SuburbRepository suburbRepository;


}
