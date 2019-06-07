package com.ombrodrigo.converter.bean.converters;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

@Service
public class CsvConverter implements IConverter {

    public String convert(InputStream stream) {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));

        Stream<String> lines = bufferedReader.lines();

        lines.forEach(line -> {
            String[] split = line.split(",");
            System.out.println(split);
        });

        return "CSV";
    }
}