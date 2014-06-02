package com.fluffy_minions.prototype.mainControl;

import com.fluffy_minions.prototype.IDAS.GenericMeal;
import com.fluffy_minions.prototype.needsCalculators.PersonalProfile;
import org.jacop.constraints.SumWeight;
import org.jacop.core.IntVar;
import org.jacop.core.Store;
import org.jacop.search.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by sorin on 5/22/14.
 */
public class JacopWizard {
    public String invokeTheGods(GenericMeal meal, PersonalProfile personalProfile, Logger logger) {
        String[] food = meal.getNames();
        String[] ingredients = meal.getIngredients();
        int[] price = meal.getPrices();
        int[] limits = meal.getMinimumRequiredIngredients();
        int[] upperLimits = meal.getMaximumRequiredIngredients();
        int[][] matrix = meal.getIngredientsMatrix();
        logger.info(meal.getClass().getName());
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
            IntVar minReq = new IntVar(store, "limit" + i, limits[i], upperLimits[i]);
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

        search.setTimeOut(2);
        boolean result = search.labeling(store, select);

        if(!result) { return ""; }

        String s = "";
        int[] total = new int[ingredients.length];

        for(int i = 0; i < m; ++i) {
            if(x[i].value() != 0) {
                String a = food[i] + ": ";

                s += food[i] + " - " + x[i].value() * 100 + "g\n";

                for(int k = 0; k < ingredients.length; ++k) {
                    a += ingredients[k] + " = " + matrix[k][i] +", ";
                    total[k] += x[i].value() * matrix[k][i];
                    // logger.info(limits[k] + " ");
                }

                logger.warning(a);
            }
        }

        String lmt = "";
        for(int i = 0; i < n; ++i) {
            lmt += ingredients[i] + " = " + limits[i] + ", ";
        }

        logger.warning(lmt);

        s += "\nTOTAL\n";

        for(int i = 0; i < ingredients.length; ++i) {
            s += ingredients[i] + ": " + total[i] + "\n";
        }

        return s;
    }
}
