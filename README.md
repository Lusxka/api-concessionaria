# API Concessionária - Onde os Carros Ganham Vida (e Dados!) 

E aí, galera! Bem-vindos ao projeto `api-concessionaria`, o lugar onde os carros ganham vida... digitalmente, claro! Aqui, a gente junta o melhor dos dois mundos: a paixão por carros e a magia da tecnologia.

## Pra que serve essa belezinha? 

Essa API foi criada para facilitar a vida de quem trabalha com concessionárias. Com ela, você pode gerenciar carros, clientes, vendas e tudo mais que rola nesse universo automotivo. É tipo um superpoder para a sua concessionária!

## Como usar (sem se perder no caminho) ️

1.  **Clone o repositório:**

    ```bash
    git clone [https://github.com/Lusxka/api-concessionaria.git](https://github.com/Lusxka/api-concessionaria.git)
    ```

2.  **Entre na pasta do projeto:**

    ```bash
    cd api-concessionaria
    ```

3.  **Instale as dependências:**

    ```bash
    npm install
    ```

4.  **Configure o banco de dados:**

    * Crie um arquivo `.env` na raiz do projeto, seguindo o exemplo do `.env.example`.
    * Preencha as informações do seu banco de dados (nome, usuário, senha, etc.).

5.  **Execute as migrações:**

    ```bash
    npx sequelize-cli db:migrate
    ```

6.  **Inicie a API:**

    ```bash
    npm run dev
    ```

7.  **Explore a documentação:**

    * Acesse `http://localhost:3000/api-docs` para ver a documentação da API (gerada com Swagger).

## O que você encontra por aqui? 

* **Endpoints para gerenciar carros:** adicione, edite, liste e apague carros do seu estoque.
* **Endpoints para gerenciar clientes:** cadastre, atualize, liste e exclua clientes.
* **Endpoints para gerenciar vendas:** registre vendas, consulte histórico e muito mais.
* **Autenticação:** proteja seus dados com um sistema de autenticação seguro.
* **Documentação Swagger:** explore a API de forma interativa e veja todos os detalhes dos endpoints.

## Contribuindo para a garagem ️

Quer dar um upgrade nessa API? Fique à vontade para contribuir! Siga estes passos:

1.  Faça um fork do repositório.
2.  Crie uma branch com a sua feature (`git checkout -b minha-feature`).
3.  Faça commit das suas mudanças (`git commit -am 'Adiciona minha feature'`).
4.  Faça push para a branch (`git push origin minha-feature`).
5.  Abra um Pull Request.

## Licença 

Este projeto está sob a licença MIT. Sinta-se à vontade para usar, modificar e distribuir como quiser!

## Contato 

Tem alguma dúvida, sugestão ou quer bater um papo sobre carros? Manda um e-mail para [endereço de email removido].

É isso aí, galera! Espero que vocês curtam essa API tanto quanto a gente curtiu criar. Bora acelerar juntos!
