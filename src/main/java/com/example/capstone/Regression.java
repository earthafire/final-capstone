package com.example.capstone;

import weka.attributeSelection.AttributeSelection;
import weka.attributeSelection.CfsSubsetEval;
import weka.attributeSelection.GreedyStepwise;
import weka.classifiers.evaluation.Evaluation;
import weka.classifiers.functions.LinearRegression;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;
import weka.filters.Filter;

public class Regression {
    public LinearRegression run(Instances dataset) throws Exception {

        LinearRegression lr = new LinearRegression();
        lr.buildClassifier(dataset);
        System.out.println(lr);

        Evaluation lrEval = new Evaluation(dataset);
        lrEval.evaluateModel(lr, dataset);
        System.out.println(lrEval.toSummaryString());
        return lr;
    }
}
