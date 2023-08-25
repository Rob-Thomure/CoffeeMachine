package org.example;

import java.util.Map;

public abstract class Coffee {
    private final int water;
    private final int milk;
    private final int coffeeBeans;
    private final int cost;

    public Coffee(int water, int milk, int coffeeBeans, int cost) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.cost = cost;
    }

    public Map<String, Integer> getIngredients() {
        return Map.of("water", water,
                "milk", milk,
                "coffeeBeans", coffeeBeans,
                "cost", cost);
    }

}
