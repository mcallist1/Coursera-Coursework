package funsets

object Main extends App {
  import FunSets._

  // Give me An American
  val america = singletonSet(1)

  // Is the calling code of america 1?
  println(contains(america, 1))

  // Is the calling code of america 46?
  println(contains(america, 46))
}
