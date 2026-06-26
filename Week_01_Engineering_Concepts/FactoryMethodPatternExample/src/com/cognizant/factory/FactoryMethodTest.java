package com.cognizant.factory;

public class FactoryMethodTest {
    public static void main(String[] args) {
        // The client code interacts completely via abstract factories and interfaces
        DocumentFactory wordCreator = new WordDocumentFactory();
        DocumentFactory pdfCreator = new PdfDocumentFactory();
        DocumentFactory excelCreator = new ExcelDocumentFactory();

        Document myDoc1 = wordCreator.createDocument();
        Document myDoc2 = pdfCreator.createDocument();
        Document myDoc3 = excelCreator.createDocument();

        System.out.println("--- Polling Dynamic Factory Processing Actions ---");
        myDoc1.open();
        myDoc1.close();
        System.out.println();

        myDoc2.open();
        myDoc2.close();
        System.out.println();

        myDoc3.open();
        myDoc3.close();
    }
}