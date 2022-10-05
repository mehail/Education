# Общее описание

*Учебный проект ИПК ГГТУ им. П.О.Сухого*

## Название программы

*Education*

## Цель приложения

Это учебный проект, предназначенный для сквозного выполнения лабораторных и практических заданий в процессе получения
образования

## Информация о реализации

* **Язык программирования:** Java
* **Версия Java:** "11"

Приложение RESTful написано с использованием технологий:

* Spring Boot
* Spring Web
* Swagger

___

# Описание функционала

* Лабораторные работы по дисциплине "Основы алгоритмизации и программирования на языках высокого уровня"

___

# Запуск приложения

## 1. Необходимое ПО

<table>
    <thead>
        <tr>
            <th>Software</th>
            <th>Version</th>
            <th>Deb based linux</th>
            <th>Windows</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td colspan="4" align="center"><i>Without containerization system</i></td>
        </tr>
        <tr>
            <td>Java</td>
            <td align="center">11</td>
            <td><i>sudo apt install openjdk-11-jdk</i></td>
            <td><a href="https://jdk.java.net/java-se-ri/11">jdk.java.net</a></td>
        </tr>
        <tr>
            <td>Maven</td>
            <td align="center">3.8.6</td>
            <td><i>sudo apt install maven</i></td>
            <td><a href="https://maven.apache.org/download.cgi">maven.apache.org</a></td>
        </tr>
    </tbody>
</table>

## 2. Клонирование репозитория

```
  git clone https://github.com/mehail/Education.git
```

## 3. Запуск из командной строки / терминала:
```
mvn clean install spring-boot:run
```


## 4. Техническое описание

После запуска приложения <a href="http://localhost:8080/swagger-ui/index.html">Swagger UI</a>
доступен на локальном хосте с возможностью тестирования функциональности с помощью веб-интерфейса
____

# Contacts

* **Author:** Mihail Artyugin
* **E-mail:** mehailpost@gmail.com
