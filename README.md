![License](https://img.shields.io/badge/license-MIT-blue.svg)
![Java](https://img.shields.io/badge/java-21-blue.svg)
![Status](https://img.shields.io/badge/status-stable-brightgreen)

# Puedes ver la aplicación aquí:

## Servidor Heroku
https://ufc-rivals-cd6647701d82.herokuapp.com/

## Servidor propìo
http://ufc.rivals.mooo.com/

---
# Despliegue local

Pasos para desplegar la aplicación **UFC Rivals** en un entorno Linux, utilizando variables de entorno que normalmente defines desde IntelliJ.


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
https://github.com/lucaschacon3/UFC-Rivals
cd ufc-rivals
```

2. **Define las variables de entorno necesarias (contacta conmigo)**

3. **Construye el proyecto**:

```bash
mvn clean package
```

4. **Ejecuta la aplicación**:

```bash
java -jar target/ufc-rivals-0.0.1-SNAPSHOT.jar
```

La aplicación estará disponible en el puerto 80 (si te da problemas de seguridad cambia el puerto al 8080 desde application.properties):

```
http://localhost
```

