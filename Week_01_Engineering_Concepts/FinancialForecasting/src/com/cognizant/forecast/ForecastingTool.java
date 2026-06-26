package com.cognizant.forecast;

public class ForecastingTool {

    /**
     * Recursive method to calculate the future value of an investment/asset.
     * Formula: Future Value = Present Value * (1 + Growth Rate)^Years
     *
     * @param presentValue The starting value
     * @param growthRate   The constant annual growth rate (e.g., 0.05 for 5%)
     * @param years        The number of years to forecast into the future
     * @return The predicted future value
     */
    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        // 1. Base Case: If years is 0, the value remains the present value
        if (years == 0) {
            return presentValue;
        }

        // 2. Recursive Step: Calculate value for (years - 1) and apply the growth for the current year
        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, years - 1);
    }
}