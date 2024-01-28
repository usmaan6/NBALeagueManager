## Documentation 

Available in the documentation folder.

## Create Database Entries

This project uses MySql. To populate data into your database, first run the init.sql file and then run the data.sql file to populate starter.

## Running the application

In order to connect to a sql server (specifically MySql), add the file application.properties to src/main/resources and add the following lines, making sure to change the user and password to match your credentials

```
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/databaseName?serverTimezone=America/Chicago&useSSL=false
spring.datasource.username=yourUserName
spring.datasource.password=yourPassWord
server.error.whitelabel.enabled=false
```

It is suggested to download and run the .sql scripts to match database setup. In that case, the databasename will be leagueManager

```
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/leagueManager?serverTimezone=America/Chicago&useSSL=false
spring.datasource.username=yourUserName
spring.datasource.password=yourPassWord
server.error.whitelabel.enabled=false
```

## Entry Point

The entry point of this project localhost:8080/home. From there, buttons will be available to navigate to the various pages.
