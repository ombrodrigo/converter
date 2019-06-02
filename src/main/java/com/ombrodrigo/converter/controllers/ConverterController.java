package com.ombrodrigo.converter.controllers;

import java.io.IOException;
import java.nio.charset.Charset;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ConverterController {

    @PostMapping("/converter/csv-to-json")
    public String csvToJson(@RequestParam("file") MultipartFile file) throws IOException {
        // text/csv
        String response = StreamUtils.copyToString(file.getInputStream(), Charset.defaultCharset());
        return response;
    }

    @PostMapping("/converter/xml-to-json")
    public String xmlToJson(@RequestParam("file") MultipartFile file) throws IOException {
        // application/xml/csv
        String response = StreamUtils.copyToString(file.getInputStream(), Charset.defaultCharset());
        return response;
    }
}