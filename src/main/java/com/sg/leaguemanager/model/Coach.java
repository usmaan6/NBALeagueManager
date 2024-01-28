package com.sg.leaguemanager.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Coach {
    private int cid;
    private String coachfname;
    private String coachlname;
    private BigDecimal csalary;
    private int cwins;
    private int closses;
    private int tid;

    public int getCid() {
        return cid;
    }

    public String getCoachfname() {
        return coachfname;
    }

    public String getCoachlname() {
        return coachlname;
    }

    public BigDecimal getCsalary() {
        return csalary;
    }

    public int getCwins() {
        return cwins;
    }

    public int getClosses() {
        return closses;
    }

    public int getTid() {
        return tid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public void setCoachfname(String coachfname) {
        this.coachfname = coachfname;
    }

    public void setCoachlname(String coachlname) {
        this.coachlname = coachlname;
    }

    public void setCsalary(BigDecimal csalary) {
        this.csalary = csalary;
    }

    public void setCwins(int cwins) {
        this.cwins = cwins;
    }

    public void setClosses(int closses) {
        this.closses = closses;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coach coach = (Coach) o;
        return cid == coach.cid && Objects.equals(csalary, coach.csalary) && Integer.compare(cwins, coach.getCwins()) == 0 && Integer.compare(closses,coach.getClosses()) == 0 && tid == coach.tid && Objects.equals(coachfname, coach.coachfname) && Objects.equals(coachlname, coach.coachlname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cid, coachfname, coachlname, csalary, cwins, closses, tid);
    }

    @Override
    public String toString() {
        return "Coach{" +
                "cid=" + cid +
                ", coachfname='" + coachfname + '\'' +
                ", coachlname='" + coachlname + '\'' +
                ", csalary=" + csalary +
                ", cwins=" + cwins +
                ", closses=" + closses +
                ", tid=" + tid +
                '}';
    }
}
