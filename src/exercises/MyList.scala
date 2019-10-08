/*
 * Created by Hugo Brito on 25/9/2019.
 */

package exercises

abstract class MyList[+A] {

	/*
		head: Int = first element of the list
		tail: Int = remainder of the list
		isEmpty: Boolean = is this list empty
		add(Int): List => new list with this element added
		override toString => a string representation of the list
	 */

	def head: A
	def tail: MyList[A]
	def isEmpty: Boolean
	def add[B >: A](elem: B): MyList[B]
	// polymorphic call
	def printElements: String
	override def toString: String = "[" + printElements + "]"

}

object Empty extends MyList[Nothing] {
	def head: Nothing = throw new NoSuchElementException
	def tail: MyList[Nothing] = throw new NoSuchElementException
	def isEmpty: Boolean = true
	def add[B >: Nothing](elem: B): MyList[B] = new Cons(elem, Empty)
	override def printElements: String = ""
}

class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
	def head: A = h
	def tail: MyList[A] = t
	def isEmpty: Boolean = false
	def add[B >: A](elem: B): MyList[B] = new Cons(elem, this)
	override def printElements: String =
		if(t.isEmpty) "" + h
		else h + " " + t.printElements
}

object ListTest extends App {
	val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
	println(list.head)
	println(list.add(4).head)
	println(list.isEmpty)
	println(list.toString)

	val listOfInteger: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
	val listOfStrings: MyList[String] = new Cons("Hello", new Cons("Scala", Empty))

	println(listOfInteger.toString)
	println(listOfStrings.toString)

}