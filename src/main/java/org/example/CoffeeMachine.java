package org.example;

import java.util.Map;
import java.util.Scanner;

enum CurrentState {
    CHOOSING_ACTION, CHOOSING_COFFEE_VARIANT, FILLING_COFFEE_MACHINE, TAKE_MONEY, CHECK_REMAINING
}

public class CoffeeMachine {
    public CurrentState currentSate;
    private int mlOfWater;
    private int mlOfMilk;
    private int gramsOfCoffeeBeans;
    private int disposableCups;
    private int money;

    public CoffeeMachine () {
        this.currentSate = CurrentState.CHOOSING_ACTION;
        this.mlOfWater = 400;
        this.mlOfMilk = 540;
        this.gramsOfCoffeeBeans = 120;
        this.disposableCups = 9;
        this.money = 550;
    }

    public void processInput(String input) {
        switch (this.currentSate) {
            case CHOOSING_COFFEE_VARIANT:
                int coffeeType = Integer.parseInt(input);
                Coffee coffee = new CoffeeFactory().createCoffee(coffeeType);
                Map<String, Integer> ingredients = coffee.getIngredients();
                purchaseCup(ingredients.get("water"),
                        ingredients.get("milk"),
                        ingredients.get("coffeeBeans"),
                        ingredients.get("cost"));
                break;
            case FILLING_COFFEE_MACHINE:
                fillMachine(input);
                break;
            case TAKE_MONEY:
                takeMoney();
                break;
            case CHECK_REMAINING:
                printInventory();
                break;
        }
    }

    private void purchaseCup(int ML_OF_WATER_PER_CUP, int ML_OF_MILK_PER_CUP,
                             int GRAMS_OF_COFFEE_BEANS_PER_CUP, int PRICE_PER_CUP) {
        if (this.mlOfWater < ML_OF_WATER_PER_CUP) {
            System.out.println("Sorry, not enough water!\n");
        } else if (this.mlOfMilk < ML_OF_MILK_PER_CUP) {
            System.out.println("Sorry, not enough milk\n");
        } else if (this.gramsOfCoffeeBeans < GRAMS_OF_COFFEE_BEANS_PER_CUP) {
            System.out.println("Sorry, not enough coffee beans\n");
        } else if (this.disposableCups < 1) {
            System.out.println("Sorry, not enough cups\n");
        } else {
            System.out.println("I have enough resources, making you a coffee!\n");
            this.mlOfWater -= ML_OF_WATER_PER_CUP;
            this.mlOfMilk -= ML_OF_MILK_PER_CUP;
            this.gramsOfCoffeeBeans -= GRAMS_OF_COFFEE_BEANS_PER_CUP;
            this.disposableCups--;
            this.money += PRICE_PER_CUP;
        }
    }

    private void fillMachine(String ingredients) {
        String[] ingredientsArray = ingredients.split(" ") ;
        this.mlOfWater += Integer.parseInt(ingredientsArray[0]);
        this.mlOfMilk += Integer.parseInt(ingredientsArray[1]);
        this.gramsOfCoffeeBeans += Integer.parseInt(ingredientsArray[2]);
        this.disposableCups += Integer.parseInt(ingredientsArray[3]);
    }

    private void takeMoney() {
        System.out.printf("I gave you $%d%n%n", this.money);
        this.money -= this.money;
    }

    private void printInventory() {
        System.out.printf("The coffee machine has:%n%d ml of water%n%d ml of milk%n%d g of coffee beans%n%d " +
                        "disposable cups%n$%d of money%n%n", this.mlOfWater, this.mlOfMilk, this.gramsOfCoffeeBeans,
                this.disposableCups, this.money);
    }
}