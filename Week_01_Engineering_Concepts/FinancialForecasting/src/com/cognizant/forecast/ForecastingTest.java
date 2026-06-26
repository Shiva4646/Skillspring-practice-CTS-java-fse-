package com.cognizant.forecast;

public class ForecastingTest {
    public static void main(String[] args) {
        double startingPrincipal = 1000.0; // Initial investment of ₹1000/ $1000
        double annualGrowthRate = 0.05;    // 5% constant growth rate
        int forecastPeriodYears = 5;       // Forecast for 5 years

        System.out.println("--- 📈 Launching Financial Forecasting Simulation ---");
        System.out.println("Initial Value: " + startingPrincipal);
        System.out.println("Annual Growth Rate: " + (annualGrowthRate * 100) + "%");
        System.out.println("Forecast Horizon: " + forecastPeriodYears + " years\n");

        // Execute the recursive calculation
        double predictedFutureValue = ForecastingTool.calculateFutureValue(startingPrincipal, annualGrowthRate, forecastPeriodYears);

        System.out.println("--- 📊 Simulation Results ---");
        System.out.printf("Estimated Future Value after %d years: %.2f\n", forecastPeriodYears, predictedFutureValue);

        System.out.println("\n--- 🧠 Algorithmic Analysis Block ---");
        System.out.println("• Time Complexity: O(Y) where Y is the number of years, since the method calls itself once per year.");
        System.out.println("• Space Complexity: O(Y) due to the call stack overhead from call frames storage.");
        System.out.println("• Optimization Strategy: To prevent a Call Stack Overflow with long periods (e.g., 500 years), " +
                "this recursive solution can be optimized using an iterative loop (O(1) auxiliary space) or Memoization.");
    }
}