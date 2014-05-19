package com.fluffy_minions.prototype.needsCalculators;

public class TotalCaloriesCalculator {
	private double bmr;
	private double finalTDEE;

	public double getBmr() {
		return bmr;
	}

	public void setBmr(double bmr) {
		this.bmr = bmr;
	}
	
	public double getTDEE(){
		return finalTDEE;
	}

	public double computeBMR(PersonalProfile profile) {
		if(profile.getGender().equals("Male")) {
			bmr = (88.362 + (double)(13.397 * profile.getWeight()) + (double)(4.799 * profile.getHeight()) - (5.677 * profile.getAge()));
		}
		else {
			bmr = (447.593 + (double)(9.247 * profile.getWeight()) + (double)(3.098 * profile.getHeight()) - (4.330 * profile.getAge()));
		}
		return bmr;
	}
		
	public double computeTDEE(PersonalProfile profile)
	{
		bmr = this.computeBMR(profile);
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
	        return finalTDEE;
	    }

}
