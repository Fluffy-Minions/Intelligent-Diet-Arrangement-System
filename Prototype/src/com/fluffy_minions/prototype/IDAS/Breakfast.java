package com.fluffy_minions.prototype.IDAS;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.fluffy_minions.prototype.SQLiteHelper;
import com.fluffy_minions.prototype.food.DBRow;
import com.fluffy_minions.prototype.food.DBRows;
import com.fluffy_minions.prototype.needsCalculators.PersonalProfile;
import com.fluffy_minions.prototype.needsCalculators.TotalNeedsCalculator;

public class Breakfast implements IMeal, extends GenericMeal{
    private static final Logger LOGGER = Logger.getLogger(Breakfast.class.getName());

    public Breakfast(SQLiteHelper sqLiteHelper) {

        SQLiteDatabase db = sqLiteHelper.getReadableDatabase();

        for(String table : this.getTables()) {
            Cursor c = db.rawQuery("SELECT * FROM " + table, null);

            int[] indexes = new int[] {
                c.getColumnIndex("_id"),
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
                c.getColumnIndex("MINERALS")
            };

            while(c.moveToNext()) {
                DBRow row = new DBRow(
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
                );

                dbRows.add(row);
            }

            c.close();
        }
    }

	@Override
	public String[] getNames() {
           return dbRows.getNames();
	}

	@Override
	public String[] getIngredients() { 
		return dbRows.getIngredients();
	}

	@Override
	public int[] getMinimumRequiredIngredients(PersonalProfile profile) {
		return dbRows.getMinimumRequiredIngredients(profile, 1);
	}

	@Override
	public int[] getPrices() {
        return dbRows.getPrices();
	}

	@Override
	public int[][] getIngredientsMatrix() {
		return dbRows.getIngredientsMatrix();
	}
	
	public String[] getTables(){
		return new String[] { "BAUTURI", "OUA", "CEREALE", "FRUCTE", "LACTATE", "LEGUME", "PREPARATE_CARNE", "PREPARATE_FARA_CARNE"
		};
	}

}
