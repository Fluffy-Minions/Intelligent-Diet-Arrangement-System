package com.fluffy_minions.prototype.IDAS;

import com.fluffy_minions.prototype.needsCalculators.PersonalProfile;

public interface IMeal {
    public String[] getNames();
    public String[] getIngredients();
    public int[] getMinimumRequiredIngredients(PersonalProfile profile);
    public int[] getPrices();
    public int[][] getIngredientsMatrix();

}
