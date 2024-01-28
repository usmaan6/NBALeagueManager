package com.sg.leaguemanager.dao;

import com.sg.leaguemanager.model.Team;

import java.util.List;

public interface TeamDAO {
    List<Team> getAllTeams();
    Team getTeam(int teamId);
    Team updateTeam(Team editTeam);
    Team addTeam(Team newTeam);
    Team deleteTeam(int teamId);
}
