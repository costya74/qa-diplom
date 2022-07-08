# **Запуск автотестов**

### шаги воспроизведения
1. Скачать проект с удаленного репозитория на свой локальный, с помощью команды git clone
2. Открыть проект на установленной заранее IntelliJ Idea
3. Подключите DataBase(используя mySql, postgresql)
4. Запускаем Docker контейнеры СУБД MySQL и PostgreSQL
5. Запустить контейнеры в терминале 

```
docker-compose up -d
```
проверяем, что контейнеры запустились:

```docker ps```

смотрим статус контейнеров в консоле

```![img.png](img.png)```

6. Запускаем SUT 

 + Для MySQL:
 
```java "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" -jar artifacts/aqa-shop.jar```

+ Для PostgreSQL:
```
java "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" -jar artifacts/aqa-shop.jar
```

#### Приложение должно запуститься на:
```
http://localhost:8080. 
```
Если по каким-то причинам порт 8080 на вашей машине используется другим приложением, используйте: 
java -jar app-order.jar -port=9090

7. Запускаем автотесты

>для MySQL
```
./gradlew clean test -Durl=jdbc:mysql://localhost:3306/app
```
>для PostgreSQL
```
./gradlew clean test -Durl=jdbc:postgreSQL://localhost:5433/app
```
8. Генерация отчетов
```
./gradlew clean test allureReport
./gradlew allureServe
```

9. Завершение работы AllureServe
```
Ctrl+C => Y
```
10. Остановить и удалить все контейнеры
```
docker-compose down
```
### Документация

+ [План автоматизации тестирования](https://github.com/costya74/qa-diplom/blob/master/docum%D0%B5ntation/Plan.md)
+ [Отчет по итогам тестирования](https://github.com/costya74/qa-diplom/blob/master/docum%D0%B5ntation/Report.md)
+ [Отчет по итогам автоматизации](https://github.com/costya74/qa-diplom/blob/master/docum%D0%B5ntation/Summary.md)