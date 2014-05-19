package IDAS;

import needsCalculators.PersonalProfile;

public interface IMeal {
    public String[] getNames();
    public String[] getIngredients();
    public int[] getMinimumRequiredIngredients(PersonalProfile profile);
    public int[] getPrices();
    public int[][] getIngredientsMatrix();

}
