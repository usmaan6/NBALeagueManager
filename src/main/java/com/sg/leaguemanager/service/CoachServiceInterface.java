package com.sg.leaguemanager.service;

import com.sg.leaguemanager.model.Coach;

import java.util.List;

public interface CoachServiceInterface {
    List<Coach> getAllCoaches();

    Coach getCoachById(int cid);

    Coach addNewCoach(Coach coach);

    Coach updateCoachData(int cid, Coach coach);

    void deleteCoachById(int cid);

}
