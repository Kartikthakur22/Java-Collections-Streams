package Collections.MapInterface;

import java.util.*;

public class ShoppingCart {
    private Map<String, Double> productPrices = new HashMap<>();
    private Map<String, Integer> cart = new LinkedHashMap<>();
    private TreeMap<Double, String> sortedProducts = new TreeMap<>();

    public void addProduct(String product, double price) {
        productPrices.put(product, price);
        sortedProducts.put(price, product);
    }

    public void addToCart(String product, int quantity) {
        if (productPrices.containsKey(product)) {
            cart.put(product, cart.getOrDefault(product, 0) + quantity);
        } else {
            System.out.println("Product not found!");
        }
    }

    public void displayCart() {
        System.out.println("Cart (Insertion Order): " + cart);
    }

    public void displayProductsSortedByPrice() {
        System.out.println("Products Sorted by Price: " + sortedProducts);
    }

    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        
        shoppingCart.addProduct("Laptop", 1000.0);
        shoppingCart.addProduct("Phone", 500.0);
        shoppingCart.addProduct("Headphones", 150.0);
        
        shoppingCart.addToCart("Phone", 2);
        shoppingCart.addToCart("Laptop", 1);
        shoppingCart.addToCart("Headphones", 3);
        
        shoppingCart.displayCart();
        shoppingCart.displayProductsSortedByPrice();
    }
}
