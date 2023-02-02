# AREP Taller 1

Aplicación de cosnulta de descripciones de peliculas, la cual consume un API externo para la consulta de estas. Se recibe el titulo de una pelicula y se podrá visualizar el resultado en formato de una tabla la cual entrega la descripción de la pelicula en diferentes aspectos

## Iniciando

### Prerequisites

- Maven - Administrador de dependencias y administrador del ciclo de vida del proyecto
- Java - Ambiente de desarrollo
-  Git - Sistema de control de versiones y descarga del repositorio

### Instalando el entorno

Para correr el programa primero descargue el repositorio con el siguiente comando
```
git clone https://github.com/Derjasai/AREP_Lab01.git
```

Una vez clonado el repositorio ingrese en la carpeta descargada y corra el siguiente comando para ejecutar el programa

```
mvn clean package exec:java -D "exec.mainClass"="edu.escuelaing.arep.app.HttpServer"
```

Finalmente ingrese al navegador de su preferencia con el siguiente link:
http://localhost:35000

## Documentación
Se encontrar la documentación en la carpeta nombrada "javadoc", para generar nueva documentación puede correr el siguiente comando
```
mvn javadoc:javadoc
```
La nueva documentación generada puede encontrarla en la ruta /target/site/apidocs

## Corriendo Tests unitatios

Para correr los test ubiquese en la carpeta principal de repositorio y corra el siguiente comando desde la consola

```
mvn test
```

## Despliegue

Add additional notes about how to deploy this on a live system

## Construido con

* [Maven](https://maven.apache.org/) - Dependency Management

## Versonamiento

Versión 1.0

## Autores

* Daniel Esteban Ramos Jimenéz

## Explicaciones tecnicas

Se hace una arquitectura enfocada en API Rest. Se implementa el patrón de diseño SINGLETON para la creación de caché, puesto que este es el único caché que debe existir dentro del servidor

- Extensibilidad: Si se requiere hacer  la consulta a otra API del mismo estilo basta con cambiar la dirección de la URL en el atributo establecido en la clase de APIConnection y mandar el Query correspondiente en HttpServer
- Patrones usados: Se usa el patrón de Fachada y el patrón de Singleton
- Modularización: Todas clases implementan metodos los cuales singuel el principio de unica responsabilidad, lo cual nos permite extender el codigo de ser necesario en dado caso que se neceite