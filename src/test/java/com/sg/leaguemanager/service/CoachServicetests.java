package com.sg.leaguemanager.service;

import com.sg.leaguemanager.dao.CoachDAO;
import com.sg.leaguemanager.model.Coach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CoachServicetests {
    private CoachService coachService;

    public CoachServicetests(){
        CoachDAO coachDAO = new CoachDaoStubImpl();
        coachService = new CoachService(coachDAO);
    }

    @Test
    @DisplayName("Find Coach Service test")
    public void findCoachServiceTest() {
        Coach returnCoach = coachService.getCoachById(2);
        assertNotNull(returnCoach);
        assertEquals("Jerry", returnCoach.getCoachfname());
    }

    @Test
    @DisplayName("Update Coach Service Test")
    public void updateCoachServiceTest() {
        Coach coach = new Coach();
        coach.setCid(121);
        coach.setCoachfname("Updated Coach Name");
        coach.setCoachlname("Updated Coach Name");
        coach.setTid(1);

        Coach upCoach = coachService.updateCoachData(121, coach);
        upCoach = coachService.getCoachById(121);
        assertNotNull(upCoach);
        assertEquals(121, upCoach.getCid());
        assertEquals("Updated Coach Name", upCoach.getCoachfname());
        assertEquals("Updated Coach Name", upCoach.getCoachlname());
        assertEquals(1, upCoach.getTid());
    }

    @Test
    @DisplayName("Coach Not Updated Service Test")
    public void coachNotUpdatedServiceTest() {
        Coach coach = new Coach();
        coach.setCid(121);
        coach.setCoachfname("Updated Coach Name");
        coach.setCoachlname("Updated Coach Name");
        coach.setTid(1);

        Coach upCoach = coachService.updateCoachData(99, coach);
        assertEquals("IDs do not match, coach not updated", coach.getCoachfname());
        assertEquals("IDs do not match, coach not updated", coach.getCoachlname());
    }

    @Test
    @DisplayName("Coach Add Service Test")
    public void coachAddServiceTest() {
        Coach coach = new Coach();
        coach.setCoachfname("New Coach Name");
        coach.setCoachlname("New Coach Name");
        Coach newCoach = coachService.addNewCoach(coach);
        assertNotNull(newCoach);
        assertEquals("New Coach Name", newCoach.getCoachfname());
        assertEquals("New Coach Name", newCoach.getCoachlname());
    }

    @Test
    @DisplayName("Coach No Add Service Test")
    public void coachNoAddServiceTest() {
        Coach coach = new Coach();
        coach.setCoachfname("");
        coach.setCoachlname("");
        Coach newCoach = coachService.addNewCoach(coach);
        assertEquals("First Name blank, coach NOT added", coach.getCoachfname());
        assertEquals("Last Name blank, coach NOT added", coach.getCoachlname());
    }
}
