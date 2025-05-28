![License](https://img.shields.io/badge/license-MIT-blue.svg)
![Java](https://img.shields.io/badge/java-21-blue.svg)
![Status](https://img.shields.io/badge/status-stable-brightgreen)
![Build Status](https://img.shields.io/github/workflow/status/lucaschacon3/ufc-rivals/CI?label=Build)


# 🥊 UFC Rivals – Despliegue en Linux

Pasos para desplegar la aplicación **UFC Rivals** en un entorno Linux, utilizando variables de entorno que normalmente defines desde IntelliJ.

---

## ✅ Requisitos

- Linux (Ubuntu/Debian)
- Java 21
- Maven

---

## ⚙️ Instalación de dependencias

```bash
sudo apt update
sudo apt install openjdk-21-jdk maven
````

Verifica que todo esté instalado correctamente:

```bash
java -version
mvn -v
```

---

## 📁 Despliegue

1. **Clona el repositorio**:

```bash
git clone https://github.com/yourusername/ufc-rivals.git
cd ufc-rivals
```

2. **Define las variables de entorno necesarias**

Contacta conmigo para acceder a las variables de entorno.

3. **Construye el proyecto**:

```bash
mvn clean package
```

4. **Ejecuta la aplicación**:

```bash
java -jar target/ufc-rivals-0.0.1-SNAPSHOT.jar
```

La aplicación estará disponible en:

```
http://localhost:8080
```

