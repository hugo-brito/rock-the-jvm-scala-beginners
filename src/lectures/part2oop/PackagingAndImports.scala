/*
 * Created by Hugo Brito on 16/10/2019.
 */

package lectures.part2oop

import playground.{Cinderella => Princess, PrinceCharming}

import java.util.Date
import java.sql.{Date => sqlDate}

object PackagingAndImports extends App {

	// package members are accessible by their simple name
	val writer = new Writer("Daniel", "RockTheJVM", 2018)

	// import the package
	val princess = new Princess // playground.Cinderella = fully qualified name

	// packages are in hierarchy
	// matching folder structure.

	// package object
	sayHello
	println(SPEED_OF_LIGHT)

	// imports
	val prince = new PrinceCharming

	// 1. Use Fully Qualified name
	val date = new Date
	// 2. use aliasing
	val sqlDate = new sqlDate(2018, 5, 4)

	// default imports
	// java.lang - String, Object, Exception
	// scala - Int, Nothing, Function
	// scala.Predef - println, ???
}