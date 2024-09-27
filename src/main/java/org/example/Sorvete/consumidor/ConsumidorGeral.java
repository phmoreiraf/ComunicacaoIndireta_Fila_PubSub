package org.example.Sorvete.consumidor;

import com.rabbitmq.client.*;
import org.example.config.RabbitMQConfig;

public class ConsumidorGeral {

    private final static String QUEUE_NAME = "fila_sorvete";

    public static void main(String[] argv) throws Exception {
        try (Connection connection = RabbitMQConfig.getConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            System.out.println("Monitorando pedidos...");

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String pedido = new String(delivery.getBody(), "UTF-8");
                System.out.println("Pedido monitorado: " + pedido);

                // Simula o processamento do pedido
                processarPedido(pedido);

                // Simula o registro do pedido em um "banco de dados"
                registrarPedido(pedido);
            };

            // O consumidor deve continuar executando
            channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });

            // Mantenha o programa em execução para continuar monitorando
            synchronized (ConsumidorGeral.class) {
                ConsumidorGeral.class.wait();
            }
        }
    }

    private static void processarPedido(String pedido) {
        // Simula algum tipo de processamento do pedido
        System.out.println("Processando pedido: " + pedido);
        try {
            Thread.sleep(500); // Simula tempo de processamento
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Processamento interrompido: " + e.getMessage());
        }
        System.out.println("Pedido processado: " + pedido);
    }

    private static void registrarPedido(String pedido) {
        // Simula o registro do pedido em um banco de dados
        System.out.println("Registrando pedido no banco de dados: " + pedido);
        // Aqui você pode adicionar lógica para inserir o pedido em um banco de dados real
    }
}
