package com.sg.leaguemanager.dao;

import com.sg.leaguemanager.dao.mappers.PlayerMapper;
import com.sg.leaguemanager.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.tree.RowMapper;
import java.sql.*;
import java.util.List;
@Repository
public class PlayerDAOImpl implements PlayerDAO{


    @Autowired
    JdbcTemplate jdbcTemplate;

    public PlayerDAOImpl(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}



    @Override
    @Transactional
    public Player createNewPlayer(Player player) {

        String sql =  "INSERT INTO player(fName, lName, ppg, rpg, apg, psalary, tid) VALUES (?, ?, ?, ?, ?, ?, ?)";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update((Connection con) -> {
            PreparedStatement statement = con.prepareStatement(
                    sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, player.getfName());
            statement.setString(2, player.getlName());
            statement.setDouble(3, player.getPpg());
            statement.setDouble(4, player.getRpg());
            statement.setDouble(5, player.getApg());
            statement.setBigDecimal(6, player.getPsalary());
            statement.setInt(7,player.getTid());
            return statement;

        }, keyHolder);
        player.setPid(keyHolder.getKey().intValue());
        player.setTid(keyHolder.getKey().intValue());
        return player;
    }

    @Override
    public List<Player> getAllPlayer() {

        String sql = "SELECT * FROM player";
        return jdbcTemplate.query(sql,new PlayerMapper());
    }

    @Override
    public Player findPlayertById(int pid) {
        String sql = "SELECT * FROM player WHERE pid = ?";
        try{
            return jdbcTemplate.queryForObject(sql, new Object[]{pid}, new PlayerMapper());
        } catch (EmptyResultDataAccessException e ) {
            return null;
        }
    }

    @Override
    public Player updatePlayer(Player player) {

        if (player == null) {
            throw new IllegalArgumentException("Player cannot be null");
        }

        String sql = "UPDATE player SET fName = ?, lName = ?, ppg = ?, rpg = ?, apg = ?, psalary = ?, tid = ? WHERE pid = ?";

        jdbcTemplate.update(sql, player.getfName(), player.getlName(), player.getPpg(), player.getRpg(), player.getApg(), player.getPsalary(), player.getTid(), player.getPid());

        return player;
    }

    @Override
    public void deletePlayer(int pid) {
        String sql = "DELETE FROM player WHERE pid = ?";
        jdbcTemplate.update(sql, pid);

    }

    @Override
    public void updatePlayerToTeam(int tid, int pid) {
        String sql = "UPDATE player SET tid = ? WHERE pid = ?";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(sql,tid, pid);


    }





}
