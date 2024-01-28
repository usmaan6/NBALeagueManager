package com.sg.leaguemanager.service;

import com.sg.leaguemanager.model.Player;

import java.util.List;

public interface PlayerServiceInterface {

    Player createNewPlayer(Player player);

    List<Player> getAllPlayer();

    Player findPlayertById(int pid);

    Player updatePlayer(Player player, int pid);

    void deletePlayer(int pid);

    void updatePlayerToTeam(int pid, int tid);
}
