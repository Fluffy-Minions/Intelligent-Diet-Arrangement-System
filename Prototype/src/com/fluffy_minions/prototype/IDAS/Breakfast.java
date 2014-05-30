package com.fluffy_minions.prototype.IDAS;

import java.util.ArrayList;
import java.util.Arrays;
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

/**
 * The class Breakfast contains the food that is chosen
 * for breakfast and the minimum requirements for breakfast.
 */

public class Breakfast extends GenericMeal implements IMeal {

    /**
     * This constructor retrieves all the food from
     * the appropriate tables and stores it in dbRows.
     * @param sqLiteHelper
     * @param personalProfile information about a person (age, weight, height, activity level)
     */

    public Breakfast(SQLiteHelper sqLiteHelper, PersonalProfile personalProfile) {

        SQLiteDatabase db = sqLiteHelper.getReadableDatabase();

        for(String table : this.getTables()) {
            Cursor c = db.rawQuery("SELECT * FROM " + table + " WHERE BREAKFAST = 1", null);

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

        names = dbRows.getNames();
        ingredients = dbRows.getIngredients();
        minimumRequiredIngredients = dbRows.getMinimumRequiredIngredients(personalProfile, 1);
        maximumRequiredIngredients = dbRows.getMaximumRequiredIngredients(personalProfile, 1);
        prices = dbRows.getPrices();
        ingredientsMatrix = dbRows.getIngredientsMatrix();

        regenerate();
    }

    @Override

    public String[] getTables(){
		return new String[] { "BAUTURI", "OUA", "CEREALE", "FRUCTE", "LACTATE", "LEGUME", "PREPARATE_CARNE", "PREPARATE_FARA_CARNE"
		};
	}

}
