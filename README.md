# Comunicação Indireta

# Diferenças entre Abordagens Implementadas

Este documento resume as diferenças entre as duas abordagens de mensagens implementadas usando RabbitMQ: Fila de Mensagens e Pub/Sub.

## 1. Fila de Mensagens - Pedidos de Sorvete

Nesta abordagem, utilizamos uma fila de mensagens para gerenciar pedidos de sorvete. As mensagens são enviadas para uma fila específica, e um ou mais consumidores podem processá-las. É ideal para cenários onde cada mensagem deve ser processada por apenas um consumidor.

### Características:
- **Ponto-a-Ponto**: Cada mensagem é consumida por apenas um consumidor.
- **Ordenação**: As mensagens são processadas na ordem em que foram enviadas.
- **Uso**: Adequado para processamento de tarefas, como pedidos de sorvete.

## 2. Pub/Sub - Anúncio de Novos Sabores de Sorvete

Nesta abordagem, utilizamos o modelo de publicação e assinatura (Pub/Sub) para anunciar novos sabores de sorvete. As mensagens são enviadas para um exchange, e todos os assinantes recebem as mensagens.

### Características:
- **Broadcast**: Cada mensagem é entregue a todos os assinantes.
- **Desacoplamento**: Publicadores e assinantes são desacoplados, permitindo maior flexibilidade.
- **Uso**: Ideal para notificações de eventos, como anúncios de novos produtos.

## Considerações Finais

A escolha entre fila de mensagens e Pub/Sub depende do caso de uso específico. Fila de mensagens é melhor para tarefas que requerem processamento único, enquanto Pub/Sub é mais adequado para disseminação ampla de informações.
