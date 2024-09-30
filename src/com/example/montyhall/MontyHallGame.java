package com.example.montyhall;

import java.util.Random;

public class MontyHallGame {
    private final int totalGames;
    private int switchWins;
    private int stayWins;

    public MontyHallGame(int totalGames) {
        if (totalGames < 0) {
            throw new IllegalArgumentException("Количество игр не может быть отрицательным");
        }
        this.totalGames = totalGames;
        this.switchWins = 0;
        this.stayWins = 0;
        simulateGames();
    }

    private void simulateGames() {
        Random random = new Random();
        for (int i = 0; i < totalGames; i++) {
            int prizeDoor = random.nextInt(3);
            int chosenDoor = random.nextInt(3);
            int revealedDoor;

            do {
                revealedDoor = random.nextInt(3);
            } while (revealedDoor == prizeDoor || revealedDoor == chosenDoor);

            // If the player switches
            int switchDoor = 3 - chosenDoor - revealedDoor; // the remaining door
            if (switchDoor == prizeDoor) {
                switchWins++;
            } else {
                stayWins++;
            }
        }
    }

    public int getSwitchWins() {
        return switchWins;
    }

    public int getStayWins() {
        return stayWins;
    }
}