package com.tasky.circlycrossy;

public class GameInterface {

    private static final int DEFAULT_NUMBER_OF_PLAYERS = 2;

    private final CirclyCrossy circlyCrossy;
    private final MovementParser movementParser;
    private final UserInterface ui;

    public GameInterface(CirclyCrossy circlyCrossy, MovementParser movementParser, UserInterface ui) {
        this.circlyCrossy = circlyCrossy;
        this.movementParser = movementParser;
        this.ui = ui;
    }

    public void startGame() {
        ui.println("Circly-Crossy game.");
        ui.println("Number of players is set to " + DEFAULT_NUMBER_OF_PLAYERS);
        ui.println("Starting the game...");

        while (circlyCrossy.getCurrentGameState().getWinner() == 0) {
            printGameState(circlyCrossy.getCurrentGameState());
            ui.print("Type in your move [x,y]: ");
            PlayerMovement playerMovement = readPlayerMovementUntilNoException();
            while (!circlyCrossy.makeAMove(playerMovement)) {
                ui.print("Illegal movement, type in your move again: ");
                playerMovement = readPlayerMovementUntilNoException();
            }
            RulesChecker.verifyThreeFields(circlyCrossy.getCurrentGameState());
        }

        ui.println("Game finished, player" + circlyCrossy.getCurrentGameState().getWinner() + " is the winner.");
    }

    private PlayerMovement readPlayerMovementUntilNoException() {
        while (true) {
            try {
                return movementParser.parse(ui.nextLine());
            } catch (IllegalArgumentException e) {
                ui.print(e.getMessage() + ", type in your move again: ");
            }
        }
    }

    private void printGameState(CirclyCrossy.GameState gameState) {
        ui.println("Current game grid:");
        char[][] gameGrid = gameState.getGameGrid();
        for (int i = 0; i < gameGrid.length; i++) {
            for (int j = 0; j < gameGrid.length; j++) {
                ui.print(gameGrid[i][j]);
            }
            ui.print("\n");
        }
        ui.println("Current player: player" + gameState.getCurrentPlayer());
    }
}
