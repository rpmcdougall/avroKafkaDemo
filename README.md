# Avro Kafka Demo


# Setting Up Dev Environment

### Via Docker Compose

In the root directory of this project:
```
docker-compose up -d
```

### Via Confluent Platform
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

Schema is derived using Avro4s serializer.
 
### Produce Records
For this project with the pre-generated User schema class run the `ProducerApp` object in the `com.rm.demoapps` package.