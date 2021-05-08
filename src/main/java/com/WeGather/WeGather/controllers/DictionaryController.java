package com.WeGather.WeGather.controllers;

import com.WeGather.WeGather.repositories.DictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DictionaryController {
    @Autowired
    DictionaryRepository dictionaryRepository;


}
