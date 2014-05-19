import java.util.Random;

/**
 * Created by sorin on 5/19/14.
 */
public class Breakfast implements Meal {
    @Override
    public String[] getNames() {
        return new String[] {"Eggs", "Cheese", "Chocolate", "Minions"};
    }

    @Override
    public String[] getIngredients() {
        return new String[] { "Calories", "Carbs", "Proteins" };
    }

    @Override
    public int[] getPrices() {
        Random random = new Random();

        return new int[] { random.nextInt(50) + 1,  random.nextInt(50) + 1, random.nextInt(50) + 1, random.nextInt(50) + 1 };
    }

    @Override
    public int[] getMinimumRequiredIngredients() {
        // We need 400 calories, 230 carbs, 140 proteins
        return new int[] { 100, 125, 140 };
    }

    @Override
    public int[][] getIngredientsMatrix() {
        return new int[][] {
            // Eggs Cheese Chocolate Minions
            {  42,  25,     30,    23    }, // Calories
            {  26,  85,     22,    10    }, // Carbs
            {  23,  31,     25,    66    } // Proteins
        };
    }
}
