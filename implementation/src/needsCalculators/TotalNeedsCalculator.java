package needsCalculators;


public class TotalNeedsCalculator {
	private TotalProteinsCalculator proteinsCalculator = new TotalProteinsCalculator();
	private TotalCaloriesCalculator caloriesCalculator = new TotalCaloriesCalculator();
	private TotalFiberCalculator fiberCalculator = new TotalFiberCalculator();
	private TotalFatsCalculator fatsCalculator = new TotalFatsCalculator();
	private PersonalProfile profile;

	public double getNecessaryCalories(){
		return caloriesCalculator.getTDEE();
	}

	public double getNecessaryProteins(){
		return proteinsCalculator.getProteins();
	}
	
	public double getNecessaryFiber(){
		return fiberCalculator.getFiber();
	}
	
	public double getNecessaryFats(){
		return fatsCalculator.getFats();
	}
	
	public PersonalProfile getPersonalProfile() {
		return profile;
	}
	public void setPersonalProfile(PersonalProfile personalProfile) {
		this.profile = personalProfile;
	}
	
	public void computeNeeds(){
		double calories = caloriesCalculator.computeTDEE(profile);
		fiberCalculator.computeFiber(calories);
		proteinsCalculator.computeProteins(profile);
		fatsCalculator.computeFats(calories);
	}
	
}
