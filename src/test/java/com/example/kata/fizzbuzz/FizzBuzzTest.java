package com.example.kata.fizzbuzz;

import com.example.kata.fizzbuzz.strategy.FizzBuzzStrategy;
import com.example.kata.fizzbuzz.strategy.MultipleOf;
import com.example.kata.fizzbuzz.strategy.MultipleOf3AndGreaterThan6Strategy;
import com.example.kata.fizzbuzz.strategy.MultipleOf5Strategy;
import com.example.kata.fizzbuzz.strategy.ResultAsTheNumberStrategy;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class FizzBuzzTest {

	private FizzBuzz fizzBuzz;
	private FizzBuzzResult fizzBuzzResult;

	@Before
	public void setUp () {
		fizzBuzzResult = new FizzBuzzResult();

		this.fizzBuzz = new FizzBuzz(
				new MultipleOf3AndGreaterThan6Strategy(new MultipleOf(3), fizzBuzzResult),
				new MultipleOf5Strategy(new MultipleOf(5), fizzBuzzResult),
				new ResultAsTheNumberStrategy(fizzBuzzResult));
	}

	@Test
	public void should_return_the_same_value_for_non_multiples_of_3_or_5 () {
		assertThat(fizzbuzz(3), is("3"));
	}

	@Test
	public void should_return_fizz_for_multiples_of_3_greater_or_equal_than_6 () {
		assertThat(fizzbuzz(6), is("Fizz"));
	}

	@Test
	public void should_return_buzz_for_multiples_of_5 () {
		assertThat(fizzbuzz(5), is("Buzz"));
	}

	@Test
	public void should_return_fizzbuzz_for_multiples_of_5_and_3_greater_or_equal_than_30 () {
		assertThat(fizzbuzz(30), is("Fizz" + "Buzz"));
	}

	@Test
	public void should_use_all_injected_strategies () {

		final FizzBuzzStrategy first = mock(FizzBuzzStrategy.class);
		final FizzBuzzStrategy second = mock(FizzBuzzStrategy.class);
		final FizzBuzz sut = new FizzBuzz(first, second);
		sut.getFor(1);
		verify(first).apply(anyInt());
		verify(second).apply(anyInt());
	}

	private String fizzbuzz (int n) {
		fizzBuzz.getFor(n);
		return fizzBuzzResult.get();
	}


}
