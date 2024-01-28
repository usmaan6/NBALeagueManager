package com.sg.leaguemanager.dao;

import com.sg.leaguemanager.model.Coach;

import java.util.List;

public interface CoachDAO {
    Coach createNewCoach(Coach coach);

    List<Coach> getAllCoach();

    Coach findCoachById(int cid);

    void updateCoach(Coach coach);

    Coach deleteCoach(int cid);

}
