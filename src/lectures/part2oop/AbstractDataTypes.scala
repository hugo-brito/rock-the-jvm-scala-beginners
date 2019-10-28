/*
 * Created by Hugo Brito on 28/10/2019.
 */

/*
 * Created by Hugo Brito on 22/9/2019.
 */

package lectures.part2oop

object AbstractDataTypes extends App {

	// abstract
	abstract class Animal { // cannot be instantiated
		val creatureType: String = "Wild"
		def eat: Unit
	}

	class Dog extends Animal {
		override val creatureType: String = "Canine"
		def eat: Unit = println("crunch crunch")
	}

	// traits
	trait Carnivore { // "the ultimate abstract data type in Scala"
		def eat(animal: Animal): Unit // abstract fields and methods
		val preferredMeal: String = "fresh meat"

	}

	trait ColdBlooded
	class Crocodile extends Animal with Carnivore with ColdBlooded {
		override val creatureType: String = "croc"
		def eat: Unit = println("nomnomnom")
		def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")
	}

	val dog = new Dog
	val croc = new Crocodile
	croc.eat(dog)

	// traits vs abstract classes
	// 1 - traits do not have constructor parameter
	// 2 - multiple traits may be inherited by the same class
	// 3 - traits = behaviour, abstract class = "thing"

}
