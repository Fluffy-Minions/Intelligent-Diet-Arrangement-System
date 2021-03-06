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
 * Computes the menu for a meal.
 */
public class JacopWizard {
    /**
     * Computes the menu.
     *
     * @param meal the meal for which to compute the menu
     * @param logger where to store the logs
     * @return the meal
     */
    public String invokeTheGods(GenericMeal meal, Logger logger) {
        String[] food = meal.getNames();
        String[] ingredients = meal.getIngredients();
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

        for(int i = 0; i < n; i++) {
            IntVar minReq = new IntVar(store, "limit" + i, limits[i], upperLimits[i]);
            store.impose(new SumWeight(x, matrix[i], minReq));
        }

        List<IntVar> vars = new ArrayList<IntVar>();
        for(IntVar v : x)
            vars.add(v);

        SelectChoicePoint<IntVar> select = new SimpleSelect<IntVar>(vars.toArray(new IntVar[1]),
                null, new IndomainMin<IntVar>());

        Search search = new DepthFirstSearch<IntVar>();

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
