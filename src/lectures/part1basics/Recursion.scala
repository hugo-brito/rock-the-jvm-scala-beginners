/*
 * Created by Hugo Brito on 17/9/2019.
 */

package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App{

	def factorial(n: Int): Int =
		if (n <= 1) 1
		else {
			println("Computing factorial of " + n + " - I first need the factorial of " + (n-1))
			val result = n * factorial(n-1)
			println("Computed factorial of " + n)

			result
		}

	println(factorial(10))
//	println(factorial(5000)) // Exception in thread "main" java.lang.StackOverflowError

	def anotherFactorial(n: Int): BigInt = {
		@tailrec
		def factHelper(x: Int, accumulator: BigInt): BigInt =
			if (x <= 1) accumulator
			else factHelper(x - 1, x * accumulator) // TAIL RECURSION = use the recursive call as the LAST expression

		factHelper(n, 1)
	}

	/*
		anotherFactorial(10) = factHelper(10, 1)
		= factHelper(9, 10 * 1)
		= factHelper(8, 9 * 10 * 1)
		= factHelper(7, 8 * 9 * 10 * 11)
		= ...
		= factHelper(2, 3 * 4 * ... * 10 * 1)
		= factHelper(1, 1 * 2 * 3 * 4 * ... * 10)
		= 1 * 2 * 3 * 4 * ... * 10
	 */

	println(anotherFactorial(5000)) // works!

	/* Write tail-recursive versions of:
		1. Concatenate a string n times
		2. IsPrime
		3. Fibonacci function
	 */

	// 1.

	def aRepeatedFunction(aString: String, n: Int) = { // recursive functions need to have the return type!
		if (n == 1) aString
		else {
			@tailrec
			def helper(n: Int, accumulator: String): String = {
				if (n == 0) accumulator
				else helper(n - 1, (aString + " " + accumulator))
			}

			helper(n, "")
		}
	}

	println(aRepeatedFunction("hello", 10))

	// 2.

	def isPrime(n: Int): Boolean = {
		@tailrec
		def isPrimeTailRec(t: Int, isStillPrime: Boolean): Boolean =
			// the accumulator has always the same type as the return type and stores the value of the computation
			// so far
			if (!isStillPrime) false
			else if (t <= 1) true
			else isPrimeTailRec(t - 1, n % t != 0 && isStillPrime)

		isPrimeTailRec(n / 2, true)
	}

	// it's already tail-recursive

	// 3.

	def fibonacci(n: Int) = {
		@tailrec
		def helper(i: Int, acc1: Int, acc2: Int): Int = {
			// the number of recursive calls of the recursive function is the number of accumulators I need
			if(i >= n) acc1
			else helper(i+1, acc1 + acc2, acc1)
		}
		if (n <= 2) 1
		else helper(2, 1, 1)
	}

	println("0: " + fibonacci(0) + "\n1: " + fibonacci(1) + "\n5: " + fibonacci(5) + "\n8: " + fibonacci(8))
}
