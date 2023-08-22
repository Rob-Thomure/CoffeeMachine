package org.example;

import java.util.Scanner;

public class CoffeeMachine {
    public static Scanner scanner = new Scanner(System.in);
    public final static int ML_OF_WATER_PER_CUP = 200;
    public final static int ML_OF_MILK_PER_CUP = 50;
    public final static int GRAMS_OF_COFFEE_BEANS_PER_CUP = 15;

    public static void main(String[] args) {
        int cupsCoffee = askHowManyCupsCoffeeNeeded();
        printAmountOfIngredientsNeeded(cupsCoffee);
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
