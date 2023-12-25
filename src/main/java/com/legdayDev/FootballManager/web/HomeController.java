package com.legdayDev.FootballManager.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Slf4j
@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("data","Cristiano");
        return "/home";
    }
}
