package com.fluffy_minions.prototype.needsCalculators;

public class TotalCarbsCalculator {
	private double carbs;
	private double minCarbs;
	private double maxCarbs;
	
	public double getMinCarbs() {
		return minCarbs;
	}

	public double getMaxCarbs() {
		return maxCarbs;
	}

	public double getCarbs() {
		return carbs;
	}

	public void setCarbs(double carbs) {
		this.carbs = carbs;
	}
	
	public double computeCarbs(double calories) {
		carbs = (0.4 * calories)/4; // apparently here we have to divide by 4 in order to transform from calories in grams
		return carbs;
	}
	
	public double computeMinCarbs(double calories) {
		minCarbs = 0.9 * this.computeCarbs(calories);
		return minCarbs;
	}
	
	public double computeMaxCarbs(double calories) {
		maxCarbs = 1.1 * this.computeCarbs(calories);
		return maxCarbs;
	}
}
