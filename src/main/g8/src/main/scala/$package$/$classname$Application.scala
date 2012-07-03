package $package$

import com.vaadin.Application
import vaadin.scala._

//add-ons
import org.vaadin.teemu.ratingstars.RatingStars


class $classname$Application Application extends Application {
  def init {
    val layout = new VerticalLayout
    setMainWindow(new Window("$name$", content = layout))
    
    val panel = new Panel(caption = "Panel", height = 300 px) {
      add(new Button(caption = "Button1"))
      add(new Button(caption = "Button2"))
      add(new Button(caption = "Button3"))
    }

    getMainWindow.addComponent(new VerticalLayout(width = 100 percent, height = 100 percent) {
      add(panel)
      add(new Button(caption = "Embedded button"))
      add(new RatingStars())
    })

    layout.setSizeFull
  }
}
