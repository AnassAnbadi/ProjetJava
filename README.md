# ☕ ProjetJava

A comprehensive Java application built with Maven, demonstrating modern Java development practices and enterprise-level architecture.

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)

## 📋 Table of Contents

- [About](#about)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [API Documentation](#api-documentation)
- [Testing](#testing)
- [Contributing](#contributing)
- [Contributors](#contributors)
- [License](#license)

## 🎯 About

ProjetJava is a modern Java application that showcases:

- **Enterprise Architecture** - Clean, scalable, and maintainable code structure
- **Maven Integration** - Dependency management and build automation
- **Spring Framework** - Comprehensive application framework
- **RESTful APIs** - Modern web service implementation
- **Best Practices** - Following Java coding standards and design patterns

## ✨ Features

### Core Functionality
- ✅ **RESTful Web Services** - Complete REST API implementation
- ✅ **Database Integration** - Persistent data storage and management
- ✅ **Authentication & Authorization** - Secure user management
- ✅ **Data Validation** - Input validation and error handling
- ✅ **Logging System** - Comprehensive application logging
- ✅ **Configuration Management** - Externalized configuration
- ✅ **Exception Handling** - Global exception management

### Technical Features
- 🔧 **Maven Build System** - Automated build and dependency management
- 🔧 **Spring Boot** - Auto-configuration and embedded server
- 🔧 **JPA/Hibernate** - Object-relational mapping
- 🔧 **Unit Testing** - Comprehensive test coverage
- 🔧 **API Documentation** - Swagger/OpenAPI integration
- 🔧 **Docker Support** - Containerization ready

## 📋 Prerequisites

Before running this project, make sure you have:

- **Java 11+** - [Download Java](https://adoptium.net/)
- **Maven 3.6+** - [Download Maven](https://maven.apache.org/download.cgi)
- **Git** - [Download Git](https://git-scm.com/)
- **IDE** - IntelliJ IDEA, Eclipse, or VS Code (recommended)

### Optional
- **Docker** - For containerized deployment
- **Postman** - For API testing

## 🚀 Installation

### 1. Clone the Repository

```bash
git clone https://github.com/AnassAnbadi/ProjetJava.git
cd ProjetJava
```

### 2. Build the Project

Using Maven Wrapper (recommended):
```bash
# On Unix/Linux/macOS
./mvnw clean install

# On Windows
mvnw.cmd clean install
```

Using system Maven:
```bash
mvn clean install
```

### 3. Run the Application

```bash
# Using Maven Wrapper
./mvnw spring-boot:run

# Using system Maven
mvn spring-boot:run

# Using Java directly
java -jar target/ProjetJava-1.0.0.jar
```

The application will start on `http://localhost:8080`

## 🖥️ Usage

### Starting the Application

1. **Development Mode**
   ```bash
   ./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
   ```

2. **Production Mode**
   ```bash
   java -jar target/ProjetJava-1.0.0.jar --spring.profiles.active=prod
   ```

### Accessing the Application

- **Main Application**: http://localhost:8080
- **API Documentation**: http://localhost:8080/swagger-ui.html
- **Health Check**: http://localhost:8080/actuator/health
- **API Base URL**: http://localhost:8080/api/v1

### Environment Configuration

Create an `application.properties` file in `src/main/resources`:

```properties
# Server Configuration
server.port=8080
server.servlet.context-path=/

# Database Configuration
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# JPA Configuration
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Logging Configuration
logging.level.com.example=DEBUG
logging.level.org.springframework=INFO
```

## 📁 Project Structure

```
ProjetJava/
├── .settings/              # IDE-specific settings
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           ├── controller/     # REST Controllers
│   │   │           ├── service/        # Business Logic
│   │   │           ├── repository/     # Data Access Layer
│   │   │           ├── model/          # Entity Classes
│   │   │           ├── dto/            # Data Transfer Objects
│   │   │           ├── config/         # Configuration Classes
│   │   │           └── Application.java # Main Class
│   │   └── resources/
│   │       ├── application.properties  # Configuration
│   │       ├── static/                # Static Resources
│   │       └── templates/             # View Templates
│   └── test/
│       └── java/                      # Unit Tests
├── target/                 # Compiled Classes & JAR
├── .classpath             # Eclipse Classpath
├── .project               # Eclipse Project File
├── HELP.md                # Spring Boot Help
├── mvnw                   # Maven Wrapper (Unix)
├── mvnw.cmd               # Maven Wrapper (Windows)
├── pom.xml                # Maven Configuration
└── README.md              # Project Documentation
```

## 🔧 Maven Configuration

### Key Dependencies

The `pom.xml` includes essential dependencies:

```xml
<dependencies>
    <!-- Spring Boot Starter Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    
    <!-- Spring Boot Starter Data JPA -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    
    <!-- H2 Database -->
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>
    
    <!-- Spring Boot Starter Test -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

### Maven Commands

```bash
# Clean and compile
./mvnw clean compile

# Run tests
./mvnw test

# Package application
./mvnw package

# Skip tests during build
./mvnw clean install -DskipTests

# Run with specific profile
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
```

## 📚 API Documentation

### Authentication Endpoints

```http
POST /api/v1/auth/login
POST /api/v1/auth/register
POST /api/v1/auth/logout
GET  /api/v1/auth/profile
```

### User Management

```http
GET    /api/v1/users          # Get all users
GET    /api/v1/users/{id}     # Get user by ID
POST   /api/v1/users          # Create new user
PUT    /api/v1/users/{id}     # Update user
DELETE /api/v1/users/{id}     # Delete user
```

### Example API Requests

#### Create User
```bash
curl -X POST http://localhost:8080/api/v1/users \\
  -H "Content-Type: application/json" \\
  -d '{
    "name": "John Doe",
    "email": "john.doe@example.com",
    "password": "securePassword123"
  }'
```

#### Get All Users
```bash
curl -X GET http://localhost:8080/api/v1/users \\
  -H "Accept: application/json"
```

## 🧪 Testing

### Running Tests

```bash
# Run all tests
./mvnw test

# Run specific test class
./mvnw test -Dtest=UserServiceTest

# Run tests with coverage
./mvnw test jacoco:report
```

### Test Structure

```
src/test/java/
├── integration/           # Integration Tests
├── unit/                 # Unit Tests
│   ├── controller/       # Controller Tests
│   ├── service/          # Service Tests
│   └── repository/       # Repository Tests
└── TestApplication.java  # Test Configuration
```

### Example Test

```java
@SpringBootTest
@AutoConfigureTestDatabase
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void shouldCreateUser() {
        // Given
        UserDto userDto = new UserDto("John", "john@example.com");
        
        // When
        User createdUser = userService.createUser(userDto);
        
        // Then
        assertThat(createdUser.getName()).isEqualTo("John");
        assertThat(createdUser.getEmail()).isEqualTo("john@example.com");
    }
}
```

## 🐳 Docker Support

### Dockerfile

```dockerfile
FROM openjdk:11-jre-slim

WORKDIR /app

COPY target/ProjetJava-1.0.0.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
```

### Docker Commands

```bash
# Build image
docker build -t projet-java .

# Run container
docker run -p 8080:8080 projet-java

# Run with environment variables
docker run -p 8080:8080 -e SPRING_PROFILES_ACTIVE=prod projet-java
```

## 🔍 Monitoring & Health Checks

### Actuator Endpoints

```http
GET /actuator/health        # Application health
GET /actuator/info          # Application info
GET /actuator/metrics       # Application metrics
GET /actuator/env           # Environment properties
```

### Custom Health Indicators

```java
@Component
public class DatabaseHealthIndicator implements HealthIndicator {
    
    @Override
    public Health health() {
        // Custom health check logic
        return Health.up()
            .withDetail("database", "Available")
            .build();
    }
}
```

## 🤝 Contributing

We welcome contributions! Please follow these steps:

1. **Fork the repository**
2. **Create a feature branch**
   ```bash
   git checkout -b feature/amazing-feature
   ```
3. **Make your changes**
4. **Add tests** for new functionality
5. **Run tests** to ensure everything works
   ```bash
   ./mvnw test
   ```
6. **Commit your changes**
   ```bash
   git commit -m 'Add amazing feature'
   ```
7. **Push to the branch**
   ```bash
   git push origin feature/amazing-feature
   ```
8. **Open a Pull Request**

### Code Style Guidelines

- Follow Java naming conventions
- Use meaningful variable and method names
- Add JavaDoc comments for public methods
- Maintain test coverage above 80%
- Use Spring Boot best practices

## 👥 Contributors

Thanks to these wonderful people who have contributed to this project:

- **[AnassAnbadi](https://github.com/AnassAnbadi)** - Project Lead & Main Developer
- **[RadoinSadraoui](https://github.com/RadoinSadraoui)** - Contributor & Code Reviewer

## 🚀 Deployment

### Local Deployment

```bash
# Build the application
./mvnw clean package

# Run the JAR file
java -jar target/ProjetJava-1.0.0.jar
```

### Production Deployment

```bash
# Build with production profile
./mvnw clean package -Pprod

# Run with production configuration
java -jar target/ProjetJava-1.0.0.jar --spring.profiles.active=prod
```

## 📝 Troubleshooting

### Common Issues

1. **Port Already in Use**
   ```bash
   # Change port in application.properties
   server.port=8081
   ```

2. **Maven Build Fails**
   ```bash
   # Clean and rebuild
   ./mvnw clean install -U
   ```

3. **Database Connection Issues**
   ```bash
   # Check database configuration in application.properties
   # Ensure database is running and accessible
   ```

### Getting Help

- Check the [HELP.md](HELP.md) file for Spring Boot specific guidance
- Review application logs for error details
- Consult Spring Boot documentation
- Open an issue on GitHub

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🙏 Acknowledgments

- Spring Boot team for the excellent framework
- Maven community for build automation
- All contributors who helped improve this project

---

**Made with  by [AnassAnbadi](https://github.com/AnassAnbadi) and [RadoinSadraoui](https://github.com/RadoinSadraoui)**

*"Code is like humor. When you have to explain it, it's bad." – Cory House*
```

This comprehensive README provides:

1. **Professional presentation** with badges and clear structure
2. **Complete setup instructions** for different environments
3. **Detailed project structure** explanation
4. **API documentation** with examples
5. **Testing guidelines** and examples
6. **Docker support** for containerization
7. **Contributing guidelines** for collaboration
8. **Troubleshooting section** for common issues
9. **Acknowledgment of contributors** from the repository
10. **Production-ready deployment** instructions

The documentation covers all aspects of a modern Java/Spring Boot project and provides everything needed to understand, build, deploy, and contribute to your ProjetJava application.
```

