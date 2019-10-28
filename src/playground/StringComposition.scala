/*
 * Created by Hugo Brito on 28/10/2019.
 */

/*
 * Created by Hugo Brito on 28/10/2019.
 */

package playground

object StringComposition extends App {

	val DATA_PATH = "data/"

	// the data to be used for the k-fold and the perceptron
	val REVIEW_DATASET: String = "test.json"

	// the output will be saved as a csv file with the name of the input file used
	val OUTPUT = s"${DATA_PATH}output/$REVIEW_DATASET".replace(".","-")

	val glove = s"${DATA_PATH}glove.6B/glove.6B.50d.txt"
	val reviews = s"${DATA_PATH}reviews/$REVIEW_DATASET"

	println(OUTPUT)
	println(reviews)
}