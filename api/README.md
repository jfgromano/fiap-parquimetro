# API TECH-CHALLENGE

- [Autenticação](#autenticação)
   - [Cadastrar usuario](#end-point-cadastrar-usuario)
   - [Autenticar](#end-point-autenticação)
- [Endereços](#endereços)
   - [Obter endereço](#end-point-obter-endereço)
   - [Editar endereço](#end-point-editar-endereço)
- [Contatos](#contatos)
   - [Obter contato](#end-point-obter-contato)
   - [Editar contato](#end-point-editar-contato)
- [Veiculos](#veiculos)
   - [Cadastrar veiculo](#end-point-cadastrar-veiculo)
   - [Editar veiculo](#end-point-editar-veiculo)
   - [Listar veiculos](#end-point-listar-veiculos)
   - [Remover veiculo](#end-point-remover-veiculo)
- [Cartoes](#cartoes)
   - [Cadastrar cartao](#end-point-cadastrar-cartao)
   - [Marcar cartao como principal](#end-point-marcar-cartao-como-principal)
   - [Listar cartoes](#end-point-listar-cartoes)
   - [Remover cartao](#end-point-remover-cartao)
- [Pedidos](#pedidos)
   - [Checkout](#end-point-checkout)
   - [Status pedido](#end-point-status-pedido)
   - [Finalizar periodo](#end-point-finalizar-periodo)
   - [Recibo](#end-point-recibo)
 - [Erros](#erros)
   - [422 - Dados de input invalidos](#422---dados-de-input-invalidos)
   - [404 - Entidade nao encontrada](#404---entidade-nao-encontrada)


# Autenticação 

## End-point: Cadastrar usuario
Cria um usuario para se autenticar e utilizar as apis
### Method: POST
>```
>/auth/cadastrar
>```
### Body

```json
{
    {
    "email": "teste1@outlook.com",
    "senha": "123456",
    "nome": "Joao",
    "sexo": "M",
    "dataDeNascimento": "01/02/1990",
    "cpf": 00000000000,
    "endereco": {
        "rua": "Rua teste",
        "numero": "12",
        "bairro": "Bairro XYZ",
        "cidade": "São Paulo",
        "estado": "SP"
    },
    "contato" : {
        "email": "asddsa@asd.com.br",
        "numeroCelular": "(11) 95842-85452"
    }
}
}
```

### Exemplo retorno
```json
{
    {
    "id": "8ebbc27c-c9c9-45b7-b629-a62265fa6c58",
    "email": "teste1@outlook.com",
    "nome": "Joao",
    "sexo": "M",
    "cpf": "00000000000",
    "dataDeNascimento": "01/02/1990"
    }
}
```

### Status code

|Status Code|Descrição|
|---|---|
|201|Cadastrado com sucesso|
|409|Email ja existe|

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Autenticação
Gera um token JWT utilizado para as rotas das apis
### Method: POST
>```
>/auth/jwt
>```
### Body

```json
{
    "email": "teste@fiap.com",
    "senha": "123456"
}
```

### Exemplo retorno
```json
{
    "token": "eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ0ZXN0ZUBmaWFwLmNvbSIsImlzcyI6InRlY2gtY2hhbGxlbmdlIiwiaWF0IjoxNjkzODA4MTMwLCJleHAiOjE2OTM4MDkzMzB9._cXaFRq9adlNuJ_3s0HY62pI9Wfa5irKsgduPVLrQ3a3D9J7mAN1MZcYv_8dEBaE2S1YI8Wcjli6vFXDw5yMew"
}
```

### Status code

|Status Code|Descrição|
|---|---|
|200|Autenticado com sucesso|
|403|Falha ao validar credenciais|

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃
# Endereços 

## End-point: Obter endereço
Obtem o endereço do usuario atual
### Method: GET
>```
>/enderecos
>```

### Exemplo retorno
```json
{
    "id": "355e9ed9-198a-4b4c-a7fd-6e9e15a9e2ae",
    "rua": "Rua teste",
    "numero": "15",
    "bairro": "Bairro XYZ",
    "cidade": "São Paulo",
    "estado": "SP"
}
```

### Status code

|Status Code|Descrição|
|---|---|
|200|Sucesso|


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Editar endereço
### Method: PUT
>```
>/endereços/{id}
>```
### Body
```json
{
    "rua": "Rua teste",
    "numero": "15",
    "bairro": "Bairro XYZ",
    "cidade": "São Paulo",
    "estado": "SP"
}
```

### Exemplo retorno
```json
{
    "id": "355e9ed9-198a-4b4c-a7fd-6e9e15a9e2ae",
    "rua": "Rua teste",
    "numero": "15",
    "bairro": "Bairro XYZ",
    "cidade": "São Paulo",
    "estado": "SP"
}
```

### Status code

|Status Code|Descrição|
|---|---|
|201|Atualizado com sucesso|
|422|Dados invalidos|

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃
# Contato 

## End-point: Obter contato
Obtem o contato do usuario atual
### Method: GET
>```
>/contatos
>```

### Exemplo retorno
```json
{
    "id": "20a03019-2d39-4243-8be1-57fb19ced8ea",
    "email": "asddsa@asd.com.br",
    "numeroCelular": "(11) 98558-8558"
}
```

### Status code

|Status Code|Descrição|
|---|---|
|200|Sucesso|


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Editar contato
Editar o contato do usuario atual
### Method: PUT
>```
>/contatos/{id}
>```
### Body
```json
{
    "email": "asddsa@asd.com.br",
    "numeroCelular": "(11) 97887-8585"
}
```

### Exemplo retorno
```json
{
    "id": "77cf765b-5530-48b3-a17a-9f5101d2d4df",
    "email": "asddsa@asd.com.br",
    "numeroCelular": "(11) 97887-8585"
}
```

### Status code

|Status Code|Descrição|
|---|---|
|201|Atualizado com sucesso|
|422|Dados invalidos|

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃
# Veiculo 

## End-point: Cadastrar veiculo
Cadastra um veiculo para o usuario atual
### Method: POST
>```
>/veiculos
>```

### Exemplo corpo
```json
{
    "placa": "JRC6759",
    "cor": "azul",
    "modelo": "gol",
    "marca": "fiat",
    "estado": "SP"
}
```
### Exemplo retorno
```json
{
    "id": "48831648-324c-487b-94e0-d12a35dabfe7",
    "placa": "JRC6759",
    "cor": "azul",
    "marca": "fiat",
    "modelo": "gol"
}
```

### Status code

|Status Code|Descrição|
|---|---|
|200|Sucesso|


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Editar veiculo
Edita os dados de um veiculo especifico
### Method: PUT
>```
>/veiculos/{id}
>```

### Exemplo corpo
```json
{
    "placa": "JRC6753",
    "cor": "azuls",
    "modelo": "gol",
    "marca": "fiat",
    "estado": "SP"
}
```

### Exemplo retorno
```json
{
    "id": "9eb3cff4-a305-4dc4-ab49-2dbd741e6043",
    "placa": "JRC6753",
    "cor": "azuls",
    "marca": "fiat",
    "modelo": "gol"
}
```

### Status code

|Status Code|Descrição|
|---|---|
|200|Sucesso|


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃
## End-point: Listar veiculos
Lista todos os veiculos do usuario
### Method: GET
>```
>/veiculos
>```

### Exemplo retorno
```json
[
    {
        "id": "9eb3cff4-a305-4dc4-ab49-2dbd741e6043",
        "placa": "JRC6753",
        "cor": "azuls",
        "marca": "fiat",
        "modelo": "gol"
    }
]
```

### Status code

|Status Code|Descrição|
|---|---|
|200|Sucesso|


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Remover veiculo
Remover um veiculo especifico
### Method: DELETE
>```
>/veiculos/{id}
>```

### Status code

|Status Code|Descrição|
|---|---|
|204|Removido com sucesso|

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

# Cartoes 

## End-point: Cadastrar cartao
Cadastra um cartao para o usuario atual
### Method: POST
>```
>/cartoes
>```

O parametro token se refere a um possivel token retornado pelo gateway de pagamento no front

### Exemplo corpo
```json
{
    "ultimosQuatroDigitos": "4552",
    "token": "JKASHDKJY2348HLKASDH2NCDFOASYD9823HRLK23HJN4OUA90SAD",
    "tipo": "credito",
    "principal": true
}
```

### Exemplo retorno
```json
{
    "id": "49f7f404-d13d-42fd-8f26-a469c527c313",
    "ultimosQuatroDigitos": "4552",
    "tipo": "credito",
    "principal": true
}
```

### Status code

|Status Code|Descrição|
|---|---|
|200|Sucesso|


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Marcar cartao como principal
Marca um cartao com a flag de principal (uso apenas em um possivel front)
### Method: PUT
>```
>/cartoes/{id}
>```

### Status code

|Status Code|Descrição|
|---|---|
|204|Sucesso|


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃
## End-point: Listar cartoes
Lista todos os cartoes do usuario
### Method: GET
>```
>/cartoes
>```

### Exemplo retorno
```json
[
    {
        "id": "7e010b8e-5d49-4e00-a163-255047de9b36",
        "ultimosQuatroDigitos": "4552",
        "tipo": "credito",
        "principal": true
    }
]
```

### Status code

|Status Code|Descrição|
|---|---|
|200|Sucesso|


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Remover cartao
Remover um cartao especifico
### Method: DELETE
>```
>/cartoes/{id}
>```

### Status code

|Status Code|Descrição|
|---|---|
|204|Removido com sucesso|

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

# Pedidos 

## End-point: Checkout
Realiza um checkout, ponto inicial da api onde usuario ira fechar o pedido e aguardar aprovação de pagamento
### Method: POST
>```
>/pedidos
>```

O parametro token se refere a um possivel token retornado pelo gateway de pagamento no front

### Exemplo corpo (Pedido variavel)
```json
{
    "tipoPeriodo": "variavel",
    "idVeiculo": "48831648-324c-487b-94e0-d12a35dabfe7",
    "pagamento": {
        "tipoPagamento": "CREDITO",
        "idCartao": "9f9a13fe-d726-423f-95a3-5bd0f37c3fc5"

    }
}
```

### Exemplo corpo (Pedido fixo)
```json
{
    "tipoPeriodo": "fixo",
    "idVeiculo": "48831648-324c-487b-94e0-d12a35dabfe7",
    "pagamento": {
        "tipoPagamento": "PIX",
    }
}
```

### Exemplo retorno
```json
{
    "id": "57273593-129b-4224-b970-5fac6436089f",
    "tipoPeriodo": "variavel",
    "horas": 1,
    "statusPagamento": "PROCESSANDO"
}
```

### Status code

|Status Code|Descrição|
|---|---|
|200|Sucesso|


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Status pedido
Rota para verificar o status atual do pagamento do pedido que esta sendo processado em background
### Method: GET
>```
>/pedidos/{id}
>```

### Exemplo retorno
```json
{
    "id": "6b8a1e5c-b362-4f47-9f98-a0003aeea5a8",
    "tipoPeriodo": "variavel",
    "horas": 1,
    "statusPagamento": "CONCLUIDO"
}
```

### Status code

|Status Code|Descrição|
|---|---|
|200|Sucesso|


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃
## End-point: Finalizar periodo
Finaliza um perido de estacionamento, o usuario ira utilizar essa rota quando ele quiser encerrar o periodo de estacionamento
### Method: POST
>```
>/pedidos/{id}/finalizar
>```

### Status code

|Status Code|Descrição|
|---|---|
|204|Sucesso|


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Recibo
Obter dados do recibo, rota disponivel apenas em pedidos ja finalizados
### Method: GET
>```
>/pedidos/{id}/recibo
>```

### Exemplo retorno
```json
{
    "detalhes": {
        "dataPedido": "10/11/2023 02:38:23",
        "tipo": "variavel",
        "valorHora": 5.00
    },
    "periodo": {
        "tempoEstacionado": "00:00:-23",
        "inicio": "10/11/2023 02:38:29",
        "fim": "10/11/2023 02:38:51"
    },
    "veiculo": {
        "id": "48831648-324c-487b-94e0-d12a35dabfe7",
        "placa": "JRC6759",
        "cor": "azul",
        "marca": "fiat",
        "modelo": "gol"
    },
    "pagamento": {
        "tipoPagamento": "CREDITO",
        "cartao": {
            "id": "9f9a13fe-d726-423f-95a3-5bd0f37c3fc5",
            "ultimosQuatroDigitos": "4552",
            "tipo": "credito",
            "principal": true
        },
        "valor": 5.00
    }
}
```

### Status code

|Status Code|Descrição|
|---|---|
|200|Sucesso|

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

# Erros

## 422 - Dados de input invalidos
A api ira retornar todos os erros de input de formulario dentro do array "campos" com um status code 422
```json
{
    "campos": {
        "nome": [
            "não deve estar em branco"
        ]
    }
}
```

## 404 - Entidade nao encontrada
A api ira retornar 404 em casos onde o cliente tenta interagir com um id de entidade inexistente na base
```json
{
    "mensagem": "Nao foi possivel localizar a {nome-entidade}!"
}
```