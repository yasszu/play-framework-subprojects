package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import services.SearchService

import scala.concurrent.ExecutionContext

@Singleton
class SearchController @Inject()(cc: ControllerComponents, service: SearchService)(implicit val exec: ExecutionContext) extends AbstractController(cc) {

  def search(q: String): Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    Logger.info(s"GET http://localhost:9000/search?q=$q")
    service.request(q).map { response =>
      Ok(response.body)
    }
  }

}
