package com.sg.leaguemanager.controller;

import com.sg.leaguemanager.model.Team;
import com.sg.leaguemanager.service.TeamServiceInterface;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TeamController {
    @Autowired
    TeamServiceInterface teamServ;

    //the return value is the page that's shown
    @GetMapping("teams")
    public String displayTeams(Model model) {
        List<Team> teams = teamServ.getAllTeams();
        model.addAttribute("teams", teams);
        return "teams";
    }

    @GetMapping("teamDetail")
    public String teamDetail(Integer id, Model model) {
        Team team = teamServ.getTeamById(id);
        model.addAttribute("team", team);
        return "teamDetail";
    }

    @GetMapping("deleteTeam")
    public String deleteTeam(Integer id, Model model) {
        Team team = teamServ.deleteTeamById(id);

        //if unable to delete (foreign keys exist)
        if (team == null) {
            //add delete failed to model: this is not ideal but it'll get the job done
            model.addAttribute("deleteSuccess", false);

            //assuming the id is correct, get the team and pass it over
            Team oldTeam = teamServ.getTeamById(id);
            model.addAttribute("team", oldTeam);
            return "teamDetail";
        }

        //delete successful - go back to teams
        else {
            return "redirect:/teams";
        }
    }

    @GetMapping("addTeam")
    public String addTeamForm() {
        return "addTeam";
    }

    @PostMapping("addTeam")
    public String addTeam(Team team, HttpServletRequest request, Model model) {
        List<String> errors = new ArrayList<>();

        //big decimal string is looked at separately: check if valid
        String decString = request.getParameter("teamPayrollStr");
        if (teamServ.validBigDecimalString(decString)) {
            team.setTeamPayroll(new BigDecimal(decString));
        }
        else {
            errors.add("invalid big decimal input");
        }

        //validate the rest of the fields
        errors.addAll(teamServ.validateFields(team));

        //if there are no errors, add successful
        if (errors.isEmpty()) {
            teamServ.addNewTeam(team);
            return "redirect:/teams";
        }

        //if errors, unsuccessful - go back to add
        //currently it just wipes everything out which is not ideal
        else {
            model.addAttribute("errors", errors);
            return "addTeam";
        }
    }

    @GetMapping("editTeam")
    public String editTeamForm(Integer id, Model model) {
        //add the team matching id to the model, display the page
        model.addAttribute("team", teamServ.getTeamById(id));
        return "editTeam";
    }

    @PostMapping("editTeam")
    public String editTeam(Team team, HttpServletRequest request, Model model) {
        List<String> errors = new ArrayList<>();

        //big decimal string is looked at separately: check if valid
        String decString = request.getParameter("teamPayrollStr");
        if (teamServ.validBigDecimalString(decString)) {
            team.setTeamPayroll(new BigDecimal(decString));
        }
        else {
            errors.add("invalid big decimal input");
        }

        //validate the rest of the fields
        errors.addAll(teamServ.validateFields(team));

        //if no errors, update data
        if (errors.isEmpty()) {
            teamServ.updateTeamData(team);
            return "redirect:/teams";
        }

        //if errors, unsuccessful - go back to edit
        else {
            model.addAttribute("team", team);
            model.addAttribute("errors", errors);
            return "editTeam";
        }
    }

}