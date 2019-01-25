# Avro Kafka Demo


# Setting Up Dev Environment
Install Confluent Platform
https://www.confluent.io/download/

### Start Confluent platform

```
 
$ bin/confluent-hub install \\n--no-prompt confluentinc/kafka-connect-datagen:0.1.0 // First time only
$ bin/confluent start
```

####  Start a Consumer
```
bin/kafka-avro-console-consumer --bootstrap-server localhost:9092 --topic demo-topic --zookeeper localhost:2181
```

### Defining an Avro Schema

Avro Schema Docs: https://avro.apache.org/docs/1.8.1/spec.html

Example
```
{
    "namespace": "kakfa-avro.test",
     "type": "record",
     "name": "user",
     "fields":[
         {
            "name": "id", "type": "int"
         },
         {
            "name": "name",  "type": "string"
         },
         {
            "name": "email", "type": ["string", "null"]
         }
     ]
}
```


### Generating a AvroSpecific Class File using AvroHugger

- Download AvroHugger Tools https://github.com/julianpeeters/avrohugger#avrohugger-tools


 ```
 java -jar avrohugger-tools_2.12-1.0.0-RC15-assembly.jar generate-specific schema schema.avsc .
 ```
 
 
### Produce Records
For this project with the pre-generated User schema class run the `ProducerApp` object in the `com.rm.demoapps` package.