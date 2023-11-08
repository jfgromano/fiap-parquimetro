## Tecnologias utilizadas
- Java 21
- Spring
- Postgres
- Docker
- Rabbitmq

## Infra
Neste desafio, como o requisito era possibilidade de escalar, eu dividi em alguns microservicos:

 - API: Sera a api que o usuario ira se comunicar, todos os cadastros e consultas serao feitos por ela, é o unico serviço exposto na internet
 - Notificacao: Servico responsavel por enviar as notificações aos usuarios
 - Pagamento: Serviço que processa os pagamentos em background
 - Scheduler: Servico que gerencia os agendamentos de pagamento e notificacoes, enviando os comandos para os servicos de notificaco e pagamento quando necessario.

## Alterações em relação a fase 1
A maioria das rotas da API nao tem muito segredo, sao basicamente operações CRUD, a diferença esta nas rotas:

### Rota Checkout pedido

Essa rota vai efetuar o pedido e enviar uma mensagem para o rabbit que sera consumida pelo serviço de pagamentos, esse serviço vai simular o processamento de um pagamento e enviar a resposta de volta para o rabbit, entao um listener da API ira salvar o status do pagamento e se o status for concluido ja é dado inicio ao periodo de estacionamento, enviando uma mensagem ao rabbit novamente para agendar as notificações e futuros pagamentos se o tipo de periodo for variavel. 

Os Agendamentos de notificação vao ser enviados aos usuarios 10 minutos antes da expiração do tempo, para simular as notificações o microservico de notificacao disponibiliza uma caixa de email fake para viauzalizar os recebimentos em http://localhost:1025 

### Rota status pedido
Apenas exibe o status do processamento de pagamento

### Rota Finalizar periodo
Finaliza o periodo de estacionamento, cancelando qualquer futura notificação e possibilitando a emissao dos recibos

### Rota Recibo
Essa rota so fica disponivel apos finalizar o periodo, ela exibe os detalhes de todo o pedido.

##Desafios

Acho que o maior desafio aqui foi a comunicação entre os serviços sem criar muita dependencia entre eles. é possivel escalar facilmente cada microserviço usando um auto scaling aws por exemplo pois nenhum serviço guarda estados na memoria ou disco, toda comunicação é feita via uma fila do rabbitMQ e nao tem nenhuma dependencia em rotas http por exemplo.

Cada microserviço tem seu proprio banco de dados e isso reduz muito a carga em grande escala.