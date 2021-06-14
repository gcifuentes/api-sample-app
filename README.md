# API Sample App para Banco BICE

## Requisitos

- Java 11 en adelante
- Maven
- Salida a internet

## Instrucciones de instalación

- En el terminal del sistema operativo, posicionarse sobre la carpeta del proyecto
- Instalar las dependencias del proyecto ejecutando <code>mvn install</code>
- Generar package ejecutando <code>mvn package</code>
- Iniciar proyecto ejecutando <code>java -jar target/sample-app-1.0.0.jar</code>

## Uso de la API

<p>La API tiene 2 servicios:</p>

- GET: localhost:9150/api/get-last-indices -> retorna un objeto Indice con indicadores y su valor a una fecha determinada
- GET: localhost:9150/api/get-last-currency/list -> retorna una lista de indicadores

