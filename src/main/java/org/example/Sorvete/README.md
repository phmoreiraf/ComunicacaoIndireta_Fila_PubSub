# Guia de Uso: Fila de Mensagens - Pedidos de Sorvete

Este documento descreve como configurar e utilizar o sistema de fila de mensagens para processar pedidos de sorvete usando RabbitMQ.

## Consumidor de Pedidos

O **Consumidor de Pedidos** processa as mensagens de pedidos de sorvete da fila.

### Como Funciona
- **Conexão e Canal**: Conecta-se ao RabbitMQ e cria um canal.
- **Declaração da Fila**: Declara a mesma fila onde os pedidos foram enviados.
- **Recepção de Pedidos**: Recebe e processa cada pedido de sorvete.

### Como Utilizar
1. Certifique-se de que o RabbitMQ está em execução.
2. Compile o projeto Java.
3. Execute a classe `ConsumidorGeral`.
4. Verifique o console para ver os pedidos processados.

## Produtor de Pedidos

O **Produtor de Pedidos** envia mensagens para uma fila que representa pedidos de sorvete.

### Como Funciona
- **Conexão e Canal**: Estabelece uma conexão com o RabbitMQ e cria um canal.
- **Declaração da Fila**: Declara uma fila onde os pedidos serão enviados.
- **Envio de Mensagens**: Publica mensagens de pedidos na fila.

### Como Utilizar
1. Certifique-se de que o RabbitMQ está em execução.
2. Compile o projeto Java.
3. Execute a classe `SorveteProdutor`.
4. Verifique o console para confirmar o envio dos pedidos.

## Considerações Finais

Esta abordagem é ideal para sistemas onde cada mensagem precisa ser processada por apenas um consumidor, como em filas de processamento de pedidos.
