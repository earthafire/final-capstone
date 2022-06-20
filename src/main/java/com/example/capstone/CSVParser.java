package com.example.capstone;

import com.example.capstone.model.Row;
import com.opencsv.CSVReader;

import java.io.*;
import java.util.ArrayList;

public class CSVParser {
    public static ArrayList<Row> parseCSV(){
        ArrayList<Row> rows = new ArrayList<Row>();

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("survey_results_public.csv");
        Reader targetReader = new InputStreamReader(is);
        try (CSVReader csvReader = new CSVReader(targetReader);) {
            String[] values = null;
            int count = 0;
            while ((values = csvReader.readNext()) != null) {
                if (count == 0) {
                    count++;
                    continue;
                }
                count++;
                if (values[10].equalsIgnoreCase("NA") || values[47].equalsIgnoreCase("NA")) {
                    continue;
                }

                String state = values[4];
                int years;
                int compensation;
                try {
                    years = Integer.parseInt(values[10]);
                    compensation = Integer.parseInt(values[47]);
                } catch(NumberFormatException e) {
                    continue;
                }

                String country = values[3];
                String orgSize = values[12];

                Row row = new Row(state, years, country, orgSize, compensation);
                rows.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rows;
    }
}
