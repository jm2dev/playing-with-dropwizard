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

    private List<BankStatement> getStatements(String csvInput) throws FileNotFoundException {
        return parseCsvFileToBeans(csvInput, ',', BankStatement.class);
    }

    private List<BankStatement> calculate(List<BankStatement> statements, double initialBalance) {
        List<BankStatement> result = new ArrayList<>();
        double balance = initialBalance;
        for (BankStatement statement : statements) {
            result.add(new BankStatement(
                    balance + statement.getAmount(),
                    statement.getDate(),
                    statement.getAccount(),
                    statement.getAmount(),
                    statement.getSubcategory(),
                    statement.getMemo()
            ));
            balance = balance + statement.getAmount();
        }

        return result;
    }
    @Test
    public void calculateBalances() throws FileNotFoundException {
        List<BankStatement> originals = getStatements("src/test/resources/bank-pre.csv");
        List<BankStatement> statements = Lists.reverse(originals);
        List<BankStatement> converted = Lists.reverse(calculate(statements, 7591.48));
        List<BankStatement> expected = getStatements("src/test/resources/bank-post.csv");
        assertThat(converted, is(expected));
    }
}
