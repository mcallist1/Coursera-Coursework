package recfun

object Main {

  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
    val test : String = "(((hello)there)you)("
    println(balance(test.toList))
    println()
    println()

    println(sumInts(1,3))
    println(sumCubes(1,300))
    println(sumTail(x => x * x , 1, 3))

    println(sumCubesCurry(1,10))
    println(sumCurry(x => x * x * x)(1,10))



  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      if(c == 0 || c ==r) 1 else pascal(c,r-1) + pascal(c-1,r-1);
    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      val paren_close = chars.indexOf(')')
      if(paren_close == -1){
        if(chars.indexOf('(') == -1){
          return true;
        }
      }

      val paren_start = (chars.take(paren_close)).lastIndexOf('(')
      if(paren_start == -1){
        return false;
      }

     val  extract = (chars.take(paren_start) ::: chars.takeRight(chars.length -(paren_close+1)))

      return balance(extract)

    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = 1;

/**
    def sumInts(a: Int, b: Int): Int =
      if(a > b) 0 else a + sumInts(a + 1, b)


    def cube(x: Int): Int = x * x * x

    def sumCubes(a: Int, b: Int): Int =
      if(a > b) 0 else cube(a) + sumCubes(a + 1, b)

  */

  def sum(f: Int => Int, a: Int, b: Int): Int =
    if(a > b) 0
    else f(a) + sum(f, a+1, b)

  def sumInts (a: Int, b: Int) = sum(x => x,a,b)
  def sumCubes(a: Int, b: Int) = sum(x => x * x * x, a,b)


  def sumTail(f: Int => Int, a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, f(a) + acc)
    }
    loop(a, 0)
  }


  //Currying reduces the code amount even more

  def sumCurry(f: Int=> Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int =
      if(a > b) 0
      else f(a) + sumF(a + 1, b)
    sumF
  }

  def sumIntsCurry = sumCurry(x => x)
  def sumCubesCurry = sumCurry(x => x * x * x)



  }



