# Challenge API Foro Hub 

**Documentación para usuarios**

Foro Hub es una aplicación web desarrollada con Spring Boot que permite a los usuarios crear, consultar, actualizar, listar y eliminar tópicos en un foro de discusión.

## Características principales

- Autenticación de usuarios mediante JWT.
- Creación de nuevos tópicos de discusión.
- Consulta y listado de tópicos.
- Actualización de tópicos existentes.
- Eliminación (desactivación) de tópicos.
- Validaciones en la entrada de datos de los tópicos.
- Tratamiento de errores personalizado.

## Tecnologías utilizadas

- Java 17
- Spring Boot 3
- Spring Data JPA
- Spring Security
- JWT
- Swagger (Documentación de la API)
- Lombok
- Validaciones con Jakarta Validation
- Workbench MySQL
- Insomnia (pruebas de la API)
- Swagger

## Configuración y ejecución

1. Asegúrate de tener instalado Java JDK y una herramienta de gestión de dependencias como Maven.
2. Clona este repositorio en tu máquina local.
3. Configura la cadena de conexión a la base de datos en el archivo `application.properties`.
4. Ejecuta la aplicación Spring Boot utilizando tu IDE.

## Documentación de la API

Una vez que la aplicación esté en funcionamiento, puedes acceder a la documentación de la API Swagger en `http://localhost:8080/swagger-ui.html`. Allí encontrarás información detallada sobre los endpoints disponibles, sus parámetros y ejemplos de uso.

## Acceso a la aplicación

- Usuario: jorge.aita
- Contraseña: 12345678
- Genera la clave para MySQL con Bcrypt Password Generator.

## Pruebas de la API

Puedes utilizar una herramienta como Insomnia para realizar pruebas en los endpoints de la API.
No olvides generar la clave referida a la contraseña Bearer Token para Insomnia.
Los datos de acceso puedes utilizarlos para URL de Swagger UI: http://localhost:8080/swagger-ui.html.

Iniciará la aplicación en http://localhost:8080.

## Endpoints Disponibles

### Autenticación
Endpoint de Autenticación

URL: /login
Método: POST
Descripción: Autentica a un usuario y devuelve un token JWT válido.

**Ejemplo de solicitud:**
{
  "login": "nombre_de_usuario",
  "clave": "contraseña"
}


### Tópicos  

Crear Tópico

URL: /topicos
Método: POST
Descripción: Crea un nuevo tópico de discusión.
Ejemplo de solicitud:

{
  "titulo": "Título del Tópico",
  "mensaje": "Mensaje del Tópico",
  "fechaCreacion": "2024-06-17",
  "status": "activo",
  "autor": "nombre_autor",
  "curso": "curso_relacionado"
}


**Listar Tópicos**

URL: /topicos
Método: GET
Descripción: Obtiene una lista paginada de todos los tópicos activos.
Actualizar Tópico

URL: /topicos
Método: PUT
Descripción: Actualiza los detalles de un tópico existente.

Ejemplo de solicitud:
{
  "id": 1,
  "titulo": "Nuevo Título del Tópico",
  "mensaje": "Nuevo Mensaje del Tópico",
  "fechaCreacion": "2024-06-18",
  "status": "activo",
  "autor": "nuevo_autor",
  "curso": "curso_modificado"
}


**Eliminar Tópico**

URL: /topicos/{id}
Método: DELETE
Descripción: Elimina un tópico específico por su ID.


### Gestión de Errores

Errores de Validación
La API maneja errores de validación de datos. Si se proporciona una solicitud inválida, se devolverán mensajes de error adecuados.

Recursos No Encontrados
Si se intenta acceder a un recurso que no existe, se devolverá un código de estado 404 Not Found.


## Contribución

Si deseas contribuir a este proyecto, puedes hacerlo a través de pull requests en este repositorio. Asegúrate de seguir las mejores prácticas de codificación y de proporcionar una descripción clara de los cambios realizados.

## Desarrollado por:
Jorge Aita - Challenge Foro Hub - ONE - Alura LATAM
