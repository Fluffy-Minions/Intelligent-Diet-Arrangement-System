package com.fluffy_minions.prototype.needsCalculators;

/**
 * This class stores and computes all the necessary ingredients a person needs in a day.
 */
public class TotalNeedsCalculator {

    /**
     * We need to instantiate a calculator for each ingredient needed,
     * a profile which will be used to computed some of the needs and
     * a mealNeeds which represents the percentage of ingredients needed for each of the three daily meals.
     */
	private TotalProteinsCalculator proteinsCalculator = new TotalProteinsCalculator();
	private TotalCaloriesCalculator caloriesCalculator = new TotalCaloriesCalculator();
	private TotalFiberCalculator fiberCalculator = new TotalFiberCalculator();
	private TotalFatsCalculator fatsCalculator = new TotalFatsCalculator();
	private TotalCarbsCalculator carbsCalculator = new TotalCarbsCalculator();
	private PersonalProfile profile;
	private MealNeeds mealNeeds = new MealNeeds();

    /**
     * The fields represent each of the five categories of ingredients:
     * calories, proteins, fiber, fats, carbs used for each of the three meals of the day:
     * breakfast, lunch and dinner.
     */
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

    /**
     * This method returns the necessary calories computed in the caloriesCalculator.
     * @return calories
     */
	public double getNecessaryCalories(){
		return caloriesCalculator.getTDEE();
	}

    /**
     * This method returns the necessary proteins computed in the proteinsCalculator.
     * @return proteins
     */
	public double getNecessaryProteins(){
		return proteinsCalculator.getProteins();
	}

    /**
     * This method returns the necessary fibers computed in the fiberCalculator.
     * @return fiber
     */
	public double getNecessaryFiber(){
		return fiberCalculator.getFiber();
	}

    /**
     * This method returns the necessary fats computed in the fiberCalculator.
     * @return fats
     */
    public double getNecessaryFats(){
        return fatsCalculator.getFats();
    }

    /**
     * This method returns the necessary calories for breakfast.
     * @return breakfastCalories
     */
	public double getBreakfastCalories() {
		return breakfastCalories;
	}

    /**
     * This method returns the necessary fibers for breakfast.
     * @return breakfastFiber
     */
	public double getBreakfastFiber() {
		return breakfastFiber;
	}

    /**
     * This method returns the necessary proteins for breakfast.
     * @return breakfastProteins
     */
	public double getBreakfastProteins() {
		return breakfastProteins;
	}

    /**
     * This method returns the necessary fats for breakfast.
     * @return breakfastFats
     */
	public double getBreakfastFats() {
		return breakfastFats;
	}

    /**
     * This method returns the necessary carbs for breakfast.
     * @return breakfastCarbs
     */
	public double getBreakfastCarbs() {
		return breakfastCarbs;
	}

    /**
     * This method returns the necessary calories for lunch.
     * @return lunchCalories
     */
	public double getLunchCalories() {
		return lunchCalories;
	}

    /**
     * This method returns the necessary fibers for lunch.
     * @return lunchFiber
     */
	public double getLunchFiber() {
		return lunchFiber;
	}

    /**
     * This method returns the necessary proteins for lunch.
     * @return lunchProteins
     */
	public double getLunchProteins() {
		return lunchProteins;
	}

    /**
     * This method returns the necessary fats for lunch.
     * @return lunchFats
     */
	public double getLunchFats() {
		return lunchFats;
	}

    /**
     * This method returns the necessary carbs for lunch.
     * @return lunchCarbs
     */
	public double getLunchCarbs() {
		return lunchCarbs;
	}

    /**
     * This method returns the necessary calories for dinner.
     * @return dinnerCalories
     */
	public double getDinnerCalories() {
		return dinnerCalories;
	}

    /**
     * This method returns the necessary fibers for dinner.
     * @return dinnerFiber
     */
	public double getDinnerFiber() {
		return dinnerFiber;
	}

    /**
     * This method returns the necessary proteins for dinner.
     * @return dinnerProteins
     */
	public double getDinnerProteins() {
		return dinnerProteins;
	}

    /**
     * This method returns the necessary fats for dinner.
     * @return dinnerFats
     */
	public double getDinnerFats() {
		return dinnerFats;
	}

    /**
     * This method returns the necessary carbs for dinner.
     * @return dinnerCarbs
     */
	public double getDinnerCarbs() {
		return dinnerCarbs;
	}

    /**
     * This method returns the person's specified profile.
     * @return profile
     */
	public PersonalProfile getPersonalProfile() {
		return profile;
	}

    /**
     * This method changes the value of the personalProfile.
     * @param personalProfile new value for the personalProfile
     */
	public void setPersonalProfile(PersonalProfile personalProfile) {
		this.profile = personalProfile;
	}

    /**
     * This method computes all the minimum needs for each of the three daily meals.
     */
	public void computeMinNeeds(){
		double totalCalories = caloriesCalculator.computeMinCalories(profile);
		double totalFiber = fiberCalculator.computeMinFiber(totalCalories);
		double totalProteins = proteinsCalculator.computeMinProteins(profile);
		double totalFats = fatsCalculator.computeMinFats(totalCalories);
		double totalCarbs = carbsCalculator.computeMinCarbs(totalCalories);

        /**
         * Breakfast needs represent 30% of the entire day's needs.
         */
		breakfastCalories = mealNeeds.computeNeeds(0.3, totalCalories);
		breakfastFiber = mealNeeds.computeNeeds(0.3, totalFiber);
		breakfastProteins = mealNeeds.computeNeeds(0.3, totalProteins);
		breakfastFats = mealNeeds.computeNeeds(0.3, totalFats);
		breakfastCarbs = mealNeeds.computeNeeds(0.3, totalCarbs);

        /**
         * Lunch needs represent 45% of the entire day's needs.
         */
		lunchCalories = mealNeeds.computeNeeds(0.45, totalCalories);
		lunchFiber = mealNeeds.computeNeeds(0.45, totalFiber);
		lunchProteins = mealNeeds.computeNeeds(0.45, totalProteins);
		lunchFats = mealNeeds.computeNeeds(0.45, totalFats);
		lunchCarbs = mealNeeds.computeNeeds(0.45, totalCarbs);

        /**
         * Breakfast needs represent 25% of the entire day's needs.
         */
		dinnerCalories = mealNeeds.computeNeeds(0.25, totalCalories);
		dinnerFiber = mealNeeds.computeNeeds(0.25, totalFiber);
		dinnerProteins = mealNeeds.computeNeeds(0.25, totalProteins);
		dinnerFats = mealNeeds.computeNeeds(0.25, totalFats);
		dinnerCarbs = mealNeeds.computeNeeds(0.25, totalCarbs);

	}

    /**
     * This method computes all the maximum needs for each of the three daily meals.
     */
    public void computeMaxNeeds(){
        double totalCalories = caloriesCalculator.computeMaxCalories(profile);
        double totalFiber = fiberCalculator.computeMaxFiber(totalCalories);
        double totalProteins = proteinsCalculator.computeMaxProteins(profile);
        double totalFats = fatsCalculator.computeMaxFats(totalCalories);
        double totalCarbs = carbsCalculator.computeMaxCarbs(totalCalories);

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
