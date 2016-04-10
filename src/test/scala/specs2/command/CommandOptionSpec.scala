package specs2.command

import mars.command.CommandOption
import mars.command.CommandOption._
import org.junit.runner.RunWith
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CommandOptionSpec extends Specification {

  "Command Option Spec" should {

    "returns Left Command Option when receives L/l ignoring case" in {

      CommandOption.from("L") ==== Left
      CommandOption.from("l") ==== Left
    }

    "returns Right Command Option when receives R/r ignoring case" in {

      CommandOption.from("R") ==== Right
      CommandOption.from("r") ==== Right
    }

    "returns Movement Command Option when receives M/m ignoring case" in {

      CommandOption.from("M") ==== Movement
      CommandOption.from("m") ==== Movement
    }

    "returns Unknown Command Option for any character" in {

      CommandOption.from("1") ==== Unknown
      CommandOption.from("121221") ==== Unknown
      CommandOption.from("%") ==== Unknown
      CommandOption.from("}{_++{") ==== Unknown
    }
  }
}
