package com.rm.Producer


import java.util.{Properties, UUID}

import org.apache.avro.Schema
import org.apache.avro.Schema.Parser


import com.rm.Domain.User
import io.confluent.kafka.serializers.KafkaAvroSerializer
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerConfig, ProducerRecord}
import org.apache.kafka.common.serialization.StringSerializer

import scala.io.Source

class UserProducer() {

  case class KafkaProducerConfigs() {
    val properties = new Properties()
    properties.put("bootstrap.servers", "127.0.0.1:9092")
    properties.put("message.send.max.retries", "5")
    properties.put("acks", "all")
    properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, classOf[StringSerializer].getCanonicalName)

    //set value serializer to avro serializer
    properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, classOf[KafkaAvroSerializer].getCanonicalName)
    properties.put("client.id", UUID.randomUUID().toString)
    properties.put("schema.registry.url", "http://127.0.0.1:8081" )
  }

  val producer = new KafkaProducer[String, User](KafkaProducerConfigs().properties)

  def send(topic: String, users: List[User]): Unit = {
    try {
      val queueMessages = users.map { user =>
        val record = new ProducerRecord[String,User](topic , user)
        producer.send(record)
      }
    } catch {
      case ex: Exception =>
        println(ex.printStackTrace().toString)
        ex.printStackTrace()
    }
    finally {
      producer.close()
    }

  }

}
