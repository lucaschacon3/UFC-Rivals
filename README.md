![License](https://img.shields.io/badge/license-MIT-blue.svg)
![Java](https://img.shields.io/badge/java-21-blue.svg)
![Status](https://img.shields.io/badge/status-stable-brightgreen)
![Build Status](https://img.shields.io/github/workflow/status/lucaschacon3/ufc-rivals/CI?label=Build)

Claro, aquí tienes el contenido completo listo para pegar en tu archivo `README.md`, todo en formato Markdown:

````markdown
# 🥊 UFC Rivals – Despliegue en Linux

Sigue estos pasos para desplegar la aplicación **UFC Rivals** en un entorno Linux.

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

Verifica las instalaciones:

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

2. **Copia el archivo de variables de entorno** (por ejemplo, `.env`) al directorio raíz del proyecto.

3. **Exporta las variables de entorno**:

```bash
export $(cat .env | xargs)
```

> 📝 Asegúrate de que tu archivo `.env` tenga el formato:
>
> ```
> VAR1=value1
> VAR2=value2
> ```

4. **Construye el archivo `.jar`**:

```bash
mvn clean package
```

5. **Ejecuta la aplicación**:

```bash
java -jar target/ufc-rivals-0.0.1
```

