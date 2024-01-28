package com.sg.leaguemanager.dao;

import com.sg.leaguemanager.model.Coach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CoachDAOImplTest {
    @Autowired
    CoachDAO coachDao;

    public void CoachDaoDbTest () {}

    @Test
    public void testGetAllCoaches() {
        Coach testCoach = new Coach();
        testCoach.setCid(1);
        testCoach.setCoachfname("jerry");
        testCoach.setCoachlname("john");
        testCoach.setCsalary(new BigDecimal("4000004.0000"));
        testCoach.setCwins(32);
        testCoach.setClosses(9);
        testCoach.setTid(1);


        List<Coach> fromDao = coachDao.getAllCoach();
        assertEquals(fromDao.get(0), testCoach);
        assertEquals(fromDao.size(), 1);
    }

    @Test
    public void testGetOneCoach() {
        Coach testCoach = new Coach();
        testCoach.setCid(1);
        testCoach.setCoachfname("jerry");
        testCoach.setCoachlname("john");
        testCoach.setCsalary(new BigDecimal("4000004.0000"));
        testCoach.setCwins(32);
        testCoach.setClosses(9);
        testCoach.setTid(1);


        Coach fromDao = coachDao.findCoachById(1);
        assertEquals(testCoach, fromDao);
    }

    @Test
    public void addCoachTest() {
        Coach testCoach = new Coach();
        testCoach.setCoachfname("testing");
        testCoach.setCoachlname("testeroo");
        testCoach.setCwins(3);
        testCoach.setClosses(91);
        testCoach.setCsalary(new BigDecimal("999.0000"));
        testCoach.setTid(1);
        Coach added = coachDao.createNewCoach(testCoach);
        Coach fromDao = coachDao.findCoachById(added.getCid());
        assertEquals(fromDao, added);
        //get all and check against length
        assertEquals(2, fromDao.getCid());
    }

    @Test
    public void updateCoachTest() {
        Coach testCoach = coachDao.findCoachById(1);
        testCoach.setClosses(100);
        assertEquals(1, testCoach.getCid());

        coachDao.updateCoach(testCoach);
        Coach fromDao = coachDao.getAllCoach().get(0);
        assertEquals(testCoach, fromDao);
    }

    @Test
    public void deleteCoachTest() {
        Coach test = coachDao.findCoachById(1);
        Coach deleted = coachDao.deleteCoach(1);
        assertEquals(test, deleted);
    }
}
