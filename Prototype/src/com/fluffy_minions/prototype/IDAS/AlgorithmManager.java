package com.fluffy_minions.prototype.IDAS;

import com.fluffy_minions.prototype.needsCalculators.TotalCaloriesCalculator;

public class AlgorithmManager {
	private IStorage database = new SQLiteStorage();
	private MealGenerator generator = new MealGenerator();
	private TotalCaloriesCalculator calculator;
	
	public static void main(String[] args){

	}

}
