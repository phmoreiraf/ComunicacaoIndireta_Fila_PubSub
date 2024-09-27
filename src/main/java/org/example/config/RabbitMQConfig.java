package org.example.config;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitMQConfig {
    // URL de conexão RabbitMQ (substitua com sua URL do CloudAMQP)
    private static final String RABBITMQ_URL = "amqps://tvdtwaay:hqJENBFOxEgD_WiUmVejjvmJwLSoUGZn@shark.rmq.cloudamqp.com/tvdtwaay";

    public static Connection getConnection() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUri(RABBITMQ_URL);  // Define a URL de conexão
        return factory.newConnection();
    }
}