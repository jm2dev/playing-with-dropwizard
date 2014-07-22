package com.jm2dev.csv;

import com.jm2dev.csv.beans.BankStatement;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static com.jm2dev.csv.Parser.parseCsvFileToBeans;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ParserTest {
    @Test
    public void parseBarclaysOriginalCsvFile() throws FileNotFoundException {
        String csvInput = "src/test/resources/bank-pre.csv";
        List<BankStatement> statements = parseCsvFileToBeans(csvInput, ',', BankStatement.class);

        assertThat(statements.size(), is(2));
    }

}
