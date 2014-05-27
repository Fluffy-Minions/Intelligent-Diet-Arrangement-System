package com.fluffy_minions.prototype.food;

import com.fluffy_minions.prototype.IDAS.IMeal;
import com.fluffy_minions.prototype.needsCalculators.PersonalProfile;
import com.fluffy_minions.prototype.needsCalculators.TotalNeedsCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class is used for the interaction between the JacoP library and
 * the database with every type of food.
 *
 * Created by sorin on 5/19/14.
 */

public class DBRows {

    /**
     * the list of rows in the database
     */

	private List<DBRow> rows = new ArrayList<DBRow>();

    /**
     * This method adds another row in the list of rows.
     */

	public void add(DBRow row) {
		rows.add(row);
	}

    /**
     * This method returns the name of the food.
     */

	public String[] getNames() {
		List<String> names = new ArrayList<String>();
		for (DBRow row:rows) {
			names.add(row.getName());
		}
		return names.toArray(new String[rows.size()]);
	}

    /**
     * This method returns the ingredients.
     */

	public String[] getIngredients() {
		String[] ingredients = { "CALORIES" , "FATS" , "CARBS" , "FIBER", "PROTEINS" };
		return ingredients;
	}

    /**
     * This method returns the minimum daily requirement for every ingredient.
      */

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

    /**
     * This method returns the list of random prices.
     */
	public int[] getPrices() {
		Random random = new Random();

        int[] prices = new int[getNames().length];
        int price = random.nextInt(50);
        for(int i = 0; i < prices.length; ++i) {
            prices[i] = price + 1;
        }

        return prices;

		//return new int[] { random.nextInt(50) + 1,  random.nextInt(50) + 1, random.nextInt(50) + 1, random.nextInt(50) + random.nextInt(50) + 1 };
	}


    /**
     * This method returns the number of ingredients (calories/fiber/etc.)
     * that every food in the database contains.
     */

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
