# Lab-3
## Integrantes
### David Espinosa
### Emily noreña
## DESCRIPCIÓN PROYECTO
El proyecto consiste en un sistema de gestión de bibliotecas, donde hay clases que representan ```Libro```, ```Usuario```, ```Prestamo```, y ```Biblioteca```. Los usuarios pueden tomar prestados libros de la biblioteca, y la Biblioteca se encarga de gestionar los préstamos, asegurarse de que los libros estén disponibles, y mantener un registro de los libros prestados.
### CREAR PROYECTO CON MAVEN
Deben crear un proyecto maven con los siguientes parámetros:
```yml
Grupo: edu.eci.cvds 
Artefacto: Library 
Paquete: edu.eci.cvds.tdd 
archetypeArtifactId: maven-archetype-quickstart 
```
### AGREGAR DEPENDENCIA JUNIT5
- Buscar en maven central la dependencia de JUnit5 en su versión más reciente.
- Edite el archivo pom.xml del proyecto para agregar la dependencia.
- Verifique que la versión de java sea la 17

### Agregar clases
- public class Book

- public class User

- public class Loan

- public class Library

## PRUEBAS UNITARIAS Y TDD
Para poder implementar los métodos ```addBook, loanABook y returnLoan``` de la clase ```Library``` vamos a aplicar la técnica de TDD, por cada caso de prueba se debe hacer un commit, cada commit debe tener la prueba nueva y la implementación para que la prueba del commit funcione. Las pruebas anteriormente implementadas deben continuar funcionando.

### CREAR CLASE DE PRUEBA
Es necesario crear la clase de prueba para ```edu.eci.cvds.tdd.Library```, la clase debe seguir los estándares de nombres estudiados en clase.

Para pensar en los casos de pruebas lean detenidamente el javadoc de los métodos para reconocer las clases de equivalencia, basados en las clases de equivalencia se debe crear una prueba la cual debe fallar y posteriormente implementar el código necesario para que funcione, este proceso se debe repetir hasta cumplir con la especificación definida en el javadoc.

### COBERTURA
- Agregar la dependencia de jacoco, utilizar la última versión disponible en maven central.
### SONARQUBE
Ahora es necesario hacer el análisis estático del código usando SonarQube, para lo cual necesitamos tener Docker.

- Para lo cual se debe descargar la imagen de docker con el siguiente comando ```docker pull sonarqube``` 
- Ahora se debe arrancar el servicio de SonarQube con el siguiente comando ```docker run -d --name sonarqube -e SONAR_ES_BOOTSTRAP_CHECKS_DISABLE=true -p 9000:9000 sonarqube:latest```
- Validar funcionamiento ```docker ps -a```
- Iniciar sesión en sonar ```localhost:9000``` cambiar la clave por defecto usuario y contraseña es admin.
- Entrar a las opciones de la cuenta.
  - Account -> settings -> generate token.
- Una vez sonar este corriendo deben generar un token  
- Instale sonarLint en el IDE que este manejando.
- Añada el plugin de Sonar en el archivo pom del proyecto.
