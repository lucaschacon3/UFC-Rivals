![License](https://img.shields.io/badge/license-MIT-blue.svg)
![Java](https://img.shields.io/badge/java-21-blue.svg)
![Status](https://img.shields.io/badge/status-stable-brightgreen)
![Build Status](https://img.shields.io/github/workflow/status/lucaschacon3/ufc-rivals/CI?label=Build)

# UFC Rivals – Local Setup Guide

This guide will help you set up and run the **UFC Rivals** project locally using **H2** (in-memory database).

---

## 🛠️ Prerequisites

Make sure you have the following installed:

### ✅ Java 21

#### **Windows:**
1. Download and install **OpenJDK21** from [OpenJDK21](https://www.oracle.com/es/java/technologies/downloads/).
2. Set the **JAVA_HOME** environment variable:
   - Go to **Control Panel > System and Security > System > Advanced system settings**.
   - Click **Environment Variables** and under **System Variables**, click **New**.
   - Set **JAVA_HOME** to the path of your Java 21 installation, for example:  
     `C:\Program Files\AdoptOpenJDK\jdk-21`

3. Add **Java to PATH** by adding `%JAVA_HOME%\bin` to the **Path** variable.

#### **Linux (Ubuntu/Debian):**
```bash
sudo apt update
sudo apt install openjdk-21-jdk
````

#### Verify Installation:

```bash
java -version
```

---

### ✅ Maven

#### **Windows:**

1. Download **Maven** from [Apache Maven](https://maven.apache.org/download.cgi).
2. Extract the archive and add the `bin` directory to your **PATH** environment variable.
3. In **Environment Variables**, set **MAVEN\_HOME** to the path where Maven was extracted.

#### **Linux (Ubuntu/Debian):**

```bash
sudo apt install maven
```

#### Verify Installation:

```bash
mvn -v
```

---

## 🚀 Running the Project Locally (with H2)

### 1. Clone the repository

Open a terminal (or Command Prompt in Windows) and run:

```bash
git clone https://github.com/yourusername/ufc-rivals.git
cd ufc-rivals
```

### 2. Build the project

Run the following command to build the project:

```bash
mvn clean install
```

---

### 3. Run the application

To start the Spring Boot application, run:

```bash
mvn spring-boot:run
```

This will start the app and you can access it in your browser at:

```
http://localhost:8080
```


## 📄 H2 Database Configuration (default)

You do not need to make any changes to your database configuration as **H2** is used by default in the `application.properties`.

Here’s the relevant section in `src/main/resources/application.properties`:

```properties
# H2 Database Configuration
spring.datasource.url=jdbc:h2:mem:ufcdb;DB_CLOSE_DELAY=-1
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
```

This configuration will allow you to use an **H2 in-memory database**, and you can access the **H2 Console** at `http://localhost:8080/h2-console`.

---

Tienes razón, si el proyecto es una **aplicación web** y no una aplicación de consola, el proceso de despliegue debe tener en cuenta que será ejecutado en un servidor de aplicaciones, no solo como un `.jar` independiente. Si deseas que el archivo `.jar` se despliegue en un servidor como un servicio web (por ejemplo, **Tomcat** o **Nginx**), el comando sigue siendo válido, pero es probable que el despliegue dependa de cómo esté configurado el servidor de producción.

Voy a modificar esa sección para ser más adecuada a una **aplicación web Spring Boot**:

---


## 📤 Deployment (Optional)

To deploy the **UFC Rivals** project to a production server:

### 1. Build the `.jar` file (Production Build)
You can build a production-ready `.jar` file to deploy to a server:

```bash
mvn clean package
````

This will generate a `.jar` file in the `target` folder (e.g., `web-0.0.1-SNAPSHOT.jar`).

### 2. Run the application (Locally or on Server)

To run the `.jar` file locally or on your production server, use the following command:

```bash
java -jar target/web-0.0.1-SNAPSHOT.jar
```

This will start the Spring Boot application as a web service on the default port `8080`.



## 📜 License

This project is licensed under the MIT License.

---

## 🤝 Contributing

Feel free to fork this repository and submit a pull request. If you encounter any issues, please open an issue on GitHub.

---

## 📬 Contact

For any questions or feedback, please reach out via GitHub issues or email.

