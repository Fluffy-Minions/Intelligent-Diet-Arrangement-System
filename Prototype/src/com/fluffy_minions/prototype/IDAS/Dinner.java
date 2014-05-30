package com.fluffy_minions.prototype.IDAS;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.fluffy_minions.prototype.SQLiteHelper;
import com.fluffy_minions.prototype.food.DBRow;
import com.fluffy_minions.prototype.needsCalculators.PersonalProfile;
import com.fluffy_minions.prototype.needsCalculators.TotalNeedsCalculator;

public class Dinner extends GenericMeal implements IMeal {

    public Dinner(SQLiteHelper sqLiteHelper, PersonalProfile personalProfile) {

        SQLiteDatabase db = sqLiteHelper.getReadableDatabase();

        for(String table : this.getTables()) {
            Cursor c = db.rawQuery("SELECT * FROM " + table + " WHERE DINNER = 1", null);

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
        minimumRequiredIngredients = dbRows.getMinimumRequiredIngredients(personalProfile, 3);
        maximumRequiredIngredients = dbRows.getMaximumRequiredIngredients(personalProfile, 3);
        prices = dbRows.getPrices();
        ingredientsMatrix = dbRows.getIngredientsMatrix();

        regenerate();
    }

    public String[] getTables(){
			return new String[] { "CIORBE", "BAUTURI", "CEREALE", "DULCIURI", "FRUCTE", "GUILTY_PLEASURES", "LEGUME", "PREPARATE_CARNE", "PREPARATE_FARA_CARNE"};
		}

}
