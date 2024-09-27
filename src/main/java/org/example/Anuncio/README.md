# Guia de Uso: Pub/Sub - Anúncio de Novos Sabores de Sorvete

Este documento descreve como configurar e utilizar o sistema de publicação e assinatura (Pub/Sub) para anunciar novos sabores de sorvete usando RabbitMQ.

## Publicador de Anúncios

O **Publicador de Anúncios** envia mensagens para um tópico que anuncia novos sabores de sorvete.

### Como Funciona
- **Conexão e Canal**: Estabelece uma conexão com o RabbitMQ e cria um canal.
- **Declaração do Exchange**: Declara um exchange do tipo `fanout` para distribuição das mensagens.
- **Envio de Mensagens**: Publica anúncios de novos sabores de sorvete no exchange.

### Como Utilizar
1. Certifique-se de que o RabbitMQ está em execução.
2. Compile o projeto Java.
3. Execute a classe `AnuncioPublicador`.
4. Verifique o console para confirmar o envio dos anúncios.

## Assinante de Anúncios

O **Assinante de Anúncios** recebe as mensagens de anúncios sobre novos sabores de sorvete.

### Como Funciona
- **Conexão e Canal**: Conecta-se ao RabbitMQ e cria um canal.
- **Declaração do Exchange e Fila**: Declara um exchange do tipo `fanout` e uma fila temporária para receber mensagens.
- **Recepção de Anúncios**: Recebe e processa cada anúncio de novo sabor.

### Como Utilizar
1. Certifique-se de que o RabbitMQ está em execução.
2. Compile o projeto Java.
3. Execute a classe `ConsumidorDeSabores`.
4. Verifique o console para ver os anúncios recebidos.
5. Após isso execute o `ProdutorNovosSabores`.

## Considerações Finais

Esta abordagem é ideal para sistemas onde múltiplos consumidores precisam receber as mesmas mensagens simultaneamente, como em anúncios de novos produtos.
