package services

import javax.inject.Inject
import play.api.libs.ws.{WSClient, WSResponse}

import scala.concurrent.{ExecutionContext, Future}

class GithubService @Inject()(configuration: play.api.Configuration, ws: WSClient)(implicit val exec: ExecutionContext) {

  val URL: String = configuration.get[String]("url.api.github")

  def request(q: String): Future[WSResponse] = {
    ws.url(s"$URL/search")
      .withHttpHeaders("Contest-Type" -> "application/json")
      .withQueryStringParameters("q" -> q)
      .get()
  }

}