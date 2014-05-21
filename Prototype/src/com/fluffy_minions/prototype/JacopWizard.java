package com.fluffy_minions.prototype;

import com.fluffy_minions.prototype.IDAS.IMeal;
import com.fluffy_minions.prototype.needsCalculators.PersonalProfile;
import org.jacop.constraints.SumWeight;
import org.jacop.core.IntDomain;
import org.jacop.core.IntVar;
import org.jacop.core.Store;
import org.jacop.search.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sorin on 5/21/14.
 */
public class JacopWizard {
    public String run(IMeal meal, PersonalProfile personalProfile) {
        String[] food = meal.getNames();
        String[] ingredients = meal.getIngredients();
        int[] price = meal.getPrices();
        int[] limits = meal.getMinimumRequiredIngredients(personalProfile);
        int[][] matrix = meal.getIngredientsMatrix();

        int m = food.length;
        int n = ingredients.length;

        Store store = new Store();

        IntVar[] x = new IntVar[m];
        for(int i = 0; i < m; i++) {
            x[i] = new IntVar(store, "x_" + i, 0, 10);
        }

        // Cost to minimize: x * price
        IntVar cost = new IntVar(store, "cost", 0, 120);

        for(int i = 0; i < n; i++) {
            IntVar minReq = new IntVar(store, "limit" + i, limits[i], IntDomain.MaxInt);
//            if (i != 1) {
//                store.impose(new Knapsack(matrix[i], price, x, cost, minReq));
            //    }
            //          else {
            // this category has some items with zero profit, violates knapsack conditions so it is not used.
            store.impose(new SumWeight(x, matrix[i], minReq));
            //      }
        }

        List<IntVar> vars = new ArrayList<IntVar>();
        for(IntVar v : x)
            vars.add(v);

        SelectChoicePoint<IntVar> select = new SimpleSelect<IntVar>(vars.toArray(new IntVar[1]),
                null, new IndomainMin<IntVar>());

        Search search = new DepthFirstSearch<IntVar>();

        //search.getSolutionListener().searchAll(true);
        //search.getSolutionListener().recordSolutions(true);
        // search.setAssignSolution(true);

        boolean result = search.labeling(store, select);

        // Construct the result string:

        String s = "";
        int[] total = new int[ingredients.length];

        for(int i = 0; i < m; ++i) {
            // If this dish was selected
            if(x[i].value() != 0) {
                // Add the dish to the string
                // 3 x Pastrama de porc
                s += x[i].value() + " x " + food[i] + "\n";

                // Add up all the ingredients
                for(int k = 0; k < ingredients.length; ++k) {
                    total[k] += matrix[k][i];
                }
            }
        }

        s += "\nTOTAL\n";

        // Add the total to the string
        for(int i = 0; i < ingredients.length; ++i) {
            s += ingredients[i] + ": " + total[i] + "\n";
        }

        return s;

    }
}
