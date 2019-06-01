package tests

import clicker.equipment.Equipment
import clicker.equipment.Shovels
import clicker.equipment.Excavators
import clicker.equipment.GoldMines

import org.scalactic.Pass

import org.scalatest._


class TestEquipment extends FunSuite {
 test("something") {
  val sh = new Shovels
  sh.numberOwned = 0
  assert(sh.goldPerClick() == 0.0)
  assert(sh.goldPerSecond() == 0.0)
  assert(sh.costOfNextPurchase() == 10.0)
  val sh1 = new Shovels
  sh1.numberOwned = 1
  assert(sh1.goldPerClick() == 1.0)
  assert(sh1.goldPerSecond() == 0.0)
  assert(sh1.costOfNextPurchase() == 10.50)


  val exc = new Excavators
  exc.numberOwned = 0
  assert(exc.goldPerClick() == 0.0)
  assert(exc.goldPerSecond() == 0.0)
  assert(exc.costOfNextPurchase() == 200.0)
  val exc1 = new Excavators
  exc1.numberOwned = 1
  assert(exc1.goldPerClick() == 20.0)
  assert(exc1.goldPerSecond() == 10.0)
  assert(exc1.costOfNextPurchase() == 220.00000000000003)

  val gold = new GoldMines
  gold.numberOwned = 0
  assert(gold.goldPerClick() == 0.0)
  assert(gold.goldPerSecond() == 0.0)
  assert(gold.costOfNextPurchase() == 1000.0)
  val gold1 = new GoldMines
  gold1.numberOwned = 1
  assert(gold1.goldPerClick() == 0.0)
  assert(gold1.goldPerSecond() == 100.0)
  assert(gold1.costOfNextPurchase() == 1100.0)
 }
}