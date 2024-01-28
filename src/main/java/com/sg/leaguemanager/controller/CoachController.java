package com.sg.leaguemanager.controller;

import com.sg.leaguemanager.model.Coach;
import com.sg.leaguemanager.model.Team;
import com.sg.leaguemanager.service.CoachService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
@Controller
@CrossOrigin
public class CoachController {
    @Autowired
    CoachService coachServiceImpl;

    @GetMapping("coaches")
    public String displayAllCoaches(Model model) {
        List<Coach> coaches = coachServiceImpl.getAllCoaches();
        model.addAttribute("coaches", coaches);
        return "coaches";
    }

    @PostMapping("addCoach")
    public String addCoach(HttpServletRequest request) {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String salary = request.getParameter("salary");
        String wins = request.getParameter("wins");
        String losses = request.getParameter("losses");
        String teamId = request.getParameter("teamID");

        Coach coach = new Coach();
        coach.setCoachfname(firstName);
        coach.setCoachlname(lastName);
        coach.setCsalary(new BigDecimal(salary));
        coach.setCwins(Integer.parseInt(wins));
        coach.setClosses(Integer.parseInt(losses));
        coach.setTid(Integer.parseInt(teamId));

        coachServiceImpl.addNewCoach(coach);

        return "redirect:/coaches";
    }

    @GetMapping("deleteCoach")
    public String deleteCoach(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        coachServiceImpl.deleteCoachById(id);

        return "redirect:/coaches";
    }

    @GetMapping("editCoach")
    public String editCoach(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        Coach coach = coachServiceImpl.getCoachById(id);

        model.addAttribute("coach", coach);
        return "editCoach";
    }

    @PostMapping("editCoach")
    public String performEditCoach(HttpServletRequest request) {
        int cid = Integer.parseInt(request.getParameter("id"));
        Coach coach = coachServiceImpl.getCoachById(cid);

        coach.setCoachfname(request.getParameter("firstName"));
        coach.setCoachlname(request.getParameter("lastName"));
        coach.setCsalary(new BigDecimal(request.getParameter("salary")));
        coach.setCwins(Integer.parseInt(request.getParameter("wins")));
        coach.setClosses(Integer.parseInt(request.getParameter("losses")));
        coach.setTid(Integer.parseInt(request.getParameter("teamID")));

        coachServiceImpl.updateCoachData(cid, coach);

        return "redirect:/coaches";
    }

}
