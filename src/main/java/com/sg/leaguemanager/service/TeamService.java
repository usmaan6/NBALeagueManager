package com.sg.leaguemanager.service;

import com.sg.leaguemanager.dao.TeamDAO;
import com.sg.leaguemanager.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService implements TeamServiceInterface{
    @Autowired
    TeamDAO teamDao;

    //pass through method: call the dao
    @Override
    public List<Team> getAllTeams() {
        return teamDao.getAllTeams();
    }

    //set team name to team not found if null is returned
    @Override
    public Team getTeamById(int id) {
        Team team = teamDao.getTeam(id);

        //if team is null, return a new team with team name set to "team not found"
        if (team == null) {
            team = new Team();
            team.setTeamName("Team not found");
        }

        return team;
    }

    //when adding, make sure team doesn't already exist and team name is valid
    //assumes all validation checks have already been run. will just add
    @Override
    public Team addNewTeam(Team newTeam) {
        return teamDao.addTeam(newTeam);
    }

    //again assumes that all data already validated
    @Override
    public Team updateTeamData(Team editTeam) {
        //checks passed: update
        return teamDao.updateTeam(editTeam);
    }

    //make sure there are no references to team before deleting - will either return the deleted team or null
    @Override
    public Team deleteTeamById(int id) {
        //check no FK in coaches or players - if team doesn't exist, is ok
        Team team = teamDao.getTeam(id);
        if (team == null) {
            return new Team();
        }

        //foreign key issues: lists are not empty
        if (!team.getCoaches().isEmpty() || !team.getPlayers().isEmpty()) {
            return null;
        }

        //no foreign key issues - delete and return
        teamDao.deleteTeam(id);
        return team;
    }

    @Override
    public List<String> validateFields(Team team) {
        List<String> errors = new ArrayList<>();

        //see if team name exists - inefficient since getting all every time
        //would need to write a dao function "check name" with a sql query
        List<Team> allTeams = teamDao.getAllTeams();
        for (Team curTeam : allTeams) {
            if (curTeam.getTeamName().equalsIgnoreCase(team.getTeamName()) &&
                curTeam.getTeamId() != team.getTeamId()) {
                errors.add("Team name already exists");
            }
        }

        //check that team name is only letters or hyphen
        if (!team.getTeamName().matches("[a-zA-Z-]+")) {
            errors.add("Only letters and - allowed in team name");
        }

        //wins and losses sum to < 82, neither are negative
        if (team.getWins() < 0 || team.getLosses() < 0) {
            errors.add("Can not have negative values for wins or losses");
        }

        if (team.getWins() + team.getLosses() > 82) {
            errors.add("wins and losses total cannot exceed 82");
        }


        //return the errors that have been found
        return errors;
    }

    public boolean validBigDecimalString (String decVal) {
        //check if any non decimal characters
        if (decVal.matches("[^0-9.]]")) {
            return false;
        }

        //find position of decimal, should be < 4 after and no more than 20 total
        if (decVal.length() > 20 || decVal.length() - (decVal.indexOf('.') + 1) > 4) {
            return false;
        }

        //try converting to big decimal now
        try {
            BigDecimal dec = new BigDecimal(decVal);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
