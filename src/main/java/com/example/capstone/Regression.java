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
        //testPercentageDifference(rows, R);
        return prediction;
    }

    public static void testPercentageDifference(ArrayList<Row> rows, SimpleRegression R){
        final int testToYear = 14;
        int[] totalsalary = new int[testToYear];
        int[] datapoints = new int[testToYear];
        for(int i = 0; i < testToYear; i++){
            totalsalary[i] = 0;
            datapoints[i] = 0;
        }
        for(Row row: rows){
            if(row.getYearsExperience() < testToYear){
                totalsalary[row.getYearsExperience()] += row.getConvertedCompensation();
                datapoints[row.getYearsExperience()]++;
            }
        }
        double successRate = 0;
        for(int i = 1; i < testToYear; i++){
            System.out.println("YOE: " + i + " Prediction: " + R.predict(i) + " Average: " + totalsalary[i]/datapoints[i]);
            double percDif = (((1.0 * totalsalary[i]/datapoints[i]) - R.predict(i)) / (1.0 * totalsalary[i]/datapoints[i]));
            System.out.println("Percentage Difference: " + percDif * 100);
            if(percDif < .1 && percDif > -.1){
                successRate++;
            }
        }
        System.out.println(successRate/testToYear * 100 + "% Success Rate");
    }
}
