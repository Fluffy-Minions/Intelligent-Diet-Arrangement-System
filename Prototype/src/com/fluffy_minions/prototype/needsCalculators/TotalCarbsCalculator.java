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
	
	public double computeMinCarbs() {
		minCarbs = 0.9 * carbs;
		return minCarbs;
	}
	
	public double computeMaxCarbs() {
		maxCarbs = 1.1 * carbs;
		return maxCarbs;
	}
}
