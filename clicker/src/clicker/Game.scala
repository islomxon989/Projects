package clicker

import clicker.equipment._
import play.api.libs.json.{JsValue, Json}

class Game {

  // Do not change these state variable names, types, or initial values
  //
  // These same names, types, and initial values will be the same in all submissions on AutoLab so you can
  //  use these in your test cases
  var gold: Double = 0.0
  var lastUpdateTime: Long = System.nanoTime()
  var equipment: Map[String, Equipment] = Map("shovel" -> new Shovels, "excavator" -> new Excavators, "mine" -> new GoldMines)
  //

  def goldPerSecond(): Double = {
    var total1: Double = 0.0
    for ((k, v) <- equipment){
      total1 = total1 + v.goldPerSecond()
    }
    total1
  }

  def goldPerClick(): Double = {
    var total2: Double = 0.0
    for ((k, v) <- equipment){
      total2 = total2 + v.goldPerClick()
    }
    total2 + 1
  }

  def clickGold(): Unit = {
  val a: Double = goldPerClick()
    gold = gold + a

  }

  def buyEquipment(equipmentKey: String): Unit = {
   val neweq = equipment(equipmentKey)
    if (gold >= neweq.costOfNextPurchase())
      gold -= neweq.costOfNextPurchase()
    neweq.buy()
  }

  /**
    * takes the current epoch time in nanoseconds
    */
  def update(time: Long): Unit = {
    var a = time - lastUpdateTime
    var b = a / 1e+9
    gold += (goldPerSecond() * b)
    lastUpdateTime = time
  }


  def toJSON(): String = {
   val gol: JsValue = Json.toJson(gold)
    val las: JsValue = Json.toJson(lastUpdateTime)

    val a = equipment("shovel").numberOwned
    val b: JsValue = Json.toJson(a)
    val c = "Shovel"
    val d: JsValue = Json.toJson(c)

    val shov: Map[String, JsValue] = Map(
     "numberOwned" -> b,
      "name" -> d
    )

    val e = equipment("excavator").numberOwned
    val f: JsValue = Json.toJson(e)
    val g = "Excavator"
    val h: JsValue = Json.toJson(g)

    val exc: Map[String, JsValue] = Map(
      "numberOwned" -> f,
      "name" -> h
    )

    val i = equipment("mine").numberOwned
    val j: JsValue = Json.toJson(i)
    val k = "Gold Mine"
    val l: JsValue = Json.toJson(k)

    val golds: Map[String, JsValue] = Map(
      "numberOwned" -> j,
      "name" -> l
    )

    val shovjs: JsValue = Json.toJson(shov)
    val excjs: JsValue = Json.toJson(exc)
    val goljs: JsValue = Json.toJson(golds)

    val eq: Map[String, JsValue] = Map(
      "shovel" -> shovjs,
      "excavator" -> excjs,
      "mine" -> goljs
    )
    val eq1: JsValue = Json.toJson(eq)

    val objects: Map[String, JsValue] = Map(
      "gold" -> gol,
      "lastUpdateTime" -> las,
      "equipment" -> eq1
    )


    Json.stringify(Json.toJson(objects))
  }


  def fromJSON(jsonGameState: String): Unit = {
   val parse: JsValue = Json.parse(jsonGameState)
    val gold: Double = (parse \ "gold").as[Double]
    val lastUpdateTime: Long = (parse \ "lastUpdateTime").as[Long]
    val shovelnumberowned: Int = (parse\"equipment"\"shovel"\"numberOwned").as[Int]
    val shovelname: String = (parse\"equipment"\"shovel"\"name").as[String]
    val excnumberowned: Int = (parse\"equipment"\"excavator"\"numberOwned").as[Int]
    val excname: String = (parse\"equipment"\"excavator"\"name").as[String]
    val minenumberowned: Int = (parse\"equipment"\"mine"\"numberOwned").as[Int]
    val minename: String = (parse\"equipment"\"mine"\"name").as[String]
    equipment("shovel").numberOwned = shovelnumberowned
    equipment("shovel").name = shovelname
    equipment("excavator").numberOwned = excnumberowned
    equipment("excavator").name = excname
    equipment("mine").numberOwned = minenumberowned
    equipment("mine").name = minename






  }


  // Given
  def goldString(): String = {
    f"$gold%1.0f"
  }

  def buttonText(equipmentKey: String): String = {
    val thing: Equipment = this.equipment.getOrElse(equipmentKey, null) // will crash program if key not found
    val cost = thing.costOfNextPurchase()
    val gpc = thing.goldPerClick()
    val gps = thing.goldPerSecond()
    thing.name + f"\n$cost%1.0f gold\n$gpc%1.0f gpc\n$gps%1.0f gps\nowned: " + thing.numberOwned
  }

  //

}

object GoldMines{
  def main(args: Array[String]): Unit = {
    var y: Game = new Game
    println(y.lastUpdateTime)
  }
}




