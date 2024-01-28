package com.sg.leaguemanager.model;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.List;

public class Team {
    private int teamId;
    private String teamName;
    private String teamState;
    private int wins;
    private int losses;
    private BigDecimal teamPayroll;
    private List<Player> players;
    private List<Coach> coaches;

    // basic getters and setters
    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamState() {
        return teamState;
    }

    public void setTeamState(String teamState) {
        this.teamState = teamState;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public BigDecimal getTeamPayroll() {
        return teamPayroll;
    }

    public void setTeamPayroll(BigDecimal teamPayroll) {
        this.teamPayroll = teamPayroll;
    }

    //getters and setters for list elements
    public void addAllPlayers(List<Player> playerList) {
        players = playerList;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addAllCoaches(List<Coach> coachList) {
        coaches = coachList;
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    //equals, hashcode, to string
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return teamId == team.teamId && wins == team.wins && losses == team.losses && Objects.equals(teamName, team.teamName) && Objects.equals(teamState, team.teamState) && Objects.equals(teamPayroll, team.teamPayroll);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamId, teamName, teamState, wins, losses, teamPayroll);
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamId=" + teamId +
                ", teamName='" + teamName + '\'' +
                ", teamState='" + teamState + '\'' +
                ", wins=" + wins +
                ", losses=" + losses +
                ", teamPayroll=" + teamPayroll +
                ", players=" + players +
                ", coaches=" + coaches +
                '}';
    }
}
