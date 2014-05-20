package com.fluffy_minions.prototype.needsCalculators;

public class TotalFatsCalculator {
	private double fats;
	private double minFats;
	private double maxFats;

	public double getMinFats() {
		return minFats;
	}

	public double getMaxFats() {
		return maxFats;
	}

	public double getFats() {
		return fats;
	}

	public void setFats(double fats) {
		this.fats = fats;
	}
	
	public double computeFats(double calories) {
		fats = (0.3 * calories)/9; //apparently here we have to divide by 9 in order to transform from calories in grams
		return fats;	
	}
	
	public double computeMinFats() {
		minFats = 0.9 * fats;
		return minFats;
	}
	
	public double computeMaxFats() {
		maxFats = 1.1 * fats;
		return maxFats;
	}
}
