package org.example;

enum CurrentState {
    CHOOSING_ACTION, CHOOSING_COFFEE_VARIANT, FILLING_COFFEE_MACHINE, TAKE_MONEY, CHECK_REMAINING
}

public class CoffeeMachine {
    public CurrentState currentSate;
    private final CoffeeMachineSupplies supplies;

    public CoffeeMachine () {
        this.currentSate = CurrentState.CHOOSING_ACTION;
        this.supplies = new CoffeeMachineSupplies();
    }

    public void processInput(String input) {
        switch (this.currentSate) {
            case CHOOSING_COFFEE_VARIANT:
                int coffeeType = Integer.parseInt(input);
                Coffee coffee = new CoffeeFactory().createCoffee(coffeeType);
                purchaseCup(coffee);
                break;
            case FILLING_COFFEE_MACHINE:
                supplies.fillSupplies(input);
                break;
            case TAKE_MONEY:
                takeMoney();
                break;
            case CHECK_REMAINING:
                printInventory();
                break;
        }
    }

    private void purchaseCup(Coffee coffee) {
        if (supplies.doesHaveSufficientSupplies(coffee)) {
            supplies.purchaseCoffee(coffee);
            System.out.println("I have enough resources, making you a coffee!\n");
        } else {
            String insufficientIngredient = supplies.determineInsufficientIngredient(coffee);
            System.out.printf("Sorry, not enough %s\n\n", insufficientIngredient);
        }
    }

    private void takeMoney() {
        int moneyTaken = supplies.takeMoney();
        System.out.printf("I gave you $%d\n\n", moneyTaken);
    }

    private void printInventory() {
        System.out.printf("The coffee machine has:%n%d ml of water%n%d ml of milk%n%d g of coffee beans%n%d " +
                        "disposable cups%n$%d of money%n%n",
                supplies.getWater(),
                supplies.getMilk(),
                supplies.getCoffeeBeans(),
                supplies.getDisposableCups(),
                supplies.getMoney());
    }
}