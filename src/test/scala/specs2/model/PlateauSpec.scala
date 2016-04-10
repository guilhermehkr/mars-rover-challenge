package specs2.model

import mars.model.Plateau
import org.junit.runner.RunWith
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner

import scala.collection.JavaConversions._

@RunWith(classOf[JUnitRunner])
class PlateauSpec extends Specification {

  "Plateau constructor" should {

    "when receives a list should get the fist element and construct itself" in {

      val plateau = new Plateau(List("1 2", "blablabla"))
      plateau.getBoundX ==== 1
      plateau.getBoundY ==== 2
    }

    "when receives a empty list should throws an exception" in {

      new Plateau(List.empty[String]) must throwA[IllegalArgumentException]
    }

    "when receives a list which the first element splitted results in more or less than 2 position should throws an exception" in {

      new Plateau(List("1 2 3 4 5", "dssdsdsdds")) must throwA[IllegalArgumentException]
      new Plateau(List("1", "ffdfdfddfd")) must throwA[IllegalArgumentException]
    }

    "when receives a list which the first element contains any character instead of numbers should throws an exception" in {

      new Plateau(List("1 blabla")) must throwA[IllegalArgumentException]
    }
  }
}
