package com.ombrodrigo.converter.bean.converters;

import java.io.InputStream;

import org.springframework.stereotype.Service;

@Service
public interface IConverter {

    public String convert(InputStream stream);
}