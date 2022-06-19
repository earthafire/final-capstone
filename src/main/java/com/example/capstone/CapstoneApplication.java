package com.example.capstone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import weka.core.Instances;

import java.io.File;
import java.io.InputStream;

import static com.example.capstone.CSVParser.parseCSV;

@SpringBootApplication
public class CapstoneApplication {

	public static void main(String[] args) {
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream is = classloader.getResourceAsStream("survey_results_public.csv");

		Instances dataset = parseCSV(is);
		if (dataset == null){
			System.out.println("couldn't find file");
		} else {
			try {
				new Regression().run(dataset);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		SpringApplication.run(CapstoneApplication.class, args);
	}
}
