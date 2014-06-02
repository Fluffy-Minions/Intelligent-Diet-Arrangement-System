package com.fluffy_minions.prototype.needsCalculators;

/**
 * This class stores and computes the necessary vitamins for a person in a day.
 */
public class TotalVitaminsCalculator {
    /**
     * The fields represent the necessary vitamins in a day.
     */
	private double vitamins;

    /**
     * This method returns the vitamins needed in a day.
     * @return vitamins
     */
	public double getVitamins() {
		return vitamins;
	}

    /**
     * This method changes the value of the vitamins.
     * @param vitamins new value for the vitamins
     */
	public void setVitamins(double vitamins) {
		this.vitamins = vitamins;
	}

    /**
     * This method computes the vitamins according to the amount of calories.
     * @param calories
     * @return value of the vitamins
     */
	public double computeVitamins(double calories) {
		// here we do the computation for the vitamins needed daily
		return vitamins;
	}
}
