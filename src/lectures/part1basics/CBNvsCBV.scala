/*
 * Created by Hugo Brito on 18/9/2019.
 */

package lectures.part1basics

object CBNvsCBV extends App {

	def calledByValue(x: Long): Unit = {
		println("by value: " + x)
		println("by value: " + x) // x, the parameter is evaluated before the function is called and
		// stays the same through the computation
	}
	// by value: 49839275677500
	// by value: 49839275677500

	def calledByName(x: => Long): Unit = {
		// => tells the compiler that x is called by name
		// it delays the evaluation of the expression passed as parameter
		// the expression is evaluated every time it is used
		println("by name: " + x)
		println("by name: " + x) // x is evaluated a second time
		// lazy evaluation
	}
	// by name: 49839327481200
	// by name: 49839327514300

	calledByValue(System.nanoTime())
	calledByName(System.nanoTime())

	def infinite(): Int = 1 + infinite() // infinite loop
	def printFirst(x: Int, y: => Int) = println(x)

	// printFirst(infinite(), 34) // Exception in thread "main" java.lang.StackOverflowError
	printFirst(34, infinite()) // prints 34 and doesn't crash because the second parameter is lazy
}
