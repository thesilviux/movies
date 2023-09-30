# Teste API - Golden Raspberry Awards (Silvio Pereira Guedes)


## Requirements

Para construir e executar a aplicação você precisa:

- [JDK 17](https://www.oracle.com/java/technologies/downloads/#java17)
- [Maven 3.8](https://maven.apache.org)


## Executando localmente com IDE Eclipse

   
### Importando o Projeto Maven
  
Acione o menu `File -> Import...`

![menu File -> Import...](images/01-menu_file_import.png)

   <br/>
   <br/>
   <br/>
Será aberto o diálogo `Import`. Então selecione a opção `Maven -> Existing Maven Projects` e acione o comando ` Next > `

![diálogo Import - Maven - Existing Maven Projects + Next](images/02-import_maven_existing_maven_projects.png)

   <br/>
   <br/>
   <br/>
O próximo diálogo será `Maven Projects`. Acione o comando `Browse...` e navegue até o diretório contendo o projeto e o arquivo `pom.xml`. Pode acionar o comando ` Finish ` e aguardar o Maven configurar/atualizar as dependências do projeto.

![diálogo Maven Projects - Browse + Finish](images/03-select_maven_projects_pom_xml_finish.png)


   <br/>
   <br/>
   <br/>
Ao final do import é esperado que o projeto esteja pronto para ser executado.

![estrutura do projeto](images/04-projeto_importado.png)


   <br/>
   <br/>
   
### Executando a API

Acione o menu de contexto (right click) sobre o arquivo `src/main/java/com/texoit/teste/silvio/MovieApplication.java`. Então acione o menu `Run as > Java Application`.

![menu de contexto run as java application](images/05-run_as_java_application.png)

   <br/>
   <br/>
   <br/>
É esperado que erros sejam apresentados na saída da guia `Console` devido a uma configuração faltante e que será feita logo a seguir. Para isso, na barra de ferramentas superior, acione o menu drop down do ícone `Run` e o item `Run Configurations...`.

![menu de contexto run as java application](images/06-run_configurations.png)

   <br/>
   <br/>
   <br/>
Será apresentado o diálogo `Run Configurations`. Selecione a guia `Dependencies` e, então, o item `Classpath Entries`. Na coluna da direita acione o comando `Advanced...`. No próximo diálogo selecione a opção `Add Folders` e `OK`.

![diálogo Maven Projects - Browse + Finish](images/07-dependencies-classpath_entries-add_folders.png)


   <br/>
   <br/>
   <br/>
No diálogo `Folder Selection` navegue e selecione a pasta `src/main/resources` e acione `OK`.

![diálogo Maven Projects - Browse + Finish](images/08-folder_selection.png)


   <br/>
   <br/>
   <br/>
Ao retornar ao diálogo anterior, um novo item `resources - \movies\src\main\` terá sido adicionado abaixo de `Classpath Entries`. Acione o comando `Apply` e, então, `Close`.

![diálogo Maven Projects - Browse + Finish](images/09-apply_and_close.png)


Outra vez na barra de ferramentas superior, acione o menu drop down do ícone `Run` e execute novamente `MovieApplication`. Desta vez é esperado ausência de erros.

![barra de ferramentas ícone run movieapplication](images/10-run_movieapplication.png)

   <br/>
   <br/>
   <br/>
Finalmente, os endpoints da API podem ser chamados no navegador pela URL - [http://localhost:8080/movie/producers](http://localhost:8080/movie/producers)

![estrutura do projeto](images/11-chamada_api_navegador.png)


   <br/>
   <br/>
   
### Executando Testes de Integração


Acione o menu de contexto (right click) sobre o arquivo `src/test/java/com/texoit/teste/silvio/controller/MovieControllerIntegrationTest.java`. Então acione o menu `Run as > JUnit Test`.

![menu de contexto run as java application](images/12-run_as_junit_test.png)

   <br/>
   <br/>
   <br/>
Os resultados dos testes de integração serão apresentados na guia própria do `JUnit` 

![menu de contexto run as java application](images/13-resultados_testes_integracao-guia-junit.png)