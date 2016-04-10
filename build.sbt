name := """mars-rovers"""

version := "0.1.0"

scalaVersion := "2.11.2"

libraryDependencies += "org.specs2" %% "specs2" % "2.4.1" % "test"

libraryDependencies += "com.google.guava" % "guava" % "12.0"

fork in run := true
