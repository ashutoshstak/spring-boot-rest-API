# Spring Boot quickstart application

[![Build Status](https://travis-ci.org/vedab/spring-boot-quickstart.svg?branch=master)](https://travis-ci.org/vedab/spring-boot-quickstart)
[![Bitdeli Badge](https://d2weczhvl823v0.cloudfront.net/vedab/spring-boot-quickstart/trend.png)](https://bitdeli.com/free "Bitdeli Badge")

## Purpose

Create a REST API in Java platform with minimal installation and with minimal coding using 
[Gradle]((https://www.gradle.org/)) and [Spring Boot](http://projects.spring.io/spring-boot/).

## Steps
  - Download or Clone the repo
  - Run `gradlew run`
  - Access [http://localhost:8080/](http://localhost:8080) from your browser.
  - Java code
    - Add any REST API code to [src/main/java/com/springboot/quickstart/SampleController.java](./src/main/java/com/springboot/quickstart/SampleController.java)
	- Configurations for `Spring` and `web.xml` go into [src/main/java/com/springboot/quickstart/Application.java](./src/main/java/com/springboot/quickstart/Application.java)
  
## DIY
  - Install [Gradle](https://www.gradle.org/)
  - Create a folder - say `mkdir quickest-restapi`.
  - Go inside that folder - i.e `cd quickest-restapi`
  - Run `gradle init`
  - You should have a bunch of gradle related files generated in this folder.
  - Open `build.gradle`
    - Uncomment the code - i.e. remove `/*` & `*/` comment characters.
    - Add the below lines into `build.gradle` file
      - Add `spring-boot` gradle plugin 
	  
	    ```
		//Step-1: Spring boot plugin
        apply plugin: 'spring-boot'
        ```
	  - Add dependencies for building the application.
	  
	    ```
		//Scripts/Components to use during Build
		buildscript {
			repositories {
				mavenCentral()
			}
			dependencies{
				//Step-2: Spring boot plugin-package
				classpath("org.springframework.boot:spring-boot-gradle-plugin:1.2.0.RELEASE")
			}
		}
		```
	  - Add `compile` time dependencies in `dependencies` - not the `dependencies` under `buildscript`
	  
	    ```
        //Step-3: Spring boot starter web
        compile("org.springframework.boot:spring-boot-starter-web")
		```
  - Create a `Controller` for REST API endpoints
    - Refer to the minimally needed code in [src/main/java/com/springboot/quickstart/SampleController.java](./src/main/java/com/springboot/quickstart/SampleController.java)
  - Create a _MainClass_ for the kick starting the REST API.
    - Refer [src/main/java/com/springboot/quickstart/Application.java](./src/main/java/com/springboot/quickstart/Application.java)
  - Run `gradlew run`
  - Access [http://localhost:8080/](http://localhost:8080) from your browser.


## More DIY
  - Try adding `compile("org.springframework.boot:spring-boot-starter-actuator")` for more details about the Web Application you have created
    - Refer to the __log__ file for more REST endpoints when the _actuator_ is used
  - Try adding `compile("org.springframework.boot:spring-boot-starter-data-jpa")` and `compile("org.hsqldb:hsqldb:2.3.1")` and trial database code.
  - Try using `apply plugin: 'jetty'` and run `gradlew jettyRun` for executing the same in Jetty server

