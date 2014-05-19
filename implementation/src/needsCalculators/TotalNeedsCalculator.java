package needsCalculators;

public class TotalNeedsCalculator {
	private TotalProteinsCalculator proteinsCalculator = new TotalProteinsCalculator();
	private TotalCaloriesCalculator caloriesCalculator = new TotalCaloriesCalculator();
	private TotalFiberCalculator fiberCalculator = new TotalFiberCalculator();
	private TotalFatsCalculator fatsCalculator = new TotalFatsCalculator();
	private TotalCarbsCalculator carbsCalculator = new TotalCarbsCalculator();
	private PersonalProfile profile;
	private MealNeeds mealNeeds = new MealNeeds();
	
	private double breakfastCalories;
	private double breakfastFiber;
	private double breakfastProteins;
	private double breakfastFats;
	private double breakfastCarbs;
	private double lunchCalories;
	private double lunchFiber;
	private double lunchProteins;
	private double lunchFats;
	private double lunchCarbs;
	private double dinnerCalories;
	private double dinnerFiber;
	private double dinnerProteins;
	private double dinnerFats;
	private double dinnerCarbs;

	public double getNecessaryCalories(){
		return caloriesCalculator.getTDEE();
	}

	public double getNecessaryProteins(){
		return proteinsCalculator.getProteins();
	}

	public double getNecessaryFiber(){
		return fiberCalculator.getFiber();
	}

	public double getBreakfastCalories() {
		return breakfastCalories;
	}

	public double getBreakfastFiber() {
		return breakfastFiber;
	}

	public double getBreakfastProteins() {
		return breakfastProteins;
	}

	public double getBreakfastFats() {
		return breakfastFats;
	}

	public double getBreakfastCarbs() {
		return breakfastCarbs;
	}

	public double getLunchCalories() {
		return lunchCalories;
	}

	public double getLunchFiber() {
		return lunchFiber;
	}

	public double getLunchProteins() {
		return lunchProteins;
	}

	public double getLunchFats() {
		return lunchFats;
	}

	public double getLunchCarbs() {
		return lunchCarbs;
	}

	public double getDinnerCalories() {
		return dinnerCalories;
	}

	public double getDinnerFiber() {
		return dinnerFiber;
	}

	public double getDinnerProteins() {
		return dinnerProteins;
	}

	public double getDinnerFats() {
		return dinnerFats;
	}

	public double getDinnerCarbs() {
		return dinnerCarbs;
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
		double totalCalories = caloriesCalculator.computeTDEE(profile);
		double totalFiber = fiberCalculator.computeFiber(totalCalories);
		double totalProteins = proteinsCalculator.computeProteins(profile);
		double totalFats = fatsCalculator.computeFats(totalCalories);
		double totalCarbs = carbsCalculator.computeCarbs(totalCalories);

		breakfastCalories = mealNeeds.computeNeeds(0.3, totalCalories);
		breakfastFiber = mealNeeds.computeNeeds(0.3, totalFiber);
		breakfastProteins = mealNeeds.computeNeeds(0.3, totalProteins);
		breakfastFats = mealNeeds.computeNeeds(0.3, totalFats);
		breakfastCarbs = mealNeeds.computeNeeds(0.3, totalCarbs);

		lunchCalories = mealNeeds.computeNeeds(0.45, totalCalories);
		lunchFiber = mealNeeds.computeNeeds(0.45, totalFiber);
		lunchProteins = mealNeeds.computeNeeds(0.45, totalProteins);
		lunchFats = mealNeeds.computeNeeds(0.45, totalFats);
		lunchCarbs = mealNeeds.computeNeeds(0.45, totalCarbs);

		dinnerCalories = mealNeeds.computeNeeds(0.25, totalCalories);
		dinnerFiber = mealNeeds.computeNeeds(0.25, totalFiber);
		dinnerProteins = mealNeeds.computeNeeds(0.25, totalProteins);
		dinnerFats = mealNeeds.computeNeeds(0.25, totalFats);
		dinnerCarbs = mealNeeds.computeNeeds(0.25, totalCarbs);

	}

}
