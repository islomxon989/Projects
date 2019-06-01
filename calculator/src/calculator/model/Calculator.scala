package calculator.model

import calculator.controller.{AdditionAction, EqualAction, NumberAction}
class Calculator() {
  var add=0.0
  var sub=0.0
  var multiply=1.0
  var divide=1.0
  var multiplyM=0.0
  var multiplyD=0.0
  var multiplyA=0.0
  var multiplyS=0.0
  var userpart:Double=0
  var userString = ""
  def displayNumber(): Double = {
    userpart
  }
  def Clear():Unit={
    userpart=0
    add=0
    sub=0
    multiply=1
    divide=1
    multiplyM=0
    multiplyD=0
    multiplyA=0
    multiplyS=0
    userString = "0"
  }
  def Action(Int:Int):Unit={
    userString+=Int.toString()
    userpart=userString.toDouble
  }
  def Decimal():Unit={
    userString+="."
  }
  def multiplication():Unit={
    multiplyM=1.0
    multiply=userpart*multiply
    userString="0"
  }
  def Addition():Unit={
    multiplyA=1.0
    add+=userpart
    userString="0"
  }
  def Division():Unit={
    multiplyD=1.0
    divide=userpart/divide
    userString="0"
  }
  def Subtraction():Unit={
    multiplyS=1.0
    sub=userpart+sub
    userString="-"
  }
  def Equal():Unit={
    multiply=multiply*userString.toDouble*multiplyM
    add=(add+userString.toDouble)*multiplyA
    divide=(divide/userString.toDouble)*multiplyD
    sub=(sub+userString.toDouble)*multiplyS
    userpart=multiply+add+divide+sub
  }
}





