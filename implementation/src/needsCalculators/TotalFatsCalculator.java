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
		fats = 0.20 * calories; 
		return fats;	
	}
}
