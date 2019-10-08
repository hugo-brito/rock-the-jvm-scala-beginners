/*
 * Created by Hugo Brito on 25/9/2019.
 */

package lectures.part2oop

object Generics extends App {

	class MyList[+A] {
		// use the type A
		def add[B >: A](element: B): MyList[B] = ???
		// B is supertype of A
		// If to a list of A (which is subtype of B), I add and object of type B, the resulting list will be a list of B
		/*
		 A = Cat
		 B = Animal
		 */
	}

	class MyMap[Key, Value]

	val listOfIntegers = new MyList[Int]
	val listOfStrings = new MyList[String]

	// generic methods
	object MyList { // companion objects cannot be type parameterized
		def empty[A]: MyList[A] = ???
	}

	val emptyListOfIntegers = MyList.empty[Int]

	// variance problem
	class Animal
	class Cat extends Animal
	class Dog extends Animal

	// 1. yes List[Cat] extends List[Animal] = COVARIANCE
	class CovariantList[+A]
	val animal: Animal = new Cat
	val animalList: CovariantList[Animal] = new CovariantList[Cat]
	// animalList.add(new Dog) ??? => Yes, but then instead of a List[Cat] we return a list of animals

	// 2. No = INVARIANCE
	class InvariantList[A]
	val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

	// 3. Hell, no! CONTRAVARIANCE -- the opposite of COVARIANCE
	class ContravariantList[-A]
	val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]
	// another example
	class Trainer[-A]
	val trainer: Trainer[Cat] = new Trainer[Animal]

	//bounded types
	class Cage[A <: Animal](animal: A) // this is an upper bound type on Animal
	// only accepts subclasses of Animal (must be a subclass such as Cat, Dog)
	val cage = new Cage(new Dog)

	class Car
//	val newCage = new Cage(new Car)

	// expand MyList to be generic
}
