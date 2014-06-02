package com.fluffy_minions.prototype.needsCalculators;

/**
 * This class stores and computes the necessary proteins for a person in a day.
 */
public class TotalProteinsCalculator {

    /**
     * The fields represent the necessary proteins,
     * the minimum necessary proteins and the maximum number of proteins
     * in a day.
     */
	private double proteins;
	private double minProteins;
	private double maxProteins;

    /**
     * This method returns the minimum proteins needed in a day.
     * @return minProteins
     */
	public double getMinProteins() {
		return minProteins;
	}

    /**
     * This method returns the maximum proteins needed in a day.
     * @return maxProteins
     */
	public double getMaxProteins() {
		return maxProteins;
	}

    /**
     * This method returns the number of proteins computed based on a person's details.
     * @return proteins
     */
	public double getProteins() {
		return proteins;
	}

    /**
     * This method changes the value of the proteins.
     * @param proteins new value for the proteins
     */
	public void setProteins(double proteins) {
		this.proteins = proteins;
	}

    /**
     * This method computes the proteins according the person's profile details,
     * their weight and activity level.
     * @param profile
     * @return value of the proteins
     */
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

    /**
     * This method computes the minimum proteins, representing 90% of the computed proteins.
     * @param profile
     * @return value of the minProteins
     */
	public double computeMinProteins(PersonalProfile profile) {
		minProteins = 0.9 * this.computeProteins(profile);
		return minProteins;
	}

    /**
     * This method computes the maximum proteins, representing 110% of the computed proteins.
     * @param profile
     * @return value of the maxProteins
     */
	public double computeMaxProteins(PersonalProfile profile) {
		maxProteins = 1.1 * this.computeProteins(profile);
		return maxProteins;
	}
	
}
