package com.sg.leaguemanager.service;

import com.sg.leaguemanager.dao.PlayerDAO;
import com.sg.leaguemanager.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlayerService implements PlayerServiceInterface{

   @Autowired
   PlayerDAO  PlayerDao;

   public PlayerService(PlayerDAO PlayerDao){
       this.PlayerDao = PlayerDao;
   }


    @Override
    public Player createNewPlayer(Player player) {


        if (player.getfName().isBlank()){
            player.setfName("First name blank, player NOT added");
        }
        if (player.getlName().isBlank()){
            player.setlName("Last name blank, player NOT added");
        }

        return PlayerDao.createNewPlayer(player);


    }

    @Override
    public List<Player> getAllPlayer() {
        return PlayerDao.getAllPlayer();
    }

    @Override
    public Player findPlayertById(int pid) {

        try {
            return PlayerDao.findPlayertById(pid);
        } catch (DataAccessException e) {
            Player notFoundPlayer = new Player();
            notFoundPlayer.setfName("Player not found");
            notFoundPlayer.setlName("Player not found");
            return notFoundPlayer;
        }


    }

    @Override
    public Player updatePlayer(Player player, int pid) {
        if (pid != player.getPid()){
            player.setfName("Player ID does not match");
            player.setlName("Player ID does not match");
            return player;
        }

        PlayerDao.updatePlayer(player);
        return player;
    }

    @Override
    public void deletePlayer(int pid) {

        PlayerDao.deletePlayer(pid);

    }

    @Override
    public void updatePlayerToTeam(int pid, int tid) {

        PlayerDao.updatePlayerToTeam(pid,tid);

    }
}
