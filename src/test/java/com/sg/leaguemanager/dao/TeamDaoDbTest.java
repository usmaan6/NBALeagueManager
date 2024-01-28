package com.sg.leaguemanager.dao;

import com.sg.leaguemanager.dao.TeamDAO;
import com.sg.leaguemanager.model.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TeamDaoDbTest {
    @Autowired
    TeamDAO teamDao;

    public TeamDaoDbTest () {}

    @Test
    public void testGetAll() {
        //when db is initialized, there should only be one team: celtics
        Team testTeam = new Team();
        testTeam.setTeamId(1);
        testTeam.setTeamName("celtics");
        testTeam.setTeamState("Massachusetts");
        testTeam.setWins(32);
        testTeam.setLosses(9);
        testTeam.setTeamPayroll(new BigDecimal("183480482.0000"));

        List<Team> fromDao = teamDao.getAllTeams();
        assertEquals(fromDao.get(0), testTeam);
        assertEquals(fromDao.size(), 1);
    }

    @Test
    public void testGetOne() {
        //when db is initialized, there should only be one team: celtics
        Team testTeam = new Team();
        testTeam.setTeamId(1);
        testTeam.setTeamName("celtics");
        testTeam.setTeamState("Massachusetts");
        testTeam.setWins(32);
        testTeam.setLosses(9);
        testTeam.setTeamPayroll(new BigDecimal("183480482.0000"));
        Team fromDao = teamDao.getTeam(1);
        assertEquals(testTeam, fromDao);
    }

    /*
    * @Test
    @DisplayName("Create new Teacher Test")
    public void createNewTeacherTest() {
        Teacher teacher = new Teacher();
        teacher.setTeacherFName("FirstName");
        teacher.setTeacherLName("LastName");
        teacherDao.createNewTeacher(teacher);
        List<Teacher> teachers = teacherDao.getAllTeachers();
        assertNotNull(teachers);
        assertEquals(11, teachers.size());
    }
    *
    * */

    @Test
    public void addTeamTest() {
        Team testTeam = new Team();
        testTeam.setTeamName("testing");
        testTeam.setTeamState("testeroo");
        testTeam.setWins(3);
        testTeam.setLosses(91);
        testTeam.setTeamPayroll(new BigDecimal("999.0000"));
        Team added = teamDao.addTeam(testTeam);
        Team fromDao = teamDao.getTeam(added.getTeamId());
        assertEquals(fromDao, added);
        assertEquals(2, fromDao.getTeamId());
    }

    @Test
    public void updateTest() {
        Team testTeam = teamDao.getTeam(1);
        testTeam.setLosses(100);
        assertEquals(1, testTeam.getTeamId());

        teamDao.updateTeam(testTeam);
        Team fromDao = teamDao.getAllTeams().get(0);
        assertEquals(testTeam, fromDao);
    }

    @Test
    public void deleteTest() {
        Team test = teamDao.getTeam(1);
        Team deleted = teamDao.deleteTeam(1);
        assertEquals(test, deleted);
    }
}