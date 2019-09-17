/*
 * Created by Hugo Brito on 17/9/2019.
 */

package lectures.part1basics

object ValuesVariableTypes extends App {
  // extending App allows for running the code in the IDE

  val x: Int = 42
  // syntax for declaring a value
  println(x)

  // vals are immutable
  // x = 2; -> so this, can't do

  val y = 42
  // compiler can infer types

  // val z: Int = "" // this can't do

  val aString: String = ""; // pieces of text between double quotes
  // semicolons are allowed but considered bad style
  val anotherString = "goodbye"

  val aBoolean: Boolean = false
  val aChar: Char = 'a' // single characters between single quotes
  val anInt: Int = x
  val aShort: Short = 6546 // needs to be short
  val aLong: Long = 4564217665465661464L
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  // variables
  var aVariable: Int = 4

  aVariable = 5 // side effects

}