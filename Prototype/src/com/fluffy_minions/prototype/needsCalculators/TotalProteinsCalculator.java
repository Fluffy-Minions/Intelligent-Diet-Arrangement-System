package com.fluffy_minions.prototype.needsCalculators;

public class TotalProteinsCalculator {
	private double proteins;
	private double minProteins;
	private double maxProteins;
	
	public double getMinProteins() {
		return minProteins;
	}

	public double getMaxProteins() {
		return maxProteins;
	}

	public double getProteins() {
		return proteins;
	}

	public void setProteins(double proteins) {
		this.proteins = proteins;
	}

	public double computeProteins(PersonalProfile profile){
		double proteins = profile.getWeight();
		switch (profile.getActivityLevel())
		{
		case "Sedentary": 
			proteins = proteins * 0.8;
		case "Lightly active": 
			proteins = proteins * 1.0;
		case "Moderately active": 
			proteins = proteins * 1.3;
		case "Very active": 
			proteins = proteins * 1.5;
		case "Extremely active":
			proteins = proteins * 1.8;
		}
		return proteins;
	}	
	
	public double computeMinProteins(PersonalProfile profile) {
		minProteins = 0.9 * this.computeProteins(profile);
		return minProteins;
	}
	
	public double computeMaxProteins(PersonalProfile profile) {
		maxProteins = 1.1 * this.computeProteins(profile);
		return maxProteins;
	}
	
}
