package com.WeGather.WeGather.controllers;

import com.WeGather.WeGather.models.SystemConfiguration;
import com.WeGather.WeGather.repositories.SystemConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Set;

@Controller
public class SystemConfigurationController {

    @Autowired
    SystemConfigurationRepository systemConfigurationRepository;


    @GetMapping("/system_configuration")
    public String systemConfiguration() {

        return "SystemConfiguration.html";
    }

    @PostMapping("/system_configuration")
    public RedirectView getSystemConfiguration(
                           @RequestParam(value = "country") String country
                         , @RequestParam(value = "branch") String branch
                         , @RequestParam(value = "region") String region
                         , @RequestParam(value = "defaultCurrency") String defaultCurrency
                         , @RequestParam(value = "defaultTimeZone") String defaultTimeZone
                         , @RequestParam(value = "defaultLanguage") String defaultLanguage
                         , @RequestParam(value = "countryCode") Long countryCode
                         , @RequestParam(value = "googleMapKey") Long googleMapKey
                         , @RequestParam(value = "phoneMassageNumbersService") List<Long> phoneMassageNumbersService,
                           @RequestParam(value = "mailingServiceMainEmails") Set<String> mailingServiceMainEmails) {

        SystemConfiguration systemConfiguration = new SystemConfiguration( country,  branch,  region,  defaultCurrency,  defaultTimeZone,  defaultLanguage,  countryCode,  googleMapKey,  phoneMassageNumbersService, mailingServiceMainEmails);


        systemConfigurationRepository.save(systemConfiguration);
        return new RedirectView("/system_configuration");
    }

}
