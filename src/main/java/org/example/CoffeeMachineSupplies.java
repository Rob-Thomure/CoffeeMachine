package org.example;

import java.util.Map;

public class CoffeeMachineSupplies {

    private int water;
    private int milk;
    private int coffeeBeans;
    private int disposableCups;
    private int money;

    public CoffeeMachineSupplies() {
        this.water = 400;
        this.milk = 540;
        this.coffeeBeans = 120;
        this.disposableCups = 9;
        this.money = 550;
    }

    public boolean purchaseCoffee(Coffee coffee) {
        Map<String, Integer> coffeeIngredients = coffee.getIngredients();
        if (doesHaveSufficientSupplies(coffee)) {
            water -= coffeeIngredients.get("water");
            milk -= coffeeIngredients.get("milk");
            coffeeBeans -= coffeeIngredients.get("coffeeBeans");
            disposableCups -= 1;
            money += coffeeIngredients.get("cost");
            return true;
        } else {
            return false;
        }
    }

    public boolean doesHaveSufficientSupplies(Coffee coffee) {
        Map<String, Integer> coffeeIngredients = coffee.getIngredients();
        return water >= coffeeIngredients.get("water") &&
                milk >= coffeeIngredients.get("milk") &&
                coffeeBeans >= coffeeIngredients.get("coffeeBeans") &&
                disposableCups >= 1;
    }

    public String determineInsufficientIngredient(Coffee coffee) {
        Map<String, Integer> coffeeIngredients = coffee.getIngredients();
        String insufficientIngredient = "";
        if (water < coffeeIngredients.get("water")) {
            insufficientIngredient = "water";
        } else if (milk < coffeeIngredients.get("milk")) {
            insufficientIngredient = "milk";
        } else if (coffeeBeans < coffeeIngredients.get("coffeeBeans")) {
            insufficientIngredient = "coffee beans";
        } else if (disposableCups < 1) {
            insufficientIngredient = "cups";
        } else {
            insufficientIngredient = "sufficient ingredients";
        }
        return insufficientIngredient;
    }

    public void fillSupplies(String supplies) {
        String[] ingredientsArray = supplies.split(" ") ;
        water += Integer.parseInt(ingredientsArray[0]);
        milk += Integer.parseInt(ingredientsArray[1]);
        coffeeBeans += Integer.parseInt(ingredientsArray[2]);
        disposableCups += Integer.parseInt(ingredientsArray[3]);
    }

    public int takeMoney() {
        int moneyTaken = money;
        money = 0;
        return moneyTaken;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    public int getDisposableCups() {
        return disposableCups;
    }

    public int getMoney() {
        return money;
    }
}
