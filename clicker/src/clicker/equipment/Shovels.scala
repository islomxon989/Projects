package clicker.equipment

class Shovels extends Equipment {

  this.name = "Shovel"

  override def goldPerSecond(): Double = {
    return 0.0
  }

  override def goldPerClick(): Double = {
    return numberOwned
  }

  override def costOfNextPurchase(): Double = {
    var shovel = 10.0
    for (i <- 1 to numberOwned){
      shovel = shovel * 1.05
    }
    shovel
  }
}

