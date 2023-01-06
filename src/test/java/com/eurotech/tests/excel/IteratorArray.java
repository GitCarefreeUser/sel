package com.eurotech.tests.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class IteratorArray {


    public ArrayList<String> getData(String testCaseName) throws IOException {

        ArrayList<String> a=new ArrayList<>();
        FileInputStream fis = new FileInputStream("src/test/resources/slm.xlsx");
        XSSFWorkbook xw = new XSSFWorkbook(fis);

        int sheets = xw.getNumberOfSheets();


        for (int i = 0; i < sheets; i++) {

            if (xw.getSheetName(i).equalsIgnoreCase("mrb")) {
                XSSFSheet sheetAccess = xw.getSheetAt(i);  //sheet'e girme kodu buydu

                Iterator<Row> rows = sheetAccess.iterator();
                Row firstRow = rows.next();

                Iterator<Cell> ce = firstRow.cellIterator();
                int k = 0;
                int column = 0;

                while (ce.hasNext()) {
                    Cell value = ce.next(); //return type'i intellij'de kayitli zaten--sag click'te veriyor
                    if (value.getStringCellValue().equalsIgnoreCase("country")) {

                        column = k;
                    }
                    k++;
                }
                System.out.println("column: "+column);

                while (rows.hasNext()){
                    Row next = rows.next();
                    if (next.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName)){
                        Iterator<Cell> cellIterator = next.cellIterator();
                        while (cellIterator.hasNext()) {
                            a.add(cellIterator.next().getStringCellValue());
                        }

                    }

                }

            }


        }
        return a;
    }
    }



