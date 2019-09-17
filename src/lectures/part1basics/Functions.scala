/*
 * Created by Hugo Brito on 17/9/2019.
 */

package lectures.part1basics

object Functions extends App {

	def aFunction(a: String, b: Int): String = { // an Expression
		a + " " + b
	}

	println(aFunction("hello",3)) // also an Expression

	def aParameterlessFunction(): Int = 42
	println(aParameterlessFunction())
	println(aParameterlessFunction) // the same

	def aRepeatedFunction(aString: String, n: Int): String = { // recursive functions need to have the return type!
		if (n == 1) aString
		else aString + " " + aRepeatedFunction(aString, n-1)
	}

	println(aRepeatedFunction("hello",3))

	// When in need of loops, use recursion

	def aFunctionWithSideEffects(aString: String): Unit = println(aString)

	def aBigFunction(n: Int): Int = {
		def aSmallerFunction(a: Int, b: Int): Int = a + b

		aSmallerFunction(n, n-1)
	}

	/* Write functions that do the following:
		1. A greeting function (name, age) => "Hi, my name is $name and I am $age years old."
		2. Factorial function 1 * 2 * 3 * .. * n
		3. A Fibonacci function
			f(1) = 1
			f(2) = 1
			f(n) = f(n - 1) + f(n - 2)
		4. Test if a number is prime
	 */

	// 1.

	def greeting(name: String, age: Int) = "Hi, my name is " + name + " and I am " + age + " years old."
	println(greeting("Hugo", 29))

	// 2.

	def factorial(n: Int): Int = n match {
		case n if (n <= 0) => 1
		case n => n * factorial(n-1)
	}

	println("0: " + factorial(0) + "\n1: " + factorial(1) + "\n5: " + factorial(5))

	def fibonacci(n: Int): Int = n match {
		case n if (n <= 2) => 1
		case n => fibonacci(n-1) + fibonacci(n-2)
	}

	println("0: " + fibonacci(0) + "\n1: " + fibonacci(1) + "\n5: " + fibonacci(5))

	def isPrime(n: Int): Boolean = {
		def isPrimeUntil(t: Int): Boolean =
			if (t <= 1) true
			else n % t !=0 && isPrimeUntil(t-1)

		isPrimeUntil(n / 2)
	}

	println(isPrime(37))
	println(isPrime(2003))
	println(isPrime(37 * 17))

}
