package com.sg.leaguemanager.service;

import com.sg.leaguemanager.dao.PlayerDAO;
import com.sg.leaguemanager.dao.PlayerDAOImpl;
import com.sg.leaguemanager.model.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PlayerServiceTest {

    PlayerService playerService;
    public PlayerServiceTest(){
        PlayerDAO playerDAO = new PlayerDaoStubImpl();
        playerService = new PlayerService(playerDAO);
    }

    @Test
    void createNewPlayer() {
        Player player = new Player();
        player.setPid(2);
        player.setfName("Kevin");
        player.setlName("Durant");
        player.setPpg(28.3);
        player.setRpg(6);
        player.setApg(5.1F);
        player.setPsalary(new BigDecimal("378900245.0000"));
        player.setTid(2);

        Player dao = playerService.createNewPlayer(player);

        assertEquals("Kevin", dao.getfName());
        assertEquals("Durant", dao.getlName());


    }


    @Test
    @DisplayName("Find Player Service Test")
    void findPlayertById() {
        Player returnPlayer = playerService.findPlayertById(2);
        assertNotNull(returnPlayer);
        assertEquals("Kevin", returnPlayer.getfName());
        assertEquals("Durant", returnPlayer.getlName());
    }

    @Test
    @DisplayName("Player Not Found Service Test")
    void findPlayertByWrongId() {
        Player returnPlayer = playerService.findPlayertById(99999);
        assertNotNull(returnPlayer);
        assertEquals("Player not found", returnPlayer.getfName());
        assertEquals("Player not found", returnPlayer.getlName());
    }

    @Test
    @DisplayName("Update Player Service Test")
    void updatePlayer() {
        Player player = new Player();
        player.setPid(1);
        player.setfName("LeBron");
        player.setlName("James Jr");
        player.setPpg(24.8);
        player.setRpg(8);
        player.setApg(4.3F);
        player.setPsalary(new BigDecimal("123456789.0000"));
        player.setTid(2);

        Player upPlayer = playerService.updatePlayer(player, player.getPid());
        assertEquals("James Jr",upPlayer.getlName());

    }

    @Test
    @DisplayName("No Update Player Service Test (PID does not match)")
    void noUpdatePlayer() {
        Player player = new Player();
        player.setPid(100);
        player.setfName("LeBron");
        player.setlName("James Jr");
        player.setPpg(24.8);
        player.setRpg(8);
        player.setApg(4.3F);
        player.setPsalary(new BigDecimal("123456789.0000"));
        player.setTid(2);

        Player upPlayer = playerService.updatePlayer(player, 99);
        assertEquals("Player ID does not match",upPlayer.getfName());
        assertEquals("Player ID does not match",upPlayer.getlName());

    }
}