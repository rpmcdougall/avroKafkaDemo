package com.rm.Producer

import com.ovoenergy.kafka.serialization.core._
import com.ovoenergy.kafka.serialization.avro4s._
import com.rm.Domain.User
import com.sksamuel.avro4s._
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import org.apache.kafka.clients.CommonClientConfigs._

import scala.collection.JavaConverters._


class UserProducer() {

  val schemaRegistryEndpoint = "http://localhost:8081"

  implicit val UserToRecord = ToRecord[User]

  val producer = new KafkaProducer(
    Map[String, AnyRef](BOOTSTRAP_SERVERS_CONFIG->"localhost:9092").asJava,
    nullSerializer[String],
    avroBinarySchemaIdSerializer[User](schemaRegistryEndpoint, isKey = false, includesFormatByte = true)
  )


  def send(topic: String, users: List[User]) = {
    users.map { user =>
      val record = new ProducerRecord[String, User](topic, user)
      producer.send(record)
    }
    producer.close()
  }


}
