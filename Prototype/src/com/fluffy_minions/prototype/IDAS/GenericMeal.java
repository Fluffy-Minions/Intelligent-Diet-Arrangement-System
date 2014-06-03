package com.fluffy_minions.prototype.IDAS;

import com.fluffy_minions.prototype.food.DBRows;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

/**
 * This class provides the requirements of one meal (breakfast/lunch/dinner),
 * the amount of ingredients that each food contains
 * and the rows in the database.
 */

public abstract class GenericMeal {

    /**
     * The fields are for logger, the names of every type of food,
     * the ingredients, the minimum and the maximum requirements,
     * the prices and the matrix with the amount of ingredients each type
     * of food contains.
     */

	protected DBRows dbRows = new DBRows();
    protected static final Logger LOGGER = Logger.getLogger(Breakfast.class.getName());
    protected String[] names;
    protected String[] ingredients;
    protected int[] minimumRequiredIngredients;
    protected int[] maximumRequiredIngredients;
    protected int[] prices;
    protected int[][] ingredientsMatrix;


    public abstract String[] getTables();

    /**
     * This method returns the names of every type of food.
     * @return food name
     */

    public String[] getNames() {
        return names;
    }

    /**
     * This method returns the ingredients.
     * @return ingredients
     */

    public String[] getIngredients() {
        return ingredients;
    }

    /**
     * This method provides the minimum number of calories/proteins/etc.
     * for the current meal.
     * @return min ingredients
     */

    public int[] getMinimumRequiredIngredients() {
        return minimumRequiredIngredients;
    }

    /**
     * This method provides the maximum number of calories/proteins/etc.
     * for the current meal.
     * @return max ingredients
     */

    public int[] getMaximumRequiredIngredients() { return maximumRequiredIngredients; }


    public int[] getPrices() {
        return prices;
    }

    /**
     * This method returns the number of calories/proteins/fiber/etc. for every type of food.
     * @return matrix containing the ingredients for every food
     */

    public int[][] getIngredientsMatrix() {
        return ingredientsMatrix;
    }

    /**
     * This method selects a number of random
     * types of food from the database
     * for a new menu.
     */

    public void regenerate() {
        int size = 40;
        String[] newNames = new String[size];
        int[] newPrices = new int[size];
        int[][] newMatrix = new int[ingredients.length][size];

        Random random = new Random();
        List<Integer> randoms = new ArrayList<>();
        int rnd = 0;
        for(int i = 0; i < size; ++i) {
            do {
                rnd = random.nextInt(names.length);
            } while(randoms.contains(rnd));

            randoms.add(rnd);
        }

        for(int i = 0; i < size; ++i) {
            newNames[i] = names[randoms.get(i)];
            newPrices[i] = prices[randoms.get(i)];

            for(int k = 0; k < ingredients.length; ++k) {
                newMatrix[k][i] = ingredientsMatrix[k][randoms.get(i)];
            }
        }

        names = newNames;
        prices = newPrices;
        ingredientsMatrix = newMatrix;

    }

}
