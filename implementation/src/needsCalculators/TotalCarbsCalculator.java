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
		carbs = 0.5 * calories;
		return carbs;
	}
}
