package needsCalculators;

public class TotalProteinsCalculator {
	double proteins;
	
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
	
}
