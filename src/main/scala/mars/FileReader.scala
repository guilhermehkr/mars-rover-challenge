package mars

import scala.io.Source
import scala.collection.JavaConversions._

object FileReader {
  def readFrom(path: String) : java.util.List[String] = Source.fromURL( getClass.getResource(path) ).getLines().filterNot( _.isEmpty ).toList
}
