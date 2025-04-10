# 📚 Gestor de Biblioteca de Mangas

¡Bienvenido/a al gestor de **Biblioteca de Mangas**! Este es un proyecto web diseñado para administrar una biblioteca de mangas, ofreciendo funcionalidades clave como la gestión de títulos, alquileres y categorías.

---

## 🖋️ **Descripción**
El gestor de biblioteca es una aplicación desarrollada utilizando tecnologías robustas y confiables:
- **Modelo DAO Manual**: Para interactuar con la base de datos de manera estructurada.
- **Java Servlets**: Como controlador central, gestionando las solicitudes del cliente.
- **JSP (Java Server Pages)**: Para construir las vistas dinámicas del proyecto.
- **Servidor Tomcat**: Albergando la aplicación y manejando el procesamiento en el backend.

Este sistema proporciona una forma eficiente y moderna de organizar los mangas disponibles, alquilarlos y administrarlos.

---

## 🚀 **Características**
1. **Gestión de Mangas**:
   - Crear, editar y eliminar mangas disponibles en la biblioteca.
   - Asociar mangas con categorías y verificar su estado (alquilado o disponible).

2. **Gestión de Alquileres**:
   - Registrar nuevos alquileres.
   - Editar las fechas de inicio/fin de un alquiler.
   - Eliminar alquileres de forma sencilla.

3. **Interfaz Amigable**:
   - Tablas dinámicas para mostrar mangas y alquileres.
   - Uso de modales con confirmaciones de acciones importantes (por ejemplo, eliminación).

4. **Arquitectura Clara**:
   - Basado en el patrón MVC (Modelo-Vista-Controlador), separando responsabilidades y facilitando el mantenimiento.

---

## 🛠️ **Tecnologías Utilizadas**
- **Java**: Lenguaje principal del proyecto.
- **Apache Tomcat**: Servidor web para alojar la aplicación.
- **MySQL**: Base de datos relacional para almacenar información sobre mangas y alquileres.
- **Bootstrap**: Framework CSS para un diseño moderno y responsivo.
- **JSP y Servlets**: Para la lógica del lado del servidor y la construcción dinámica de vistas.
- **DAO Manual**: Gestión directa de las operaciones CRUD contra la base de datos.

---

## 📷 **Capturas de Pantalla**

### Inicio
![Inicio](assets/screenshots/inicio.png)

### Lista de Mangas
![Mangas](assets/screenshots/mangas.png)

### Confirmación eliminados
![Confirmación eliminados](assets/screenshots/confirmacion.png)

### Gestión de Alquileres
![Gestión de Alquileres](assets/screenshots/alquileres.png)

### Nuevo Manga
![Nuevo Manga](assets/screenshots/nuevo.png)

---

## ⚙️ **Configuración del Proyecto**

### Requisitos
- **JDK 11 o superior**.
- **Apache Tomcat 9.0 o superior**.
- **MySQL Server** (o cualquier otra base de datos relacional compatible).

### Instalación
1. Clona el repositorio en tu máquina local.
   ```bash
   git clone https://github.com/tu-usuario/gestor-biblioteca-manga.git

2. Configura la base de datos:
- Crea la base de datos manga_db.
- Importa las tablas necesarias desde el archivo manga_db.sql.

3. Modifica los datos de conexión a la base de datos en DB_Connection.java:
  private static final String DB_URL = "jdbc:mysql://localhost:3306/manga_db";
  private static final String DB_USER = "root";
  private static final String DB_PASSWORD = "tu_contraseña";

4. Despliega el proyecto en tu servidor Tomcat y accede desde tu navegador:
     http://localhost:8080/gestor-biblioteca-mangas
