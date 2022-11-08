package com.tasky.circlycrossy;

import java.util.Scanner;

public class CirclyCrossyApplication {

    public static void main(String[] args) {

        RulesChecker rulesChecker = new RulesChecker();
        CirclyCrossy circlyCrossy = new CirclyCrossy();
        MovementParser movementParser = new MovementParser();
        UserInterface userInterface = new UserInterface(new Scanner(System.in), System.out);


        new GameInterface(circlyCrossy, movementParser, rulesChecker, userInterface).startGame();
    }
}
