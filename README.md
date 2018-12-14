## Markdown editor / backend 

El presente proyecto es un backend para la gestión de documentos markdown, que posibilita la ejecución de las operaciones de crear, actualizar, eliminar y listar los documentos markdown almacenados en el servidor.

### Tecnologías

El proyecto está desarrollado en Java con el marco de trabajo Spring Boot. Emplea JPA para la conexión e integración con el gestor de bases de datos, con ello puede usar cualquier gestor de bases de datos SQL, por ejemplo (PostgreSQL, MySQL, SQLite, H2, entre otros). En este desarrollo se empleó MySQL, para usar otro solo debe añadir la dependencia del driver al fichero pom.xml y ajustar la URL de conexión en el fichero de configuración.

### Puesta en operación.

Para ejecutar el proyecto clonarlo desde el repositorio, ponerse en la raíz del mismo y ejecutar el comando `mvn install` , esto descargará las dependencias y generará un fichero JAR en la carpeta /target dentro del directorio del proyecto.

Las configuraciones del proyecto pueden cambiarse desde el fichero `src/main/resources/application.properties` . Por defecto ahora mismo se ejecuta por el puerto 8082.

Antes de ejecutar el proyecto verifique en el fichero de configuración los datos de conexión a MySQL y cree una base de datos llamada `mdeditor`.


### Pruebas de operación

Una vez levantado el backend posterior a realizar el mvn install y java -jar fichero.jar se ha colocado una fichero de perfil de [Insomia](https://insomnia.rest/) con los ejemplos para realizar las operaciones de crear un documento, actualizarlo, eliminarlo y listar los documentos colocados en el servidor.


