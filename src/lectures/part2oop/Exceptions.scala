/*
 * Created by Hugo Brito on 16/10/2019.
 */

package lectures.part2oop

object Exceptions extends App {

	val x: String = null
//	println(x.length)
//  this ^^ will crash with a NPE

	// 1. throwing and catching exceptions

//	val aWeirdValue = throw new NullPointerException

	// throwable classes extend the Throwable class.
	// Exception and Error are the major Throwable subtypes

	// 2. how to catch exceptions
	def getInt(withException: Boolean): Int =
		if (withException) throw new RuntimeException("No int for you")
		else 42

	val potentialFail = try {
		// code that might throw
		getInt(true)
	} catch {
		case e: RuntimeException => 43
	} finally {
		// code that will get executed NO MATTER WHAT
		// optional
		// does not influence the return type of this expression
		// use finally only for side effects
		println("finally")
	}

	println(potentialFail)

	// 3. how to define my own exceptions
	class MyException extends Exception
	val exception = new MyException

//	throw exception

	/*
		1. Crash program with an OutOfMemoryError
		2. Crash with SOError
		3. Pocket Calculator
			- add(x,y)
			- subtract(x,y)
			- multiply(x,y)
			- divide(x,y)

			Throw
				- OverflowExpection if add(x,y) exceeds Int.MAX_VALUE
				- UnderflowException if subtract(x,y) exceeds Int.MIN_VALUE
				- MathCalculationException for division by 0
	 */
	// Out of Memory:
//	val array = Array.ofDim(Int.MaxValue)

	// Stack Overflow
//	def infinite: Int = 1 + infinite
//	val noLimit = infinite

	class OverflowException extends RuntimeException
	class UnderflowException extends RuntimeException
	class MathCalculationException extends RuntimeException("Division by 0")
	object PocketCalculator {
		def add(x: Int, y: Int) = {
			val result = x + y
			if (x > 0 && y > 0 && result < 0) throw new OverflowException
			else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
			else result
		}

		def subtract(x: Int, y: Int) = {
			val result = x - y
			if (x > 0 && y < 0 && result < 0) throw new OverflowException
			else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
			else result
		}

		def multiply(x: Int, y: Int) = {
			val result = x * y
			if (x > 0 && y > 0 && result < 0) throw new OverflowException
			else if (x < 0 && y < 0 && result < 0) throw new OverflowException
			else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
			else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
			else result
		}

		def divide(x: Int, y: Int) = {
			if (y == 0) throw new MathCalculationException
			else x / y
		}
	}

//	println(PocketCalculator.add(Int.MaxValue, 10))
	println(PocketCalculator.divide(2, 0))

}
