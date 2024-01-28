package com.sg.leaguemanager.service;

import com.sg.leaguemanager.dao.PlayerDAO;
import com.sg.leaguemanager.model.Player;

import java.math.BigDecimal;
import java.util.List;

public class PlayerDaoStubImpl implements PlayerDAO {

    public Player onlyPlayer;

    public PlayerDaoStubImpl(){
        onlyPlayer = new Player();
        onlyPlayer.setPid(2);
        onlyPlayer.setfName("Kevin");
        onlyPlayer.setlName("Durant");
        onlyPlayer.setPpg(28.3);
        onlyPlayer.setRpg(6);
        onlyPlayer.setApg(5.1);
        onlyPlayer.setPsalary(new BigDecimal("378900245.0000"));
        onlyPlayer.setTid(2);
    }

    @Override
    public Player createNewPlayer(Player player) {
        if(player.getfName().toString() == "" ||
        player.getlName().toString() == "") {
            player.setfName("First Name blank, player NOT added");
            player.setlName("Last Name blank, player NOT added");
        }
        return player;
    }

    @Override
    public List<Player> getAllPlayer() {
        //Pass through method no tests
        return null;
    }

    @Override
    public Player findPlayertById(int pid) {
        if (onlyPlayer.getPid() != pid){
            onlyPlayer.setfName("Player not found");
            onlyPlayer.setlName("Player not found");
        }
        return onlyPlayer;
    }

    @Override
    public Player updatePlayer(Player player) {
        onlyPlayer.setfName(player.getfName());
        onlyPlayer.setlName(player.getlName());
        onlyPlayer.setPid(player.getPid());

        return player;
    }

    @Override
    public void deletePlayer(int pid) {
        //Pass through method no tests
    }

    @Override
    public void updatePlayerToTeam(int pid, int tid) {
        //Pass through method no tests
    }
}
