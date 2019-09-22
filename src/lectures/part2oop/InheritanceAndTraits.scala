/*
 * Created by Hugo Brito on 22/9/2019.
 */

package lectures.part2oop

object InheritanceAndTraits extends App {

	// single class : can only extend one class at a time
	sealed class Animal {
		// Animal is a superclass of cat
		private def breathe = println("uuuuuuuf") // only instances of Animal class can access it
		protected def eat = println("nomnom") // only instances of Animal and subclasses
		def publicMethod = println("can be publicly accessed") // can be called outside the class. Subclasses also
		// have access to it
		val creatureType = "Wild"
	}

	class Cat extends Animal {
		// Cat is a subclass of Animal
		// inherits all non private member of the superclass
		def crunch = {
			eat
			println("crunch crunch")
		}
	}

	val cat = new Cat
	cat.crunch

// constructors
class Person(name: String, age: Int) {
	def this(name: String) = this(name, 0)
}
	class Adult(name: String, age: Int, idCard: String) extends Person(name)

	// overriding
	class Dog (override val creatureType: String) extends Animal {
//		override val creatureType: String = "Domestic"
		override def eat = {
			super.eat
			println("crunch, crunch")
		}

		override def publicMethod: Unit = print("I'm a dog and I've overridden the method from the super class Animal")

	}
	// the same as:
//	class Dog (dogType: String) extends Animal {
//		override val creatureType: String = "dog"
//	}

	val dog = new Dog("K9")
	// by using super.eat in the subclass and provide further implementation, this method executes everything.
	println("dog.eat:")
	dog.eat
	println(dog.creatureType)

	// type substitution (broad: polymorphism)
	val unknownAnimal: Animal = new Dog("K9")
	// will always go the most overridden method whenever possible
	unknownAnimal.publicMethod
	// I'm a dog and I've overridden the method from the super class Animal

	// oveRIDING vs overLOADING

	// super

	// preventing overrides
	// 1 - use final on member -- prevents subclasses from overriding the methods from the superclass
	// 2 - use final on the class -- prevents the WHOLE class to be extended! It cannot have subclasses
	// 3 - seal the class -- = extend classes in THIS FILE, prevents extensions in other files

}
