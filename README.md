# CRUD
В проекте реализованы CRUD методы с использованием фраемворка Spring,
которые выполняют операции create, read, update и delete над объектом Purchase (покупка). Для демонстрации CRUD операций рализовано 
консольное приложение с подключением к H2 базе данных. Сборка осущевстляется через Maven.

Для запуска приложение необходимо ввести в терминале в корневой папке пректа:

```
 mvn clean spring-boot:run   
```

В проекте присутствуют тесты @DataJpaTest для проверки работоспособности CRUD операций. 
Для запуска тестов необходимо ввести: 
```
 mvn clean test      
```
