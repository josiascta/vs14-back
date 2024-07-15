package task05;

import task05.questions.Completing;
import task05.questions.MultipleChoice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Area {
    private String title;
    private List<Project> projects = new ArrayList<>();

    public Area(String title) {
        this.title = title;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public Project returnRandomProject() {
        if (projects.isEmpty()) {
            return null;
        }
        Random random = new Random();
        int index = random.nextInt(projects.size());
        return projects.get(index);
    }

    public void addProject(Project project) {
        projects.add(project);
    }

    public static Area loadFrontendArea() {
        Area frontendArea = new Area("Frontend");

        MultipleChoice question1Fp1 = new MultipleChoice(Game.TerminalColors.YELLOW + "Você está criando a página inicial da loja virtual e precisa adicionar um botão de 'Comprar'. Qual tag HTML você deve usar para isso?" + Game.TerminalColors.RESET, 2, 5);
        question1Fp1.addOption("1. <input>");
        question1Fp1.addOption("2. <button>");
        question1Fp1.addOption("3. <a>");

        MultipleChoice question2Fp1 = new MultipleChoice(Game.TerminalColors.YELLOW + "Agora, você precisa adicionar uma imagem do produto na página. Qual tag HTML é utilizada para isso?" + Game.TerminalColors.RESET, 3, 5);
        question2Fp1.addOption("1. <image>");
        question2Fp1.addOption("2. <pic>");
        question2Fp1.addOption("3. <img>");

        MultipleChoice question3Fp1 = new MultipleChoice(Game.TerminalColors.YELLOW + "O cliente deseja que a fonte usada na loja virtual seja 'Arial'. Qual propriedade CSS você usaria para definir a fonte do texto?" + Game.TerminalColors.RESET, 3, 5);
        question3Fp1.addOption("1. text-family");
        question3Fp1.addOption("2. font-style");
        question3Fp1.addOption("3. font-family");

        MultipleChoice question4Fp1 = new MultipleChoice(Game.TerminalColors.YELLOW + "Para melhorar a acessibilidade, você precisa adicionar texto alternativo às imagens. Qual atributo HTML você usa para isso?" + Game.TerminalColors.RESET, 1, 5);
        question4Fp1.addOption("1. alt");
        question4Fp1.addOption("2. title");
        question4Fp1.addOption("3. description");

        MultipleChoice question5Fp1 = new MultipleChoice(Game.TerminalColors.YELLOW + "Para permitir que o cliente adicione itens ao carrinho, você precisa implementar uma função JavaScript. Qual comando é usado para definir uma função em JavaScript?" + Game.TerminalColors.RESET, 2, 5);
        question5Fp1.addOption("1. define function()");
        question5Fp1.addOption("2. function myFunction()");
        question5Fp1.addOption("3. create function()");

        Completing question6Fp1 = new Completing(Game.TerminalColors.YELLOW + "Para estilizar o botão de 'Comprar', você decide usar CSS. Qual propriedade você usaria para definir a cor de fundo? ______-color: red;" + Game.TerminalColors.RESET, 5, "background");
        Completing question7Fp1 = new Completing(Game.TerminalColors.YELLOW + "Você quer que a imagem do produto seja responsiva. Qual propriedade CSS você usaria para garantir que a imagem se ajuste ao tamanho da tela? ______: 100%;" + Game.TerminalColors.RESET, 5, "width");
        Completing question8Fp1 = new Completing(Game.TerminalColors.YELLOW + "Você quer centralizar o texto do título da página. Qual propriedade CSS você usaria para isso? text-______: center;" + Game.TerminalColors.RESET, 5, "align");
        Completing question9Fp1 = new Completing(Game.TerminalColors.YELLOW + "Você quer criar um espaço entre os itens da lista de produtos. Qual propriedade CSS você usaria para adicionar esse espaço? ______: 10px;" + Game.TerminalColors.RESET, 5, "margin-bottom");
        Completing question10Fp1 = new Completing(Game.TerminalColors.YELLOW + "Você quer selecionar todos os elementos de uma classe CSS chamada 'produto' no JavaScript. Qual método do document você usaria? document.______('produto');" + Game.TerminalColors.RESET, 5, "getElementsByClassName");

        Project FrontProject1 = new Project("Implementação de Loja Virtual", 3, false, 50);
        FrontProject1.addQuestion(question1Fp1);
        FrontProject1.addQuestion(question2Fp1);
        FrontProject1.addQuestion(question3Fp1);
        FrontProject1.addQuestion(question4Fp1);
        FrontProject1.addQuestion(question5Fp1);
        FrontProject1.addQuestion(question6Fp1);
        FrontProject1.addQuestion(question7Fp1);
        FrontProject1.addQuestion(question8Fp1);
        FrontProject1.addQuestion(question9Fp1);
        FrontProject1.addQuestion(question10Fp1);

        MultipleChoice question1Fp2 = new MultipleChoice(Game.TerminalColors.YELLOW + "Você está criando o cabeçalho do blog. Qual tag HTML você deve usar para definir o título principal da página?" + Game.TerminalColors.RESET, 1, 5);
        question1Fp2.addOption("1. <h1>");
        question1Fp2.addOption("2. <header>");
        question1Fp2.addOption("3. <title>");

        MultipleChoice question2Fp2 = new MultipleChoice(Game.TerminalColors.YELLOW + "Você quer exibir a data de cada post no blog. Qual tag HTML é semanticamente correta para isso?" + Game.TerminalColors.RESET, 3, 5);
        question2Fp2.addOption("1. <date>");
        question2Fp2.addOption("2. <span>");
        question2Fp2.addOption("3. <time>");

        MultipleChoice question3Fp2 = new MultipleChoice(Game.TerminalColors.YELLOW + "Você deseja aplicar estilos diferentes aos elementos do blog com base no tamanho da tela. Qual técnica CSS é usada para isso?" + Game.TerminalColors.RESET, 3, 5);
        question3Fp2.addOption("1. @viewport");
        question3Fp2.addOption("2. @screen");
        question3Fp2.addOption("3. @media");

        MultipleChoice question4Fp2 = new MultipleChoice(Game.TerminalColors.YELLOW + "Para adicionar interatividade aos posts do blog, você decide usar JavaScript. Qual método é usado para adicionar um evento de clique a um elemento?" + Game.TerminalColors.RESET, 1, 5);
        question4Fp2.addOption("1. addEventListener()");
        question4Fp2.addOption("2. attachEvent()");
        question4Fp2.addOption("3. onClick()");

        MultipleChoice question5Fp2 = new MultipleChoice(Game.TerminalColors.YELLOW + "Para carregar posts do blog de uma API, você usa JavaScript. Qual comando é usado para fazer uma requisição HTTP GET?" + Game.TerminalColors.RESET, 2, 5);
        question5Fp2.addOption("1. get()");
        question5Fp2.addOption("2. fetch()");
        question5Fp2.addOption("3. request()");

        Completing question6Fp2 = new Completing(Game.TerminalColors.YELLOW + "Para adicionar um link para o seu perfil de redes sociais no blog, você usa a tag <a>. Qual atributo HTML é usado para definir o URL desse link? <a ______=\"<https://meuperfil.com>\">Perfil</a>" + Game.TerminalColors.RESET, 5, "href");
        Completing question7Fp2 = new Completing(Game.TerminalColors.YELLOW + "Para melhorar o SEO do seu blog, você precisa adicionar meta tags no <head>. Qual atributo da meta tag define a descrição do site? <meta name=\"______\" content=\"Descrição do blog\">" + Game.TerminalColors.RESET, 5, "description");
        Completing question8Fp2 = new Completing(Game.TerminalColors.YELLOW + "Você quer criar um contêiner flexível para os posts do blog. Qual propriedade CSS você usaria para definir um contêiner flexível? display: transition-______;" + Game.TerminalColors.RESET, 5, "flex");
        Completing question9Fp2 = new Completing(Game.TerminalColors.YELLOW + "Você quer animar a transição de uma cor de fundo no CSS. Qual propriedade você usaria para definir a duração da transição? ______: 0.5s;" + Game.TerminalColors.RESET, 5, "duration");
        Completing question10Fp2 = new Completing(Game.TerminalColors.YELLOW + "Você quer selecionar um elemento pelo ID no JavaScript. Qual método do document você usaria?document.getElementBy______('meuId');" + Game.TerminalColors.RESET, 5, "Id");

        Project FrontProject2 = new Project("Criação de um Blog Pessoal", 3, false, 50);
        FrontProject2.addQuestion(question1Fp2);
        FrontProject2.addQuestion(question2Fp2);
        FrontProject2.addQuestion(question3Fp2);
        FrontProject2.addQuestion(question4Fp2);
        FrontProject2.addQuestion(question5Fp2);
        FrontProject2.addQuestion(question6Fp2);
        FrontProject2.addQuestion(question7Fp2);
        FrontProject2.addQuestion(question8Fp2);
        FrontProject2.addQuestion(question9Fp2);
        FrontProject2.addQuestion(question10Fp2);

        frontendArea.addProject(FrontProject1);
        frontendArea.addProject(FrontProject2);

        return frontendArea;
    }

    public static Area loadBackendArea() {
        Area backendArea = new Area("Backend");

        MultipleChoice question1Bp1 = new MultipleChoice(Game.TerminalColors.YELLOW + "Chegou o momento de codar e você precisa criar uma classe para representar os produtos no sistema. Como se faz isso em Java?" + Game.TerminalColors.RESET, 1, 5);
        question1Bp1.addOption("1. public class Produto {");
        question1Bp1.addOption("2. final class Produto {");
        question1Bp1.addOption("3. def classe Produto () {");

        MultipleChoice question2Bp1 = new MultipleChoice(Game.TerminalColors.YELLOW + "Seu colega está com uma dúvida: Qual modificador de acesso você deve usar para os atributos privados e encapsular os dados dos produtos?" + Game.TerminalColors.RESET, 1, 5);
        question2Bp1.addOption("1. private");
        question2Bp1.addOption("2. protected");
        question2Bp1.addOption("3. public");

        MultipleChoice question3Bp1 = new MultipleChoice(Game.TerminalColors.YELLOW + "Você vai instanciar um novo objeto para um produto, qual método em Java é chamado automaticamente quando um objeto é instanciado?" + Game.TerminalColors.RESET, 3, 5);
        question3Bp1.addOption("1. start()");
        question3Bp1.addOption("2. run()");
        question3Bp1.addOption("3. constructor()");

        MultipleChoice question4Bp1 = new MultipleChoice(Game.TerminalColors.YELLOW + "Qual princípio de OOP (Programação Orientada a Objetos) indica que objetos podem ser substituíveis por instâncias de suas subclasses sem afetar o comportamento do programa?" + Game.TerminalColors.RESET, 3, 5);
        question4Bp1.addOption("1. Encapsulamento");
        question4Bp1.addOption("2. Herança");
        question4Bp1.addOption("3. Polimorfismo");

        MultipleChoice question5Bp1 = new MultipleChoice(Game.TerminalColors.YELLOW + "Que tipo de relação entre classes em Java é representada quando uma classe é um tipo específico de outra classe?" + Game.TerminalColors.RESET, 3, 5);
        question5Bp1.addOption("1. Associação");
        question5Bp1.addOption("2. Composição");
        question5Bp1.addOption("3. Herança");

        Completing question6Bp1 = new Completing(Game.TerminalColors.YELLOW + "Agora você precisa criar uma constante para o tamanho de um item. Que palavra reservada é usada para definir isso em Java? String _____ TAMANHO = 'M';" + Game.TerminalColors.RESET, 5, "final");
        Completing question7Bp1 = new Completing(Game.TerminalColors.YELLOW + "Para que um método seja acessível sem a necessidade de instanciar um objeto, ele deve ser definido como ________." + Game.TerminalColors.RESET, 5, "static");
        Completing question8Bp1 = new Completing(Game.TerminalColors.YELLOW + "Para herdar uma classe em Java, utiliza-se a palavra reservada ________." + Game.TerminalColors.RESET, 5, "extends");
        Completing question9Bp1 = new Completing(Game.TerminalColors.YELLOW + "Qual tipo de dado em Java é usado para armazenar texto?" + Game.TerminalColors.RESET, 5, "String");
        Completing question10Bp1 = new Completing(Game.TerminalColors.YELLOW + "Para criar uma instância de uma classe em Java, utiliza-se a palavra reservada ________." + Game.TerminalColors.RESET, 5, "new");

        Project BackProject1 = new Project("Loja Virtual em Java", 3, false, 50);
        BackProject1.addQuestion(question1Bp1);
        BackProject1.addQuestion(question2Bp1);
        BackProject1.addQuestion(question3Bp1);
        BackProject1.addQuestion(question4Bp1);
        BackProject1.addQuestion(question5Bp1);
        BackProject1.addQuestion(question6Bp1);
        BackProject1.addQuestion(question7Bp1);
        BackProject1.addQuestion(question8Bp1);
        BackProject1.addQuestion(question9Bp1);
        BackProject1.addQuestion(question10Bp1);

        MultipleChoice question1Bp2 = new MultipleChoice(Game.TerminalColors.YELLOW + "Qual é uma função principal de um sistema de gerenciamento de estoque em backend?" + Game.TerminalColors.RESET, 2, 5);
        question1Bp2.addOption("1. Cadastro de clientes");
        question1Bp2.addOption("2. Controle de vendas");
        question1Bp2.addOption("3. Envio de emails promocionais");

        MultipleChoice question2Bp2 = new MultipleChoice(Game.TerminalColors.YELLOW + "Qual tecnologia é comumente utilizada para criar APIs RESTful em projetos backend?" + Game.TerminalColors.RESET, 3, 5);
        question2Bp2.addOption("1. HTML");
        question2Bp2.addOption("2. XML");
        question2Bp2.addOption("3. JSON");

        MultipleChoice question3Bp2 = new MultipleChoice(Game.TerminalColors.YELLOW + "Qual tipo de banco de dados é frequentemente utilizado para armazenar dados estruturados em projetos backend?" + Game.TerminalColors.RESET, 1, 5);
        question3Bp2.addOption("1. NoSQL");
        question3Bp2.addOption("2. CSV");
        question3Bp2.addOption("3. Microsoft Excel");

        MultipleChoice question4Bp2 = new MultipleChoice(Game.TerminalColors.YELLOW + "Como é comumente realizada a autenticação de usuários em sistemas backend?" + Game.TerminalColors.RESET, 2, 5);
        question4Bp2.addOption("1. Cookies");
        question4Bp2.addOption("2. JWT (JSON Web Tokens)");
        question4Bp2.addOption("3. Variáveis de sessão");

        MultipleChoice question5Bp2 = new MultipleChoice(Game.TerminalColors.YELLOW + "Qual é o objetivo principal de se usar um framework como Spring Boot em projetos backend?" + Game.TerminalColors.RESET, 2, 5);
        question5Bp2.addOption("1. Melhorar a performance do frontend");
        question5Bp2.addOption("2. Facilitar o desenvolvimento de aplicações Java");
        question5Bp2.addOption("3. Criar animações em CSS");

        Completing question6Bp2 = new Completing(Game.TerminalColors.YELLOW + "O que significa API em um contexto de backend? Interface de Programação de ______" + Game.TerminalColors.RESET, 2, "Aplicativos");
        Completing question7Bp2 = new Completing(Game.TerminalColors.YELLOW + "Qual tipo de estrutura de dados é ideal para representar um pedido de compra em um sistema de gerenciamento de estoque backend?" + Game.TerminalColors.RESET, 5, "JSON");
        Completing question8Bp2 = new Completing(Game.TerminalColors.YELLOW + "Qual tipo de autenticação é geralmente usada para proteger endpoints de API RESTful?" + Game.TerminalColors.RESET, 5, "JWT");
        Completing question9Bp2 = new Completing(Game.TerminalColors.YELLOW + "Qual tipo de banco de dados é frequentemente usado para armazenar dados não estruturados ou semi-estruturados em projetos backend?" + Game.TerminalColors.RESET, 5, "NoSQL");
        Completing question10Bp2 = new Completing(Game.TerminalColors.YELLOW + "Qual padrão é comumente usado para documentar APIs RESTful em projetos backend?" + Game.TerminalColors.RESET, 5, "Swagger");

        Project BackProject2 = new Project("Sistema de Gerenciamento de Estoque", 3, false, 50);
        BackProject2.addQuestion(question1Bp2);
        BackProject2.addQuestion(question2Bp2);
        BackProject2.addQuestion(question3Bp2);
        BackProject2.addQuestion(question4Bp2);
        BackProject2.addQuestion(question5Bp2);
        BackProject2.addQuestion(question6Bp2);
        BackProject2.addQuestion(question7Bp2);
        BackProject2.addQuestion(question8Bp2);
        BackProject2.addQuestion(question9Bp2);
        BackProject2.addQuestion(question10Bp2);

        backendArea.addProject(BackProject1);
        backendArea.addProject(BackProject2);

        return backendArea;
    }

    public static Area loadQaArea() {
        Area qaArea = new Area("QA");

        MultipleChoice question1Qap1 = new MultipleChoice(Game.TerminalColors.YELLOW + "Qual ferramenta é comumente usada para automação de testes em aplicações web?" + Game.TerminalColors.RESET, 2, 5);
        question1Qap1.addOption("1. JIRA");
        question1Qap1.addOption("2. Selenium Webdriver");
        question1Qap1.addOption("3. Jenkins");

        MultipleChoice question2Qap1 = new MultipleChoice(Game.TerminalColors.YELLOW + "Qual dos seguintes frameworks de testes é frequentemente utilizado em conjunto com Selenium para testes automatizados em Java?" + Game.TerminalColors.RESET, 2, 5);
        question2Qap1.addOption("1. Django");
        question2Qap1.addOption("2. TestNG");
        question2Qap1.addOption("3. Flask");

        MultipleChoice question3Qap1 = new MultipleChoice(Game.TerminalColors.YELLOW + "Qual é a principal vantagem de usar automação de testes em aplicações web?" + Game.TerminalColors.RESET, 1, 5);
        question3Qap1.addOption("1. Execução repetitiva e eficiente de testes");
        question3Qap1.addOption("2. Redução do tempo de desenvolvimento de novas funcionalidades");
        question3Qap1.addOption("3. Aumento da complexidade dos testes");

        MultipleChoice question4Qap1 = new MultipleChoice(Game.TerminalColors.YELLOW + "Qual ferramenta é utilizada para integração contínua e pode ser configurada para executar testes automatizados?" + Game.TerminalColors.RESET, 3, 5);
        question4Qap1.addOption("1. Selenium");
        question4Qap1.addOption("2. Maven");
        question4Qap1.addOption("3. Jenkins");

        MultipleChoice question5Qap1 = new MultipleChoice(Game.TerminalColors.YELLOW + "Em um ambiente de automação de testes com Selenium, qual linguagem de programação é frequentemente utilizada?" + Game.TerminalColors.RESET, 3, 5);
        question5Qap1.addOption("1. PHP");
        question5Qap1.addOption("2. Ruby");
        question5Qap1.addOption("3. Java");

        Completing question6Qap1 = new Completing(Game.TerminalColors.YELLOW + "Os relatórios gerados após a execução dos testes automatizados ajudam a identificar rapidamente regressões e _______" + Game.TerminalColors.RESET, 5, "falhas");
        Completing question7Qap1 = new Completing(Game.TerminalColors.YELLOW + "Os scripts de testes automatizados geralmente são escritos em linguagens de programação como Java, Python ou _______" + Game.TerminalColors.RESET, 5, "JavaScript");
        Completing question8Qap1 = new Completing(Game.TerminalColors.YELLOW + "Para gerenciar dependências e construir projetos em Java, frequentemente utilizamos ferramentas como Maven ou _______" + Game.TerminalColors.RESET, 5, "Gradle");
        Completing question9Qap1 = new Completing(Game.TerminalColors.YELLOW + "A execução de testes automatizados em diferentes navegadores para garantir compatibilidade é conhecida como _______ testing" + Game.TerminalColors.RESET, 5, "cross-browser");
        Completing question10Qap1 = new Completing(Game.TerminalColors.YELLOW + "Um framework de testes popular utilizado em conjunto com Selenium para criar e gerenciar testes é o _______" + Game.TerminalColors.RESET, 5, "TestNG");

        Project qaProject1 = new Project("Sistema de Automação de Testes para Aplicações Web", 3, false, 50);
        qaProject1.addQuestion(question1Qap1);
        qaProject1.addQuestion(question2Qap1);
        qaProject1.addQuestion(question3Qap1);
        qaProject1.addQuestion(question4Qap1);
        qaProject1.addQuestion(question5Qap1);
        qaProject1.addQuestion(question6Qap1);
        qaProject1.addQuestion(question7Qap1);
        qaProject1.addQuestion(question8Qap1);
        qaProject1.addQuestion(question9Qap1);
        qaProject1.addQuestion(question10Qap1);

        MultipleChoice question1Qap2 = new MultipleChoice(Game.TerminalColors.YELLOW + "Qual é a finalidade principal de um sistema de gerenciamento de bugs?" + Game.TerminalColors.RESET, 2, 5);
        question1Qap2.addOption("1. Desenvolver novas funcionalidades");
        question1Qap2.addOption("2. Rastrear e resolver problemas no software");
        question1Qap2.addOption("3. Gerar relatórios financeiros");

        MultipleChoice question2Qap2 = new MultipleChoice(Game.TerminalColors.YELLOW + "Qual das seguintes ferramentas é comumente usada para rastreamento de bugs?" + Game.TerminalColors.RESET, 3, 5);
        question2Qap2.addOption("1. Selenium");
        question2Qap2.addOption("2. Maven");
        question2Qap2.addOption("3. JIRA");

        MultipleChoice question3Qap2 = new MultipleChoice(Game.TerminalColors.YELLOW + "Em um sistema de gerenciamento de bugs, qual campo é essencial para reproduzir um bug?" + Game.TerminalColors.RESET, 1, 5);
        question3Qap2.addOption("1. Descrição do bug");
        question3Qap2.addOption("2. Nome do desenvolvedor");
        question3Qap2.addOption("3. Data de nascimento do testador");

        MultipleChoice question4Qap2 = new MultipleChoice(Game.TerminalColors.YELLOW + "Qual é um benefício chave de integrar ferramentas de automação de testes com um sistema de gerenciamento de bugs?" + Game.TerminalColors.RESET, 2, 5);
        question4Qap2.addOption("1. Reduzir o custo de desenvolvimento");
        question4Qap2.addOption("2. Automatizar a execução e rastreamento de testes, melhorando a eficiência");
        question4Qap2.addOption("3. Aumentar a complexidade do código");

        MultipleChoice question5Qap2 = new MultipleChoice("Qual é a finalidade de criar casos de teste em um sistema de gerenciamento de testes?" + Game.TerminalColors.RESET, 1, 5);
        question5Qap2.addOption("1. Documentar cenários de teste para garantir que todas as funcionalidades sejam verificadas");
        question5Qap2.addOption("2. Aumentar a quantidade de código no projeto");
        question5Qap2.addOption("3. Melhorar a interface do usuário");

        Completing question6Qap2 = new Completing(Game.TerminalColors.YELLOW + "Em um sistema de gerenciamento de bugs, a prioridade de um bug é frequentemente determinada com base em sua _______ no sistema." + Game.TerminalColors.RESET, 2, "criticidade");
        Completing question7Qap2 = new Completing(Game.TerminalColors.YELLOW + "A ferramenta _______ é amplamente utilizada para rastreamento de bugs e gerenciamento de projetos de software." + Game.TerminalColors.RESET, 3, "JIRA");
        Completing question8Qap2 = new Completing(Game.TerminalColors.YELLOW + "Um caso de teste bem documentado deve incluir os passos para reproduzir o bug, os dados de entrada e o _______ esperado." + Game.TerminalColors.RESET, 4, "resultado");
        Completing question9Qap2 = new Completing(Game.TerminalColors.YELLOW + "A execução de testes manuais é geralmente registrada no sistema de gerenciamento de testes para acompanhar a _______ de cada teste." + Game.TerminalColors.RESET, 2, "execução");
        Completing question10Qap2 = new Completing(Game.TerminalColors.YELLOW + "A integração contínua, com ferramentas como Jenkins, pode ser configurada para executar testes automatizados e reportar bugs diretamente para o sistema de _______ de bugs." + Game.TerminalColors.RESET, 5, "gerenciamento");

        Project qaProject2 = new Project("Sistema de Gerenciamento de Bugs e Testes", 3, false, 50);
        qaProject2.addQuestion(question1Qap2);
        qaProject2.addQuestion(question2Qap2);
        qaProject2.addQuestion(question3Qap2);
        qaProject2.addQuestion(question4Qap2);
        qaProject2.addQuestion(question5Qap2);
        qaProject2.addQuestion(question6Qap2);
        qaProject2.addQuestion(question7Qap2);
        qaProject2.addQuestion(question8Qap2);
        qaProject2.addQuestion(question9Qap2);
        qaProject2.addQuestion(question10Qap2);

        qaArea.addProject(qaProject1);
        qaArea.addProject(qaProject2);

        return qaArea;
    }

}