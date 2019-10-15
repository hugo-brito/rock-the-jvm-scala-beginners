/*
 * Created by Hugo Brito on 8/10/2019.
 */

package lectures.part2oop

object AnonymousClasses extends App {

	abstract class Animal {
		def eat: Unit
	}

	// anonymous class
	val funnyAnimal: Animal = new Animal {
		override def eat: Unit = println("ahahahahaha")
	}
	/*
		equivalent with

		class AnonymousClasses$$anon$1 extends Animal {
			override def eat: Unit = println("ahahahahah")
		}
		val funnyAnimal: Animal = new AnonymousClasses$$anon$1
	 */

	println(funnyAnimal.getClass)

	class Person(name: String) {
		def sayHi: Unit = println(s"Hi, my name is $name, how can I help?")
	}

	val jim = new Person("Jim") {
		override def sayHi: Unit = println(s"Hi, my name is Jim, how can I be of service?")
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

}
