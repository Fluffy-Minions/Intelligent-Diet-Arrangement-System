package IDAS;

import java.util.Random;

import needsCalculators.PersonalProfile;
import needsCalculators.TotalNeedsCalculator;

public class Breakfast implements IMeal{

	@Override
	public String[] getNames() {
		String s = "SELECT NAME FROM BAUTURI, OUA, CEREALE, FRUCTE, LACTATE, LEGUME, PREPARATE_CARNE, PREPARATE_FARA_CARNE" +
				"WHERE BREAKFAST=1 ORDER BY NAME";
		return null;
	}

	@Override
	public String[] getIngredients() { 
		String s = "CALORIES, FATS, CARBS, FIBER, PROTEINS";
		return null;
	}

	@Override
	public int[] getMinimumRequiredIngredients(PersonalProfile profile) {
		TotalNeedsCalculator calculator = new TotalNeedsCalculator();
		calculator.computeNeeds();
		return new int[] {(int)calculator.getBreakfastCalories(), (int)calculator.getBreakfastFats(),
				(int)calculator.getBreakfastCarbs(), (int)calculator.getBreakfastFiber(), 
				(int)calculator.getBreakfastProteins()};
	}

	@Override
	public int[] getPrices() {
        Random random = new Random();
        return new int[] { random.nextInt(50) + 1,  random.nextInt(50) + 1, random.nextInt(50) + 1, random.nextInt(50) + random.nextInt(50) + 1 };
	}

	@Override
	public int[][] getIngredientsMatrix() {
		String s = "SELECT NAME, CALORIES, FATS, CARBS, FIBER, PROTEINS " +
				"FROM BAUTURI, OUA, CEREALE, FRUCTE, LACTATE, LEGUME, PREPARATE_CARNE, PREPARATE_FARA_CARNE" +
				"WHERE BREAKFAST=1 ORDER BY NAME";
		return null;
	}

}
