package com.tasky.circlycrossy;

import java.util.Arrays;

public class RulesChecker {

    public boolean isValidMove(CirclyCrossy.GameState gameState, PlayerMovement playerMovement) {

        int givenXCoordinate = playerMovement.getX();
        int givenYCoordinate = playerMovement.getY();

        if (givenYCoordinate > 2 || givenXCoordinate > 2) {
            throw new IllegalArgumentException(
                    "Given coordinates are out of the game grid scope"
            );
        }

        return gameState.getGameGrid()[givenYCoordinate][givenXCoordinate] == 0;
    }

    public static int verifyThreeFields(CirclyCrossy.GameState gameState) {
        char[][] gameGrid = gameState.getGameGrid();
        int circlesCount = 0;
        int crossesCount = 0;
        int result = 0;

        boolean crossDiag = (gameGrid[0][0] == 'X' && gameGrid[1][1] == 'X' && gameGrid[2][2] == 'X') ||
                (gameGrid[0][2] == 'X' && gameGrid[1][1] == 'X' && gameGrid[2][0] == 'X');
        if(crossDiag){
            gameState.setWinner(2);
        }

        boolean circleDiag = (gameGrid[0][0] == 'O' && gameGrid[1][1] == 'O' && gameGrid[2][2] == 'O') ||
                (gameGrid[0][2] == 'O' && gameGrid[1][1] == 'O' && gameGrid[2][0] == 'O');
        if(circleDiag){
            gameState.setWinner(1);
        }

        for (int i = 0; i < gameGrid.length; i++) {
            crossesCount = 0;
            circlesCount = 0;

            for (int j = 0; j < gameGrid.length; j++) {
                if (gameGrid[i][j] == 'X') {
                    crossesCount++;
                }
                if (gameGrid[i][j] == 'O') {
                    circlesCount++;
                }
                if (circlesCount == 3) {
                    gameState.setWinner(1);
                } else if (crossesCount == 3) {
                    gameState.setWinner(2);
                } else {
                    result = 0;
                }
            }
        }

        if(result == 0){
            for (int i = 0; i < gameGrid.length; i++) {
                crossesCount = 0;
                circlesCount = 0;
                for (int j = 0; j < gameGrid.length; j++) {
                    if (gameGrid[j][i] == 'X') {
                        crossesCount++;
                    }
                    if (gameGrid[j][i] == 'O') {
                        circlesCount++;
                    }
                    if (circlesCount == 3) {
                        gameState.setWinner(1);
                    } else if (crossesCount == 3) {
                        gameState.setWinner(2);
                    } else {
                        result = 0;
                    }
                }
            }
        }
        return result;
    }
}
