package com.sg.leaguemanager.service;

import com.sg.leaguemanager.dao.CoachDAO;
import com.sg.leaguemanager.model.Coach;

import java.math.BigDecimal;
import java.util.List;

public class CoachDaoStubImpl implements CoachDAO {
    public Coach onlyCoach;
    public CoachDaoStubImpl(){
        onlyCoach = new Coach();
        onlyCoach.setCid(2);
        onlyCoach.setCoachfname("Jerry");
        onlyCoach.setCoachlname("Jones");
        onlyCoach.setCsalary(BigDecimal.valueOf(40004.43));
        onlyCoach.setCwins(32);
        onlyCoach.setClosses(9);
        onlyCoach.setTid(1);
    }
    @Override
    public Coach createNewCoach(Coach coach) {
        if(coach.getCoachfname().toString() == "" ||
                coach.getCoachlname().toString() == ""){
            coach.setCoachfname("Name blank, coach NOT added");
            coach.setCoachlname("Name blank, coach NOT added");
        }
        return coach;
    }

    @Override
    public List<Coach> getAllCoach() {
        //Pass through method no tests
        return null;
    }

    @Override
    public Coach findCoachById(int cid) {
        if (onlyCoach.getCid() != cid) {
            onlyCoach.setCoachfname("Coach Not Found");
            onlyCoach.setCoachlname("Coach Not Found");
        }
        return onlyCoach;
    }

    @Override
    public void updateCoach(Coach coach) {
        onlyCoach.setCoachfname(coach.getCoachfname());
        onlyCoach.setCoachlname(coach.getCoachlname());
        onlyCoach.setCid(coach.getCid());
    }

    @Override
    public Coach deleteCoach(int cid) {
        //Pass through method no tests
        return null;
    }


}
