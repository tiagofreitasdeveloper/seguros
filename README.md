# API Seguro

Api que realiza inclusâo e atualizaçâo de um seguro com preco tarifa calculado

## 🚀 Soluçâo

Para o cálculo do preço tarifado, foi criado classes com valores de impostos específicos para a realizaçâo do cálculo.

Essas classes implementam uma interface de Calculo para que cada classe realize o calculo de acordo com seus impostos e retorne o resultado específico a cada uma.

Essa soluçâo se baseou nos padrões estrategy e factory.

A arquitetura de projeto, foi escolhida a Arquitetura limpa, pois a mesma permite uma modificaçâo, inclusâo e exclusâo dos adapter sem provocar efeitos colaterais no 
dominio  de negócio.

### 🔧 Instalação

#### Tecnologias
- Java 21
- Spring Boot 3.2
- Maven
- Banco de Dados H2
- Prometheus

Para rodar a aplicaçâo siga os passos abaixo:

- Rodar o comando **docker-compose up** na raiz da aplicação para execuçâo dos comandos contidos no arquivo docker-compose.yml
- Subir a aplicaçâo
- Importar a collection do postman contida na raiz do projeto
- Verificar as ações realizadas (inserir ou atualizar) que foram gravadas no banco de dados H2. Segue abaixo a url do H2:

**url**: http://localhost:8081/api/h2-console

**user**: root

**pass**: root
