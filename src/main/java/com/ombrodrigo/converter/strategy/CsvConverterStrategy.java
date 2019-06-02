package com.ombrodrigo.converter.strategy;

public class CsvConverterStrategy implements IConverterStrategy {

    public String convert(String content) {
        return "CSV";
    }
}