package com.sg.leaguemanager.dao.mappers;
import com.sg.leaguemanager.model.Coach;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class CoachMapper implements RowMapper<Coach> {
    @Override
    public Coach mapRow(ResultSet rs, int rowNum) throws SQLException {
        Coach coach = new Coach();
        coach.setCid(rs.getInt("cid"));
        coach.setCoachfname(rs.getString("coachfName"));
        coach.setCoachlname(rs.getString("coachlname"));
        coach.setCwins(rs.getInt("cwins"));
        coach.setClosses(rs.getInt("closses"));
        coach.setCsalary(rs.getBigDecimal("csalary"));
        coach.setTid(rs.getInt("tid"));

        return coach;
    }
}
