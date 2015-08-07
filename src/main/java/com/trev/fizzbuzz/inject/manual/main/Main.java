package com.trev.fizzbuzz.inject.manual.main;

import com.trev.fizzbuzz.inject.manual.FizzBuzzManualInjection;
import com.trev.fizzbuzz.inject.manual.FizzBuzzNumberProvider;
import com.trev.fizzbuzz.inject.manual.FizzBuzzPrinter;
import com.trev.fizzbuzz.inject.manual.FizzBuzzTextProvider;

public class Main
{

    public static void main(final String[] args)
    {
        final FizzBuzzNumberProvider numberProvider = new FizzBuzzNumberProvider();
        final FizzBuzzTextProvider textProvider = new FizzBuzzTextProvider();
        final FizzBuzzPrinter printer = new FizzBuzzPrinter();
        final FizzBuzzManualInjection fizzBuzz = new FizzBuzzManualInjection(numberProvider, textProvider, printer);
        fizzBuzz.doFizzBuzz();
    }

}
