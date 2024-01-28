package com.sg.leaguemanager.dao;

import com.sg.leaguemanager.dao.mappers.CoachMapper;
import com.sg.leaguemanager.dao.mappers.PlayerMapper;
import com.sg.leaguemanager.dao.mappers.TeamMapper;
import com.sg.leaguemanager.model.Coach;
import com.sg.leaguemanager.model.Player;
import com.sg.leaguemanager.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class TeamDaoDB implements TeamDAO {
    //jdbc template object
    @Autowired
    JdbcTemplate jdbc;


    @Override
    public List<Team> getAllTeams() {
        //get the teams
        final String GET_ALL_TEAMS = "SELECT * FROM team";
        List<Team> teams = jdbc.query(GET_ALL_TEAMS, new TeamMapper());

        //add the coaches and players
        for (Team team : teams) {
            addCoachesToTeam(team);
            addPlayersToTeam(team);
        }

        //return completed list
        return teams;
    }

    //get team from the db, uses helper functions to get the players and coaches
    @Override
    public Team getTeam(int teamId) {
        try {
            final String GET_TEAM_BY_ID = "SELECT * FROM team WHERE tid = ?";
            Team team = jdbc.queryForObject(GET_TEAM_BY_ID, new TeamMapper(), teamId);

            //if team is null, it doesn't exist: return null
            if (team == null) {
                return null;
            }

            //not null: add the players and coaches to the team
            addCoachesToTeam(team);
            addPlayersToTeam(team);
            return team;
        } catch(DataAccessException ex) {
            return null;
        }
    }

    @Override
    public Team updateTeam(Team editTeam) {
        //update statement
        final String UPDATE_TEAM = "UPDATE team SET "
                + "tName = ?, "
                + "state = ?, "
                + "wins = ?, "
                + "losses = ?, "
                + "payroll = ? "
                + "WHERE tId = ?;";

        //jdbc template call
        jdbc.update(UPDATE_TEAM,
                editTeam.getTeamName(),
                editTeam.getTeamState(),
                editTeam.getWins(),
                editTeam.getLosses(),
                editTeam.getTeamPayroll(),
                editTeam.getTeamId());

        //return argument - may update later for error checking
        return editTeam;
    }

    @Override
    public Team addTeam(Team newTeam) {
        //query string, keyholder to grab the autoassigned id
        final String INSERT_TEAM = "INSERT INTO team(tName, state, wins, losses, payroll) VALUES(?, ?, ?, ?, ?)";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbc.update((Connection conn) -> {
            PreparedStatement statement = conn.prepareStatement(
                    INSERT_TEAM,
                    Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, newTeam.getTeamName());
            statement.setString(2, newTeam.getTeamState());
            statement.setInt(3, newTeam.getWins());
            statement.setInt(4, newTeam.getLosses());
            statement.setBigDecimal(5, newTeam.getTeamPayroll());
            return statement;

        }, keyHolder);

        //return the team with updated id
        newTeam.setTeamId(keyHolder.getKey().intValue());
        return newTeam;
    }

    @Override
    public Team deleteTeam(int teamId) {
        //query string, delete - returns the deleted team
        Team delTeam = getTeam(teamId);
        final String DELETE_TEAM = "DELETE FROM team WHERE tid = ?;";
        jdbc.update(DELETE_TEAM, teamId);
        return delTeam;
    }

    //helpers for adding player and coach information to the team object. designed to only work in
    //the get method - other classes should not be directly calling these
    private void addCoachesToTeam(Team team) {
        //query for coaches with an inner join
        final String COACHES_ON_TEAM = "SELECT * FROM coach "
                + "INNER JOIN team ON coach.tid = team.tid WHERE team.tid = ?";
        List<Coach> coaches = jdbc.query(COACHES_ON_TEAM,
                new CoachMapper(), team.getTeamId());

        //add to team
        team.addAllCoaches(coaches);
    }

    private void addPlayersToTeam(Team team) {
        //query for players with an inner join
        final String PLAYERS_ON_TEAM = "SELECT * FROM player "
                + "INNER JOIN team ON player.tid = team.tid WHERE team.tid = ?";
        List<Player> players = jdbc.query(PLAYERS_ON_TEAM,
                new PlayerMapper(), team.getTeamId());

        //add to team
        team.addAllPlayers(players);
    }
}
