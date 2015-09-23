package controllers

import com.google.inject.ImplementedBy
import javax.inject._
import play.api._
import play.api.data.Forms._
import play.api.data.validation.Constraints._
import play.api.mvc._

@ImplementedBy(classOf[EnglishHello])
trait Hello {
  def sayHello(name: String): String
}
class EnglishHello extends Hello {
  def sayHello(name: String) = "Hello " + name
}

class PersonController @Inject() (hello: Hello) extends Controller {
  def index = Action {
    Ok(hello.sayHello("michael"))
  }
}
