package com.rm.demoapps

import com.rm.Domain.User
import com.rm.Producer.UserProducer

object ProducerApp extends App {

  private val topic = "demo-topic"

  val producer = new UserProducer()

  val user1 = User(1, "Joe Shmo", None)
  val user2 = User(2, "Jim Bob", Some("jim@bob.com"))

  producer.send(topic, List(user1, user2))

}
