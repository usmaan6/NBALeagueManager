package com.sg.leaguemanager.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TeamServiceTests {
    @Autowired
    TeamServiceInterface teamServ;

    public TeamServiceTests() {}

}