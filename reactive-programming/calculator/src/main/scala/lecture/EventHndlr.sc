
trait Subscriber {
  def handler(pub: Publisher)
}

trait Publisher {
  private var subscribers: Set[Subscriber] = Set()
  def subscribe(subscriber: Subscriber) =
    subscribers += subscriber
  def unsubscribe(subscriber: Subscriber) =
    subscribers -= subscriber
  def publish() = subscribers.foreach(_.handler(this))
}

class BankAccount extends Publisher {
  private var balance = 0
  def currentBalance: Int = balance
  def deposit(amount: Int): Unit  = {
    if (amount > 0) {
      balance = balance + amount
      publish()
    }
  }

  def withdraw(amount: Int): Int = {
    if(amount > 0 && amount <= balance) {
      balance = balance - amount
      publish()
      balance
    } else throw new Error("You don't have money buddy!")
  }
}

class Consolidator(observed: List[BankAccount]) extends Subscriber {
  observed.foreach(_.subscribe(this))
  compute()

  private var total: Int = _

  private def compute() = total = observed.map(_.currentBalance).sum

  override def handler(pub: Publisher): Unit = compute()

  def totalBalance = total
}

val a = new BankAccount
val b = new BankAccount
b.deposit(100)
val c = new Consolidator(List(a, b))

c.totalBalance
