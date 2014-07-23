package com.jm2dev.csv;

import com.google.common.collect.Lists;
import com.jm2dev.csv.beans.BankStatement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class CrunchReady {
    static final Logger LOG = LoggerFactory.getLogger(CrunchReady.class);
    private List<BankStatement> statements;
    private double balance;

    public CrunchReady(List<BankStatement> statements, double balance) {
        List<BankStatement> reversedStatements = Lists.reverse(statements);
        this.statements = reversedStatements;
        this.balance = balance;
    }

    public List<BankStatement> calculate() {
        List<BankStatement> result = new ArrayList<>();
        double newBalance = balance;
        for (BankStatement statement : statements) {
            BankStatement st = new BankStatement(
                    newBalance + statement.getAmount(),
                    statement.getDate(),
                    statement.getAccount(),
                    statement.getAmount(),
                    statement.getSubcategory(),
                    statement.getMemo()
            );
            result.add(st);
            newBalance = newBalance + statement.getAmount();
            LOG.info(String.format("balance: %s | entry: %s", newBalance, st.toString()));
        }

        return Lists.reverse(result);
    }
}
