package com.jm2dev.csv;

import com.jm2dev.csv.beans.BankStatement;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class PersisterTest {
    private String csv = "src/test/resources/test.csv";
    private File csvfile = new File(csv);

    @Before
    public void setup() {
        if (csvfile.exists())
            csvfile.delete();
    }

    @Test
    public void saveCsvToFile() throws IOException {
        BankStatement statement = new BankStatement();
        statement.setBalance(7500.00);
        statement.setDate("12/03/2014");
        statement.setAccount("20-96-55 03692345");
        statement.setAmount(7500.00);
        statement.setSubcategory("OTH");
        statement.setMemo("1/EVI PUBL *    675941*INVOICE: E* TFR");
        List<BankStatement> statements = Arrays.asList(statement);

        Persister persister = new Persister(csv, statements);
        persister.save();

        assertTrue(csvfile.exists());
    }
}
