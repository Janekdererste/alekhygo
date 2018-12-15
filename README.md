## How to set up the project for development

Before one can work on the project some preperations need to be done.

### 1. Set up your IDE

The project is using [Lombok](https://projectlombok.org/) to generate getters 
and setters.You need to install a plugin, so that the IDE gives IntelliSense 
support for the generated methods. In IntelliJ you can do so by selecting
File -> Settings. In the settings menu select Plugins -> Browse repositories. In
the repository browser Search for 'lombok' and click 'install'.

### 2. Compile the project

The project is also using [QueryDSL](http://www.querydsl.com/) for typesafe 
queries against a database. The library relies on generated source code which,
well, needs to be generated before the first run. To do so, simply execute

```
mvn clean compile
```
