package com.example.thebestprog;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;


public class Service {

    public List<Double> getColum(Sheet sheet, int i) {
        List<Double> values = new ArrayList<Double>();

        for (Row r : sheet) {
            Cell c = r.getCell(i);
            if (c != null) {
                if (c.getCellType() == CellType.NUMERIC) {
                    values.add(c.getNumericCellValue());
                }
            }
        }
        return values;
    }

    public List<Double> standardNormalization(List<Double> list){
        double average = list.stream().mapToDouble(Number::doubleValue).average().getAsDouble(); // Среднее значение

        double stDev = 0.0; // Среднее отклонение
        for (double num : list) {
            stDev += Math.pow(num - average, 2);
        }
        double standardDeviation = Math.sqrt(stDev / (double) (list.size() -1));

        List<Double> answer = new ArrayList<>(); // стандартизированное значение
        for (double i : list) {
            if(standardDeviation != 0) answer.add((i-average)/standardDeviation);
            else answer.add(0.0);
        }
        return answer;
    }

    public void MinMaxAve(String name, List<Double> list){
        double min = list.stream().mapToDouble(Double::doubleValue).min().getAsDouble();
        double max = list.stream().mapToDouble(Double::doubleValue).max().getAsDouble();
        double aver = list.stream().mapToDouble(Number::doubleValue).average().getAsDouble();

        System.out.printf("%s - min = %f, max = %f, aver = %f %n", name, min, max, aver);
    }
}
