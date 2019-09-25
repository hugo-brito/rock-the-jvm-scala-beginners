/*
 * Created by Hugo Brito on 25/9/2019.
 */

package exercises

abstract class MyList {
	def head: Int
	def tail: MyList
	def isEmpty: Boolean
	def add(elem: Int): MyList
	// polymorphic call
	def printElements: String
	override def toString: String = "[" + printElements + "]"

	/*
		head: Int = first element of the list
		tail: Int = remainder of the list
		isEmpty: Boolean = is this list empty
		add(Int): List => new list with this element added
		override toString => a string representation of the list
	 */

}

object Empty extends MyList {
	def head: Int = throw new NoSuchElementException
	def tail: MyList = throw new NoSuchElementException
	def isEmpty: Boolean = true
	def add(elem: Int): MyList = new Cons(elem, Empty)
	override def printElements: String = ""
}

class Cons(h: Int, t: MyList) extends MyList {
	def head: Int = h
	def tail: MyList = t
	def isEmpty: Boolean = false
	def add(elem: Int): MyList = new Cons(elem, this)
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

}