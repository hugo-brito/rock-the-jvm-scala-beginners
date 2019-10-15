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

	/*
		3. MyList:
		- map(transformer) => MyList
		- filter(predicate) => MyList
		- flatMap(transformer from A to MyList[B]) => MyList[B]
	 */

	def map[B] (transformer: MyTransformer[A, B]): MyList[B]
	def filter(predicate: MyPredicate[A]): MyList[A]
	def flatMap[B] (transformer: MyTransformer[A, MyList[B]]): MyList[B]

	// concatenation
	def ++[B >: A](list: MyList[B]): MyList[B]

}

object Empty extends MyList[Nothing] {
	def head: Nothing = throw new NoSuchElementException
	def tail: MyList[Nothing] = throw new NoSuchElementException
	def isEmpty: Boolean = true
	def add[B >: Nothing](elem: B): MyList[B] = new Cons(elem, Empty)
	override def printElements: String = ""

	def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = Empty
	def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty
	def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty

	def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
}

class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
	def head: A = h
	def tail: MyList[A] = t
	def isEmpty: Boolean = false
	def add[B >: A](elem: B): MyList[B] = new Cons(elem, this)
	override def printElements: String =
		if(t.isEmpty) "" + h
		else h + " " + t.printElements

	/*
		[1,2,3].map(n * 2)
		= new Cons(2, [2,3].map(n * 2))
		= new Cons(2, new Cons(4, [3].map(n * 2)))
		= new Cons(2, new Cons(4, new Cons(6, Empty.map(n * 2))))
		= new Cons(2, new Cons(
	 */
	def map[B](transformer: MyTransformer[A,B]) = new Cons(transformer.transform(h), t.map(transformer))

	/*
		[1,2,3].filter(n % 2 == 0) =
		  [2,3].filter(n % 2 == 0) =
		  = new Cons(2, [3].filter(n % 2 == 0))
		  = new Cons(2, Empty.filter(n % 2 == 0))
		  = new Cons(2, Empty)
	 */
	def filter(predicate: MyPredicate[A]): MyList[A] = {
		if (predicate.test(h)) new Cons(h, t.filter(predicate))
		else t.filter(predicate)
	}

	/*
		[1,2] ++ [3,4,5]
		= new Cons(1, [2] ++ [3,4,5])
		= new Cons(1, new Cons(2, Empty ++ [3,4,5]))
		= new Cons(1, new Cons(2, new Cons(3, new Cons(4 new Cons 5)))))
	 */
	def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)

	/*
		[1,2].flatMap(n => [n, n+1])
		= [1,2] ++ [2].flatMap(n => [n, n+1])
		= [1,2] ++ [2,3] ++ Empty.flatMap(n => [n, n+1])
		= [1,2] ++ [2,3] ++ Empty
		= [1,2,2,3]
	 */
	def flatMap[B] (transformer: MyTransformer[A, MyList[B]]): MyList[B] = {
		transformer.transform(h) ++ t.flatMap(transformer)
	}
}

/*
	1. Generic trait MyPredicate[-T] with a little method test(T) => Boolean
		-- tests whether T passes the condition
	2. Generic trait MyTransformer[-A, B] with a method transform(A) => B
		-- converts value of type A in value of type B
*/

trait MyPredicate[-T] {
	def test(elem: T): Boolean
}

trait MyTransformer[-A, B] {
	def transform(a: A): B
}

/*
	1. Generic trait MyPredicate[-T] with a little method test(T) => Boolean
		-- tests whether T passes the condition
	2. Generic trait MyTransformer[-A, B] with a method transform(A) => B
		-- converts value of type A in value of type B
	3. MyList:
		- map(transformer) => MyList
		- filter(predicate) => MyList
		- flatMap(transformer from A to MyList[B]) => MyList[B]

	class EvenPredicate extends MyPredicate[Int]
	class StringToIntTransformer extends MyTransformer[String, Int]

	[1,2,3].map(n * 2) = [2,4,6]
	[1,2,3,4].filter(n % 2) = [2,4]
	[1,2,3].flatMap(n => [n, n+1]) => [1,2,2,3,3,4]
 */

object ListTest extends App {
	val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
	println(list.head)
	println(list.add(4).head)
	println(list.isEmpty)
	println(list.toString)

	val listOfInteger: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
	val anotherListOfInteger: MyList[Int] = new Cons(4, new Cons(5, Empty))
	val listOfStrings: MyList[String] = new Cons("Hello", new Cons("Scala", Empty))

	println(listOfInteger.toString)
	println(listOfStrings.toString)

	println(listOfInteger.map(new MyTransformer[Int, Int] {
		override def transform(a: Int): Int = a * 2
	}).toString)

	println(listOfInteger.filter(new MyPredicate[Int] {
		override def test(elem: Int): Boolean = elem % 2 == 0
	}).toString)

	println((listOfInteger ++ anotherListOfInteger).toString)

	println(listOfInteger.flatMap(new MyTransformer[Int, MyList[Int]] {
		override def transform(a: Int): MyList[Int] = new Cons(a, new Cons[Int](a + 1, Empty))
	}).toString)

}