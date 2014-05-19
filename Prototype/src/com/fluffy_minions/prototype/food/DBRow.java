package com.fluffy_minions.prototype.food;

/**
 * Created by sorin on 5/19/14.
 */
public class DBRow {
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
    public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getBreakfast() {
		return breakfast;
	}

	public int getLunch() {
		return lunch;
	}

	public int getDinner() {
		return dinner;
	}

	public int getNeeds_sidedish() {
		return needs_sidedish;
	}

	public int getIs_sidedish() {
		return is_sidedish;
	}

	public int getCalories() {
		return calories;
	}

	public int getProteins() {
		return proteins;
	}

	public int getFats() {
		return fats;
	}

	public int getCarbs() {
		return carbs;
	}

	public int getFibers() {
		return fibers;
	}

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
