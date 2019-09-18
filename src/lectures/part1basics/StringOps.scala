/*
 * Created by Hugo Brito on 18/9/2019.
 */

package lectures.part1basics

object StringOps extends App {

	val str: String = "Hello, I am learning Scala"

	// Java functions that are also available in Scala
	println(str.charAt(2))
	println(str.substring(7, 11))
	// from index 7 (inclusive) until index 11 (exclusive)
	println(str.split(" ").toList)
	println(str.startsWith("Hello"))
	println(str.replace(" ", "-"))
	println(str.toLowerCase)
	println(str.length)
	println(str.reverse)

	// Scala-specific functions
	val aNumberString = "45"
	val aNumber = aNumberString.toInt
	println('a' +: aNumberString) // prepending 'a' to aNumberString
	println('a' +: aNumberString :+ 'z') // prepending 'a' and appending 'z'

	// Scala-specific: String interpolators
	val name = "David"
	val age = 12
	val greeting = s"Hello, name is $name and I am $age years old"
	// s tells that there will be other Strings injected in greeting
	// $ specifies where in the string and calls the name of the other strings
	val anotherGreeting = s"Hello, my name is $name and I will be turning ${age + 1} years old"
	println(anotherGreeting)

	// F-interpolators
	val speed = 1.2f
	val myth = f"$name%s can eat $speed%2.2f burgers per minute"
	println(myth)

	// raw-interpolator
	println(raw"This is a \n newLine") // prints literally
	val escaped = "This is a \n newLine"
	println(raw"$escaped") // still prints new line

}
