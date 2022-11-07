package com.tasky.circlycrossy;

public class GameInterface {

    private static final int DEFAULT_NUMBER_OF_PLAYERS = 2;

    private final CirclyCrossy circlyCrossy;

    private final RulesChecker rulesChecker;

    private final UserInterface ui;
    private final MovementParser movementParser;

    public GameInterface(CirclyCrossy circlyCrossy,
                         MovementParser movementParser,
                         RulesChecker rulesChecker,
                         UserInterface ui) {
        this.circlyCrossy = circlyCrossy;
        this.rulesChecker = rulesChecker;
        this.ui = ui;
        this.movementParser = movementParser;
    }

    public void startGame() {
        ui.println("Circly-Crossy game.");
        ui.println("Number of players is set to " + DEFAULT_NUMBER_OF_PLAYERS);
        ui.println("Starting the game...");

        while (!circlyCrossy.getCurrentGameState().hasWinner()) {
            printGameState(circlyCrossy.getCurrentGameState());
            ui.print("Type in your move [x,y]: ");
            PlayerMovement playerMovement = readPlayerMovementUntilNoException();
            while (isAgainstRules(playerMovement) && !circlyCrossy.makeAMove(playerMovement)) {
                ui.print("Illegal movement, type in your move again: ");
                playerMovement = readPlayerMovementUntilNoException();
                isAgainstRules(playerMovement);
            }
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

    private boolean isAgainstRules(PlayerMovement playerMovement) {
        boolean moveAgainstRules = true;
        try {
            rulesChecker.isValidMove(circlyCrossy.getCurrentGameState(), playerMovement);

        } catch (IllegalArgumentException e) {
            moveAgainstRules = false;
            ui.print(e.getMessage() + ", type in your move again. \n");
        } catch (ArrayIndexOutOfBoundsException e) {
            moveAgainstRules = false;
            ui.print(e.getMessage() + ", type in your move again. \n");
        }
        return moveAgainstRules;
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
