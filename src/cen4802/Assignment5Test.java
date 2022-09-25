package cen4802;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Assignment5Test {
	
	@Test
	@DisplayName("User input test.")
	@Timeout(value = 20000, unit = TimeUnit.MILLISECONDS)
	void userInputTest() {
		assertNotNull(Assignment5.userInputInt("Please enter a number between 0 and 5 (inclusive): ", 0, 5));
	}

	@ParameterizedTest(name = "{index} => n={0}, result={1}")
	@DisplayName("Recursive Fibonacci calculation test.")
	@CsvSource({
		"1,0",
		"2,1",
		"3,1",
		"4,2",
		"5,3",
		"6,5",
		"7,8",
		"8,13",
		"9,21",
		"10,34",
	})
	@Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
	void recursiveTest(int n, int result) {
		assertEquals(result, Assignment5.recursiveFibSeq(n));
	}
	
	@ParameterizedTest(name = "{index} => a={0}, b={1}, c={2}")
	@DisplayName("Display results test.")
	@CsvSource({
		"11, 55, The 11th term of the Fibonacci sequence is 55.",
		"12, 89, The 12th term of the Fibonacci sequence is 89.",
		"13, 144, The 13th term of the Fibonacci sequence is 144.",
		"20, 4181, The 20th term of the Fibonacci sequence is 4181.",
		"21, 6765, The 21st term of the Fibonacci sequence is 6765.",
		"22, 10946, The 22nd term of the Fibonacci sequence is 10946.",
		"23, 17711, The 23rd term of the Fibonacci sequence is 17711.",
	})
	@Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
	void displayResultsTest(int a, int b, String c) {
		assertEquals(Assignment5.displayResult(a, b), c);
	}
	
}
