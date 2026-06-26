package com.cognizant.search;

import java.util.Arrays;
import java.util.Comparator;

public class SearchAlgorithms {

    // 1. Linear Search Implementation
    public static Product linearSearch(Product[] products, String targetName) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(targetName)) {
                return product; // Found
            }
        }
        return null; // Not found
    }

    // 2. Binary Search Implementation (Assumes array is sorted by productName)
    public static Product binarySearch(Product[] products, String targetName) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].getProductName().compareToIgnoreCase(targetName);

            if (comparison == 0) {
                return products[mid]; // Found
            }
            if (comparison < 0) {
                left = mid + 1; // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }
        return null; // Not found
    }
}