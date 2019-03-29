package recfun 
object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
        if(c==0 || c==r) 1 else pascal(c-1,r-1) + pascal(c, r-1)
    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
        def stack(ipt: List[Char], cnt: Int): Int = {
            if(ipt.isEmpty || cnt <0) cnt
            else{
            if(ipt.head == '(') stack(ipt.tail, cnt+1)
            else if(ipt.head == ')') stack(ipt.tail, cnt-1)
            else stack(ipt.tail, cnt)
            }
        }

        if(stack(chars, 0)!=0) false else true
    }


  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
        if(money == 0) 1
        else if(coins.isEmpty) 0
        else{
            if(money >= coins.head) countChange(money - coins.head, coins) + countChange(money, coins.tail)
            else countChange(money, coins.tail)
        }
    }
  }
