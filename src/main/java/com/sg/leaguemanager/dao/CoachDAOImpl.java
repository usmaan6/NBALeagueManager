package com.sg.leaguemanager.dao;

import com.sg.leaguemanager.dao.mappers.CoachMapper;
import com.sg.leaguemanager.model.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;
@Repository
public class CoachDAOImpl implements CoachDAO{

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public CoachDAOImpl(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    @Override
    public Coach createNewCoach(Coach coach) {
        String sql =  "INSERT INTO coach(coachfname, coachlname, csalary, cwins, closses, tid) VALUES (?, ?, ?, ?, ?, ?)";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update((Connection con) -> {
            PreparedStatement statement = con.prepareStatement(
                    sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, coach.getCoachfname());
            statement.setString(2, coach.getCoachlname());
            statement.setBigDecimal(3, coach.getCsalary());
            statement.setInt(4, coach.getCwins());
            statement.setInt(5, coach.getClosses());
           statement.setInt(6, coach.getTid());
            return statement;

        }, keyHolder);
        coach.setCid(keyHolder.getKey().intValue());
        //coach.setTid(keyHolder.getKey().intValue());
        return coach;
    }

    @Override
    public List<Coach> getAllCoach() {
        String sql = "SELECT * FROM coach";
        return jdbcTemplate.query(sql,new CoachMapper());
    }

    @Override
    public Coach findCoachById(int cid) {
        String sql = "SELECT * FROM coach WHERE cid = ?";
        try{
            return jdbcTemplate.queryForObject(sql, new Object[]{cid}, new CoachMapper());
        } catch (EmptyResultDataAccessException e ) {
            return null;
        }
    }

    @Override
    public void updateCoach(Coach coach) {
        if (coach == null) {
            throw new IllegalArgumentException("Coach cannot be null");
        }

        String sql = "UPDATE coach SET coachfname = ?, coachlname = ?, csalary = ?, cwins = ?, closses = ?, tid = ? WHERE cid = ?";

        jdbcTemplate.update(sql, coach.getCoachfname(), coach.getCoachlname(), coach.getCsalary(), coach.getCwins(), coach.getClosses(), coach.getTid(), coach.getCid());
    }

    @Override
    public Coach deleteCoach(int cid) {
        Coach delTeam = findCoachById(cid);
        String sql = "DELETE FROM coach WHERE cid = ?";
        jdbcTemplate.update(sql, cid);
        return delTeam;
    }


}
