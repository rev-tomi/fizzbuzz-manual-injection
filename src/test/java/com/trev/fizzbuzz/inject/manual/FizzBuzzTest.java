package com.trev.fizzbuzz.inject.manual;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FizzBuzzTest
{

    private FizzBuzzManualInjection sut;

    @Mock
    private FizzBuzzNumberProvider numberProvider;

    @Mock
    private FizzBuzzTextProvider textProvider;

    @Mock
    private FizzBuzzPrinter printer;

    @BeforeMethod
    public void setUp()
    {
        final Stream<Integer> oneTwoThree = IntStream.of(1, 2, 3).boxed();
        MockitoAnnotations.initMocks(this);
        when(numberProvider.getFizzBuzzNumbers()).thenReturn(oneTwoThree);
        sut = new FizzBuzzManualInjection(numberProvider, textProvider, printer);
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

    @Test
    public void testMessagePrinted()
    {
        // GIVEN
        final String defaultMsg = "TEST";
        final Answer<String> numberedTestAnswer = new Answer<String>()
        {
            @Override
            public String answer(final InvocationOnMock invocation) throws Throwable
            {
                final Integer num = (Integer) invocation.getArguments()[0];
                return defaultMsg + " " + num;
            }
        };
        doAnswer(numberedTestAnswer).when(textProvider).getFizzBuzzText(anyInt());

        // WHEN
        sut.doFizzBuzz();

        // THEN
        final InOrder order = Mockito.inOrder(printer);
        order.verify(printer).printFizzBuzz(defaultMsg + " 1");
        order.verify(printer).printFizzBuzz(defaultMsg + " 2");
        order.verify(printer).printFizzBuzz(defaultMsg + " 3");
    }

}
