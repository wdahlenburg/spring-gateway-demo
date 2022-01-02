# Spring Gateway Demo

This repo is intended to accompany the blog post here: https://wya.pl/2021/12/20/bring-your-own-ssrf-the-gateway-actuator/.

The Gateway actuator allows for administrators of the application to define new routes and manipulate existing ones. This repo provides a basic Spring application that has the Gateway actuator enabled. This allows you to test out adding or deleting routes in a development environment.

After the application is compiled you should be able to view the existing routes by visiting: http://127.0.0.1:9000/actuator/gateway/routes

### Compile

```
$ mvn package
```

### Run

```
$ java -jar target/spring-gateway-demo-0.0.1-SNAPSHOT.jar
```

The application should run be running on port 9000.