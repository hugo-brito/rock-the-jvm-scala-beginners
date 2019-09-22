/*
 * Created by Hugo Brito on 22/9/2019.
 */

package lectures.part2oop

object AbstractDataTypes extends App {

	// abstract
	abstract class Animal { // cannot be instantiated
		val creatureType: String
		def eat: Unit
	}

	class Dog extends Animal {
		override val creatureType: String = "Canine"
		def eat: Unit = println("crunch crunch")
	}

	// traits
	trait Carnivore {
		def eat(animal: Animal): Unit

	}

	class Crocodile extends Animal with Carnivore {
		val creatureType: String = "croc"
		def eat: Unit = "nomnomnom"
		def eat(animal: Animal): Unit = s"I'm a croc and I'm eating ${animal.creatureType}"
	}

}
