package com.fluffy_minions.prototype.food;

import com.fluffy_minions.prototype.IDAS.IMeal;
import com.fluffy_minions.prototype.needsCalculators.PersonalProfile;
import com.fluffy_minions.prototype.needsCalculators.TotalNeedsCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by sorin on 5/19/14.
 */
public class DBRows {
	private List<DBRow> rows = new ArrayList<DBRow>();

	public void add(DBRow row) {
		rows.add(row);
	}

	public String[] getNames() {
		List<String> names = new ArrayList<String>();
		for (DBRow row:rows) {
			names.add(row.getName());
		}
		return names.toArray(new String[rows.size()]);
	}

	public String[] getIngredients() {
		String[] ingredients = { "CALORIES" , "FATS" , "CARBS" , "FIBER", "PROTEINS" };
		return ingredients;
	}

	public int[] getMinimumRequiredIngredients(PersonalProfile profile, int type) {
		TotalNeedsCalculator calculator = new TotalNeedsCalculator();
        calculator.setPersonalProfile(profile);
		calculator.computeNeeds();
		if (type == 1)			//if type breakfast
			return new int[] {(int)calculator.getBreakfastCalories(), (int)calculator.getBreakfastFats(),
				(int)calculator.getBreakfastCarbs(), (int)calculator.getBreakfastFiber(), 
				(int)calculator.getBreakfastProteins()};

		else
			if(type ==2)		//if type lunch
				return new int[] {(int)calculator.getLunchCalories(), (int)calculator.getLunchFats(),
					(int)calculator.getLunchCarbs(), (int)calculator.getLunchFiber(), 
					(int)calculator.getLunchProteins()};

			else					//if type dinner
				return new int[] {(int)calculator.getDinnerCalories(), (int)calculator.getDinnerFats(),
					(int)calculator.getDinnerCarbs(), (int)calculator.getDinnerFiber(), 
					(int)calculator.getDinnerProteins()};

	}

	public int[] getPrices() {
		Random random = new Random();
		return new int[] { random.nextInt(50) + 1,  random.nextInt(50) + 1, random.nextInt(50) + 1, random.nextInt(50) + random.nextInt(50) + 1 };
	}

	public int[][] getIngredientsMatrix() {
		int[][] ingredients = new int[getIngredients().length][rows.size()];
		for(int i = 0;  i < this.getIngredients().length; i++) {
			for(int j = 0;  j < rows.size(); j++) {
				if(i == 0) {
					ingredients[i][j] = rows.get(j).getCalories();
				}
				else {
					if( i == 1) {
						ingredients[i][j] = rows.get(j).getFats();
					} 
					else if( i == 2 ) {
						ingredients[i][j] = rows.get(j).getCarbs();
					} 
					else if( i == 3) {
						ingredients[i][j] = rows.get(j).getFibers();
					} 
					else {
						ingredients[i][j] = rows.get(j).getProteins();
					}
				}
			}
		}
		return ingredients;
	}
}
