/**
 * Created by sorin on 5/19/14.
 */
public interface Meal {
    public String[] getNames();
    public String[] getIngredients();
    public int[] getMinimumRequiredIngredients();
    public int[] getPrices();
    public int[][] getIngredientsMatrix();
}

