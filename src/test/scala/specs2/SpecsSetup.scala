package specs2

object SpecsSetup {

  // Files should be at test/resources

  private val myTestFileName = "rovers-entries"
  def myTest = s"/$myTestFileName"

  private val yourFileName = "rovers-entries"
  def realTestFile = s"/$yourFileName"
}
