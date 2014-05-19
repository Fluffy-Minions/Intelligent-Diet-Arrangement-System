package com.fluffy_minions.prototype.IDAS;

import com.fluffy_minions.prototype.food.DBRows;

public abstract class GenericMeal {
	protected DBRows dbRows = new DBRows();
	
	public abstract String[] getTables();

}
