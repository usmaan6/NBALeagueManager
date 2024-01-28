package com.sg.leaguemanager.dao.mappers;

import com.sg.leaguemanager.model.Team;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TeamMapper implements RowMapper<Team> {
    @Override
    public Team mapRow(ResultSet rs, int index) throws SQLException {
        Team team = new Team();
        team.setTeamId(rs.getInt("tid"));
        team.setTeamName(rs.getString("tName"));
        team.setTeamState(rs.getString("state"));
        team.setWins(rs.getInt("wins"));
        team.setLosses(rs.getInt("losses"));
        team.setTeamPayroll(rs.getBigDecimal("payroll"));
        return team;
    }
}
