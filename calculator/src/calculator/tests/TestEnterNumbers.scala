package calculator.tests

  import calculator.controller.{AdditionAction, EqualAction, NumberAction}
  import calculator.model.Calculator
  import org.scalatest._

  class TestEnterNumbers extends FunSuite {

    val EPSILON: Double = 0.000001

    def equalDoubles(d1: Double, d2: Double): Boolean = {
      (d1 - d2).abs < EPSILON
    }

    test("yet") {
      val calc: Calculator = new Calculator()
      new NumberAction(calc, 1).handle(null)
      new NumberAction(calc, 2).handle(null)
      new NumberAction(calc, 3).handle(null)
      assert(calc.displayNumber() == 123.0)

      val calc2: Calculator = new Calculator()
      new NumberAction(calc2, 4).handle(null)
      new NumberAction(calc2, 5).handle(null)
      new NumberAction(calc2, 6).handle(null)
      assert(calc2.displayNumber() == 456.0)

      val calc3: Calculator = new Calculator()
      new NumberAction(calc3, 7).handle(null)
      new NumberAction(calc3, 8).handle(null)
      new NumberAction(calc3, 9).handle(null)
      assert(calc3.displayNumber() == 789.0)

      val calc4: Calculator = new Calculator()
      new NumberAction(calc4, 7).handle(null)
      new NumberAction(calc4, 0).handle(null)
      assert(calc4.displayNumber() == 70.0)

      val calc5: Calculator = new Calculator()
      new NumberAction(calc5, 1).handle(null)
      new NumberAction(calc5, 0).handle(null)
      new NumberAction(calc5, 2).handle(null)
      new NumberAction(calc5, 1).handle(null)
      assert(calc5.displayNumber() == 1021.0)

      val calc6: Calculator = new Calculator()
      new NumberAction(calc6, 1).handle(null)
      new NumberAction(calc6, 0).handle(null)
      new NumberAction(calc6, 2).handle(null)
      new NumberAction(calc6, 1).handle(null)
      new NumberAction(calc6, 1).handle(null)
      assert(calc6.displayNumber() == 10211.0)

      val calc7: Calculator = new Calculator()
      new NumberAction(calc7, 1).handle(null)
      assert(calc7.displayNumber() == 1.0)

      val calc8: Calculator = new Calculator()
      new NumberAction(calc8, 1).handle(null)
      new NumberAction(calc8, 0).handle(null)
      new NumberAction(calc8, 2).handle(null)
      new NumberAction(calc8, 1).handle(null)
      new NumberAction(calc8, 1).handle(null)
      new NumberAction(calc8, 1).handle(null)
      assert(calc8.displayNumber() == 102111.0)
    }
  }

