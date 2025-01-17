package ui.models;

import java.util.Random;

public enum DeliveryMethod {
    ONE_DAY_DELIVERY("One Day Delivery", 0.99),
    FAST_DELIVERY("Fast Delivery", 0.50),
    STANDARD_DELIVERY("Standard Delivery", 0);

    private final String name;
    private final double price;

    DeliveryMethod(String name, double v) {
        this.name = name;
        this.price = v;
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name;
    }

    public static DeliveryMethod getRandomDeliveryMethod() {
        Random random = new Random();
        return DeliveryMethod.values()[random.nextInt(DeliveryMethod.values().length)];
    }
}