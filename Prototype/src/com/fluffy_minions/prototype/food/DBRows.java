package com.fluffy_minions.prototype.food;

import com.fluffy_minions.prototype.IDAS.IMeal;
import com.fluffy_minions.prototype.needsCalculators.PersonalProfile;

/**
 * Created by sorin on 5/19/14.
 */
public class DBRows implements IMeal {
    private void add(DBRow row) {

    }

    @Override
    public String[] getNames() {
        return new String[0];
    }

    @Override
    public String[] getIngredients() {
        return new String[0];
    }

    @Override
    public int[] getMinimumRequiredIngredients(PersonalProfile profile) {
        return new int[0];
    }

    @Override
    public int[] getPrices() {
        return new int[0];
    }

    @Override
    public int[][] getIngredientsMatrix() {
        return new int[0][];
    }
}
