package clicker.equipment

class Excavators extends Equipment{

  this.name = "Excavator"

  override def goldPerClick(): Double = {
    return numberOwned * 20.0
  }

  override def goldPerSecond(): Double = {
    return numberOwned * 10.0
  }

  override def costOfNextPurchase(): Double = {
    var excavator = 200.0
    for (i <- 1 to numberOwned){
      excavator = excavator * 1.1
    }
  excavator
  }

}
