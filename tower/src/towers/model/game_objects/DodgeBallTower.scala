package towers.model.game_objects

import play.api.libs.json.{JsValue, Json}
import towers.model.genetics.genes.Gene
import towers.model.physics.PhysicsVector

class DodgeBallTower(val x: Int, val y: Int) extends GameObject {

  // The height at which projectiles are fired
  val height = 3.0

  // Towers can only fire at players closer than this distance from the tower
  val sightRange = 5.0

  // The magnitude of the velocity at which projectiles are fired
  val projectileVelocity = 5.0


  def fire(jsonGameState: String): List[Projectile] = {
    var listprojectile: List[Projectile] = List()
    val parse: JsValue = Json.parse(jsonGameState)
    val players: List[Map[String, JsValue]] = (parse \ "players").as[List[Map[String, JsValue]]]
    var fplayerx = 0.0
    var fplayery = 0.0
    var mindistance = 5.1
    val towerloc = new PhysicsVector(this.x +0.5, this.y +0.5, height)
    for (user <- players){
      val playerx = user("x").as[Double]
      val playery = user("y").as[Double]
      val playerloc = new PhysicsVector(playerx, playery)
      var distance = playerloc.distance2d(towerloc)
      if(distance < sightRange && distance < mindistance){
        mindistance = distance
        fplayerx = playerx
        fplayery = playery
      }
    }
    if (mindistance == 5.1){
      return listprojectile
    }
    else {
      val xdifference: Double = fplayerx - towerloc.x
      val ydifference: Double = fplayery - towerloc.y
      val velocity: PhysicsVector = new PhysicsVector(xdifference, ydifference).normal2d()
      val newvelocity = new PhysicsVector(velocity.x * 5, velocity.y * 5)
      listprojectile = listprojectile :+ new Projectile(towerloc, newvelocity)
      listprojectile
    }
  }


  def aimFire(jsonGameState: String): List[Projectile] = {
    // TODO: Bonus Objective
    List()
  }


  // Suggested Genetic Algorithm setup
  def getFitnessFunction(targetPlayer: Player): PhysicsVector => Double = {
    null
  }

  def vectorIncubator(genes: List[Gene]): PhysicsVector = {
    null
  }

}
