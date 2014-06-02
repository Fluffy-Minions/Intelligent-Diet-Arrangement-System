package com.fluffy_minions.prototype.needsCalculators;

/**
 * This class stores and computes the necessary minerals for a person in a day.
 */
public class TotalMineralsCalculator {
    /**
     * The fields represent the necessary minerals in a day.
     */
	private double minerals;

    /**
     * This method returns the minerals needed in a day.
     * @return minerals
     */
	public double getMinerals() {
		return minerals;
	}

    /**
     * This method changes the value of the minerals.
     * @param minerals new value for the minerals
     */
	public void setMinerals(double minerals) {
		this.minerals = minerals;
	}

    /**
     * This method computes the minerals according to the amount of calories.
     * @param calories
     * @return value of the minerals
     */
	public double computeMinerals(double calories) {
		// here we do the computation for the minerals needed daily
		return minerals;
	}
}
