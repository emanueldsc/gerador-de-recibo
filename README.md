# Gerador de Recibo

## Sobre a aplicação
Simples gerador de quecibo.

Os recibos gerados possuem validação digital via qrcode.

## Detalhes de implementação

No backend as tecnologias empregadas são:

- Java
- Spring Boot

No frontend foram utilizados:
- Typescript (Superset de Javascript)
- React
- Tailwind ui

## Infraestrutura

O backend da aplicação está rodando em container Docker e hospedada na aws.

O frontend está hospedado na vercel no seguine endereço [Link da aplicação](http://www.google.com).

## Funcionalidade

### Backend

- [x] Endpoint de criação de recibo.
- [x] Endpoint de validação de recibos.
- [x] Testes unitários.
- [x] Testes de integração.
- [x] Tratamento de erros com requisições.
- [ ] Geração de PDF do recibo.
- [ ] Criação de Usuário para salvar dados de preenchimento de recibos.
- [ ] Salvar recibos gerados.

### Frontend

- [ ] Criar usuário.
- [ ] Login de usuário.
- [ ] Gerar recibos.
- [ ] Tabela de boletos com histórico de recibos.

### Infra Estrutura

- [ ] Dockerfile.
- [ ] Docker-compose.
- [ ] Hospedar imagem ECR.
- [ ] Subir imagem em container EC2.