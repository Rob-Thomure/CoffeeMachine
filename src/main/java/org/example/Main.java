package org.example;

import java.util.Scanner;

public class Main {
    static Scanner keyboard = new Scanner(System.in);
    static CoffeeMachine coffeeMachine = new CoffeeMachine();

    public static void main(String[] args) {
        while (true) {
            coffeeMachine.currentSate = CurrentState.CHOOSING_ACTION;
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = keyboard.nextLine();
            System.out.println();
            switch (action) {
                case "buy" -> buy(coffeeMachine);
                case "fill" -> fill(coffeeMachine);
                case "take" -> take(coffeeMachine);
                case "remaining" -> remaining(coffeeMachine);
                case "exit" -> {
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }

    }

    public static void buy(CoffeeMachine coffeeMachine) {
        coffeeMachine.currentSate = CurrentState.CHOOSING_COFFEE_VARIANT;
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to " +
                "main menu:");
        String coffeeType = keyboard.nextLine();
        if (!coffeeType.equals("back")) {
            coffeeMachine.processInput(coffeeType);
        }
    }

    public static void fill(CoffeeMachine coffeeMachine) {
        coffeeMachine.currentSate = CurrentState.FILLING_COFFEE_MACHINE;
        System.out.println("Write how many ml of water you want to add:");
        String input = keyboard.nextLine() + " ";
        System.out.println("Write how many ml of milk you want to add:");
        input += keyboard.nextLine() + " ";
        System.out.println("Write how many grams of coffee beans you want to add:");
        input += keyboard.nextLine() + " ";
        System.out.println("Write how many disposable cups of coffee you want to add:");
        input += keyboard.nextLine();
        System.out.println();
        coffeeMachine.processInput(input);
    }

    public static void take(CoffeeMachine coffeeMachine) {
        coffeeMachine.currentSate = CurrentState.TAKE_MONEY;
        coffeeMachine.processInput("");
    }

    public static void remaining(CoffeeMachine coffeeMachine) {
        coffeeMachine.currentSate = CurrentState.CHECK_REMAINING;
        coffeeMachine.processInput("");
    }


}

