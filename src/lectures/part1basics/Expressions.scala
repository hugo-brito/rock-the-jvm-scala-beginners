/*
 * Created by Hugo Brito on 17/9/2019.
 */

package lectures.part1basics

object Expressions extends App {
  val x = 1 + 2 // Expression
  println(x)

  println(2 + 3 * 4)
  // + - * / & | ^ << >> >>> (right shift with zero extension)
  // all the above work with integers and return integers

  println(1 == x) // inside the parenthesis is an expression and evaluates to a boolean
  // == != > >= < <=
  // return boolean values

  println(!(1 == x))
  // ! && ||
  // boolean operators for logic

  var aVariable = 2
  aVariable += 3 // also works with -= *= /=  ---> side effects only work with variables, not values
  println(aVariable)

  // Instructions (DO) vs Expressions (VALUE)

  // IF expression
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3 // IF Expression!! (returns a value)
  println(aConditionedValue)
  println((if(aCondition) 5 else 3) + 1)

  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }

  // EVERYTHING in Scala is an Expression

  val aWeirdValue = (aVariable = 3) // Unit === void
  println(aWeirdValue)
  // returns the following:
  // ()

  // side effects: println(), whiles, reassigning ---> instructions that return Unit

  val aCodeBlock = { // everything within braces is an expression.
                     // the value of this expression is the value of the last statement
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  }
  // anything defined inside a code block is not visible outside. F.ex:

  // val anotherValue = z + 1 // can't resolve z

  // Questions:
  // 1. Difference between "hello world" and println("hello world")?
  // The first is a String (as in a value of type String) the second is an instruction (as in print to the terminal) and
  // therefore had type Unit.

  // 2.

  val someValue = {
    2 < 3
  }
  // Boolean, true

  val someOtherValue = {
    if(someValue) 239 else 986
    42
  }
  // Int, 42


}
