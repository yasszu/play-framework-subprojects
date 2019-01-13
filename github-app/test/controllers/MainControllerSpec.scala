package controllers

import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.test._
import play.api.test.Helpers._

/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 *
 * For more information, see https://www.playframework.com/documentation/latest/ScalaTestingWithScalaTest
 */
class MainControllerSpec extends PlaySpec with GuiceOneAppPerTest with Injecting {

  "MainController GET /" should {
    "render the index page from a new instance of controller" in {
      val controller = new MainController(stubControllerComponents())
      val index = controller.index().apply(FakeRequest(GET, "/"))
      status(index) mustBe OK
      contentType(index) mustBe Some("text/plain")
      contentAsString(index) must include ("Welcome to search app")
    }
  }

}
