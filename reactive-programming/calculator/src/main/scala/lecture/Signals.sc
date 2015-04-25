import calculator.{Signal, Var}

class BankAccount {
  val balance = Var(0)
  def deposit(amount: Int): Unit  = {
    if (amount > 0) {
      val b = balance()
      balance() = b + amount
    }
  }

  def withdraw(amount: Int): Int = {
    if(amount > 0 && amount <= balance()) {
      val b = balance()
      balance() = b - amount
      balance()
    } else throw new Error("You don't have money buddy!")
  }
}

def consolidator(accounts: List[BankAccount]): Signal[Int] =
  Signal(accounts.map(_.balance()).sum)

val a = new BankAccount
val b = new BankAccount
val c = consolidator(List(a, b))
a deposit 200
b deposit 37
c()
val xchange = Signal(256)
val inCurrency = Signal(c()* xchange())
inCurrency()