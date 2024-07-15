-- Players

INSERT INTO PLAYER
(ID ,NICKNAME, SCORE)
VALUES(SEQ_PLAYER.nextval, 'Ze', 0);

INSERT INTO PLAYER
(ID ,NICKNAME, SCORE)
VALUES(SEQ_PLAYER.nextval, 'Ana', 0);


-- Areas

INSERT INTO AREA
(ID ,TITLE)
VALUES(1, 'Frontend');

INSERT INTO AREA
(ID ,TITLE)
VALUES(2, 'Backend');

INSERT INTO AREA
(ID ,TITLE)
VALUES(3, 'QA');


-- Projects

INSERT INTO PROJECT (ID, TITLE, MAX_ERRORS, SCORE, AREA_ID)
VALUES (SEQ_PROJECT.NEXTVAL, 'Implementação de Loja Virtual', 3, 50, 1);

INSERT INTO PROJECT (ID, TITLE, MAX_ERRORS, SCORE, AREA_ID)
VALUES (SEQ_PROJECT.NEXTVAL, 'Criação de um Blog Pessoal', 3, 50, 1);

INSERT INTO PROJECT (ID, TITLE, MAX_ERRORS, SCORE, AREA_ID)
VALUES (SEQ_PROJECT.NEXTVAL, 'Loja Virtual em Java', 3, 50, 2);

INSERT INTO PROJECT (ID, TITLE, MAX_ERRORS, SCORE, AREA_ID)
VALUES (SEQ_PROJECT.NEXTVAL, 'Sistema de Gerenciamento de Estoque', 3, 50, 2);

INSERT INTO PROJECT (ID, TITLE, MAX_ERRORS, SCORE, AREA_ID)
VALUES (SEQ_PROJECT.NEXTVAL, 'Sistema de Automação de Testes para Aplicações Web', 3, 50, 3);

INSERT INTO PROJECT (ID, TITLE, MAX_ERRORS, SCORE, AREA_ID)
VALUES (SEQ_PROJECT.NEXTVAL, 'Sistema de Gerenciamento de Bugs e Testes', 3, 50, 3);


-- Question Types

INSERT INTO QUESTION_TYPE (ID, IDENTIFIER)
VALUES (1, 'multiple_choice');

INSERT INTO QUESTION_TYPE (ID, IDENTIFIER)
VALUES (2, 'completing');


-- Questions

-- Frontend Project 1

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Você está criando a página inicial da loja virtual e precisa adicionar um botão de "Comprar". Qual tag HTML você deve usar para isso?', NULL, 5, 1, 1);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Agora, você precisa adicionar uma imagem do produto na página. Qual tag HTML é utilizada para isso?', NULL, 5, 1, 1);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'O cliente deseja que a fonte usada na loja virtual seja "Arial". Qual propriedade CSS você usaria para definir a fonte do texto?', NULL, 5, 1, 1);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Para melhorar a acessibilidade, você precisa adicionar texto alternativo às imagens. Qual atributo HTML você usa para isso?', NULL, 5, 1, 1);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Para permitir que o cliente adicione itens ao carrinho, você precisa implementar uma função JavaScript. Qual comando é usado para definir uma função em JavaScript?', NULL, 5, 1, 1);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Para estilizar o botão de "Comprar", você decide usar CSS. Qual propriedade você usaria para definir a cor de fundo? ______-color: red;?', 'background', 5, 1, 2);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Você quer que a imagem do produto seja responsiva. Qual propriedade CSS você usaria para garantir que a imagem se ajuste ao tamanho da tela? ______: 100%;', 'width', 5, 1, 2);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Você quer centralizar o texto do título da página. Qual propriedade CSS você usaria para isso? text-______: center;', 'align', 5, 1, 2);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Você quer criar um espaço entre os itens da lista de produtos. Qual propriedade CSS você usaria para adicionar esse espaço? ______: 10px;', 'margin-bottom', 5, 1, 2);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Você quer selecionar todos os elementos de uma classe CSS chamada "produto" no JavaScript. Qual método do document você usaria? document.______("produto");', 'getElementsByClassName', 5, 1, 2);

