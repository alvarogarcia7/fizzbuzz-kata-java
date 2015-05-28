package com.example.kata.fizzbuzz;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FizzBuzzTest {

    private FizzBuzz fizzBuzz;

    @Before
    public void setUp() {
        this.fizzBuzz = new FizzBuzz();
    }

    @Test
    public void should_return_the_same_value_for_non_multiples_of_3_or_5() {
        assertThat(fizzbuzz(3), is("3"));
    }

    @Test
    public void should_return_fizz_for_multiples_of_3_greater_or_equal_than_6() {
        assertThat(fizzbuzz(6), is(FizzBuzz.FIZZ));
    }

    @Test
    public void should_return_buzz_for_multiples_of_5() {
        assertThat(fizzbuzz(5), is(FizzBuzz.BUZZ));
    }

    @Test
    public void should_return_fizzbuzz_for_multiples_of_5_and_3_greater_or_equal_than_30() {
        assertThat(fizzbuzz(30), is(FizzBuzz.FIZZ + FizzBuzz.BUZZ));
    }

    private String fizzbuzz(int n) {
        return fizzBuzz.getFizzBuzzFor(n);
    }


}
