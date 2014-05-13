package bmrCalculator;

public class TotalCaloriesCalculator {
	private PersonalProfile profile;
	private double bmr;
	private double finalTDEE;
	
	public int getWeightKg() {
		return (int)(profile.getWeight() * 0.453592);
	}
	
	public int getHeightCm() {
		return (int)(profile.getHeight() * 2.54);
	}
	
	public double computeBMR() {
		if(profile.getGender() == "Male") {
			bmr = (88.362 + (double)(13.397 * getWeightKg()) + (double)(4.799 * getHeightCm()) - (5.677 * profile.getAge()));
		}else {
			bmr = (447.593 + (double)(9.247 * getWeightKg()) + (double)(3.098 * getHeightCm()) - (4.330 * profile.getAge()));
		}
		return bmr;
	}
	
	public double getTDEE(PersonalProfile profile)
	{
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
