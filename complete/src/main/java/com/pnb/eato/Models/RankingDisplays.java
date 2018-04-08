package com.pnb.eato.Models;

public class RankingDisplays {
    private String name;
    private String joinDate;
    private int reputation;

    public RankingDisplays() {
    }

    public RankingDisplays(String name, String joinDate, int reputation) {

        this.name = name;
        this.joinDate = joinDate;
        this.reputation = reputation;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }
}
