package com.trev.fizzbuzz.inject.manual;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FizzBuzzTest
{

    private FizzBuzzManualInjection sut;

    @Mock
    private FizzBuzzNumberProvider numberProvider;

    @Mock
    private FizzBuzzTextProvider textProvider;

    private Stream<Integer> oneTwoThree;

    @BeforeMethod
    public void setUp()
    {
        oneTwoThree = IntStream.of(1, 2, 3).boxed();
        MockitoAnnotations.initMocks(this);
        when(numberProvider.getFizzBuzzNumbers()).thenReturn(oneTwoThree);
        sut = new FizzBuzzManualInjection(numberProvider, textProvider);

        //        oneTwoThree = IntStream.of(1, 2, 3).boxed();
        //        doReturn(oneTwoThree).when(sut).getFizzBuzzNumbers();
        //        doNothing().when(sut).printFizzBuzz(anyString());
    }

    @Test
    public void testStreamRetrieved()
    {
        // WHEN
        sut.doFizzBuzz();

        // THEN
        verify(numberProvider).getFizzBuzzNumbers();
    }

    @Test
    public void testTextGenerated()
    {
        // WHEN
        sut.doFizzBuzz();

        // THEN
        final InOrder order = Mockito.inOrder(textProvider);
        order.verify(textProvider).getFizzBuzzText(1);
        order.verify(textProvider).getFizzBuzzText(2);
        order.verify(textProvider).getFizzBuzzText(3);
    }

}
