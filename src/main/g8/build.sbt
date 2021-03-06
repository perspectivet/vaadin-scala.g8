import net.thunderklaus.GwtPlugin._

name := "$name$"
 
scalaVersion := "2.9.1"
 
seq(webSettings: _*)

seq(gwtSettings: _*)

gwtVersion := "2.4.0"

resolvers += "Vaadin add-ons repository" at "http://maven.vaadin.com/vaadin-addons"

// basic dependencies
libraryDependencies ++= Seq(
  "com.vaadin" % "vaadin" % "6.7.6",
  "org.vaadin.addons" % "scaladin" % "1.0.0",
  "org.eclipse.jetty" % "jetty-webapp" % "8.0.4.v20111024" % "container"
)

libraryDependencies ++= Seq(
	//Add add-ons from the directory here. e.g.
	"org.vaadin.addons" % "ratingstars" % "1.4"
)



// hack: sbt-gwt-plugin assumes that sources are in src/main/java
javaSource in Compile <<= (scalaSource in Compile)

gwtModules := List("$package$.$classname$Widgetset")

javaOptions in Gwt += "-mx1024M"

// more correct place would be to compile widgetset under the target dir and configure jetty to find it from there 
gwtTemporaryPath := file(".") / "src" / "main" / "webapp" / "VAADIN" / "widgetsets"