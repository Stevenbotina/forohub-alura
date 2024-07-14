# 🌟 ForoHub API 🌟

_ForoHub es un espacio donde los miembros de una plataforma pueden hacer preguntas y compartir respuestas sobre temas específicos. En este proyecto, replicaremos este proceso en el back end creando una API REST usando Spring._

Nuestra API se enfocará en los tópicos y sus respuestas, permitiendo a los usuarios:

- Crear un nuevo tópico o respuesta
- Mostrar todos los tópicos o respuestas creados
- Mostrar un tópico o respuesta específico
- Actualizar un tópico o respuesta
- Eliminar un tópico o respuesta

En resumen, implementaremos un conjunto completo de operaciones CRUD (Crear, Leer, Actualizar, Eliminar).

## Comenzando 🚀

Estas instrucciones te ayudarán a obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas.

Consulta la sección de Deployment para conocer cómo desplegar el proyecto.

## Tecnologías Utilizadas 🛠️

En el desarrollo de ForoHub API se utilizaron las siguientes tecnologías y herramientas:

- **Java**: Lenguaje de programación principal para la lógica del backend.
- **Spring Boot**: Framework utilizado para crear la aplicación REST.
- **Spring Data JPA**: Para la gestión y acceso a la base de datos.
- **Spring Security**: Para la autenticación y autorización de usuarios.
- **MySQL**: Sistema de gestión de bases de datos utilizado.
- **Hibernate**: Framework de mapeo objeto-relacional (ORM) utilizado junto con JPA.
- **JWT (JSON Web Tokens)**: Para la gestión de tokens de seguridad.
- **Maven**: Herramienta de gestión y construcción de proyectos.
- **IntelliJ IDEA**: Entorno de desarrollo integrado (IDE) utilizado para escribir y mantener el código.
- **Insomnia**: Herramienta utilizada para probar y validar las solicitudes y respuestas de la API.

Estas tecnologías y herramientas permitieron desarrollar una API REST robusta, segura y fácil de mantener.


## Pre-requisitos 📋

Las herramientas necesarias son IntelliJ IDEA, Insomnia (para pruebas) y MySQL.

- [IntelliJ IDEA](https://www.jetbrains.com/es-es/idea/download/?section=windows)
- [MySQL](https://dev.mysql.com/downloads/installer/)
- [Insomnia](https://insomnia.rest/download)


## Instalación 🔧

Antes de iniciar el servicio, deberás crear una nueva base de datos con el nombre: `foro_hub`.

1. **Clona este repositorio:**

   ```sh
   git clone https://github.com/Stevenbotina/forohub-alura

2. **Abre el proyecto en IntelliJ IDEA: Navega hasta el archivo .properties y verifica los siguientes datos:**
   
    ```sh

    spring.datasource.url=jdbc:mysql://localhost/${DB_NAME}
    spring.datasource.username=TU_USUARIO_DB
    spring.datasource.password=TU_CONTRASEÑA_DB
    api.security.secret=JWT_SECRET (123456 por defecto)

## Ejemplos de Uso de la API

### Crear un Usuario
- **Método HTTP:** POST
- **URI:** `http://localhost:8080/user`
- **Cuerpo JSON:**

  ```json
  {
     "email" : "tu email",
     "userName" : "tu usuario",
     "password" : "tu contraseña"
  }

## Actualizar un Usuario

- **Método HTTP:** PUT
- **URI:** `http://localhost:8080/user/{id}`
- **Cuerpo JSON:** 

  ```json
  
  {
     "id" : "id del usuario",
     "email" : "tu nuevo email",
     "userName" : "tu nuevo usuario",
     "password" : "tu nueva contraseña"
  }

## Listar Todos los Usuarios
- **Método HTTP:** GET
- **URI: http://localhost:8080/user**
## Obtener un Usuario por su ID
- **Método HTTP:** GET
- **URI: http://localhost:8080/user/{id}**
## Eliminar un Usuario
- **Método HTTP: DELETE**
- **URI: http://localhost:8080/user/{id}**
## Crear un Tópico
- **Método HTTP:** POST
- **URI: http://localhost:8080/topics**
- **Cuerpo JSON:**
  
   ```json
  {
     "title" : "tu título",
     "body" : "tu tema",
     "courseName" : "tu nombre de curso"
  }

## Actualizar un Tópico
- **Método HTTP:** PUT
- **URI: http://localhost:8080/topics/{id}**
- **Cuerpo JSON:**

  ```json
  
  {
     "id" : "id del tópico",
     "title" : "tu nuevo título",
     "body" : "tu nuevo tema",
     "courseName" : "nombre del curso"
  }

## Listar Todos los Tópicos
- **Método HTTP:** GET
- **URI: http://localhost:8080/topics**
## Obtener un Tópico por su ID
- **Método HTTP: GET**
- **URI: http://localhost:8080/topics/{id}**
## Eliminar un Tópico
- **Método HTTP: DELETE**
- **URI: http://localhost:8080/topics/{id}**
## Crear una Respuesta
- **Método HTTP:** POST
- **URI: http://localhost:8080/response/{id}**
- **Cuerpo JSON:**

    ```json
    {
       "id" : "id del tópico",
       "responseTitle" : "el título de tu respuesta",
       "body" : "tu respuesta"
    }

## Actualizar una Respuesta
- **Método HTTP:** PUT
- **URI: http://localhost:8080/response/{id}**
- **Cuerpo JSON:**

  ```json

  {
     "id" : "id de la respuesta",
     "responseTitle" : "el título de tu nueva respuesta",
     "body" : "tu nueva respuesta"
  }
## Listar Todas las Respuestas
- **Método HTTP:** GET
- **URI: http://localhost:8080/response**
## Obtener una Respuesta por su ID
- **Método HTTP:** GET
- **URI: http://localhost:8080/response/{id}**
## Eliminar una Respuesta
- **Método HTTP:** DELETE
- **URI: http://localhost:8080/response/{id}**

## 📝 Licencia

Este proyecto está bajo la licencia MIT.
