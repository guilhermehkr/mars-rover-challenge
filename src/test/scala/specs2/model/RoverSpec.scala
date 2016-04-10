package specs2.model

import java.util
import java.util.{List, ArrayList}

import com.google.common.collect.Lists
import mars.command.{Left, Movement}
import mars.compass.Compass
import mars.model.{Status, Plateau, Rover, Coordinate}
import org.junit.runner.RunWith
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner

import scala.collection.JavaConversions._

@RunWith(classOf[JUnitRunner])
class RoverSpec extends Specification {

  "Rover creator" should {

    "when receives the following string (directions > 1 2 N) and (commands -> LMLMLMLMM) should create a Ok rover" +
      " with Compass North, Coordinates x = 1 and y = 2 and list of commands which contains 4 lefts, and 5 movements" in {

      val parameter: List[List[String]] = Lists.newArrayList()
      val list: List[String] = Lists.newArrayList("1 2 N", "LMLMLMLMM")
      parameter.add( list )
      val rover = Rover.createRovers(parameter, new Plateau(1,1))

      rover.head.getCommands.size() ==== 9
      rover.head.getCommands.count(command => command.isInstanceOf[Left]) ==== 4
      rover.head.getCommands.count(command => command.isInstanceOf[Movement]) ==== 5
      rover.head.getCurrentCoordinate ==== new Coordinate(1, 2)
      rover.head.getCurrentDirection ==== Compass.North
    }
  }

  "should return a Rover nok when receives non valid coordinate" in {

    val parameter: List[List[String]] = Lists.newArrayList()
    val list: List[String] = Lists.newArrayList("1 C N", "LMLMLMLMM")
    parameter.add( list )
    val rover = Rover.createRovers(parameter, new Plateau(1,1))

    rover.head.getStatus ==== Status.Nok
    rover.head.getCurrentCoordinate ====  new Coordinate(-1, -1)
    rover.head.getCurrentDirection ==== Compass.Unknown
    rover.head.getPlateau ==== new Plateau(-1, -1)
  }
}
