package com.example.kata.fizzbuzz;

import com.example.kata.fizzbuzz.strategy.FizzBuzzStrategy;
import com.example.kata.fizzbuzz.strategy.MultipleOf;
import com.example.kata.fizzbuzz.strategy.MultipleOf5Strategy;
import org.junit.Before;
import org.junit.Test;

import static com.example.kata.fizzbuzz.util.TestDoubles.mock;
import static com.example.kata.fizzbuzz.util.TestDoubles.stub;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

public class MultipleOf5StrategyTest {

    private static final int ANY_VALUE = 0;
    private FizzBuzzStrategy sut;
    private MultipleOf multipleMock;
    private FizzBuzzResult fizzBuzzResult;

    @Before
    public void setUp () throws Exception {
        fizzBuzzResult = new FizzBuzzResult();
    }

    @Test
    public void should_ask_the_multiplication_collaborator(){
        multipleMock = mock(MultipleOf.class);
        sut = sutWith(multipleMock);

        act();

        verify(multipleMock).isMultipleOf(ANY_VALUE);
    }

    @Test
    public void should_add_fizz_when_the_condition_holds () {
        final MultipleOf multipleCollaborator = getMultipleCollaboratorThatAlwaysMatchesTheCondition();
        sut = sutWith(multipleCollaborator);

        final String result = act();

        assertThat(result, is("Buzz"));
    }

    private MultipleOf getMultipleCollaboratorThatAlwaysMatchesTheCondition () {
        final MultipleOf multipleCollaborator = stub(MultipleOf.class);
        doReturn(true).when(multipleCollaborator).isMultipleOf(anyInt());
        return multipleCollaborator;
    }

    private MultipleOf5Strategy sutWith (final MultipleOf multipleCollaborator) {
        return new MultipleOf5Strategy(multipleCollaborator, fizzBuzzResult);
    }

    private String act () {
        sut.apply(ANY_VALUE);
        return fizzBuzzResult.get();
    }

}
