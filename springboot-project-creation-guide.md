# How to Create a Maven Spring Boot Project Using Command Line

## Method 1: Using Spring Initializr (Recommended)

### Option A: Using curl (Most Common)

```bash
# Basic Spring Boot Web project
curl https://start.spring.io/starter.zip \
  -d dependencies=web \
  -d type=maven-project \
  -d language=java \
  -d bootVersion=3.2.0 \
  -d baseDir=my-springboot-app \
  -d groupId=com.example \
  -d artifactId=my-springboot-app \
  -d name=my-springboot-app \
  -d description="Demo project for Spring Boot" \
  -d packageName=com.example.myspringbootapp \
  -d packaging=jar \
  -d javaVersion=17 \
  -o my-springboot-app.zip

# Extract the project
unzip my-springboot-app.zip
cd my-springboot-app
```

### Option B: Using Spring Boot CLI

```bash
# Install Spring Boot CLI first (if not installed)
brew install spring-boot  # on macOS
# or
sdk install springboot    # using SDKMAN!

# Create project
spring init --dependencies=web,data-jpa,h2 my-springboot-app
cd my-springboot-app
```

## Method 2: Using Maven Archetype

```bash
# Create a basic Maven project and add Spring Boot manually
mvn archetype:generate \
  -DgroupId=com.example \
  -DartifactId=my-springboot-app \
  -DarchetypeArtifactId=maven-archetype-quickstart \
  -DinteractiveMode=false

cd my-springboot-app
```

Then you'll need to manually configure the pom.xml to add Spring Boot dependencies.

## Method 3: Complete curl Command with Common Dependencies

```bash
curl https://start.spring.io/starter.zip \
  -d dependencies=web,data-jpa,h2,devtools,lombok \
  -d type=maven-project \
  -d language=java \
  -d bootVersion=3.2.0 \
  -d baseDir=complete-springboot-app \
  -d groupId=com.example \
  -d artifactId=complete-springboot-app \
  -d name=complete-springboot-app \
  -d description="Complete Spring Boot application" \
  -d packageName=com.example.completespringbootapp \
  -d packaging=jar \
  -d javaVersion=17 \
  -o complete-springboot-app.zip

unzip complete-springboot-app.zip
cd complete-springboot-app
```

## Common Dependencies You Can Add

- `web` - Spring Web (REST controllers)
- `data-jpa` - Spring Data JPA
- `h2` - H2 Database (in-memory)
- `mysql` - MySQL Driver
- `postgresql` - PostgreSQL Driver
- `devtools` - Spring Boot DevTools (auto-restart)
- `lombok` - Project Lombok (reduce boilerplate)
- `test` - Spring Test (testing)
- `security` - Spring Security
- `actuator` - Spring Boot Actuator (monitoring)
- `validation` - Bean Validation
- `aop` - Spring AOP

## After Project Creation

### 1. Navigate to project directory
```bash
cd your-project-name
```

### 2. Build and run the application
```bash
# Using Maven wrapper
./mvnw spring-boot:run

# Or using Maven (if installed globally)
mvn spring-boot:run
```

### 3. Test the application
```bash
# Test endpoint
curl http://localhost:8080

# Or open in browser
open http://localhost:8080
```

## Example: Creating a Web API Project

Here's a complete example to create a REST API project:

```bash
curl https://start.spring.io/starter.zip \
  -d dependencies=web,data-jpa,h2,devtools,lombok,validation \
  -d type=maven-project \
  -d language=java \
  -d bootVersion=3.2.0 \
  -d baseDir=my-api-project \
  -d groupId=com.example \
  -d artifactId=my-api-project \
  -d name=my-api-project \
  -d description="REST API project with Spring Boot" \
  -d packageName=com.example.myapiproject \
  -d packaging=jar \
  -d javaVersion=17 \
  -o my-api-project.zip

unzip my-api-project.zip
cd my-api-project
./mvnw spring-boot:run
```

## Useful Tips

1. **Interactive Mode**: Use `https://start.spring.io` in browser for visual project creation
2. **List all dependencies**: Visit `https://start.spring.io/dependencies` to see available dependencies
3. **Customize port**: Add `server.port=8081` in `application.properties`
4. **Enable profiles**: Use `--active=dev` in curl command or configure in properties

## Quick Start Commands

```bash
# Super simple web app
curl https://start.spring.io/starter.zip -d dependencies=web -d baseDir=simple-app -o simple-app.zip
unzip simple-app.zip && cd simple-app && ./mvnw spring-boot:run

# Web app with database
curl https://start.spring.io/starter.zip -d dependencies=web,data-jpa,h2 -d baseDir=web-db-app -o web-db-app.zip
unzip web-db-app.zip && cd web-db-app && ./mvnw spring-boot:run
```

These commands will create a fully functional Spring Boot project that you can start developing immediately!
