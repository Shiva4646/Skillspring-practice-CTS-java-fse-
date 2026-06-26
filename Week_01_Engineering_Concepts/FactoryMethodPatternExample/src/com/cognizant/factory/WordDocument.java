package com.cognizant.factory;

public class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("[DOC ENGINE]: Opening active native .docx Word Document stream.");
    }
    @Override
    public void close() {
        System.out.println("[DOC ENGINE]: Safely serializing and closing Word Document.");
    }
}