package com.trev.fizzbuzz.inject.manual;

public class FizzBuzzManualInjection
{

    private final FizzBuzzNumberProvider numberProvider;
    private final FizzBuzzTextProvider textProvider;

    public FizzBuzzManualInjection(final FizzBuzzNumberProvider numberProvider, final FizzBuzzTextProvider textProvider)
    {
        this.numberProvider = numberProvider;
        this.textProvider = textProvider;
    }

    public void doFizzBuzz()
    {
        numberProvider.getFizzBuzzNumbers().forEach(num -> {
            final String msg = textProvider.getFizzBuzzText(num);
        });
    }

}
