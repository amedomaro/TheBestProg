package com.example.thebestprog;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;


@SpringBootApplication
public class TheBestProgApplication {

    public static void main(String[] args) throws IOException {
        //SpringApplication.run(TheBestProgApplication.class, args);

        Service service = new Service();

//        FileInputStream file = new FileInputStream(new File("D:\\kc_house_data_PARSING.xlsx")); // Загрузка файла
        FileInputStream file = new FileInputStream(new File("D:\\test.xlsx")); // Загрузка файла
        Workbook workbook = new XSSFWorkbook(file); // Инициализация в объект
        Sheet sheet = workbook.getSheetAt(0); // Чтение первого листа

        List<Double> bedrooms = service.getColum(sheet, 3); // Загрузка данных bedrooms
        List<Double> bathrooms = service.getColum(sheet, 4); // Загрузка данных bathrooms
        List<Double> view = service.getColum(sheet, 9); // Загрузка данных view

        List<Double> bedroomNormalization = service.standardNormalization(bedrooms);
        List<Double> bathroomsNormalization = service.standardNormalization(bathrooms);
        List<Double> viewNormalization = service.standardNormalization(view);


        System.out.println(Arrays.toString(bedroomNormalization.toArray()));
        System.out.println("_________________________");
        System.out.println(Arrays.toString(bathroomsNormalization.toArray()));
        System.out.println("_________________________");
        System.out.println(Arrays.toString(viewNormalization.toArray()));

    }
}
