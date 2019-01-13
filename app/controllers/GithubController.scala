package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import services.GithubService

import scala.concurrent.ExecutionContext

@Singleton
class GithubController @Inject()(cc: ControllerComponents, service: GithubService)(implicit val exec: ExecutionContext) extends AbstractController(cc) {

  def search(q: String): Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    Logger.info(s"GET http://localhost:9000/github/search?q=$q")
    service.request(q).map { response =>
      Ok(response.body)
    }
  }

}
