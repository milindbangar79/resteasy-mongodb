## Resteasy MongoDB Project

This repository provides a simple example for the following involving RestEasy framework:

1. To connect to MongoDB using Dependency Injection
2. Create Swagger Spec using [swagger.io](https://github.com/swagger-api/swagger-core/wiki/Swagger-Core-RESTEasy-2.X-Project-Setup-1.5)
3. Dependency Injection : Start the Wildfly server using -P param to load application.properties file. This ensures that properties file is available in the classpath


### POM Configuration


```
Dependencies Required for Dependency Injection :

<dependency>
			<groupId>org.jboss.resteasy</groupId>
			<artifactId>resteasy-cdi</artifactId>
			<version>3.6.2.Final</version>
</dependency>

** For Property Dependency Injection **

<dependency>
			<groupId>io.xlate</groupId>
			<artifactId>property-inject</artifactId>
			<version>1.0.3</version>
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

