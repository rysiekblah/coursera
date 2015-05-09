import scala.concurrent.{Promise, Future}
import concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}
case class TaxCut(reduction: Int)

object Government {
  def redeemCampaignPledge(): Future[TaxCut] = {
    println("Gov started")
    val p = Promise[TaxCut]()
    Future {
      println("Starting the new legislative period.")
      Thread.sleep(2000)
      p.success(TaxCut(20))
      println("We reduced the taxes! You must reelect us!!!!1111")
    }
    p.future
  }
}

val taxCutF: Future[TaxCut] = Government.redeemCampaignPledge()
println("Now that they're elected, let's see if they remember their promises...")
taxCutF.onComplete {
  case Success(TaxCut(reduction)) =>
    println(s"A miracle! They really cut our taxes by $reduction percentage points!")
  case Failure(ex) =>
    println(s"They broke their promises! Again! Because of a ${ex.getMessage}")
}