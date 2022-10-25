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
        if (rulesChecker.isValidMove(gameState, playerMovement)) {
            if (gameState.getCurrentPlayer() == 1) {
                getCurrentGameState().getGameGrid()[playerMovement.getY()][playerMovement.getX()] = 'O';
                gameState.setCurrentPlayer(2);
            } else {
                getCurrentGameState().getGameGrid()[playerMovement.getY()][playerMovement.getX()] = 'X';
                gameState.setCurrentPlayer(1);}
            return true;
        } else {
            return false; // not a valid move
        }
    }

    public static class GameState {
        private final char[][] gameGrid;
        private int currentPlayer;
        private int winner;

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

        public int getWinner() {
            return winner;
        }

        public boolean hasWinner() {
            return winner != 0;
        }
    }
}
