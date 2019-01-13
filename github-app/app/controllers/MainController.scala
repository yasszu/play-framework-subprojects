package controllers

import javax.inject._
import play.api._
import play.api.libs.ws.WSClient
import play.api.mvc._

import scala.concurrent.ExecutionContext

@Singleton
class MainController @Inject()(cc: ControllerComponents, ws: WSClient)(implicit val exec: ExecutionContext) extends AbstractController(cc) {

  def index(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok("Welcome to github-app")
  }

  def search(q: String, limit: Int = 10, page: Int = 1): Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    ws.url("https://api.github.com/search/repositories")
      .withHttpHeaders("ContestType" -> "application/json")
      .withQueryStringParameters("q" -> q, "limit" -> limit.toString, "page" -> page.toString)
      .get().map { response =>
      Ok(response.body)
    }
  }

}
