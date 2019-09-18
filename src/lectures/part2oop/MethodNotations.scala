/*
 * Created by Hugo Brito on 18/9/2019.
 */

import scala.language.postfixOps

package lectures.part2oop {

	object MethodNotations extends App {

		class Person(val name: String, favouriteMovie: String, val age: Int = 0) {
			def likes(movie: String): Boolean = movie == favouriteMovie
			def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
			def +(nickname: String): Person = new Person(s"$name ($nickname)", favouriteMovie)
			def unary_! : String = s"$name, what the heck?!"
			def unary_+ : Person = new Person(name, favouriteMovie, age + 1)
			def learns(what: String) = s"$name learns $what"
			def learnsScala = this learns "Scala"
			def isAlive: Boolean = true
			def apply(): String = s"Hi, my name is $name and I like $favouriteMovie"
			def apply(n: Int): String = s"$name watched $favouriteMovie $n times"
		}


		val mary = new Person("Mary", "Inception")
		println(mary.likes("Inception"))
		println(mary likes "Inception") // equivalent
		// (syntactic sugar)! Nicer ways to write more cumbersome methods
		// infix notation = operator notation (only works with method that only take 1 parameter)

		// "operators" in Scala
		val tom = new Person("Tom", "Fight Club")
		println(mary + tom) // equivalent to:
		println(mary.+(tom))

		println(1 + 2) // equivalent to:
		println(1.+(2))

		// ALL OPERATORS ARE METHODS.

		val x = -1 // equivalent to 1.unary_-
		val y = 1.unary_-
		// unary_ prefix only works with - + ~ !

		println(!mary)
		println(mary.unary_!)

		// postfix notation // only available to methods that don't take parameters

		println(mary.isAlive)
		println(mary isAlive)

		// apply

		println(mary.apply())
		println(mary()) // equivalent
		// when the compiler sees an object being called like a method without parameters, it will look for the apply method
		// and calls it

		/*
		1. Overload the + operator
			mary + "the rockstar" => new Person "Mary (the rockstar)" // same movie

		2. Add an age to the Person class (with default value 0)
			Add an unary + operation => new person with the age + 1
			+mary => mary with the age incrementer

		3. Add a "learns" method in the Person class => "Mary learns Scala"
			Add a learnsScala method, calls learns method with "Scala"
			Use it in postfix notation

		4. Overload the apply method
			mary.apply(2) => "Mary watched Inception 2 times"

	 */

		println((mary + "the Rockstar") ())
		println((+mary).age)
		println(mary learnsScala)
		println(mary(10)) // apply

	}

}