-- Frontend Project 2

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Você está criando o cabeçalho do blog. Qual tag HTML você deve usar para definir o título principal da página?', NULL, 5, 2, 1);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Você quer exibir a data de cada post no blog. Qual tag HTML é semanticamente correta para isso?', NULL, 5, 2, 1);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Você deseja aplicar estilos diferentes aos elementos do blog com base no tamanho da tela. Qual técnica CSS é usada para isso?', NULL, 5, 2, 1);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Para adicionar interatividade aos posts do blog, você decide usar JavaScript. Qual método é usado para adicionar um evento de clique a um elemento?', NULL, 5, 2, 1);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Para carregar posts do blog de uma API, você usa JavaScript. Qual comando é usado para fazer uma requisição HTTP GET?', NULL, 5, 2, 1);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Para adicionar um link para o seu perfil de redes sociais no blog, você usa a tag <a>. Qual atributo HTML é usado para definir o URL desse link? <a ______="<https://meuperfil.com>">Perfil</a>', 'href', 5, 2, 2);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Para melhorar o SEO do seu blog, você precisa adicionar meta tags no <head>. Qual atributo da meta tag define a descrição do site? <meta name="______" content="Descrição do blog">', 'description', 5, 2, 2);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Você quer criar um contêiner flexível para os posts do blog. Qual propriedade CSS você usaria para definir um contêiner flexível? display: transition-______;', 'flex', 5, 2, 2);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Você quer animar a transição de uma cor de fundo no CSS. Qual propriedade você usaria para definir a duração da transição? ______: 0.5s;', 'duration', 5, 2, 2);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Você quer selecionar um elemento pelo ID no JavaScript. Qual método do document você usaria? document.getElementBy______("meuId");', 'Id', 5, 2, 2);


-- Backend Project 1

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Chegou o momento de codar e você precisa criar uma classe para representar os produtos no sistema. Como se faz isso em Java?', NULL, 5, 3, 1);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Seu colega está com uma dúvida: Qual modificador de acesso você deve usar para os atributos privados e encapsular os dados dos produtos?', NULL, 5, 3, 1);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Você vai instanciar um novo objeto para um produto, qual método em Java é chamado automaticamente quando um objeto é instanciado?', NULL, 5, 3, 1);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Qual princípio de OOP (Programação Orientada a Objetos) indica que objetos podem ser substituíveis por instâncias de suas subclasses sem afetar o comportamento do programa?', NULL, 5, 3, 1);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Que tipo de relação entre classes em Java é representada quando uma classe é um tipo específico de outra classe?', NULL, 5, 3, 1);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Agora você precisa criar uma constante para o tamanho de um item. Que palavra reservada é usada para definir isso em Java? String _____ TAMANHO = "M";', 'final', 5, 3, 2);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Para que um método seja acessível sem a necessidade de instanciar um objeto, ele deve ser definido como ________.', 'static', 5, 3, 2);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Para herdar uma classe em Java, utiliza-se a palavra reservada ________.', 'extends', 5, 3, 2);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Qual tipo de dado em Java é usado para armazenar texto?', 'String', 5, 3, 2);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Para criar uma instância de uma classe em Java, utiliza-se a palavra reservada ________.', 'new', 5, 3, 2);

-- Backend Project 2

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Qual é uma função principal de um sistema de gerenciamento de estoque em backend?', NULL, 5, 4, 1);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Qual tecnologia é comumente utilizada para criar APIs RESTful em projetos backend?', NULL, 5, 4, 1);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Qual tipo de banco de dados é frequentemente utilizado para armazenar dados estruturados em projetos backend?', NULL, 5, 4, 1);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Como é comumente realizada a autenticação de usuários em sistemas backend?', NULL, 5, 4, 1);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Qual é o objetivo principal de se usar um framework como Spring Boot em projetos backend?', NULL, 5, 4, 1);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'O que significa API em um contexto de backend? Interface de Programação de ______', 'Aplicativos', 5, 4, 2);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Qual tipo de estrutura de dados é ideal para representar um pedido de compra em um sistema de gerenciamento de estoque backend?', 'JSON', 5, 4, 2);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Qual tipo de autenticação é geralmente usada para proteger endpoints de API RESTful?', 'JWT', 5, 4, 2);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Qual tipo de banco de dados é frequentemente usado para armazenar dados não estruturados ou semi-estruturados em projetos backend?', 'NoSQL', 5, 4, 2);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Qual padrão é comumente usado para documentar APIs RESTful em projetos backend?', 'Swagger', 5, 4, 2);


