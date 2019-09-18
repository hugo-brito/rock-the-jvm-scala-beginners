/*
 * Created by Hugo Brito on 18/9/2019.
 */

package lectures.part1basics

object DefaultArgs extends App {

	def trFact(n: Int, acc: Int = 1): Int =
		// acc: Int = 1 // this is the default value of the accumulator
		// if no accumulator is provided, the first one will start with 1
		if (n <= 1) acc
	else trFact(n-1, n*acc)

	val fact10 = trFact(10)
	// works

	def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = println("saving picture")
	savePicture(width = 800)

	/*
		1. pass in every leading argument
		2. name the arguments
	 */

	savePicture(height = 600, width = 600, format = "png")
	// works because we named the parameters
}
