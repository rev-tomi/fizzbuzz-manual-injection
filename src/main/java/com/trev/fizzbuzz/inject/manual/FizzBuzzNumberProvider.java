package com.trev.fizzbuzz.inject.manual;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FizzBuzzNumberProvider
{
    public Stream<Integer> getFizzBuzzNumbers()
    {
        return IntStream.rangeClosed(1, 100).boxed();
    }

}
