package Question4;
/*
Create a program to create PriorityQueque to store product information
Product class : consist of fields: productId, productName, productPrice. Create and store 5 product into
PriorityQueque
You need to use Comparator for custom priority (as per productPrice)
 */
import java.util.*;

// Product class with productId, productName, and productPrice
class Product {
    int productId;
    String productName;
    double productPrice;

    // Constructor
    public Product(int productId, String productName, double productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    // Override toString method to print product details
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Product ID: ").append(productId).append("\n");
        sb.append("Product Name: ").append(productName).append("\n");
        sb.append("Product Price: ").append(productPrice).append("\n");
        return sb.toString();
       // return "Product{ID=" + productId + ", Name='" + productName + "', Price=" + productPrice + "}";
    }
}

// Custom comparator to compare products by productPrice (ascending order)
class ProductComparatorPrice implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        // Compare by price, ascending order
        return Double.compare(p1.productPrice, p2.productPrice);
    }
}

public class PriorityQueueProduct {
    public static void main(String[] args) {
        // Create a PriorityQueue with custom comparator (sort by product price)
        PriorityQueue<Product> pq = new PriorityQueue<>(new ProductComparatorPrice());

        // Add 5 products to the priority queue
        pq.add(new Product(1, "V", 100));
        pq.add(new Product(2, "G", 300));
        pq.add(new Product(3, "X", 500));
        pq.add(new Product(4, "A", 400));
        pq.add(new Product(5, "B", 200));

        // Print products in order of their price (ascending order)
        System.out.println("Products in PriorityQueue (Sorted by Price):");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll()); // poll() retrieves and removes the head of the queue
        }
    }
}

