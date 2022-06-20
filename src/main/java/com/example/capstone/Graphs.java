package com.example.capstone;

import com.example.capstone.model.Row;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Graphs {
    int count = 0;
    int sum = 0;
    public static Map getStateAverages(ArrayList<Row> rows)  {
        Map stateMap = new HashMap<>();
        Map averageObjectsMap = new HashMap<>();
        for (Row row : rows) {
            String state = row.getState();
            if (state.equalsIgnoreCase("NA")) {
                continue;
            }
            Graphs stateAverage = (Graphs) averageObjectsMap.get(state);
            if (stateAverage == null) {
                stateAverage = new Graphs();
            }
            stateAverage.count++;
            stateAverage.sum += row.getConvertedCompensation();

            int average = stateAverage.sum / stateAverage.count;

            averageObjectsMap.put(state, stateAverage);
            stateMap.put(state, average);
        }

        return stateMap;
    }

    public static Map getOrgSizeAverages(ArrayList<Row> rows)  {
        Map orgSizeMap = new HashMap<>();
        Map averageObjectsMap = new HashMap<>();
        for (Row row : rows) {
            if(row.getOrganizationSize().equalsIgnoreCase("na")){
                continue;
            }
            Graphs stateAverage = (Graphs) averageObjectsMap.get(row.getOrganizationSize());
            if (stateAverage == null) {
                stateAverage = new Graphs();
            }
            stateAverage.count++;
            stateAverage.sum += row.getConvertedCompensation();

            int average = stateAverage.sum / stateAverage.count;

            averageObjectsMap.put(row.getOrganizationSize(), stateAverage);
            orgSizeMap.put(row.getOrganizationSize(), average);
        }

        return orgSizeMap;
    }


    public static Map getGroupedByYears(ArrayList<Row> rows)  {

        Map yearsMap = new HashMap<>();
        for (Row row : rows) {
            int years = row.getYearsExperience();

            Map salaryGroupedForYears = (Map) yearsMap.get(years);
            if (salaryGroupedForYears == null) {
                salaryGroupedForYears = new HashMap<>();
            }

            int compensation = row.getConvertedCompensation();
            String compensationGroup = "";

            if (compensation < 40000) {
                compensationGroup = "Less than 40,000";
            } else if (compensation < 80000) {
                compensationGroup = "40,000-80,000";
            } else if (compensation < 120000) {
                compensationGroup = "80,000-120,000";
            } else if (compensation < 200000) {
                compensationGroup = "120,000-200,000";
            } else {
                compensationGroup = "120,000+";
            }

            int count = 0;
            if (salaryGroupedForYears.get(compensationGroup) != null) {
                count = (int) salaryGroupedForYears.get(compensationGroup);
            }

            salaryGroupedForYears.put(compensationGroup, ++count);

            yearsMap.put(years, salaryGroupedForYears);
        }

        return yearsMap;
    }
}
