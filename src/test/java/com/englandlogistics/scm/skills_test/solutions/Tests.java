package com.englandlogistics.scm.skills_test.solutions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.englandlogistics.scm.skills_test.first.Fizzbuzz;
import com.englandlogistics.scm.skills_test.second.Fibonacci;
import com.englandlogistics.scm.skills_test.third.SumOfThree;
import com.englandlogistics.scm.skills_test.third.Triple;

public class Tests 
{
	@Test
	public void testFizzBuzz() {
		final int n = 100;
		List<String> results = Fizzbuzz.fizzBuzz(n);
		assertNotNull(results);
		//basic
		assertEquals("1", results.get(0));
		assertEquals("2", results.get(1));
		assertEquals("fizz", results.get(2));
		assertEquals("4", results.get(3));
		assertEquals("buzz", results.get(4));
		assertEquals("62", results.get(61));
		assertEquals("83", results.get(82));

		//Select tests. Testing this algorithmically gives away the algorithm!
		assertEquals("fizz", results.get(2));
		assertEquals("fizz", results.get(5));
		assertEquals("fizz", results.get(32));
		assertEquals("fizz", results.get(98));
		
		assertEquals("buzz", results.get(4));
		assertEquals("buzz", results.get(9));
		assertEquals("buzz", results.get(24));
		assertEquals("buzz", results.get(69));
		
		assertEquals("fizzbuzz", results.get(14));
		assertEquals("fizzbuzz", results.get(29));
		assertEquals("fizzbuzz", results.get(59));
		assertEquals("fizzbuzz", results.get(74));
		
		//Degenerate case
		results = Fizzbuzz.fizzBuzz(0);
		results = Fizzbuzz.fizzBuzz(-3);
	}
	
	@Test
	public void testFibonacci() {
		assertEquals(Fibonacci.fibonacci(1), 1);
		assertEquals(Fibonacci.fibonacci(2), 1);
		assertEquals(Fibonacci.fibonacci(3), 2);
		assertEquals(Fibonacci.fibonacci(4), 3);
		assertEquals(Fibonacci.fibonacci(5), 5);
		assertEquals(Fibonacci.fibonacci(6), 8);
		assertEquals(Fibonacci.fibonacci(7), 13);
		
		assertEquals(Fibonacci.fibonacci(20), 6765);
		assertEquals(Fibonacci.fibonacci(25), 75025);
		assertEquals(Fibonacci.fibonacci(30), 832040);
		
		assertEquals(Fibonacci.fibonacci(46), 1836311903);
		
		//assertEquals(Fibonacci.fibonacci(100), new BigInteger("354224848179261915075"));
		
		//assertEquals(Fibonacci.fibonacci(400), new BigInteger("222232244629420445529739893461909967206666939096499764990979600"));
		
		//TODO: Implement complex epsilon assertions
		//assertEquals(Fibonacci.fibonacci(3.5), ~ Complex(2.409 , -0.082));
		
	}
	
	@Test
	public void testSumOfThree() {
		//single solution
		validateTriple(new Integer[]{3, 15, -12, 10, -2, -3});
		
		//multiple solutions(long)
		validateTriple(new Integer[]{7, -11, 20, 9, 12, 5, 5, -6, -9, -13, -16, -7, 17, 20, 6, -8, 16, -5, 18, 7, -7, -7, 19, 12, 11, 17, -8, 4, 14, -15});
		
		//worst case
		validateTriple(new Integer[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,15,-15,0});
		
		//triple zero
		validateTriple(new Integer[]{0, 3, 15, -12, 0, 10, -2, -7, 0});
		
		//no solution
		Triple solution = SumOfThree.sumOfThree(Arrays.asList(new Integer[]{3, 11, 12, 10, -2, -3}));
		assertEquals(solution == null, true);
		
	}
	
	public void validateTriple(Integer[] args) {
		Triple solution = SumOfThree.sumOfThree(Arrays.asList(args));
		assertNotNull(solution);
		assertNotEquals(solution.x, solution.y);
		assertNotEquals(solution.x, solution.z);
		assertNotEquals(solution.y, solution.z);
		assertEquals(0, args[solution.x] + args[solution.y] + args[solution.z]);
	}
}
