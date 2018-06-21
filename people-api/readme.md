#Some setup information :).

# MongoDB

* Install mongodb: https://docs.mongodb.com/manual/installation/
* Start it: $ sudo mongod
* Make sure it started at 127.0.0.1:27017 by executing 
    * $ sudo mongo --host 127.0.0.1:27017

# Kafka
* https://kafka.apache.org/quickstart

# Redis

* https://redis.io/download
* $ wget http://download.redis.io/releases/redis-4.0.10.tar.gz
* $ tar xzf redis-4.0.10.tar.gz
* $ cd redis-4.0.10
* $ make
* $ src/redis-server
    * make sure it started on localhost:6379