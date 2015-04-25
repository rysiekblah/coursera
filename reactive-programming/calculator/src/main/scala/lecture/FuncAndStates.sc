def iterate(n:Int, f:Int=>Int, x:Int): Int =
  if(n==0) x else iterate(n-1, f, f(x))

def square(x:Int) = x*x

iterate(1, square, 4)

class BankAccount {
  private var balance = 0;
  def deposit(amount: Int): Unit  = {
    if (amount > 0) balance = balance + amount
  }

  def withdraw(amount: Int): Int = {
    if(amount > 0 && amount <= balance) {
      balance = balance - amount
      balance
    } else throw new Error("You don't have money buddy!")
  }
}

val account = new BankAccount
account.deposit(1000)
account.withdraw(900)
account.withdraw(101)

//def cons[T](hd:T, t1: => Stream[T]) = new Stream[T] {
//  override def head = hd
//  private var t10pt: Option[Stream[T]]=None
//  def tail: T = t10pt match {
//    case Some(x) => x
//    case None => t10pt = Some(t1); tail
//  }
//}
