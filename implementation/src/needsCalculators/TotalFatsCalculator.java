package needsCalculators;

public class TotalFatsCalculator {
	private double fats;

	public double getFats() {
		return fats;
	}

	public void setFats(double fats) {
		this.fats = fats;
	}
	
	public double computeFats(double calories) {
		fats = (0.3 * calories)/9; //apparently here we have to divide by 9 in order to transform from calories in grams
		return fats;	
	}
}
