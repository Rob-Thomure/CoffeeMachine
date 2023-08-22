package org.example;

import java.util.Scanner;

public class CoffeeMachine {
    public static Scanner scanner = new Scanner(System.in);
    public final static int ML_OF_WATER_PER_CUP = 200;
    public final static int ML_OF_MILK_PER_CUP = 50;
    public final static int GRAMS_OF_COFFEE_BEANS_PER_CUP = 15;

    public static void main(String[] args) {
        estimateNumberOfServings();
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
