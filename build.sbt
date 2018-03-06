name := "akka-spring"

version := "1.0"

scalaVersion := "2.11.5"

lazy val akkaVersion = "2.5.11"

mainClass in (Compile, run) := Some("hello.SampleController")

libraryDependencies ++= Seq(
  "org.springframework.boot" % "spring-boot-starter-web" % "2.0.0.RELEASE",
  "com.typesafe.akka" %% "akka-actor" % akkaVersion
)

