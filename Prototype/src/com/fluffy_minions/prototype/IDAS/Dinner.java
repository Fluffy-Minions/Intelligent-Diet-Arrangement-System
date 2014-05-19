package com.fluffy_minions.prototype.IDAS;

import java.util.Random;

import com.fluffy_minions.prototype.needsCalculators.PersonalProfile;
import com.fluffy_minions.prototype.needsCalculators.TotalNeedsCalculator;

public class Dinner implements IMeal{

	@Override
	public String[] getNames() {
		String s = "SELECT NAME FROM GUILTY_PLEASURES, CIORBE, BAUTURI, OUA, CEREALE, FRUCTE, LACTATE, LEGUME, PREPARATE_CARNE, PREPARATE_FARA_CARNE" +
				"WHERE DINNER=1 ORDER BY NAME";
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
		return new int[] {(int)calculator.getDinnerCalories(), (int)calculator.getDinnerFats(),
				(int)calculator.getDinnerCarbs(), (int)calculator.getDinnerFiber(), 
				(int)calculator.getDinnerProteins()};
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
				"WHERE DINNER=1 ORDER BY NAME";
		return null;
	}

}
