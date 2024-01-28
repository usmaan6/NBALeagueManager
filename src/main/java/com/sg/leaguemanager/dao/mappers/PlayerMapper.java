package com.sg.leaguemanager.dao.mappers;

import com.sg.leaguemanager.model.Player;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerMapper implements RowMapper<Player> {
   @Override
    public Player mapRow(ResultSet rs, int rowNum) throws SQLException {

        Player player = new Player();
        player.setPid(rs.getInt("pid"));
        player.setfName(rs.getString("fName"));
        player.setlName(rs.getString("lName"));
        player.setPpg(rs.getDouble("ppg"));
        player.setRpg(rs.getDouble("rpg"));
        player.setApg(rs.getDouble("apg"));
        player.setPsalary(rs.getBigDecimal("psalary"));
        player.setTid(rs.getInt("tid"));


        return player;

    }

}
