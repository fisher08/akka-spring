name := "akka-spring"

version := "1.0"

scalaVersion := "2.11.5"

lazy val akkaVersion = "2.5.11"

mainClass in (Compile, run) := Some("hello.SampleController")

libraryDependencies ++= Seq(
  "org.springframework.boot" % "spring-boot-starter-web" % "2.0.0.RELEASE",
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-remote" % akkaVersion,
  "com.typesafe.akka" %% "akka-cluster" % akkaVersion,
  "com.typesafe.akka" %% "akka-cluster-metrics" % akkaVersion,
  "com.typesafe.akka" %% "akka-cluster-tools" % akkaVersion,
  "com.typesafe.akka" %% "akka-multi-node-testkit" % akkaVersion,
  "org.scalatest" %% "scalatest" % "2.2.1" % "test",
  "io.kamon" % "sigar-loader" % "1.6.6-rev002",
  "javax.inject" % "javax.inject" % "1"
)

