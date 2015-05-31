package com.example.kata.fizzbuzz;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FizzBuzzResultTest {

	private FizzBuzzResult fizzBuzzResult;

	@Before
	public void setUp () throws Exception {
		fizzBuzzResult = new FizzBuzzResult();
	}

	@Test
	public void should_be_empty_by_default () {

		assertThat(fizzBuzzResult.isEmpty(), is(true));
	}

	@Test
	public void should_not_be_empty_after_adding_a_suffix () {
		fizzBuzzResult.append("any");
		assertThat(fizzBuzzResult.isEmpty(), is(false));
	}

}
