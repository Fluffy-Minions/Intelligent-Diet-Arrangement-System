package com.fluffy_minions.prototype.IDAS;
import java.util.ArrayList;
import java.util.List;

import com.fluffy_minions.prototype.food.Food;



public class MealGenerator {
	private List <Meal> meals = new ArrayList <>();
	private List <Food> food = new ArrayList <>();
	
	public void prepareMeal(){
		
	}

	public List<Food> getFood() {
		return food;
	}

	public void setFood(List<Food> food) {
		this.food = food;
	}

	public List<Meal> getMeals() {
		return meals;
	}

	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}
}
