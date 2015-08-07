package com.trev.fizzbuzz.inject.manual;

public class FizzBuzzManualInjection
{

    private final FizzBuzzNumberProvider numberProvider;

    public FizzBuzzManualInjection(final FizzBuzzNumberProvider numberProvider)
    {
        this.numberProvider = numberProvider;
    }

    public void doFizzBuzz()
    {
        numberProvider.getFizzBuzzNumbers();
    }

}
