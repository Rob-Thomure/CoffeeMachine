package org.example;

import java.util.Scanner;

public class CoffeeMachine {
    public static Scanner scanner = new Scanner(System.in);
    public final static int ML_OF_WATER_PER_CUP = 200;
    public final static int ML_OF_MILK_PER_CUP = 50;
    public final static int GRAMS_OF_COFFEE_BEANS_PER_CUP = 15;
    public static int mlOfWater = 400;
    public static int mlOfMilk = 540;
    public static int gramsOfCoffeeBeans = 120;
    public static int disposableCups = 9;
    public static int money = 550;

    public static void main(String[] args) {
        printInventory();
        chooseAction();
        printInventory();
    }

    public static void chooseAction() {
        System.out.println("\nWrite action (buy, fill, take):");
        String action = scanner.nextLine();
        switch (action) {
            case "buy":
                chooseCoffeeType();
                break;
            case "fill":
                fillCoffeeMachine();
                break;
            case "take":
                takeMoney();
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    public static void takeMoney() {
        System.out.printf("I gave you $%d%n%n", money);
        money -= money;
    }

    public static void fillCoffeeMachine() {
        System.out.println("Write how many ml of water you want to add:");
        mlOfWater += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        mlOfMilk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        gramsOfCoffeeBeans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        disposableCups += scanner.nextInt();
        System.out.println();
    }

    public static void chooseCoffeeType() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        int coffeeType = scanner.nextInt();
        System.out.println();
        switch (coffeeType) {
            case 1:
                buyEspresso();
                break;
            case 2:
                buyLatte();
                break;
            case 3:
                buyCappuccino();
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    public static void buyEspresso() {
        final int ML_OF_WATER_PER_CUP = 250;
        final int GRAMS_OF_COFFEE_BEANS_PER_CUP = 16;
        final int PRICE_PER_CUP = 4;
        mlOfWater -= ML_OF_WATER_PER_CUP;
        gramsOfCoffeeBeans -= GRAMS_OF_COFFEE_BEANS_PER_CUP;
        disposableCups--;
        money += PRICE_PER_CUP;
    }

    public static void buyLatte() {
        final int ML_OF_WATER_PER_CUP = 350;
        final int ML_OF_MILK_PER_CUP = 75;
        final int GRAMS_OF_COFFEE_BEANS_PER_CUP = 20;
        final int PRICE_PER_CUP = 7;
        mlOfWater -= ML_OF_WATER_PER_CUP;
        mlOfMilk -= ML_OF_MILK_PER_CUP;
        gramsOfCoffeeBeans -= GRAMS_OF_COFFEE_BEANS_PER_CUP;
        disposableCups--;
        money += PRICE_PER_CUP;
    }

    public static void buyCappuccino() {
        final int ML_OF_WATER_PER_CUP = 200;
        final int ML_OF_MILK_PER_CUP = 100;
        final int GRAMS_OF_COFFEE_BEANS_PER_CUP = 12;
        final int PRICE_PER_CUP = 6;
        mlOfWater -= ML_OF_WATER_PER_CUP;
        mlOfMilk -= ML_OF_MILK_PER_CUP;
        gramsOfCoffeeBeans -= GRAMS_OF_COFFEE_BEANS_PER_CUP;
        disposableCups--;
        money += PRICE_PER_CUP;
    }

    public static void printInventory() {
        System.out.printf("The coffee machine has:%n%d ml of water%n%d ml of milk%n%d g of coffee beans%n%d " +
                "disposable cups%n$%d of money%n", mlOfWater, mlOfMilk, gramsOfCoffeeBeans, disposableCups, money);
    }

    public static void estimateNumberOfServings() {
        System.out.println("Write how many ml of water the coffee machine has:");
        int water = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int coffeeBeans = scanner.nextInt();
        int cupsNeeded = askHowManyCupsCoffeeNeeded();
        int maximumCupsMade = calculateMaxNumCups(water, milk, coffeeBeans);
        printResults(cupsNeeded, maximumCupsMade);
    }

    public static void printResults(int cupsNeeded, int maximumCupsMade) {
        if (cupsNeeded == maximumCupsMade) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (maximumCupsMade > cupsNeeded) {
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)",
                    maximumCupsMade - cupsNeeded);
        } else {
            System.out.printf("No, I can make only %d cup(s) of coffee", maximumCupsMade);
        }
    }

    public static int calculateMaxNumCups(int water, int milk, int coffeeBeans) {
        int cupsForWater = water / ML_OF_WATER_PER_CUP;
        int cupsForMilk = milk / ML_OF_MILK_PER_CUP;
        int cupsForBeans = coffeeBeans / GRAMS_OF_COFFEE_BEANS_PER_CUP;
        int maximumCups = Math.min(cupsForWater, cupsForMilk);
        return Math.min(maximumCups, cupsForBeans);
    }

    public static void printAmountOfIngredientsNeeded(int cups) {
        int water = cups * ML_OF_WATER_PER_CUP;
        int milk = cups * ML_OF_MILK_PER_CUP;
        int coffeeBeans = cups * GRAMS_OF_COFFEE_BEANS_PER_CUP;
        System.out.printf("For %d cups of coffee you will need:%n%d ml of water%n%d ml of milk%n%d g of coffee " +
                "beans", cups, water, milk, coffeeBeans);
    }

    public static int askHowManyCupsCoffeeNeeded() {
        System.out.println("Write how many cups of coffee you will need:");
        return scanner.nextInt();
    }

    public static void makeCoffee() {
        System.out.println("Starting to make a coffee\n" +
                "Grinding coffee beans\n" +
                "Boiling water\n" +
                "Mixing boiled water with crushed coffee beans\n" +
                "Pouring coffee into the cup\n" +
                "Pouring some milk into the cup\n" +
                "Coffee is ready!");
    }
}
