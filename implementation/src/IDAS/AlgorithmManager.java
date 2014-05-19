package IDAS;

import java.sql.Connection;
import java.sql.DriverManager;

import needsCalculators.TotalCaloriesCalculator;

public class AlgorithmManager {
	private IStorage database = new SQLiteStorage();
	private MealGenerator generator = new MealGenerator();
	private TotalCaloriesCalculator calculator;
	
	public static void main(String[] args){

	}

}
