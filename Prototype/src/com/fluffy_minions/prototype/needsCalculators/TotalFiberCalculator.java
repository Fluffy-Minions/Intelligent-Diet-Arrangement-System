package com.fluffy_minions.prototype.needsCalculators;

/**
 * This class stores and computes the necessary fiber for a person in a day.
 */
public class TotalFiberCalculator {
    /**
     * The fields represent the necessary fiber,
     * the minimum necessary fiber and the maximum number of fiber
     * in a day.
     */
	private double fiber;
	private double minFiber;
	private double maxFiber;

    /**
     * This method returns the minimum fiber needed in a day.
     * @return minFiber
     */
	public double getMinFiber() {
		return minFiber;
	}

    /**
     * This method returns the maximum fiber allowed in a day.
     * @return maxFiber
     */
	public double getMaxFiber() {
		return maxFiber;
	}

    /**
     * This method returns the number of fiber computed based on a person's details.
     * @return fiber
     */
	public double getFiber() {
		return fiber;
	}

    /**
     * This method changes the value of the fiber.
     * @param fiber new value for the fiber
     */
	public void setFiber(double fiber) {
		this.fiber = fiber;
	}

    /**
     * This method computes the fiber according to the amount of calories.
     * @param calories
     * @return value of the fiber
     */
	public double computeFiber(double calories){
		fiber = (calories*14)/1000;
		return fiber;
	}

    /**
     * This method computes the minimum fiber, representing 90% of the computed fiber.
     * @param calories
     * @return value of the minFiber
     */
	public double computeMinFiber(double calories) {
		minFiber = 0.9 * this.computeFiber(calories);
		return minFiber;
	}

    /**
     * This method computes the maximum fiber, representing 110% of the computed fiber.
     * @param calories
     * @return value of the maxFiber
     */
	public double computeMaxFiber(double calories) {
		maxFiber = 1.1 * this.computeFiber(calories);
		return maxFiber;
	}

}
