package com.trev.fizzbuzz.inject.manual;

public class FizzBuzzManualInjection
{

    private final FizzBuzzNumberProvider numberProvider;
    private final FizzBuzzTextProvider textProvider;
    private final FizzBuzzPrinter printer;

    public FizzBuzzManualInjection(final FizzBuzzNumberProvider numberProvider,
        final FizzBuzzTextProvider textProvider,
        final FizzBuzzPrinter printer)
    {
        this.numberProvider = numberProvider;
        this.textProvider = textProvider;
        this.printer = printer;
    }

    public void doFizzBuzz()
    {
        numberProvider.getFizzBuzzNumbers().forEach(num -> {
            final String msg = textProvider.getFizzBuzzText(num);
            printer.printFizzBuzz(msg);
        });
    }

}
