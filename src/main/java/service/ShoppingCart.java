package service;

import model.Discountable;
import model.Food;

public class ShoppingCart {
    private Food[] foods;

    public ShoppingCart(Food[] foods) {
        this.foods = foods;
    }

    public double getTotalPriceWithoutDiscount() {
        double total = 0;
        for (Food food : foods) {
            total += food.getAmount() * food.getPrice();
        }
        return total;
    }

    public double getTotalPriceWithDiscount() {
        double total = 0;
        for (Food food : foods) {
            double itemTotal = food.getAmount() * food.getPrice();
            if (food instanceof Discountable) {
                itemTotal -= itemTotal * ((Discountable) food).getDiscount() / 100;
            }
            total += itemTotal;
        }
        return total;
    }

    public double getTotalVegetarianPriceWithoutDiscount() {
        double total = 0;
        for (Food food : foods) {
            if (food.isVegetarian()) {
                total += food.getAmount() * food.getPrice();
            }
        }
        return total;
    }
}
