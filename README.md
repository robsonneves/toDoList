# toDoList
Project test toDoList


Java - 8
Spring-boot
WebFlux
Mysql
Actuator ( http://localhost:8080/actuator )
JWT
JPA
Swagger ( http://localhost:8080/swagger-ui.html )
Spring Boot Admin server ( http://localhost:8081 )

============================================= Iniciar o Projeto

API (aplicação principal)
  Configurar o DB na arquivo application.properties (estou usando mysql endereço local localhost:8080...)
  Tabelas já serão criadas pelo web flux.
  Baixar dependencias, configurar sdk
  rodar projeto
  
Monitoramento (aplicação de monitoramento usando o spring boot admin server, endereço local localhost:8081)
  Baixar dependencias, configurar sdk
  rodar projeto
  
============================================= Users

Usuários criados

Admin (faz o crud de qualquer task)
  user: admin@email.com 
  senha: 123456
  
Comun (faz o crud somente das task que ele criou)
  user: user@email.com
  senha: 123456
  
Esses usuários seram nescessarios para fazer a autenticação JWT, tem um endpoint mapeado no curl que esta aqui na raiz.
Nesse arquivo do postman tem todas os endpoints mapeados.
Assim tambem como no swagger 

Qualquer duvida fico a disposição
Gostaria tambem de receber feedbaks , para evoluir desde já agradeço.













