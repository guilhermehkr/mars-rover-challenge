package specs2.compass

import mars.compass.Compass._
import mars.model.Coordinate
import org.junit.runner.RunWith
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CompassSpec extends Specification {

  "Compass creational pattern" should {

    "returns East Compass Option when receives E/e ignoring case" in {

      from("E") ==== East
      from("e") ==== East
    }

    "returns West Compass Option when receives W/w ignoring case" in {

      from("W") ==== West
      from("w") ==== West
    }

    "returns North Compass Option when receives N/n ignoring case" in {

      from("N") ==== North
      from("n") ==== North
    }

    "returns South Compass Option when receives S/s ignoring case" in {

      from("S") ==== South
      from("s") ==== South
    }

    "returns Unknown Compass Option for any character" in {

      from("2332") ==== Unknown
      from("&*&") ==== Unknown
      from("%") ==== Unknown
      from("}+_)???") ==== Unknown
    }
  }

  "Compass implicit command pattern" should {

    "East should add 1 in X coordinate" in {
      East.move(new Coordinate(3, 4)) ==== new Coordinate(4, 4)
      East.move(new Coordinate(5, 2)) ==== new Coordinate(6, 2)
    }

    "West should subtract 1 in X coordinate" in {
      West.move(new Coordinate(3, 4)) ==== new Coordinate(2, 4)
      West.move(new Coordinate(5, 1)) ==== new Coordinate(4, 1)
    }

    "North should add 1 in Y coordinate" in {
      North.move(new Coordinate(2, 4)) ==== new Coordinate(2, 5)
      North.move(new Coordinate(4, 1)) ==== new Coordinate(4, 2)
    }

    "South should subtract 1 in Y coordinate" in {
      South.move(new Coordinate(3, 7)) ==== new Coordinate(3, 6)
      South.move(new Coordinate(4, 9)) ==== new Coordinate(4, 8)
    }

    "Unknown should throw an UnsupportedOperationException" in {
      Unknown.move(null) must throwA[UnsupportedOperationException]
    }
  }
}
