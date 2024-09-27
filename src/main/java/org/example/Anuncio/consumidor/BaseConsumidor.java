package org.example.Anuncio.consumidor;

import org.example.config.RabbitMQConfig;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DeliverCallback;

public abstract class BaseConsumidor {
    private static final String NOME_DA_EXCHANGE = "novos_sabores";

    protected void iniciarConsumidor(String chaveDeRoteamento, String nomeDaSorveteria) throws Exception {
        Connection conexao = RabbitMQConfig.getConnection();
        Channel canal = conexao.createChannel();

        // Declare a exchange do tipo "topic" para novos sabores
        canal.exchangeDeclare(NOME_DA_EXCHANGE, "topic");
        String nomeDaFila = canal.queueDeclare().getQueue();
        canal.queueBind(nomeDaFila, NOME_DA_EXCHANGE, chaveDeRoteamento);

        System.out.println(" [*] Aguardando anúncios de sabores para " + nomeDaSorveteria);

        DeliverCallback callbackDeEntrega = (etiquetaConsumidor, entrega) -> {
            String mensagem = new String(entrega.getBody(), "UTF-8");
            System.out.println(" [x] " + nomeDaSorveteria + " recebeu o anúncio: '" + mensagem + "'");

            // Simula o processamento do novo sabor
            int tempoDeProcessamento = 2000 + (int) (Math.random() * 3000);
            try {
                Thread.sleep(tempoDeProcessamento);
            } catch (InterruptedException e) {
                System.err.println("Erro durante o processamento do sabor: " + e.getMessage());
                Thread.currentThread().interrupt(); // Restaura o estado de interrupção
            }
            System.out.println(" [OK] " + nomeDaSorveteria + " adicionou o sabor '" + mensagem + "' ao menu em " + (tempoDeProcessamento / 1000) + " segundos.");
        };

        canal.basicConsume(nomeDaFila, true, callbackDeEntrega, etiquetaConsumidor -> {});
    }
}
