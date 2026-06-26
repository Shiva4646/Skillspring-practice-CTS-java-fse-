package com.cognizant.search;

import java.util.Arrays;
import java.util.Comparator;

public class SearchTest {
    public static void main(String[] args) {
        // Create an unsorted array of products for Linear Search
        Product[] products = {
                new Product("P003", "Wireless Mouse", "Electronics"),
                new Product("P001", "Gaming Laptop", "Electronics"),
                new Product("P004", "Mechanical Keyboard", "Electronics"),
                new Product("P002", "Smart Watch", "Accessories")
        };

        String searchTarget = "Mechanical Keyboard";

        System.out.println("--- 1. Testing Linear Search ---");
        Product resultLinear = SearchAlgorithms.linearSearch(products, searchTarget);
        System.out.println("Linear Search Result: " + resultLinear);

        System.out.println("\n--- 2. Testing Binary Search ---");
        // Crucial Step: Binary search requires data sorted by the search key!
        Arrays.sort(products, Comparator.comparing(Product::getProductName, String.CASE_INSENSITIVE_ORDER));

        System.out.println("Sorted Array for Binary Search:");
        for (Product p : products) System.out.println("  " + p);

        Product resultBinary = SearchAlgorithms.binarySearch(products, searchTarget);
        System.out.println("Binary Search Result: " + resultBinary);

        System.out.println("\n--- 📊 Complexity Analysis Discussion ---");
        System.out.println("• Linear Search: Time Complexity is O(N) because it inspects every element sequentially.");
        System.out.println("• Binary Search: Time Complexity is O(log N) due to successive halving of search bounds.");
        System.out.println("• Conclusion: For a real-world e-commerce platform with millions of items, Binary Search (or indexing) is significantly better.");
    }
}