package com.example.capstone;


import com.example.capstone.model.Row;
import org.apache.commons.math3.stat.regression.SimpleRegression;

import java.util.ArrayList;

public class Regression {
    public static double predict(ArrayList<Row> rows, int yearExperience)  {
        SimpleRegression R = new SimpleRegression();

        for (Row row : rows) {
            R.addData(row.getYearsExperience(), row.getConvertedCompensation());
        }

        Double prediction = R.predict(yearExperience);
        return prediction;
    }
}
