package com.tasky.circlycrossy;

import java.util.Arrays;

public class RulesChecker {

    public boolean isValidMove(CirclyCrossy.GameState gameState, PlayerMovement playerMovement) {
        boolean valuated = false;
        int givenXCoordinate = playerMovement.getX();
        int givenYCoordinate = playerMovement.getY();

        if (givenYCoordinate >= gameState.getGameGrid().length
                || givenXCoordinate >= gameState.getGameGrid().length) {
            throw new ArrayIndexOutOfBoundsException(
                    "Given coordinates are out of the game grid scope"
            );
        }
        if (gameState.getGameGrid()[givenYCoordinate][givenXCoordinate] != 0) {
            throw new IllegalArgumentException(
                    "Move with that coordinates was already made"
            );
        }
        if (gameState.getGameGrid()[givenYCoordinate][givenXCoordinate] == 0) {
            valuated = true;
        }
        return valuated;
    }
}
