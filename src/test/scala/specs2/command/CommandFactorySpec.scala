package specs2.command

import mars.command.{CommandFactory, _}
import org.specs2.mutable.Specification

class CommandFactorySpec extends Specification {

  "Command Factory Spec" should {

    "returns Command Left when receives L/l" in {

      CommandFactory.fabricate("L").isInstanceOf[Left] === true
      CommandFactory.fabricate("l").isInstanceOf[Left] === true
    }

    "returns Command Right when receives R/r" in {

      CommandFactory.fabricate("R").isInstanceOf[Right] === true
      CommandFactory.fabricate("r").isInstanceOf[Right] === true
    }

    "returns Command Movement when receives M/m" in {

      CommandFactory.fabricate("M").isInstanceOf[Movement] === true
      CommandFactory.fabricate("m").isInstanceOf[Movement] === true
    }

    "returns Command Unknown when receives anything, except M/R/L" in {

      CommandFactory.fabricate("%ˆ$&ˆ").isInstanceOf[Unknown] === true
      CommandFactory.fabricate(")()(98893").isInstanceOf[Unknown] === true
    }
  }
}
