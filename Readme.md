# Prueba Tecnica BCI
Gabriel Martinez

# Requerimientos
● Desarrolle una aplicación que exponga una API RESTful de creación de usuarios.
 Todos los endpoints deben aceptar y retornar solamente JSON, inclusive al para los mensajes de
 error.

 # Mandatorio
- Plazo: 2 días, si tienes algún inconveniente con el tiempo comunicate con nosotros
-  Banco de datos en memoria. Ejemplo: HSQLDB o H2.
-  Proceso de build vía Gradle o Maven.
-  Persistencia con JPA. Ejemplo: EclipseLink, Hibernate u OpenJPA.
-  Framework SpringBoot.
-  Java 8+
-  Entrega en un repositorio público (github o bitbucket) con el código fuente y script de
 creación de BD.

 # Opcional

 ● JWT como token
 ● Pruebas unitarias
 ● Swagger

##
# Requisitos
- Springboot 3
- Java 17
- Maven 

##
# Diagrama
![Diagrama](https://github.com/BiarqGabriel/prueba-tecnica-bci/assets/132589481/a42b7e70-3e9e-462d-9c24-b4143814b7d5)

##
# Instalación
```bash
- Clonar Repositorio
- Correr con Sprinboot Tools 4 o mvn spring-boot:run
```
- La aplicación correra por defecto en el puerto 8080 en caso de querer otro puerto especificar en application.yml con server.port
##
# Objeto
```bash
{
    "nombre": "Juan Rodriguez",
    "correo": "juan@rodriguez.org",
    "contrasena": "hunter22",
    "telefonos": [
        {
            "number": "1234567",
            "citycode": "1",
            "contrycode": "57"
        }
    ]
}
```
##
# API ENDPOINTS
| ENDPOINT| METHOD | REQUEST | RESPONSE |
|---------|--------|---------|----------|
| /user?email= | GET | EMAIL | { id, name, email, passowrd, phones[], created, modified, lastLogin, token}  or {"message" : error} |
| /user | POST | {name, email, password, phones[]} | { id, name, email, passowrd, phones[], created, modified, lastLogin, token}  or {"message" : error} |
##
# SWAGGER
```bash
http://localhost:8080/swagger-ui/index.html
```
##
# LICENSE
- MIT

