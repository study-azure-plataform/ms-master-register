# Microservice Master Register With MS SQL Server

### Description

This microservice is central register Customer for other microservices usages  

#### Get Started

- JDK 11 
- Gradle
- Docker
- Git
- MS Sql Server

#### SQl Server 

if you don't have and don't want to install SQL Server, you can just run in you terminal an image SQL Server on localhost  

```Bash
$ docker run -e "ACCEPT_EULA=Y" -e "SA_PASSWORD=Docker#0" -p 1433:1433 --name sqlserver -h sqlserver -d mcr.microsoft.com/mssql/server:2019-latest 
```

Use an IDE of your choice to access SQL Server. In you first access using database master. 

User: **sa** password: **Docker#0**

After logging in, you must create a new database named **DB-MASTER-REGISTER**