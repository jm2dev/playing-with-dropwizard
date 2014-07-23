package com.jm2dev.app;

import com.jm2dev.csv.CrunchReady;
import com.jm2dev.csv.Persister;
import com.jm2dev.csv.beans.BankStatement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.util.List;

import static com.jm2dev.csv.Parser.parseCsvFileToBeans;

class Jm {
    static final Logger LOG = LoggerFactory.getLogger(Jm.class);

    public static void main(final String[] args) {
        LOG.info("Input parameters: csv file and initial balance");
        LOG.info("Starting");
        String csvFile = args[0];
        double balance = Double.parseDouble(args[1]);
        LOG.info(String.format("%s : %s", csvFile, balance));

        try {
            List<BankStatement> statements = parseCsvFileToBeans(csvFile, ',', BankStatement.class);
            CrunchReady crunch = new CrunchReady(statements, balance);
            List<BankStatement> converted = crunch.calculate();
            String csv = String.format("out-%s.csv", csvFile);
            Persister persister = new Persister(csv, converted);
            persister.save();
        } catch (java.io.IOException e) {
            LOG.error(e.getMessage());
        }

        LOG.info("Finishing");
    }
}
