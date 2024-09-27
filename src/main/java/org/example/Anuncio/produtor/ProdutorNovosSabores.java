package org.example.Anuncio.produtor;

import org.example.config.RabbitMQConfig;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class ProdutorNovosSabores {

    private static final String NOME_DA_EXCHANGE = "novos_sabores";

    public static void main(String[] args) throws Exception {
        Connection conexao = RabbitMQConfig.getConnection();
        Channel canal = conexao.createChannel();

        // Declare a exchange do tipo "topic"
        canal.exchangeDeclare(NOME_DA_EXCHANGE, "topic");

        // Lista de novos sabores com chaves de roteamento
        String[][] novosSabores = {
                {"sabores.pistache", "Novo sabor de pistache disponível!"},
                {"sabores.chocolate", "Novo sabor de chocolate branco disponível!"},
                {"sabores.morango", "Novo sabor de morango com hortelã disponível!"}
        };

        // Publicar cada sabor na exchange
        for (String[] sabor : novosSabores) {
            String chaveDeRoteamento = sabor[0];
            String mensagem = sabor[1];
            canal.basicPublish(NOME_DA_EXCHANGE, chaveDeRoteamento, null, mensagem.getBytes("UTF-8"));
            System.out.println(" [x] Anunciado: '" + mensagem + "' com chave de roteamento '" + chaveDeRoteamento + "'");
        }

        canal.close();
        conexao.close();
    }
}
