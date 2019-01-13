package services

import javax.inject.Inject
import play.api.libs.ws.{WSClient, WSResponse}

import scala.concurrent.{ExecutionContext, Future}

class SearchService @Inject()(configuration: play.api.Configuration, ws: WSClient)(implicit val exec: ExecutionContext) {

  val searchURL: String = configuration.get[String]("url.api.search")

  def request(q: String): Future[WSResponse] = {
    ws.url(s"$searchURL/search")
      .withHttpHeaders("Contest-Type" -> "application/json")
      .withQueryStringParameters("q" -> q)
      .get()
  }

}