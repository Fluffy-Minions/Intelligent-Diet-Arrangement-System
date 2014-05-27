package com.fluffy_minions.prototype.food;

/**
 * This class represents a row in the food database
 * with all the columns it contains.
 * Created by sorin on 5/19/14.
 */

public class DBRow {

    /**
     * The class contains all the columns in the database.
     */

	private final String name;
    private final int breakfast;
    private final int lunch;
    private final int dinner;
    private final int needs_sidedish;
    private final int is_sidedish;
    private final int calories;
    private final int proteins;
    private final int fats;
    private final int carbs;
    private final int fibers;
    private final int vitamins;
    private final int minerals;
    private final long id;

    /**
     *
     * This method returns the id of the row in the table.
     * @return row id
     */

    public long getId() {
		return id;
	}

    /**
     * This method returns the name of the current food.
     * @return name of the food
     */

	public String getName() {
		return name;
	}

    /**
     * This method returns the breakfast.
     * @return breakfast
     */
	public int getBreakfast() {
		return breakfast;
	}

    /**
     * This method returns the lunch.
     * @return lunch
     */

	public int getLunch() {
		return lunch;
	}

    /**
     * This method returns the dinner.
     * @return dinner
     */

	public int getDinner() {
		return dinner;
	}

    /**
     * This method returns the field
     * that says whether the current food needs side-dish.
     * @return whether it needs side-dish or not
     */

	public int getNeeds_sidedish() {
		return needs_sidedish;
	}

    /**
     * This method returns the field
     * that says whether the current food is side-dish.
     * @return whether it is a side-dish or not
     */

    public int getIs_sidedish() {
		return is_sidedish;
	}

    /**
     * This method returns the number of calories
     * the food contains.
     * @return number of calories
     */

	public int getCalories() {
		return calories;
	}

    /**
     * This method returns the number of proteins
     * the food contains.
     * @return number of proteins
     */

	public int getProteins() {
		return proteins;
	}

    /**
     * This method returns the number of fats
     * the food contains.
     * @return number of fats
     */

	public int getFats() {
		return fats;
	}

    /**
     * This method returns the number of carbs
     * the food contains.
     * @return number of carbs
     */

    public int getCarbs() {
		return carbs;
	}

    /**
     * This method returns the number of fibers
     * the food contains.
     * @return number of fibers
     */

    public int getFibers() {
		return fibers;
	}

    /**
     * This constructor initializes every field of the class DBRow.
     * @param id                row id
     * @param name              food name
     * @param breakfast         whether it is appropriate for breakfast
     * @param lunch             whether it is appropriate for lunch
     * @param dinner            whether it is appropriate for dinner
     * @param needs_sidedish    whether it needs side-dish
     * @param is_sidedish       whether it is side-dish
     * @param calories          the number of calories it contains
     * @param proteins          the number of proteins it contains
     * @param fats              the number of fats it contains
     * @param carbs             the number of carbs it contains
     * @param fibers            the number of fibers it contains
     * @param vitamins          the number of vitamins it contains
     * @param minerals          the number of minerals it contains
     */

    public DBRow(long id, String name, int breakfast, int lunch, int dinner, int needs_sidedish, int is_sidedish, int calories, int proteins, int fats, int carbs, int fibers, int vitamins, int minerals) {
        this.id = id;
        this.name = name;
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
        this.needs_sidedish = needs_sidedish;
        this.is_sidedish = is_sidedish;
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.carbs = carbs;
        this.fibers = fibers;
        this.vitamins = vitamins;
        this.minerals = minerals;
    }
    
    
}
