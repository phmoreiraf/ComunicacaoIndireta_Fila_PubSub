package org.example.Sorvete.produtor;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.example.config.RabbitMQConfig;

public class SorveteProdutor {

    private final static String QUEUE_NAME = "fila_sorvete";

    public static void main(String[] argv) throws Exception {
        try (Connection connection = RabbitMQConfig.getConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String[] pedidos = {"Chocolate", "Baunilha", "Morango", "Pistache", "Menta"};
            for (String pedido : pedidos) {
                channel.basicPublish("", QUEUE_NAME, null, pedido.getBytes());
                System.out.println("Pedido enviado: " + pedido);
            }
        }
    }
}
