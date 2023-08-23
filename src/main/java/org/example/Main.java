package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        while (true) {
            coffeeMachine.currentSate = CurrentState.CHOOSING_ACTION;
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.nextLine();
            System.out.println();
            switch (action) {
                case "buy":
                    coffeeMachine.currentSate = CurrentState.CHOOSING_COFFEE_VARIANT;
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to " +
                            "main menu:");
                    String coffeeType = scanner.nextLine();
                    if (!coffeeType.equals("back")) {
                        coffeeMachine.processInput(coffeeType);
                    }
                    break;
                case "fill":
                    coffeeMachine.currentSate = CurrentState.FILLING_COFFEE_MACHINE;
                    System.out.println("Write how many ml of water you want to add:");
                    String input = scanner.nextLine() + " ";
                    System.out.println("Write how many ml of milk you want to add:");
                    input += scanner.nextLine() + " ";
                    System.out.println("Write how many grams of coffee beans you want to add:");
                    input += scanner.nextLine() + " ";
                    System.out.println("Write how many disposable cups of coffee you want to add:");
                    input += scanner.nextLine();
                    System.out.println();
                    coffeeMachine.processInput(input);
                    break;
                case "take":
                    coffeeMachine.currentSate = CurrentState.TAKE_MONEY;
                    coffeeMachine.processInput("");
                    break;
                case "remaining":
                    coffeeMachine.currentSate = CurrentState.CHECK_REMAINING;
                    coffeeMachine.processInput("");
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }

    }

}

