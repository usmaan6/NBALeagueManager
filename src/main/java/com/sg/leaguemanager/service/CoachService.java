package com.sg.leaguemanager.service;

import com.sg.leaguemanager.dao.CoachDAO;
import com.sg.leaguemanager.model.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachService implements CoachServiceInterface{

    @Autowired
    CoachDAO coachDao;

    public CoachService(CoachDAO coachDao) {
        this.coachDao = coachDao;
    }
    @Override
    public List<Coach> getAllCoaches() {
        return coachDao.getAllCoach();
    }

    @Override
    public Coach getCoachById(int cid) {
        return coachDao.findCoachById(cid);
    }

    @Override
    public Coach addNewCoach(Coach coach) {
        if(coach.getCoachfname().isBlank()){
            coach.setCoachfname("First Name blank, coach NOT added");
        }
        if(coach.getCoachlname().isBlank()){
            coach.setCoachlname("Last Name blank, coach NOT added");
        }
        return coachDao.createNewCoach(coach);
    }

    @Override
    public Coach updateCoachData(int cid, Coach coach) {
        if(coach.getCid() == cid){
            coachDao.updateCoach(coach);
        }else {
            coach.setCoachfname("IDs do not match, coach not updated");
            coach.setCoachlname("IDs do not match, coach not updated");
        }
        return coach;
    }

    @Override
    public void deleteCoachById(int cid) {
        coachDao.deleteCoach(cid);
    }


}
