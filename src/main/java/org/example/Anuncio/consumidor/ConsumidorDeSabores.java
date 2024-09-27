package org.example.Anuncio.consumidor;

public class ConsumidorDeSabores extends BaseConsumidor {

    private static final String CHAVE_DE_ROTEAMENTO_SABORES = "sabores.*";

    public static void main(String[] args) {
        try {
            ConsumidorDeSabores consumidor = new ConsumidorDeSabores();
            consumidor.iniciarConsumidor(CHAVE_DE_ROTEAMENTO_SABORES, "Sorveteria");
        } catch (Exception e) {
            System.err.println("Erro ao iniciar o consumidor de sabores: " + e.getMessage());
        }
    }
}
