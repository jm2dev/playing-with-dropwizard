package com.jm2dev.csv;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.CsvToBean;
import au.com.bytecode.opencsv.bean.HeaderColumnNameMappingStrategy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Parser {
    public static <T> List<T> parseCsvFileToBeans(final String filename,
                                                  final char fieldDelimiter,
                                                  final Class<T> beanClass) throws FileNotFoundException {
        CSVReader reader = null;
        try {
            reader = new CSVReader(new BufferedReader(new FileReader(filename)),
                    fieldDelimiter);
            final HeaderColumnNameMappingStrategy<T> strategy =
                    new HeaderColumnNameMappingStrategy<T>();
            strategy.setType(beanClass);
            final CsvToBean<T> csv = new CsvToBean<T>();
            return csv.parse(strategy, reader);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (final IOException e) {
                    // ignore
                }
            }
        }
    }
}
