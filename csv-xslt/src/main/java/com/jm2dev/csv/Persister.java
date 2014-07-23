package com.jm2dev.csv;

import au.com.bytecode.opencsv.CSVWriter;
import com.jm2dev.csv.beans.BankStatement;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Persister {
    private String csv;
    private List<BankStatement> statements;

    public Persister(String csv, List<BankStatement> statements) {
        this.csv = csv;
        this.statements = statements;
    }

    public void save() throws IOException {
        CSVWriter writer = new CSVWriter(new FileWriter(csv));
        List<String> strings = statements.stream().map(st -> st.toString()).collect(Collectors.toList());
        for (String str : strings) {
            String[] line = str.split(",");
            writer.writeNext(line);
        }
        writer.close();
    }
}
