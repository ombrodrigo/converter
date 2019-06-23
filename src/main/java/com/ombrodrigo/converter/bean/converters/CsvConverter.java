package com.ombrodrigo.converter.bean.converters;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.springframework.stereotype.Service;

@Service
public class CsvConverter implements IConverter {

    public String convert(InputStream stream) {
        Stream<String> lines = (new BufferedReader(new InputStreamReader(stream))).lines();

        ArrayList<String[]> splitLines = new ArrayList<>();

        lines.forEach(line -> splitLines.add(line.split(",")));

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        return gson.toJson(splitLines);
    }
}