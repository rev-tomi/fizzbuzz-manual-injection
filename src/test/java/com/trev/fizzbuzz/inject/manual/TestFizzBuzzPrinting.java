package com.trev.fizzbuzz.inject.manual;

import static org.testng.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestFizzBuzzPrinting
{

    private PrintStream sysOut;
    private FizzBuzzPrinter sut;

    @BeforeMethod
    public void setUp()
    {
        sysOut = System.out;
        sut = new FizzBuzzPrinter();
    }

    @AfterMethod
    public void tearDown()
    {
        System.setOut(sysOut);
    }

    @Test
    public void testPrintFizzBuzz()
    {
        // GIVEN
        final String msg = "1";
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        // WHEN
        sut.printFizzBuzz(msg);

        // THEN
        assertEquals(baos.toString(), msg + String.format("%n"));
    }

}
