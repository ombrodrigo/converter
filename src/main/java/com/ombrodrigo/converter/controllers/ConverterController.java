package com.ombrodrigo.converter.controllers;

import java.io.IOException;

import com.ombrodrigo.converter.bean.converters.CsvConverter;
import com.ombrodrigo.converter.bean.converters.XmlConverter;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ConverterController {

    private CsvConverter csvConverter;
    private XmlConverter xmlConverter;

    @Autowired
    public ConverterController(CsvConverter csvConverter, XmlConverter xmlConverter) {
        this.csvConverter = csvConverter;
        this.xmlConverter = xmlConverter;
    }

    @PostMapping("/converter/csv/json")
    public String csvToJson(@RequestParam("file") MultipartFile file) throws IOException {
        // text/csv
        return csvConverter.convert(file.getInputStream());
    }

    @PostMapping("/converter/xml/json")
    public String xmlToJson(@RequestParam("file") MultipartFile file) throws IOException {
        // application/xml/csv
        return xmlConverter.convert(file.getInputStream());
    }
}