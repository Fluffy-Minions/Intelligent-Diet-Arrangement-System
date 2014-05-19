package needsCalculators;

public class TotalNeedsCalculator {
	private TotalProteinsCalculator proteinsCalculator = new TotalProteinsCalculator();
	private TotalCaloriesCalculator caloriesCalculator = new TotalCaloriesCalculator();
	private TotalFiberCalculator fiberCalculator = new TotalFiberCalculator();
	private TotalFatsCalculator fatsCalculator = new TotalFatsCalculator();
	private TotalCarbsCalculator carbsCalculator = new TotalCarbsCalculator();
	private PersonalProfile profile;
	private MealNeeds mealNeeds = new MealNeeds();
	
	double breakfastCalories;
	double breakfastFiber;
	double breakfastProteins;
	double breakfastFats;
	double breakfastCarbs;
	double lunchCalories;
	double lunchFiber;
	double lunchProteins;
	double lunchFats;
	double lunchCarbs;
	double dinnerCalories;
	double dinnerFiber;
	double dinnerProteins;
	double dinnerFats;
	double dinnerCarbs;

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

	public void setBreakfastCalories(double breakfastCalories) {
		this.breakfastCalories = breakfastCalories;
	}

	public double getBreakfastFiber() {
		return breakfastFiber;
	}

	public void setBreakfastFiber(double breakfastFiber) {
		this.breakfastFiber = breakfastFiber;
	}

	public double getBreakfastProteins() {
		return breakfastProteins;
	}

	public void setBreakfastProteins(double breakfastProteins) {
		this.breakfastProteins = breakfastProteins;
	}

	public double getBreakfastFats() {
		return breakfastFats;
	}

	public void setBreakfastFats(double breakfastFats) {
		this.breakfastFats = breakfastFats;
	}

	public double getBreakfastCarbs() {
		return breakfastCarbs;
	}

	public void setBreakfastCarbs(double breakfastCarbs) {
		this.breakfastCarbs = breakfastCarbs;
	}

	public double getLunchCalories() {
		return lunchCalories;
	}

	public void setLunchCalories(double lunchCalories) {
		this.lunchCalories = lunchCalories;
	}

	public double getLunchFiber() {
		return lunchFiber;
	}

	public void setLunchFiber(double lunchFiber) {
		this.lunchFiber = lunchFiber;
	}

	public double getLunchProteins() {
		return lunchProteins;
	}

	public void setLunchProteins(double lunchProteins) {
		this.lunchProteins = lunchProteins;
	}

	public double getLunchFats() {
		return lunchFats;
	}

	public void setLunchFats(double lunchFats) {
		this.lunchFats = lunchFats;
	}

	public double getLunchCarbs() {
		return lunchCarbs;
	}

	public void setLunchCarbs(double lunchCarbs) {
		this.lunchCarbs = lunchCarbs;
	}

	public double getDinnerCalories() {
		return dinnerCalories;
	}

	public void setDinnerCalories(double dinnerCalories) {
		this.dinnerCalories = dinnerCalories;
	}

	public double getDinnerFiber() {
		return dinnerFiber;
	}

	public void setDinnerFiber(double dinnerFiber) {
		this.dinnerFiber = dinnerFiber;
	}

	public double getDinnerProteins() {
		return dinnerProteins;
	}

	public void setDinnerProteins(double dinnerProteins) {
		this.dinnerProteins = dinnerProteins;
	}

	public double getDinnerFats() {
		return dinnerFats;
	}

	public void setDinnerFats(double dinnerFats) {
		this.dinnerFats = dinnerFats;
	}

	public double getDinnerCarbs() {
		return dinnerCarbs;
	}

	public void setDinnerCarbs(double dinnerCarbs) {
		this.dinnerCarbs = dinnerCarbs;
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
