package com.cognizant.factory;

public class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("[DOC ENGINE]: Loading layout definitions and opening PDF file view.");
    }
    @Override
    public void close() {
        System.out.println("[DOC ENGINE]: Terminating active Adobe PDF parsing session.");
    }
}