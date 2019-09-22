/*
 * Created by Hugo Brito on 19/9/2019.
 */

package lectures.part2oop

object Objects {

	// SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")
	object Person { // object is its type and its only instance (in Scala)
		// "static"/"class" - level functionality

		// do not receive parameters
		val N_EYES = 2
		def canFly: Boolean = false

		// factory method
		def apply(mother: Person, father: Person): Person = new Person("Bobbie")
	}

	class Person(val name: String) {
		// instance-level functionality
	}

	def main(args: Array[String]): Unit = {

		println(Person.N_EYES)
		println(Person.canFly)

		// Scala object = SINGLETON INSTANCE
		val mary = new Person("Mary")
		val john = new Person("John")
		println(mary == john) // false --> they point to different object created with the keyword "new"

		val person1 = Person
		val person2 = Person
		println(mary == john) // true --> they point to the class

		val bobbie = Person(mary, john)

	}

	// Scala Application = Scala object with the following method:
	// def main(args: Array[String]): Unit = {}


}
