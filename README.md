## Resteasy MongoDB Project

This repository provides a simple example for the following involving RestEasy framework:

1. To connect to MongoDB using Dependency Injection
2. Create Swagger Spec using [swagger.io](https://github.com/swagger-api/swagger-core/wiki/Swagger-Core-RESTEasy-2.X-Project-Setup-1.5)


### POM Configuration


```
Dependencies Required for Dependency Injection :

<dependency>
			<groupId>org.jboss.resteasy</groupId>
			<artifactId>resteasy-cdi</artifactId>
			<version>3.6.2.Final</version>
</dependency>

Swagger IO Dependency:
<dependency>
			<groupId>io.swagger</groupId>
			<artifactId>swagger-jaxrs</artifactId>
			<version>1.5.0</version>
</dependency>

MongoDB Dependency:
<dependency>
			<groupId>com.google.code.morphia</groupId>
			<artifactId>morphia</artifactId>
			<version>0.104</version>
</dependency>

```

