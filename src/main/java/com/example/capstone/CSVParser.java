package com.example.capstone;

import weka.core.Instances;
import weka.core.converters.CSVLoader;

import java.io.*;
import java.nio.file.Files;

public class CSVParser {
    public static Instances parseCSV(InputStream file){
        try {
            InputStreamReader input = new InputStreamReader(file);

            CSVLoader fileLoader = new CSVLoader();
            fileLoader.setSource(file);

            Instances dataset = fileLoader.getDataSet();

            return dataset;
        } catch (IOException e) {
            System.out.println("can't find file");
            e.printStackTrace();
            return null;
        }

    }
}
