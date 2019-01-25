import Dependencies._

name := "avroKafkaDemo"


version := "0.1"

scalaVersion := "2.12.8"

resolvers += "io.confluent" at "http://packages.confluent.io/maven/"

libraryDependencies ++= Seq(
  kafka,
  scalaTest % Test,
  "org.apache.avro"  %  "avro"  %  "1.7.7",
  "ch.qos.logback" %  "logback-classic" % "1.1.7",
  "io.confluent" % "kafka-avro-serializer" % "4.0.0"
)