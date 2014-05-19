package food;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import IDAS.IMeal;
import IDAS.TotalNeedsCalculator;
import needsCalculators.PersonalProfile;

/**
 * Created by sorin on 5/19/14.
 */
public class DBRows implements IMeal {
	private List<DBRow> rows = new ArrayList<DBRow>();
	
    public void add(DBRow row) {
    	rows.add(row);
    }

    @Override
    public String[] getNames() {
    	List<String> names = new ArrayList<String>();
        for (DBRow row:rows) {
        	names.add(row.getName());
        }
		return names.toArray(new String[rows.size()]);
    }

    @Override
    public String[] getIngredients() {
        String[] ingredients = { "CALORIES" , "FATS" , "CARBS" , "FIBER", "PROTEINS" };
        return ingredients;
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
    	int[][] ingredients;
    	for(int i = 0;  i < this.getIngredients().length; i++) {
    		for(int j = 0;  j < rows.size(); j++) {
    			if(i == 0) {
    				ingredients[i][j] = rows.get(j).getCalories();
    			}else {
    				if( i == 1) {
    					ingredients[i][j] = rows.get(j).getFats();
    				} else if( i == 2 ) {
    					ingredients[i][j] = rows.get(j).getCarbs();
    				} else if( i == 3) {
    					ingredients[i][j] = rows.get(j).getFibers();
    				} else {
    					ingredients[i][j] = rows.get(j).getProteins();
    				}
    			}
    		}
    	}
    	return ingredients;
    }
}
