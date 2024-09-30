package com.example.montyhall;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MontyHallGameTest {

    @Test
    public void testSimulation() {
        MontyHallGame game = new MontyHallGame(1000);
        int switchWins = game.getSwitchWins();
        int stayWins = game.getStayWins();

        // Assert that the wins are consistent with the expected ratio
        assertTrue(switchWins + stayWins == 1000);
        assertTrue(switchWins > stayWins, "Switching should yield more wins than staying");
    }

    @Test
    public void testInitialSetup() {
        MontyHallGame game = new MontyHallGame(100);
        assertTrue(game.getSwitchWins() >= 0);
        assertTrue(game.getStayWins() >= 0);
    }

    @Test
    public void testNegativeGames() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new MontyHallGame(-1);
        });
        assertTrue(exception.getMessage().contains("Количество игр не может быть отрицательным"));
    }
}