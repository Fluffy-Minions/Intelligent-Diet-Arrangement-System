package needsCalculators;

public class TotalCarbsCalculator {
	private double carbs;

	public double getCarbs() {
		return carbs;
	}

	public void setCarbs(double carbs) {
		this.carbs = carbs;
	}
	
	public double computeCarbs(double calories) {
		carbs = (0.4 * calories)/4; // apparently here we have to divide by 4 in order to transform from calories in grams
		return carbs;
	}
}
