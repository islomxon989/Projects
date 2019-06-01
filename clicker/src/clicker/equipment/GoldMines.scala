package clicker.equipment

class GoldMines extends Equipment{

  this.name = "Gold Mine"

  override def goldPerClick(): Double = {
    return 0.0
  }

  override def goldPerSecond(): Double = {
    return numberOwned * 100.0
  }

  override def costOfNextPurchase(): Double = {
    var mine = 1000.0
    for (i <- 1 to numberOwned){
      mine = mine * 1.1
    }
    mine
  }

}

object GoldMines{
  def main(args: Array[String]): Unit = {
    var y: GoldMines = new GoldMines
    y.numberOwned = 0
    println(y.costOfNextPurchase())
  }
}
