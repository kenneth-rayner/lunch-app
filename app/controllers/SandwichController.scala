package controllers
import play.api.libs.concurrent.Execution.Implicits.defaultContext

import com.google.inject.Inject
import play.api.mvc.{Action, Controller}
import services.SandwichService

class SandwichController @Inject()(sandwichService: SandwichService) extends Controller {
  def sandwiches() = Action.async {
    val sandwiches = sandwichService.sandwiches()
    sandwiches.map { listOfSarnies =>
      Ok(views.html.sandwiches(listOfSarnies))
    }
  }
}
