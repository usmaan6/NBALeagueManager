package com.sg.leaguemanager.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class MyErrorController implements org.springframework.boot.web.servlet.error.ErrorController{
    @RequestMapping("error")
    public String handleError() {
        return "home";
    }
}
