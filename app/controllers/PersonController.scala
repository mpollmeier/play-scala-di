package controllers

import javax.inject._
import play.api._
import play.api.data.Forms._
import play.api.data.validation.Constraints._
import play.api.mvc._

class Hello {
  def sayHello(name: String) = "Hello " + name
}

class PersonController @Inject() (hello: Hello) extends Controller {
  def index = Action {
    Ok(hello.sayHello("michael"))
  }
}
