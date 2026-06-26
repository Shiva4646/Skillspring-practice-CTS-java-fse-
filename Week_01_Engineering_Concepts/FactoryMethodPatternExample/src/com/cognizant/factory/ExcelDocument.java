package com.cognizant.factory;

public class ExcelDocument implements Document {
    @Override
    public void open() {
        System.out.println("[DOC ENGINE]: Opening Excel Spreadsheet workbook matrices.");
    }
    @Override
    public void close() {
        System.out.println("[DOC ENGINE]: Compacting calculation sheet indices and closing Excel file.");
    }
}