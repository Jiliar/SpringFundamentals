# SpringFundamentals

## FUNDAMENTOS DE SPRINGBOOT
### ¿QUÉ ES SPRING BOOT?
•	Proyecto basado en Spring. No es lo mismo que Spring. Es un proyecto que forma parte del core de Spring, al igual que Spring Cloud, etc.
•	El objetivo principal es que sólo te centres en correr la aplicación, sin preocuparte por temas de configuración, etc.
•	Tiene la gran ventaja poder integrar librerías de terceros de manera muy sencilla.
•	No tendremos que preocuparnos por configuraciones a nivel de XML, sólo configuraciones mínimas a nivel de properties (ponerle el puerto, etc).
•	No tendremos que preocuparnos de desplegar nuestra aplicación en un servidor web local cuando queramos hacer pruebas, Spring Boot también contempla esto y lleva incorporado un servidor web dónde se desplegará nuestra aplicación automáticamente.
### CARACTERÍSTICAS PRINCIPALES DE SPRING BOOT
•	Independiente: no tenemos que preocuparnos de las dependencias del core de Spring ni de la compilación de estas.
•	Incrustado Tomcat, Jetty o Undertow: Spring Boot trae consigo un servidor web como los tres mencionados donde podemos correr nuestra aplicación sin preocuparnos de generar un artefacto WAR o JAR y desplegarlo nosotros mismos.
•	Proporción de dependencias: no debemos preocuparnos por las configuraciones de depndencias de terceros o del core de Spring, Spring Boot se encargará de inyectar todo lo necesario.
•	Sin generación de XML: No debemos preocuparnos de configuración XML para que nuestra aplicación funcione.
•	Métricas de salud del aplicativo: podemos validar el estado de un servicio desplegado, sus dependencias, estado de memoria, magnitud de configuración, etc.
### ¿QUÉ ES UNA DEPENDENCIA?
Pequeña característica de un objeto especifico, que puede impactar de manera particular en el funcionamiento de una unidad.
Por ejemplo, las dependencias de un Smartphone serian:
•	Cámara
•	Micrófono
•	Pantalla
•	Batería
Alta cohesión: Involucra que la entidad ejecute sus acciones sin involucrar otra clase o entidad.
Bajo acoplamiento Hablamos de acoplamiento bajo cuando existe una independencia entre los componentes entre sí, por el contrario, un alto acoplamiento es cuando tenemos varias dependencias relacionadas a un solo componente.

Entonces podemos afirmar que en la definición de un buen diseño de software se debe tener una ALTA COHESIÓN y un BAJO ACOPLAMIENTO.

###INVERSION DE CONTROL IOC
Se refiere a la transferencia del control del flujo de un programa a un contenedor o framework.
En un website o una app móvil el contenedor sería el usuario.
Ventajas
•	Facil testing por componentes o mocks de dependencias.
•	Mayor modularización.
•	Desacoplamiento cuando lo objetos cuentan con sus dependencias.
•	Segmentación de interfaces.
•	IoC en el contexto de Spring boot
•	Los objetos que son administrados por el contenedor, spring boot los denomina beans. Un bean seria los objetos administrados por el usuario en un website.
Un bean es un objeto el cual es instanciado, ensamblado y administrado por el contenedor de Spring IoC.
Patrón de inyección de dependencias
•	Es el patrón que utiliza IoC para utilizar las dependencias anteriormente instanciadas por el contenedor de Spring.
### AUTOCONFIGURACION Y RUNTIME
Configura automáticamente tus aplicaciones basadas en dependencias JAR que agregaste mediante el pom.xml, pero si nosotros realizamos una configuración manual esta es priorizada por Spring Boot.
La autoconfiguración no es invasiva, siempre que se quiera se puede configurar Beans propios.

### ¿QUE ES UNA ANOTACION EN SPRING BOOT?
Una Anotación es una forma de añadir metadatos al código fuente Java que están disponibles para la aplicación en tiempo de ejecución o de compilación. Es una alternativa mas sencilla al uso de XML.
TIPOS DE ANOTACIONES:
@Component: anotación genérica, de ella nacen las siguientes (@Controller, @Service y @Repository). Se usa cuando tenemos una clase abstracta.
@Controller: Se usa en las clases que se encargan de recibir las peticiones HTTP por parte de usuarios o clientes, así como devolver las respuestas de esas peticiones procesadas al frontal.
@Service: Se usa en clases que se implementan a nivel de lógica de negocio, es decir, en ellas se pueden consultar unidades de persistencias (bases de datos, APIs etc) y también en ellas se realizan las validaciones.
@Repository: Se usan a nivel de interfaces, con el fin de enlazar los servicios obtenidos con la capa controladora, se podría también decir que es la capa de implementación de la persistencia de datos.
Por otro lado, no es estrictamente necesario que cumplas con colocar una notación especifica, pero es una buena práctica.
CAMBIO DE PUERTO Y PATH
<!— Despliegue Web (Http) de soluciones -->
<dependency>
<groupId> org.springframework.boot </groupId>
<artefactId>spring-boot-starter-web</artifactId>
<optional>true</optional>
</dependency>

<!— Herramientas para desarrollo -->
<dependency>
<groupId>org.springframework.boot</groupId>
<artefactId>spring-boot-devtools</artifactId>
<optional>true</optional>
</dependency>

application.properties:
•	server.port = 8081
•	server.servlet.context-path=/app
ACCESS: http://localhost:8081/app/
USO DE PROPERTIES Y VALORES
application.properties:
•	server.port = 8081
•	server.servlet.context-path=/app
•	value.name=Jiliar
•	value.lastname=Silgado
•	value.random=${random.value}

### LOGS
Qué son los logs y cómo usarlos
Son una herramienta que nos permite debugear la información, es decir; saber por donde esta pasando la información, por cual método, cual clase y con que nivel de depuración lo queremos mostrar.
Para esto tenemos en Spring, la Liberia Apache Commons la cual tiene lo siguientes niveles de log:
•	Error: Nos permite mostrar información cuando ocurre un error
•	Info: Nos muestra información muy genera
•	Debug: Este nos sirve para depurar por donde esta pasando la información a nivel de código fuente.
•	Otros, ver documentación:
Apache Commons - Apache Commons

MODELADO DE ENTIDADES CON JPA
JPA es una especificación API de Java que describe la gestión de datos relacionales en aplicaciones que utilizan la plataforma Java
Hibernate es una biblioteca ORM (Object Relational Mapping) que sigue la especificación JPA.

### CONFIGURACIÓN DE DATASOURCE CON PROPERTIES Y CLASSES
application.properties:
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=1234
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.show-sql=true

 ### ¿QUE ES JPQL?
•	JPQL  es el lenguaje de consulta definido por JPA.
•	Similar a SQL pero con la particularidad de operar sobre objetos y no con tablas y columnas.

### ¿QUE SON LOS QUERY METHODS?
Es una definición de una consulta manualmente como una cadena o derivarla del nombre del método.
NAMED PARAMETERS
Son parámetros que se envían a nivel de sentencias, estos parámetros serán inicializados dentro los parámetros del método, representándolos por medio de la anotación @Param.
@RestController: Permite que todos los métodos creados trabajen con el formato JSON, hereda de @Controller