-- QA Project 1

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Qual ferramenta é comumente usada para automação de testes em aplicações web?', NULL, 5, 5, 1);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Qual dos seguintes frameworks de testes é frequentemente utilizado em conjunto com Selenium para testes automatizados em Java?', NULL, 5, 5, 1);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Qual é a principal vantagem de usar automação de testes em aplicações web?', NULL, 5, 5, 1);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Qual ferramenta é utilizada para integração contínua e pode ser configurada para executar testes automatizados?', NULL, 5, 5, 1);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Em um ambiente de automação de testes com Selenium, qual linguagem de programação é frequentemente utilizada?', NULL, 5, 5, 1);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Os relatórios gerados após a execução dos testes automatizados ajudam a identificar rapidamente regressões e _______', 'falhas', 5, 5, 2);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Os scripts de testes automatizados geralmente são escritos em linguagens de programação como Java, Python ou _______', 'JavaScript', 5, 5, 2);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Para gerenciar dependências e construir projetos em Java, frequentemente utilizamos ferramentas como Maven ou _______', 'Gradle', 5, 5, 2);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'A execução de testes automatizados em diferentes navegadores para garantir compatibilidade é conhecida como _______ testing', 'cross-browser', 5, 5, 2);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Um framework de testes popular utilizado em conjunto com Selenium para criar e gerenciar testes é o _______', 'TestNG', 5, 5, 2);

-- QA Project 2
INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Qual é a finalidade principal de um sistema de gerenciamento de bugs?', NULL, 5, 6, 1);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Qual das seguintes ferramentas é comumente usada para rastreamento de bugs?', NULL, 5, 6, 1);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Em um sistema de gerenciamento de bugs, qual campo é essencial para reproduzir um bug?', NULL, 5, 6, 1);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Qual é um benefício chave de integrar ferramentas de automação de testes com um sistema de gerenciamento de bugs?', NULL, 5, 6, 1);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Qual é a finalidade de criar casos de teste em um sistema de gerenciamento de testes?', NULL, 5, 6, 1);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Em um sistema de gerenciamento de bugs, a prioridade de um bug é frequentemente determinada com base em sua _______ no sistema.', 'criticidade', 5, 6, 2);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'A ferramenta _______ é amplamente utilizada para rastreamento de bugs e gerenciamento de projetos de software.', 'JIRA', 5, 6, 2);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'Um caso de teste bem documentado deve incluir os passos para reproduzir o bug, os dados de entrada e o _______ esperado.', 'resultado', 5, 6, 2);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'A execução de testes manuais é geralmente registrada no sistema de gerenciamento de testes para acompanhar a _______ de cada teste.', 'execução', 5, 6, 2);

INSERT INTO QUESTION (ID, STATEMENT, ANSWER_SECRET_WORD, SCORE, PROJECT_ID, QUESTION_TYPE_ID)
VALUES (SEQ_QUESTION.NEXTVAL, 'A integração contínua, com ferramentas como Jenkins, pode ser configurada para executar testes automatizados e reportar bugs diretamente para o sistema de _______ de bugs.', 'gerenciamento', 5, 6, 2);


-- Question Options


