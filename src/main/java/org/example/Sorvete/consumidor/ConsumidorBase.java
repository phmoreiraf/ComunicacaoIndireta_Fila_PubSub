package org.example.Sorvete.consumidor;

import com.rabbitmq.client.*;
import org.example.config.RabbitMQConfig;

public class ConsumidorBase {

    private final static String QUEUE_NAME = "fila_sorvete";

    public static void main(String[] argv) throws Exception {
        try (Connection connection = RabbitMQConfig.getConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            System.out.println("Esperando por pedidos...");

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String pedido = new String(delivery.getBody(), "UTF-8");
                System.out.println("Pedido recebido: " + pedido);

                // Simula o processamento do pedido
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // Tratamento da exceção de interrupção
                    System.out.println("Processamento interrompido: " + e.getMessage());
                    Thread.currentThread().interrupt(); // Re-interrompe a thread
                }

                System.out.println("Pedido processado: " + pedido);
            };
            channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
        }
    }
}
