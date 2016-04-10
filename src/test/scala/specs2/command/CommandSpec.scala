package specs2.command

import mars.command._
import mars.compass.Compass
import mars.model.Rover
import org.junit.runner.RunWith
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CommandSpec extends Specification {

  "Left command" should {

    val left = new Left

    "returns West when receives North" in {
      val rover = new Rover(Compass.North)
      left.execute(rover)

      rover.getCurrentDirection ==== Compass.West
    }

    "returns East when receives South" in {

      val rover = new Rover(Compass.South)
      left.execute(rover)

      rover.getCurrentDirection ==== Compass.East
    }

    "returns South when receives West" in {

      val rover = new Rover(Compass.West)
      left.execute(rover)

      rover.getCurrentDirection ==== Compass.South
    }

    "returns North when receives East" in {

      val rover = new Rover(Compass.East)
      left.execute(rover)

      rover.getCurrentDirection ==== Compass.North
    }
  }

  "Right command" should {

    val right = new Right

    "returns East when receives North" in {
      val rover = new Rover(Compass.North)
      right.execute(rover)

      rover.getCurrentDirection ==== Compass.East
    }

    "returns West when receives South" in {

      val rover = new Rover(Compass.South)
      right.execute(rover)

      rover.getCurrentDirection ==== Compass.West
    }

    "returns North when receives West" in {

      val rover = new Rover(Compass.West)
      right.execute(rover)

      rover.getCurrentDirection ==== Compass.North
    }

    "returns South when receives East" in {

      val rover = new Rover(Compass.East)
      right.execute(rover)

      rover.getCurrentDirection ==== Compass.South
    }
  }

  "Unknown command" should {

    "throws an UnsupportedOperationException always" in {

      val unknown = new Unknown
      unknown.execute(new Rover()) must throwA[UnsupportedOperationException]
    }
  }
}
