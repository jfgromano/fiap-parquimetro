# FIAP Pós Tech - Tech Challenge

## Ambiente dev
O ambiente dev é util para testes com IDE, ele nao vai compilar e criar um container java mas sobe todo a infra restante para os serviços.

Basta entrar em cada uma das pastas dos servicos, criar o arquivo de variaveis de ambiente e subir os containers.

```bash
cd api
cp .env.example .env
vim .env # editar conforme necessario
docker compose up -d

cd notificacao
cp .env.example .env
vim .env # editar conforme necessario
docker compose up -d

cd pagamento
cp .env.example .env
vim .env # editar conforme necessario
docker compose up -d

cd rabbit
cp .env.example .env
vim .env # editar conforme necessario
docker compose up -d

cd scheduler
cp .env.example .env
vim .env # editar conforme necessario
docker compose up -d
```

## Ambiente homolog
No ambiente homolog temos tambem o container java em cada serviço, nao sendo necessario abrir uma ide para utilizar a api.

Basta criar a rede e depois entrar em cada uma das pastas dos servicos, criar o arquivo de variaveis de ambiente, fazer o build das imagens e subir os containers.

```bash
docker network create jfgr-parquimetro

cd api
cp .env.example .env
vim .env # editar conforme necessario
docker compose up -d

cd notificacao
cp .env.example .env
vim .env # editar conforme necessario
docker compose up -d

cd pagamento
cp .env.example .env
vim .env # editar conforme necessario
docker compose up -d

cd rabbit
cp .env.example .env
vim .env # editar conforme necessario
docker compose up -d

cd scheduler
cp .env.example .env
vim .env # editar conforme necessario
docker compose up -d
```