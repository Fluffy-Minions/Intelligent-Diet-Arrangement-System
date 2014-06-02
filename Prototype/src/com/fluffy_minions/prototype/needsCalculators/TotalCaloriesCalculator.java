package com.fluffy_minions.prototype.needsCalculators;

/**
 * This class stores and computes the necessary calories for a person in a day.
 */

public class TotalCaloriesCalculator {

    /**
     * The fields represent the basal metabolic rate,
     * the body mass index, the necessary calories,
     * the minimum necessary calories and the maximum number of calories
     * in a day.
     */
	private double bmr;
	private double bmi;
	private double finalTDEE;
	private double minCalories;
	private double maxCalories;

    /**
     * This method returns the basal metabolic rate.
     * @return bmr
     */

	public double getBmr() {
		return bmr;
	}

    /**
     * This method changes the value of the basal metabolic rate.
     * @param bmr new value for the bmr
     */

    public void setBmr(double bmr) {
		this.bmr = bmr;
	}

    /**
     * This method returns the number of necessary calories.
     * @return necessary calories
     */

	public double getTDEE(){
		return finalTDEE;
	}

    /**
     * This method returns the number of minimum necessary calories.
     * @return minimum necessary calories
     */

    public double getMinCalories() {
		return minCalories;
	}

    /**
     * This method returns the number of maximum calories.
     * @return maximum calories
     */

    public double getMaxCalories() {
		return maxCalories;
	}

    /**
     * This method computes the bmr according to the gender, age, weight
     * and height of the person.
     * @param profile information about the person
     * @return value of the bmr
     */

	public double computeBMR(PersonalProfile profile) {
		if(profile.getGender().equals("Male")) {
			bmr = 88.362 + 13.397 * profile.getWeight() + 4.799 * profile.getHeight() - 5.677 * profile.getAge();
		}
		else {
			bmr = 447.593 + 9.247 * profile.getWeight() + 3.098 * profile.getHeight() - 4.330 * profile.getAge();
		}
		return bmr;
	}

    /**
     * This method returns the number of calories for a day
     * according to the bmr and the bmi.
     * @param profile information about the person
     * @return  average number of calories necessary in a day
     */

	public double computeTDEE(PersonalProfile profile)
	{
		bmr = this.computeBMR(profile);
        bmi = this.computeBMI(profile);
		switch (profile.getActivityLevel())
		{
		case "Sedentary": 
			finalTDEE  = bmr * 1.2;
			break;
		case "Lightly active": 
			finalTDEE  = bmr * 1.375;
			break;
		case "Moderately active": 
			finalTDEE  = bmr * 1.55;
			break;
		case "Very active": 
			finalTDEE = bmr * 1.725;
			break;
		case "Extremely active":
			finalTDEE  = bmr * 1.9;
			break;
		}
		if ( bmi < 18.5 ) {
			finalTDEE = finalTDEE + 500;
		} else 
			if ( bmi > 25 ) {
				finalTDEE = finalTDEE - 500;
			} 
		return finalTDEE;
	}

    /**
     * This method computes the body mass index for a person.
     * @param profile information about the person
     * @return  bmi
     */

	public double computeBMI(PersonalProfile profile) {
		double height = profile.getHeight()/100;
		bmi = profile.getWeight() / (height * height);
		return bmi;
	}

    /**
     * This method computes the minimum number of calories that can be eaten in a day,
     * which is 10% less than the average number.
     * @param profile information about the person
     * @return        number of minimum calories
     */

    public double computeMinCalories(PersonalProfile profile) {
		minCalories = 0.9 * this.computeTDEE(profile);
		return minCalories;
	}

    /**
     * This method computes the maximum number of calories that can be eaten in a day,
     * which is 10% more than the average number.
     * @param profile information about the person
     * @return        number of maximum calories
     */

	public double computeMaxCalories(PersonalProfile profile) {
		maxCalories = 1.1 * this.computeTDEE(profile);
		return maxCalories;
	}
	
}
