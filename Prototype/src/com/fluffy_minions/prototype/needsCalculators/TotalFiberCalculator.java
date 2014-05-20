package com.fluffy_minions.prototype.needsCalculators;

public class TotalFiberCalculator {
	private double fiber;
	private double minFiber;
	private double maxFiber;

	public double getMinFiber() {
		return minFiber;
	}

	public double getMaxFiber() {
		return maxFiber;
	}

	public double getFiber() {
		return fiber;
	}

	public void setFiber(double fiber) {
		this.fiber = fiber;
	}
	
	public double computeFiber(double calories){
		fiber = (calories*14)/1000;
		return fiber;
	}
	
	public double computeMinFiber() {
		minFiber = 0.9 * fiber;
		return minFiber;
	}
	
	public double computeMaxFiber() {
		maxFiber = 1.1 * fiber;
		return maxFiber;
	}

}
