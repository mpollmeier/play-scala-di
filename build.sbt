name := "play-scala-di"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play-slick" % "1.1.0-M2",
  "org.scalatestplus" %% "play" % "1.4.0-M3" % Test
)

routesGenerator := InjectedRoutesGenerator
