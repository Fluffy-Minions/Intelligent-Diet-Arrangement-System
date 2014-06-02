package com.fluffy_minions.prototype.needsCalculators;

/**
 * This class stores and computes the necessary fats for a person in a day.
 */

public class TotalFatsCalculator {

    /**
     * The fields represent the necessary fats,
     * the minimum necessary fats and the maximum number of fats
     * in a day.
     */
	private double fats;
	private double minFats;
	private double maxFats;

    /**
     * This method returns the minimum fats needed in a day.
     * @return minFats
     */
	public double getMinFats() {
		return minFats;
	}

    /**
     * This method returns the maximum fats allowed in a day.
     * @return maxFats
     */
	public double getMaxFats() {
		return maxFats;
	}

    /**
     * This method returns the number of fats computed based on a person's details.
     * @return fats
     */
	public double getFats() {
		return fats;
	}

    /**
     * This method changes the value of the fats.
     * @param fats new value for the fats
     */
	public void setFats(double fats) {
		this.fats = fats;
	}

    /**
     * This method computes the fats according to the amount of calories.
     * @param calories
     * @return value of the fats
     */
	public double computeFats(double calories) {
		fats = (0.3 * calories)/9;
		return fats;	
	}

    /**
     * This method computes the minimum fats, representing 90% of the computed fats.
     * @param calories
     * @return value of the minFats
     */
	public double computeMinFats(double calories) {
		minFats = 0.9 * this.computeFats(calories);
		return minFats;
	}

    /**
     * This method computes the maximum fats, representing 110% of the computed fats.
     * @param calories
     * @return value of the maxFats
     */
	public double computeMaxFats(double calories) {
		maxFats = 1.1 * this.computeFats(calories);
		return maxFats;
	}
}
