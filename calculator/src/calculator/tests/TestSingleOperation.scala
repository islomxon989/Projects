package calculator.tests

import calculator.controller._
import calculator.model.Calculator
import org.scalatest._

class TestSingleOperation extends FunSuite {

  test("multiplication") {
    val calculator = new Calculator()
    new NumberAction(calculator, 2).handle(null)
    new MultiplicationAction(calculator).handle(null)
    new NumberAction(calculator, 4).handle(null)
    new EqualAction(calculator).handle(null)
    assert(calculator.displayNumber() == 8.0)
  }

  test("subtraction"){
    val calculator = new Calculator()
    new NumberAction(calculator, 10).handle(null)
    new SubtractionAction(calculator).handle(null)
    new NumberAction(calculator, 4).handle(null)
    new EqualAction(calculator).handle(null)
    assert(calculator.displayNumber() == 6.0)
  }

  test("division"){
    val calculator = new Calculator()
    new NumberAction(calculator, 7).handle(null)
    new DivisionAction(calculator).handle(null)
    new NumberAction(calculator, 2).handle(null)
    new EqualAction(calculator).handle(null)
    assert(calculator.displayNumber() == 3.5)
  }

  test("addition"){
    val calculator= new Calculator()
    new NumberAction(calculator, 1).handle(null)
    new AdditionAction(calculator).handle(null)
    new NumberAction(calculator, 8).handle(null)
    new EqualAction(calculator).handle(null)
    assert(calculator.displayNumber() == 9.0)
  }
  test("double equal"){
    val calculator = new Calculator()
    new NumberAction(calculator, 4).handle(null)
    new MultiplicationAction(calculator).handle(null)
    new NumberAction(calculator, 4).handle(null)
    new EqualAction(calculator).handle(null)
    new EqualAction(calculator).handle(null)
    assert(calculator.displayNumber() == 64.0)
  }
}
