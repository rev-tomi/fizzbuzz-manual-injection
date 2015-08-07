package com.trev.fizzbuzz.inject.manual;

public class FizzBuzzTextProvider
{

    public String getFizzBuzzText(final Integer num)
    {
        if (num % 15 == 0)
        {
            return "FizzBuzz";
        }
        if (num % 5 == 0)
        {
            return "Buzz";
        }
        if (num % 3 == 0)
        {
            return "Fizz";
        }
        return num.toString();
    }
}
