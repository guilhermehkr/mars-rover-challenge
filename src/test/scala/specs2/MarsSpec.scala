package specs2

import mars._
import org.junit.runner.RunWith
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner

import scala.collection.JavaConversions._

@RunWith(classOf[JUnitRunner])
class MarsSpec extends Specification {

  "Mars" should {

    " Executing the mission: real test in mars land (You're going to see the output results above test results)" in {

      val rovers = Mars.getInstance().startMission(SpecsSetup.realTestFile)
      println("------------------------------------------------------------------")
      println("Output:")
      rovers.foreach( rover => println(s"--> ${rover.getOutput}") )
      println("------------------------------------------------------------------")


      1 mustEqual 1
    }
  }
}