package com.sg.leaguemanager.dao;

import com.sg.leaguemanager.model.Player;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PlayerDAOImplTest {
    @Autowired
    PlayerDAO playerDAO;

    public PlayerDAOImplTest(){}

    @Test
    void createNewPlayer() {

        // each time you run this case a new player will be added to the database thus the playerID will be changed

        Player player = new Player();
        player.setPid(2);
        player.setfName("Kevin");
        player.setlName("Durant");
        player.setPpg(28.3);
        player.setRpg(6);
        player.setApg(5.1F);
        player.setPsalary(new BigDecimal("378900245.0000"));
        player.setTid(2);

        Player dao = playerDAO.createNewPlayer(player);

        assertEquals("Durant", dao.getlName());

        playerDAO.deletePlayer(player.getPid());

    }


    @Test
    void getAllPlayer() {
        Player player = new Player();
        player.setPid(1);
        player.setfName("LeBron");
        player.setlName("James");
        player.setPpg(24.8);
        player.setRpg(8);
        player.setApg(4.3);
        player.setPsalary(new BigDecimal("123456789.0000"));
        player.setTid(2);

       List<Player> dao = playerDAO.getAllPlayer();

        assertEquals(dao.get(0), player);

        // can change depending on how many times you have run the createNewPlayer() function.
        assertEquals(6, dao.size());

    }

    @Test
    void findPlayertById() {
        Player player = new Player();
        player.setPid(1);
        player.setfName("LeBron");
        player.setlName("James");
        player.setPpg(22.3);
        player.setRpg(8);
        player.setApg(4.3F);
        player.setPsalary(new BigDecimal("123456789.0000"));
        player.setTid(2);

        Player dao = playerDAO.findPlayertById(1);
        assertEquals("James", dao.getlName());
    }

    @Test
    void updatePlayer() {
        Player player = new Player();
        player.setPid(1);
        player.setfName("LeBron");
        player.setlName("James");
        player.setPpg(24.8);
        player.setRpg(8);
        player.setApg(4.3F);
        player.setPsalary(new BigDecimal("123456789.0000"));
        player.setTid(2);

        Player dao = playerDAO.updatePlayer(player);
        assertEquals(24.8,dao.getPpg());
    }

    @Test
    void deletePlayer() {
         playerDAO.deletePlayer(4);

        assertEquals(null, playerDAO.findPlayertById(4));

    }

    @Test
    void updatePlayerToTeam() {


        playerDAO.updatePlayerToTeam(3,1);

        assertEquals(3,playerDAO.findPlayertById(1).getTid());

    }
}