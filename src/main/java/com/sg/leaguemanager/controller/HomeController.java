package com.sg.leaguemanager.controller;

import com.sg.leaguemanager.model.Coach;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@CrossOrigin
public class HomeController {
    @GetMapping("home")
    public String returnhome() {
        return "home";
    }
}
