package com.sg.leaguemanager.dao;

import com.sg.leaguemanager.model.Player;

import java.util.List;

public interface PlayerDAO {
    Player createNewPlayer(Player player);

    List<Player> getAllPlayer();

    Player findPlayertById(int pid);

    Player updatePlayer(Player player);

    void deletePlayer(int pid);

    void updatePlayerToTeam(int pid, int tid);

}