-- Frontend Project 1
INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '1. <input>', 0, 1);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '2. <button>', 1, 1);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '3. <a>', 0, 1);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '1. <image>', 0, 2);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '2. <pic>', 0, 2);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '3. <img>', 1, 2);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '1. text-family', 0, 3);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '2. font-style', 0, 3);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '3. font-family', 1, 3);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '1. alt', 1, 4);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '2. title', 0, 4);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '3. description', 0, 4);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '1. define function()', 0, 5);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '2. function myFunction()', 1, 5);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '3. create function()', 0, 5);

-- Frontend Project 2

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '1. <h1>', 1, 11);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '2. <header>', 0, 11);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '3. <title>', 0, 11);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '1. <date>', 0, 12);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '2. <span>', 0, 12);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '3. <time>', 1, 12);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '1. @viewport', 0, 13);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '2. @screen', 0, 13);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '3. @media', 1, 13);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '1. addEventListener()', 1, 14);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '2. attachEvent()', 0, 14);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '3. onClick()', 0, 14);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '1. get()', 0, 15);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '2. fetch()', 1, 15);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '3. request()', 0, 15);


-- Backend Project 1

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '1. public class Produto {', 1, 21);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '2. final class Produto {', 0, 21);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '3. def classe Produto () {', 0, 21);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '1. private', 1, 22);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '2. protected', 0, 22);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '3. public', 0, 22);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '1. start()', 0, 23);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '2. run()', 0, 23);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '3. constructor()', 1, 23);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '1. Encapsulamento', 0, 24);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '2. Herança', 0, 24);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '3. Polimorfismo', 1, 24);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '1. Associação', 0, 25);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '2. Composição', 0, 25);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '3. Herança', 1, 25);

-- Backend Project 2

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '1. Cadastro de clientes', 0, 31);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '2. Controle de vendas', 1, 31);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '3. Envio de emails promocionais', 0, 31);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '1. HTML', 0, 32);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '2. XML', 0, 32);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '3. JSON', 1, 32);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '1. NoSQL', 1, 33);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '2. CSV', 0, 33);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '3. Microsoft Excel', 0, 33);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '1. Cookies', 0, 34);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '2. JWT (JSON Web Tokens)', 1, 34);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '3. Variáveis de sessão', 0, 34);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '1. Melhorar a performance do frontend', 0, 35);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '2. Facilitar o desenvolvimento de aplicações Java', 1, 35);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '3. Criar animações em CSS', 0, 35);


-- QA Project 1
INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '1. JIRA', 0, 41);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '2. Selenium Webdriver', 1, 41);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '3. Jenkins', 0, 41);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '1. Django', 0, 42);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '2. TestNG', 1, 42);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '3. Flask', 0, 42);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '1. Execução repetitiva e eficiente de testes', 1, 43);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '2. Redução do tempo de desenvolvimento de novas funcionalidades', 0, 43);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '3. Aumento da complexidade dos testes', 0, 43);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '1. Selenium', 0, 44);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '2. Maven', 0, 44);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '3. Jenkins', 1, 44);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '1. PHP', 0, 45);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '2. Ruby', 0, 45);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '3. Java', 1, 45);

-- QA Project 2

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '1. Desenvolver novas funcionalidades', 0, 51);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '2. Rastrear e resolver problemas no software', 1, 51);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '3. Gerar relatórios financeiros', 0, 51);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '1. Selenium', 0, 52);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '2. Maven', 0, 52);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '3. JIRA', 1, 52);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '1. Descrição do bug', 1, 53);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '2. Nome do desenvolvedor', 0, 53);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '3. Data de nascimento do testador', 0, 53);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '1. Reduzir o custo de desenvolvimento', 0, 54);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '2. Automatizar a execução e rastreamento de testes, melhorando a eficiência', 1, 54);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '3. Aumentar a complexidade do código', 0, 54);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '1. Documentar cenários de teste para garantir que todas as funcionalidades sejam verificadas', 1, 55);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '2. Aumentar a quantidade de código no projeto', 0, 55);

INSERT INTO QUESTION_OPTION (ID, TEXT, CORRECT, QUESTION_ID)
VALUES (SEQ_QUESTION_OPTION.NEXTVAL, '3. Melhorar a interface do usuário', 0, 55);
