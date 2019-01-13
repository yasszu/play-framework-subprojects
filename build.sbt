name := """play-application"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(commonSettings)
  .settings(libraryDependencies ++= Seq(guice, ws, scalaTest))
  .dependsOn(search)
  .aggregate(search)

lazy val search = PlayProject("search")
  .settings(libraryDependencies ++= Seq(guice, ws,  scalaTest))

lazy val commonSettings = Seq(
  organization := "yasszu",
  scalaVersion := "2.12.6"
)

def BaseProject(name: String): Project = (
  Project(name, file(name))
    settings (commonSettings: _*)
  )

def PlayProject(name: String): Project = (
  BaseProject(name)
    enablePlugins PlayScala
  )

val scalaTest  = "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test

val runAll = inputKey[Unit]("Runs all sub projects")

runAll := {
  (run in Compile in root).partialInput(" 9000").evaluated
  (run in Compile in search).partialInput(" 9001").evaluated
}

// https://www.scala-sbt.org/1.x/docs/Forking.html
fork in run := true