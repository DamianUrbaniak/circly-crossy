package com.tasky.circlycrossy;

public class CirclyCrossy {

    public static final int DEFAULT_GRID_SIZE = 3;
    private final RulesChecker rulesChecker;
    private final GameState gameState;

    public CirclyCrossy(RulesChecker rulesChecker) {
        this.rulesChecker = rulesChecker;
        gameState = new GameState(new char[DEFAULT_GRID_SIZE][DEFAULT_GRID_SIZE]);
    }

    public GameState getCurrentGameState() {
        return gameState;
    }

    public boolean makeAMove(PlayerMovement playerMovement) {
        boolean isMovementDone = false;

        if (gameState.getCurrentPlayer() == 1) {
            getCurrentGameState()
                    .getGameGrid()[playerMovement.getY()][playerMovement.getX()] = 'O';
            gameState.setCurrentPlayer(2);
            isMovementDone = true;

        } else if (gameState.getCurrentPlayer() == 2) {
            getCurrentGameState()
                    .getGameGrid()[playerMovement.getY()][playerMovement.getX()] = 'X';
            gameState.setCurrentPlayer(1);
            isMovementDone = true;
        }
        return isMovementDone;
    }


    public static class GameState {
        private final char[][] gameGrid;
        private int currentPlayer;
        private int winner = 0;

        public GameState(char[][] gameGrid) {
            this.gameGrid = gameGrid;
            this.currentPlayer = 1; // player 1 starts the game
            this.winner = 0; // 0 means no winner
        }

        public char[][] getGameGrid() {
            return gameGrid;
        }

        public int getCurrentPlayer() {

            return currentPlayer;
        }

        public void setCurrentPlayer(int currentPlayer) {

            this.currentPlayer = currentPlayer;
        }

        public void setWinner(int winner) {

            this.winner = winner;
        }

        public int getWinner() {

            return winner;
        }


        public boolean hasWinner() {

            char[][] actualGameGrid = getGameGrid();
            int circlesCount = 0;
            int crossesCount = 0;
            boolean result = false;
//checking diagonals
            for (int i = 0; i < gameGrid.length; i++) {

                if (gameGrid[i][i] == 'X') {
                    crossesCount++;
                }
                if (gameGrid[i][i] == 'O') {
                    circlesCount++;
                }
                if (circlesCount == 3) {
                    setWinner(1);
                    result = true;
                } else if (crossesCount == 3) {
                    setWinner(2);
                    result = true;
                }
            }
            crossesCount = 0;
            circlesCount = 0;
            for (int i = 0; i < gameGrid.length; i++) {

                if (gameGrid[(gameGrid.length - 1) - i][i] == 'X') {
                    crossesCount++;
                } else if (gameGrid[(gameGrid.length - 1) - i][i] == 'O') {
                    circlesCount++;
                }
                if (circlesCount == 3) {
                    setWinner(1);
                    result = true;
                } else if (crossesCount == 3) {
                    setWinner(2);
                    result = true;
                }
            }
            crossesCount = 0;
            circlesCount = 0;

//checking horizontal lines
            for (int i = 0; i < gameGrid.length; i++) {

                for (int j = 0; j < gameGrid.length; j++) {
                    if (gameGrid[i][j] == 'X') {
                        crossesCount++;
                    }
                    if (gameGrid[i][j] == 'O') {
                        circlesCount++;
                    }
                    if (circlesCount == 3) {
                        setWinner(1);
                        result = true;
                    } else if (crossesCount == 3) {
                        setWinner(2);
                        result = true;
                    }
                }
            }
            crossesCount = 0;
            circlesCount = 0;
//checking vertical lines
            if (!result) {
                for (int i = 0; i < gameGrid.length; i++) {

                    for (int j = 0; j < gameGrid.length; j++) {
                        if (gameGrid[j][i] == 'X') {
                            crossesCount++;
                        }
                        if (gameGrid[j][i] == 'O') {
                            circlesCount++;
                        }
                        if (circlesCount == 3) {
                            setWinner(1);
                            result = true;
                        } else if (crossesCount == 3) {
                            setWinner(2);
                            result = true;
                        }
                    }
                }
            }
            return result;
        }
    }
}
