package com.fluffy_minions.prototype.IDAS;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.fluffy_minions.prototype.SQLiteHelper;
import com.fluffy_minions.prototype.food.*;
import com.fluffy_minions.prototype.needsCalculators.PersonalProfile;

/**
 * The class Lunch contains the food that can be chosen
 * for lunch and the minimum requirements for lunch.
 */

public class Lunch extends GenericMeal {

    /**
     * This constructor retrieves the food from the appropriate tables and stores it.
     * Also, it computes the minimum requirements for the current profile and generates meals.
     * @param sqLiteHelper    interacts with the database
     * @param profile         information about a person (age, weight, height, activity level)
     */

    public Lunch(SQLiteHelper sqLiteHelper, PersonalProfile profile) {

        SQLiteDatabase db = sqLiteHelper.getReadableDatabase();

        for(String table : this.getTables()) {
            Cursor c = db.rawQuery("SELECT * FROM " + table + " WHERE LUNCH = 1", null);

            int[] indexes = new int[] {
                    c.getColumnIndex(Food.id),
                    c.getColumnIndex(Food.name),
                    c.getColumnIndex(Food.breakfast),
                    c.getColumnIndex(Food.lunch),
                    c.getColumnIndex(Food.dinner),
                    c.getColumnIndex(Food.needsSidedish),
                    c.getColumnIndex(Food.isSidedish),
                    c.getColumnIndex(Food.calories),
                    c.getColumnIndex(Food.proteins),
                    c.getColumnIndex(Food.fats),
                    c.getColumnIndex(Food.carbs),
                    c.getColumnIndex(Food.fiber),
                    c.getColumnIndex(Food.vitamins),
                    c.getColumnIndex(Food.minerals)
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
        minimumRequiredIngredients = dbRows.getMinimumRequiredIngredients(profile, 2);
        maximumRequiredIngredients = dbRows.getMaximumRequiredIngredients(profile, 2);
        prices = dbRows.getPrices();
        ingredientsMatrix = dbRows.getIngredientsMatrix();

        regenerate();
    }

    /**
     * This method returns the tables that contain appropriate food for this meal.
     * @return names of the tables
     */

    @Override

    public String[] getTables() {
        return new String[]{ Bauturi.getName(), Fructe.getName(),
                Legume.getName(), PreparateCarne.getName(), PreparateFaraCarne.getName(),
                Ciorbe.getName(), Dulciuri.getName(), GuiltyPleasures.getName()
        };
    }


}
