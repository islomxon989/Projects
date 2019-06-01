package calculator.controller

import calculator.model.Calculator
import javafx.event.{ActionEvent, EventHandler}
class EqualAction(calculator: Calculator) extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit = {
    calculator.Equal()
  }
}

class ClearAction(calculator: Calculator) extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit = {
    calculator.Clear()
  }
}

class DecimalAction(calculator: Calculator) extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit = {
    calculator.Decimal()
  }
}

class NumberAction(calculator: Calculator, number: Int) extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit = {
    calculator.Action(number)
  }
}

class AdditionAction(calculator: Calculator) extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit = {
    calculator.Addition()
  }
}

class SubtractionAction(calculator: Calculator) extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit = {
    calculator.Subtraction()
  }
}

class MultiplicationAction(calculator: Calculator) extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit = {
    calculator.multiplication()

  }
}

class DivisionAction(calculator: Calculator) extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit = {
    calculator.Division()
  }
}