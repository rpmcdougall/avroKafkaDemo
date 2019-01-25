package com.rm.Domain

import org.apache.avro.Schema

import scala.annotation.switch

case class User(var id: Int, var name: String, var email: Option[String]) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(0, "", None)
  def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => {
        id
      }.asInstanceOf[AnyRef]
      case 1 => {
        name
      }.asInstanceOf[AnyRef]
      case 2 => {
        email match {
          case Some(x) => x
          case None => null
        }
      }.asInstanceOf[AnyRef]
      case _ => new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }
  def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this.id = {
        value
      }.asInstanceOf[Int]
      case 1 => this.name = {
        value.toString
      }.asInstanceOf[String]
      case 2 => this.email = {
        value match {
          case null => None
          case _ => Some(value.toString)
        }
      }.asInstanceOf[Option[String]]
      case _ => new org.apache.avro.AvroRuntimeException("Bad index")
    }
    ()
  }
  def getSchema: org.apache.avro.Schema = User.SCHEMA$
}

object User {
  val SCHEMA$: Schema = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"user\",\"namespace\":\"kakfa-avro.test\",\"fields\":[{\"name\":\"id\",\"type\":\"int\"},{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"email\",\"type\":[\"string\",\"null\"]}]}")
}