package com.tasky.circlycrossy;

public class RulesChecker {

    public boolean isValidMove(CirclyCrossy.GameState gameState, PlayerMovement playerMovement) {

        int givenXCoordinate = playerMovement.getX();
        int givenYCoordinate = playerMovement.getY();

        if(givenYCoordinate > 2 || givenXCoordinate > 2){
            throw new IllegalArgumentException(
                    "Given coordinates are out of the game grid scope"
            );
        }

        return gameState.getGameGrid()[givenYCoordinate][givenXCoordinate] == 0;
    }
    public boolean checkIfSomeoneWin(CirclyCrossy.GameState gameState) {
        char[][] gameGrid = gameState.getGameGrid();
        int circlesCount = 0;
        int crossesCount = 0;
        for (int i = 0; i < gameGrid.length; i++) {
            for (int j = 0; j < gameGrid.length; j++) {
                if(gameGrid[i][j] == 'X'){
                    crossesCount++;
                } else if (gameGrid[i][j] == 'O') {
                    circlesCount++;
//                    method to finish

                }
            }
        }return true;
    }
}
