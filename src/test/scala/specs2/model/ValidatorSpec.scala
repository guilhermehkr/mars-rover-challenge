package specs2.model

import mars.command.{Unknown, Command}
import mars.compass._
import mars.model._
import org.junit.runner.RunWith
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner

import scala.collection.JavaConversions._

@RunWith(classOf[JUnitRunner])
class ValidatorSpec extends Specification {

  "Nok Validator" should {

    "when there is Nok status the rover should be filled with output message" in {

      val rover = new Rover(Compass.North, new Coordinate(1, 1), new Plateau(1, 1), Status.Nok, List.empty[Command])
      rover.validateMe()

      rover.getOutput ==== "The rover entry was malformed"
    }
  }

  "Unknown Command Validator" should {

    "when there is any invalid command, such as Unknown, the rover should be filled with output message" in {

      val rover = new Rover(Compass.North, new Coordinate(1, 1), new Plateau(1, 1), Status.Ok, List(new Unknown))
      rover.validateMe()

      rover.getOutput ==== "There is one invalid command at least, impossible to proceed"
    }
  }

  "Bottom Left Validator" should {

    "after moving the rover must be checked to find out if it is out of plateau" in {

      val rover = new Rover(Compass.North, new Coordinate(-2, -2), new Plateau(1, 1), Status.Ok, List.empty[Command])
      rover.validateMe()

      rover.getOutput ==== "The rover is outside of plateau bottom-left"
    }
  }

  "Upper Right Validator" should {

    "after moving the rover must be checked to find out if it is out of plateau" in {

      val rover = new Rover(Compass.North, new Coordinate(2, 2), new Plateau(1, 1), Status.Ok, List.empty[Command])
      rover.validateMe()

      rover.getOutput ==== "The rover is outside of plateau upper-right"
    }
  }

  "Unknown Compass Validator" should {

    "when there is Unknown compass the rover should be filled with output message" in {

      val rover = new Rover(Compass.Unknown, new Coordinate(2, 2), new Plateau(1, 1), Status.Ok, List.empty[Command])
      rover.validateMe()

      rover.getOutput ==== "The initial direction could not be read, impossible to proceed"
    }
  }
}
