package needsCalculators;

public class TotalFiberCalculator {
	private double fiber;

	public double getFiber() {
		return fiber;
	}

	public void setFiber(double fiber) {
		this.fiber = fiber;
	}
	
	public double computeFiber(double calories){
		fiber = (calories*14)/1000;
		return fiber;
	}

}
