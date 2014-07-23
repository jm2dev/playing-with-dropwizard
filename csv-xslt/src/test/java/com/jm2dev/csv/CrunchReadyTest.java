package com.jm2dev.csv;

import com.google.common.collect.Lists;
import com.jm2dev.csv.beans.BankStatement;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static com.jm2dev.csv.Parser.parseCsvFileToBeans;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class CrunchReadyTest {
    @Test
    public void calculateBalances() throws FileNotFoundException {
        List<BankStatement> statements = getStatements("src/test/resources/bank-pre.csv");
        CrunchReady crunch = new CrunchReady(statements, 7591.48);
        List<BankStatement> converted = crunch.calculate();
        List<BankStatement> expected = getStatements("src/test/resources/bank-post.csv");
        assertThat(converted, is(expected));
    }

    public List<BankStatement> getStatements(String csvInput) throws FileNotFoundException {
        return parseCsvFileToBeans(csvInput, ',', BankStatement.class);
    }
}
