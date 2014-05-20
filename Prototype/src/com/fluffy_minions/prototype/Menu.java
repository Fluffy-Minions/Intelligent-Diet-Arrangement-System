package com.fluffy_minions.prototype;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TextView;
import com.fluffy_minions.prototype.IDAS.*;
import org.jacop.constraints.SumWeight;
import org.jacop.constraints.XgteqC;
import org.jacop.constraints.knapsack.Knapsack;
import org.jacop.core.IntDomain;
import org.jacop.core.IntVar;
import org.jacop.core.Store;
import org.jacop.search.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by sorin on 3/24/14.
 */
public class Menu extends Fragment {
    private Logger LOGGER = Logger.getLogger(Menu.class.getName());
    private MainActivity mainActivity;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        mainActivity = (MainActivity) activity;
    }

    void set(IMeal meal, TextView textView) {
        String[] food = meal.getNames();
        String[] ingredients = meal.getIngredients();
        int[] price = meal.getPrices();
        int[] limits = meal.getMinimumRequiredIngredients(mainActivity.getPersonalProfile());
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

        String s = "";
        int[] total = new int[ingredients.length];

        for(int i = 0; i < m; ++i) {
            LOGGER.info(food[i] + ": " + x[i].value());

            if(x[i].value() != 0) {
                s += x[i].value() + " x " + food[i] + "\n";

                for(int k = 0; k < ingredients.length; ++k) {
                    total[k] += matrix[k][i];
                }
            }
        }

        s += "\nTOTAL\n";

        for(int i = 0; i < ingredients.length; ++i) {
            s += ingredients[i] + ": " + total[i] + "\n";
        }

        textView.setText(s);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        IMeal breakfastMeal = new Breakfast(mainActivity.getSqLiteHelper(), mainActivity.getPersonalProfile());
        IMeal lunchMeal = new Lunch(mainActivity.getSqLiteHelper(), mainActivity.getPersonalProfile());
        IMeal dinnerMeal = new Dinner(mainActivity.getSqLiteHelper(), mainActivity.getPersonalProfile());


        View view = inflater.inflate(R.layout.menu_fragment, container, false);

        TabHost tabHost=(TabHost)view.findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec spec1=tabHost.newTabSpec("Tab 1");
        spec1.setContent(R.id.tab1);
        spec1.setIndicator("Breakfast");

        TextView breakfast = (TextView) view.findViewById(R.id.breakfast_textView);
        set(breakfastMeal, breakfast);

        TabHost.TabSpec spec2=tabHost.newTabSpec("Tab 2");
        spec2.setIndicator("Lunch");
        spec2.setContent(R.id.tab2);

        TextView lunch = (TextView) view.findViewById(R.id.lunch_textView);
        set(lunchMeal, lunch);

        TabHost.TabSpec spec3=tabHost.newTabSpec("Tab 3");
        spec3.setIndicator("Dinner");
        spec3.setContent(R.id.tab3);

        TextView dinner = (TextView) view.findViewById(R.id.dinner_textView);
        set(dinnerMeal, dinner);

        tabHost.addTab(spec1);
        tabHost.addTab(spec2);
        tabHost.addTab(spec3);

        return view;
    }
}