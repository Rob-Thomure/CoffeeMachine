package org.example;

public class CoffeeFactory {

    public Coffee createCoffee(int coffeeType) {
        return switch (coffeeType) {
            case 1 -> new Espresso();
            case 2 -> new Latte();
            case 3 -> new Cappuccino();
            default -> null;
        };
    }

}
