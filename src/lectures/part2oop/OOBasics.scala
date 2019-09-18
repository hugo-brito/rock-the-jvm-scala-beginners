/*
 * Created by Hugo Brito on 18/9/2019.
 */

package lectures.part2oop

object OOBasics extends App {

	val person = new Person("John", 26) // every time a class is instantiated,
	// the whole body block is executed (including side-effects)

	println(person.age)
	println(person.x)
	person.greet("Daniel")
	person.greet()

	val author = new Writer("Charles","Dickens", 1812)
	val impostor = new Writer("Charles","Dickens", 1812)
	val novel = new Novel ("Great Expectations", 1861, author)

	println(novel.authorAge)
	println(novel.isWrittenBy(author))
	println(novel.isWrittenBy(impostor)) // should be the same but returns false

	val counter = new Counter
	counter.inc.print
	counter.inc.inc.inc.print
	counter.inc(10).print

}

class Person(name: String, val age: Int) { // constructor
	// name is parameter, age is a FIELD
	// class parameters are NOT FIELDS
	// default values also work here

	// body
	val x = 2 // this is a field

	println(1 + 3)

	// a method:
	def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

	// overloading: methods with same name, but different signatures
	def greet(): Unit = println(s"Hi, I am $name")


	// multiple constructors
	def this(name: String) = this(name, 0)

	// calls the primary constructor
	def this() = this("John Doe")
}

	/*
		Novel and a Writer

		Writer: first name, surname, year of birth
		- method full name

		Novel: name, year of release, author
		- authorAge
		- isWrittenBy(author)
		- copy (new year of release) = new instance of Novel
	 */

class Writer(firstName: String, surname: String, val year: Int) {
	def fullName: String = s"${firstName} ${surname}"
}

class Novel(name: String, val year: Int, author: Writer /* author is made a field so it can be accessed outside
 the class */) {
	def authorAge(): Int = year - author.year
	def isWrittenBy(author: Writer) = author == this.author
	def copy(newYear: Int): Novel = new Novel(name, newYear, author)
}
	/*
		Counter class
			- receive an int value
			- method current count
			- method to increment/decrement => new Counter
			- overload inc/dec to receive an amount
	 */

class Counter(val value: Int = 0) {
	// the getter method would be Counter.value
	def inc = {
		println("incrementing")
		new Counter(value + 1) // immutability
	}

	def dec = {
		println("decrementing")
		new Counter(value - 1)
	}

	def inc(n: Int): Counter = {
		if (n <= 0) this
		else inc.inc(n-1) // recursion
	}
	def dec(n: Int): Counter = {
		if (n <= 0) this
		else dec.dec(n-1) // recursion
	}

	def print = println(value)
}

