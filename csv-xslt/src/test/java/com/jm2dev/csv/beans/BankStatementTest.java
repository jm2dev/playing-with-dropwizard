package com.jm2dev.csv.beans;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BankStatementTest {
    @Test
    public void printAsCsv() {
        BankStatement statement = new BankStatement();
        statement.setBalance(7500.00);
        statement.setDate("12/03/2014");
        statement.setAccount("20-96-55 03692345");
        statement.setAmount(7500.00);
        statement.setSubcategory("OTH");
        statement.setMemo("1/EVI PUBL *    675941*INVOICE: E* TFR");

        String expected = "7500.00,12/03/2014,20-96-55 03692345,7500.00,OTH,1/EVI PUBL *    675941*INVOICE: E* TFR";
        assertThat(statement.toString(), is(expected));
    }

    @Test
    public void equalsForSameContent() {
        BankStatement statement = new BankStatement();
        statement.setBalance(7500.00);
        statement.setDate("12/03/2014");
        statement.setAccount("20-96-55 03692345");
        statement.setAmount(7500.00);
        statement.setSubcategory("OTH");
        statement.setMemo("1/EVI PUBL *    675941*INVOICE: E* TFR");

        BankStatement st = new BankStatement();
        st.setBalance(7500.00);
        st.setDate("12/03/2014");
        st.setAccount("20-96-55 03692345");
        st.setAmount(7500.00);
        st.setSubcategory("OTH");
        st.setMemo("1/EVI PUBL *    675941*INVOICE: E* TFR");

        assertThat(statement, is(st));
    }
}
