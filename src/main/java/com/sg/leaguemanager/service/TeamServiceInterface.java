package com.sg.leaguemanager.service;

import com.sg.leaguemanager.model.Team;

import java.util.List;

public interface TeamServiceInterface {

    //get all teams
    public List<Team> getAllTeams();

    //get single team: team name will be team not found if not found
    public Team getTeamById(int id);

    //return added team on completion
    public Team addNewTeam(Team newTeam);

    //checks if ids are equal, if not, returns a null
    public Team updateTeamData(Team editTeam);

    //team name will be modified based on the error found
    public Team deleteTeamById(int id);

    //the following two functions are expected to be called by the user
    //to sanitize data before attempting to persist it
    //checks all the fields, returns a list of error strings
    public List<String> validateFields(Team team);

    //check if the string used for big decimal is correct
    public boolean validBigDecimalString (String decVal);
}
