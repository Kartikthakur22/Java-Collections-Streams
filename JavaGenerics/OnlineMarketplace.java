class BookCategory {}
class ClothingCategory {}
class GadgetCategory {}

class Product<T> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product: " + name + ", Price: " + price + ", Category: " + category.getClass().getSimpleName();
    }
}

class Marketplace {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discount = product.getPrice() * percentage / 100;
        double newPrice = product.getPrice() - discount;
        product.setPrice(newPrice);
    }
}

public class OnlineMarketplace {
    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("The Great Gatsby", 20.0, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("T-shirt", 15.0, new ClothingCategory());
        Product<GadgetCategory> phone = new Product<>("Smartphone", 500.0, new GadgetCategory());

        System.out.println(book);
        System.out.println(shirt);
        System.out.println(phone);

        Marketplace.applyDiscount(book, 10);
        Marketplace.applyDiscount(shirt, 5);
        Marketplace.applyDiscount(phone, 15);

        System.out.println("\nAfter applying discounts:");
        System.out.println(book);
        System.out.println(shirt);
        System.out.println(phone);
    }
}
