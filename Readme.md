# Spring Gateway Demo

This repo is intended to accompany the blog posts here: https://wya.pl/2021/12/20/bring-your-own-ssrf-the-gateway-actuator/ and https://wya.pl/2022/02/26/cve-2022-22947-spel-casting-and-evil-beans/.

The Gateway actuator allows for administrators of the application to define new routes and manipulate existing ones. This repo provides a basic Spring application that has the Gateway actuator enabled. This allows you to test out adding or deleting routes in a development environment.

CVE-2022-22947 was identified in the Spring Cloud Gateway Server jar. If you wish to test this, you can update the pom.xml to use this a version of the library under 3.0 (for example 2.2.10.RELEASE). I have also included a packaged jar here if you wish to test this out: https://github.com/wdahlenburg/spring-gateway-demo/releases/download/v.0.0.1/spring-gateway-demo-0.0.1-SNAPSHOT.jar

After the application is compiled you should be able to view the existing routes by visiting: http://127.0.0.1:9000/actuator/gateway/routes

### Compile

```
$ mvn package -DskipTests
```

### Run

```
$ java -jar target/spring-gateway-demo-0.0.1-SNAPSHOT.jar
```

The application should run be running on port 9000.

### Docker

```
$ docker build -t spring-gateway-demo:latest .
...

$ docker run -p 9000:9000 spring-gateway-demo 
```
