package com.fluffy_minions.prototype.needsCalculators;

/**
 * This class represents the needs according to the meal and the percentage.
 * For instance, you can compute the calories for breakfast according to
 * the percentage from the total calories.
 */

public class MealNeeds {

    /**
     * This method computes the number of calories/proteins/fiber/etc. for a meal (breakfast/lunch/dinner).
     * @param percentage percentage according to meal
     * @param needs      number of total calories/proteins/fiber/etc.
     * @return           calories/proteins/fiber/etc. for the current meal
     */

	public double computeNeeds(double percentage, double needs){
		return percentage*needs;
	}
}
