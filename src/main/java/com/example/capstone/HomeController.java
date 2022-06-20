package com.example.capstone;

import com.example.capstone.model.GenerateSalary;
import com.example.capstone.model.Row;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        ArrayList<Row> rows = CSVParser.parseCSV();

        Map yearsMap = Graphs.getGroupedByYears(rows);
        model.addAttribute("yearsMap", yearsMap);

        Map stateMap = Graphs.getStateAverages(rows);
        model.addAttribute("stateMap", stateMap);

        Map orgSizeCompensationAverageMap = Graphs.getOrgSizeAverages(rows);
        model.addAttribute("orgMap", orgSizeCompensationAverageMap);
        return "home";
    }

    @GetMapping("/prediction")
    public String prediction(Model model) {
        return "prediction";
    }

    @PostMapping("/generate")
    @ResponseBody
    int generateSalary(GenerateSalary salary) {
        ArrayList<Row> rows = CSVParser.parseCSV();
        double result = Regression.predict(rows, salary.getYearsOfExperience());
        return (int)result;
    }
}
