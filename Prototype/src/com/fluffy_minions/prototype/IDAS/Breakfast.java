package com.fluffy_minions.prototype.IDAS;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.fluffy_minions.prototype.SQLiteHelper;
import com.fluffy_minions.prototype.food.DBRow;
import com.fluffy_minions.prototype.needsCalculators.PersonalProfile;
import com.fluffy_minions.prototype.needsCalculators.TotalNeedsCalculator;

public class Breakfast implements IMeal{
    private SQLiteHelper mSQLiteHelper;
    private String[] tables = new String[] { "BAUTURI", "OUA", "CEREALE", "FRUCTE", "LACTATE", "LEGUME", "PREPARATE_CARNE", "PREPARATE_FARA_CARNE" };
    private String[] columns = new String[] { "CALORIES", "FATS", "CARBS", "FIBER", "PROTEINS" };
    List<DBRow> all = new ArrayList<>();

    public Breakfast(SQLiteHelper sqLiteHelper) {
        mSQLiteHelper = sqLiteHelper;

        SQLiteDatabase db = sqLiteHelper.getReadableDatabase();

        for(String table : tables) {
            Cursor c = db.rawQuery("SELECT * FROM " + table, null);

            int[] indexes = new int[] { c.getColumnIndex("_id"),
            c.getColumnIndex("NAME"),
            c.getColumnIndex("BREAKFAST"),
            c.getColumnIndex("LUNCH"),
            c.getColumnIndex("DINNER"),
            c.getColumnIndex("NEEDS_SIDEDISH"),
            c.getColumnIndex("IS_SIDEDISH"),
            c.getColumnIndex("CALORIES"),
            c.getColumnIndex("PROTEINS"),
            c.getColumnIndex("FATS"),
            c.getColumnIndex("CARBS"),
            c.getColumnIndex("FIBER"),
            c.getColumnIndex("VITAMINS"),
            c.getColumnIndex("MINERALS") };

            while(c.moveToNext()) {
                all.add(new DBRow(
                   c.getLong(indexes[0]),
                   c.getString(indexes[1]),
                   c.getInt(indexes[2]),
                        c.getInt(indexes[3]),
                        c.getInt(indexes[4]),
                        c.getInt(indexes[5]),
                        c.getInt(indexes[6]),
                        c.getInt(indexes[7]),
                        c.getInt(indexes[8]),
                        c.getInt(indexes[9]),
                        c.getInt(indexes[10]),
                        c.getInt(indexes[11]),
                        c.getInt(indexes[12]),
                        c.getInt(indexes[13])
                ));
            }

            c.close();
        }
    }

	@Override
	public String[] getNames() {
		String s = "SELECT NAME FROM BAUTURI, OUA, CEREALE, FRUCTE, LACTATE, LEGUME, PREPARATE_CARNE, PREPARATE_FARA_CARNE WHERE BREAKFAST=1 ORDER BY NAME";

        return null;
	}

	@Override
	public String[] getIngredients() { 
		String s = "CALORIES, FATS, CARBS, FIBER, PROTEINS";
		return null;
	}

	@Override
	public int[] getMinimumRequiredIngredients(PersonalProfile profile) {
		TotalNeedsCalculator calculator = new TotalNeedsCalculator();
		calculator.computeNeeds();
		return new int[] {(int)calculator.getBreakfastCalories(), (int)calculator.getBreakfastFats(),
				(int)calculator.getBreakfastCarbs(), (int)calculator.getBreakfastFiber(), 
				(int)calculator.getBreakfastProteins()};
	}

	@Override
	public int[] getPrices() {
        Random random = new Random();
        return new int[] { random.nextInt(50) + 1,  random.nextInt(50) + 1, random.nextInt(50) + 1, random.nextInt(50) + random.nextInt(50) + 1 };
	}

	@Override
	public int[][] getIngredientsMatrix() {
		String s = "SELECT NAME, CALORIES, FATS, CARBS, FIBER, PROTEINS " +
				"FROM BAUTURI, OUA, CEREALE, FRUCTE, LACTATE, LEGUME, PREPARATE_CARNE, PREPARATE_FARA_CARNE" +
				"WHERE BREAKFAST=1 ORDER BY NAME";
		return null;
	}

}
