package com.fluffy_minions.prototype.needsCalculators;

/**
 * This class stores and computes the necessary carbs for a person in a day.
 */

public class TotalCarbsCalculator {

    /**
     * The fields represent the necessary carbs,
     * the minimum necessary carbs and the maximum number of carbs
     * in a day.
     */
	private double carbs;
	private double minCarbs;
	private double maxCarbs;

    /**
     * This method returns the minimum carbs needed in a day.
     * @return minCarbs
     */
	public double getMinCarbs() {
		return minCarbs;
	}

    /**
     * This method returns the maximum carbs allowed in a day.
     * @return maxCarbs
     */
	public double getMaxCarbs() {
		return maxCarbs;
	}

    /**
     * This method returns the number of carbs computed based on a person's details.
     * @return carbs
     */
	public double getCarbs() {
		return carbs;
	}

    /**
     * This method changes the value of the carbs.
     * @param carbs new value for the carbs
     */
	public void setCarbs(double carbs) {
		this.carbs = carbs;
	}

    /**
     * This method computes the carbs according to the amount of calories.
     * @param calories
     * @return value of the carbs
     */
    public double computeCarbs(double calories) {
		carbs = (0.4 * calories)/4; // apparently here we have to divide by 4 in order to transform from calories in grams
		return carbs;
	}

    /**
     * This method computes the minimum carbs, representing 90% of the computed carbs.
     * @param calories
     * @return value of the minCarbs
     */
	public double computeMinCarbs(double calories) {
		minCarbs = 0.9 * this.computeCarbs(calories);
		return minCarbs;
	}

    /**
     * This method computes the maximum carbs, representing 110% of the computed carbs.
     * @param calories
     * @return value of the maxCarbs
     */
	public double computeMaxCarbs(double calories) {
		maxCarbs = 1.1 * this.computeCarbs(calories);
		return maxCarbs;
	}
}
