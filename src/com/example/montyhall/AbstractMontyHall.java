package com.example.montyhall;

public abstract class AbstractMontyHall {
    protected int totalGames;
    protected int switchWins;
    protected int stayWins;

    public AbstractMontyHall(int totalGames) {
        if (totalGames <= 0) {
            throw new IllegalArgumentException("Number of games must be positive.");
        }
        this.totalGames = totalGames;
    }

    public abstract void runSimulation();

    public int getSwitchWins() {
        return switchWins;
    }

    public int getStayWins() {
        return stayWins;
    }
}
