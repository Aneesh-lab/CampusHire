# CampusHire

CampusHire is a Java-based application built with Spring Boot. The project is currently in its initial development stage, with the foundational project structure and dependencies configured.

## 🚀 Project Overview

The goal of this repository is to develop CampusHire using Java and the Spring ecosystem. Application features and functionality will be documented as development progresses.

## 🛠️ Technology Stack

| Technology       | Purpose                                    |
| ---------------- | ------------------------------------------ |
| Java 17          | Programming language                       |
| Spring Boot      | Application framework                      |
| Maven            | Dependency management and build automation |
| Spring Web MVC   | Web application development                |
| Spring Security  | Application security                       |
| MongoDB          | Database integration                       |
| Apache POI 5.2.5 | Excel file processing                      |
| Lombok           | Reducing Java boilerplate code             |


## 📂 Project Structure

```text
CampusHire/
├── .mvn/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── campushire/
│   │   │           └── campushire/
│   │   │               ├── config/
│   │   │               ├── controller/
│   │   │               └── CampushireApplication.java
│   │   └── resources/
│   └── test/
├── .gitignore
├── .gitattributes
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## ⚙️ Prerequisites

Before running the project, ensure you have:

* Java Development Kit (JDK) 17.
* Git.
* An IDE such as Visual Studio Code or IntelliJ IDEA.
* A MongoDB instance if database connectivity is required by the implemented application.

## ▶️ Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/Aneesh-lab/CampusHire.git
```

### 2. Navigate to the project directory

```bash
cd CampusHire
```

### 3. Run the application on Windows

```powershell
.\mvnw.cmd spring-boot:run
```

Alternatively, you can build the project using:

```powershell
.\mvnw.cmd clean package
```

The application may require additional configuration before it can run successfully. Database connection settings and other required properties should be configured locally.

## 🧪 Testing

The project includes dependencies for Spring Boot testing. Automated tests will be added and documented as development progresses.

To execute the available tests on Windows, run:

```powershell
.\mvnw.cmd test
```

## 🔒 Configuration and Security

* Keep database credentials, API keys, and other sensitive information out of version control.
* Use local configuration or environment variables for sensitive values.
* Do not commit passwords or production secrets to the repository.

## 📈 Future Development

This README will be updated as CampusHire develops, including details about implemented features, application architecture, configuration, and testing.

## 👨‍💻 Repository

GitHub: [Aneesh-lab/CampusHire](https://github.com/Aneesh-lab/CampusHire)
