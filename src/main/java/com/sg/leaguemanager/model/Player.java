package com.sg.leaguemanager.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Player {

    private int pid;
    private String fName;
    private String lName;
    private double ppg;
    private double rpg;
    private double apg;
    private BigDecimal psalary;
    private int tid;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public double getPpg() {
        return ppg;
    }

    public void setPpg(double ppg) {
        this.ppg = ppg;
    }

    public double getRpg() {
        return rpg;
    }

    public void setRpg(double rpg) {
        this.rpg = rpg;
    }

    public double getApg() {
        return apg;
    }

    public void setApg(double apg) {
        this.apg = apg;
    }

    public BigDecimal getPsalary() {
        return psalary;
    }

    public void setPsalary(BigDecimal psalary) {
        this.psalary = psalary;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return pid == player.pid && Double.compare(ppg, player.ppg) == 0 && Double.compare(rpg, player.rpg) == 0 && Double.compare(apg, player.apg) == 0 && tid == player.tid && Objects.equals(fName, player.fName) && Objects.equals(lName, player.lName) && Objects.equals(psalary, player.psalary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pid, fName, lName, ppg, rpg, apg, psalary, tid);
    }

    @Override
    public String toString() {
        return "Player{" +
                "pid=" + pid +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", ppg=" + ppg +
                ", rpg=" + rpg +
                ", apg=" + apg +
                ", psalary=" + psalary +
                ", tid=" + tid +
                '}';
    }

}
