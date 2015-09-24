import controllers._
import org.scalatest._
import org.scalatestplus.play._
import play.api.inject.bind
import play.api.inject.guice.GuiceInjector
import play.api.inject.guice.GuiceableModule
import play.api.test._
import play.api.test.Helpers._

abstract class MyPlaySpec extends WordSpec with Matchers with OptionValues with WsScalaTestClient

class GermanHello extends Hello {
  override def sayHello(name: String) = "Hallo " + name
}

class ApplicationTest extends MyPlaySpec with OneAppPerTestWithOverrides {
  override def overrideModules = Seq(
    bind[Hello].to[GermanHello]
  )

  "render the index page" in {
    val home = route(FakeRequest(GET, "/")).get
    status(home) shouldBe OK
    contentAsString(home) shouldBe "Hallo michael"
  }

}
