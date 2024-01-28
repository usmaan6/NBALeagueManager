package com.sg.leaguemanager.controller;

import com.sg.leaguemanager.dao.PlayerDAO;
import com.sg.leaguemanager.dao.TeamDAO;
import com.sg.leaguemanager.model.Player;
import com.sg.leaguemanager.model.Team;
import com.sg.leaguemanager.service.PlayerService;
import com.sg.leaguemanager.service.PlayerServiceInterface;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;
import java.util.List;
@Controller
public class PlayerController {
    @Autowired
    PlayerServiceInterface playerServ;

    @Autowired
    PlayerService playerService;

    @Autowired
    PlayerDAO playerDAO;

    @Autowired
    TeamDAO teamDAO;

    @GetMapping("players")
    public String displayPlayers(Model model){
        List<Player> players = playerServ.getAllPlayer();
        model.addAttribute("players",players);
        return "player";
    }

    @PostMapping("addPlayer")
    public String addPlayer(HttpServletRequest request){
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String ppg = request.getParameter("ppg");
        String apg = request.getParameter("apg");
        String rpg = request.getParameter("rpg");
        String contract = request.getParameter("contract");
        String tid = request.getParameter("tid");

        Player player = new Player();
        player.setfName(firstName);
        player.setlName(lastName);
        player.setPpg(Double.parseDouble(ppg));
        player.setApg(Double.parseDouble(apg));
        player.setRpg(Double.parseDouble(rpg));
        player.setPsalary(new BigDecimal(contract));
        player.setTid(Integer.parseInt(tid));

        playerService.createNewPlayer(player);

        return "redirect:/players";


    }

    @GetMapping("deletePlayer")
    public String deletePlayer(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        playerService.deletePlayer(id);

        return "redirect:/players";
    }



    @GetMapping("editPlayer")
    public String editPlayer(HttpServletRequest request, Model model) {



        int id = Integer.parseInt(request.getParameter("id"));
        Player player = playerService.findPlayertById(id);
        model.addAttribute("player", player);

        return "editPlayer";
    }

    @PostMapping("editPlayer")
    public String performEditStudent(HttpServletRequest request) {

        int pid = Integer.parseInt(request.getParameter("id"));
        Player player = playerService.findPlayertById(pid);

        player.setfName(request.getParameter("firstName"));
        player.setlName(request.getParameter("lastName"));
        player.setPpg(Double.parseDouble(request.getParameter("ppg")));
        player.setApg(Double.parseDouble(request.getParameter("apg")));
        player.setRpg(Double.parseDouble(request.getParameter("rpg")));
        player.setPsalary(new BigDecimal(request.getParameter("contract")));
        player.setTid(Integer.parseInt(request.getParameter("teamID")));


        playerService.updatePlayer(player, pid);

        return "redirect:/players";
    }


}
