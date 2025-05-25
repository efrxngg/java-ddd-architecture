<h1 align="center">
  ☕🎯 Arquitectura Hexagonal, DDD y CQRS en Java
</h1>

<p align="center">
    <a href="#"><img src="https://img.shields.io/badge/Spring_Boot-3.2-green.svg?style=flat-square&logo=spring" alt="Spring Boot 3.2"/></a>
</p>

<p align="center">
  Ejemplo de una <strong>aplicación Java utilizando Domain-Driven Design (DDD), Arquitectura Hexagonal y CQRS</strong> manteniendo el código lo más simple posible.
  <br />
  <br />
  Explora, prueba y diviértete con este proyecto.
  <a href="https://github.com/CodelyTV">¡Las estrellas son bienvenidas 😊!</a>
  <br />
  <br />
  <a href="#">Ver demo</a>
  ·
  <a href="https://github.com/CodelyTV/java-ddd-example/issues">Reportar un bug</a>
  ·
  <a href="https://github.com/CodelyTV/java-ddd-example/issues">Solicitar una funcionalidad</a>
</p>

## 🚀 Configuración del entorno

### 📄 Herramientas necesarias

1. [Instalar Java 17+](https://adoptium.net/)
2. [Instalar Docker](https://www.docker.com/get-started)
3. Clonar este proyecto: `git clone https://github.com/CodelyTV/java-ddd-example`
4. Acceder a la carpeta del proyecto: `cd java-ddd-example`

### 🛠️ Configuración del entorno

1. Crear un archivo `.env` local o configurar las variables de entorno necesarias.

### 🔥 Ejecución de la aplicación

1. Construir y ejecutar con Docker: `./mvnw clean install && docker compose up`
2. Tendrás disponibles 2 APIs backend:

    1. [Mooc Backend](http://localhost:8030/health-check)
    2. [Backoffice Backend](http://localhost:8040/health-check)

### ✅ Ejecución de pruebas

1. Ejecutar todas las pruebas con Maven: `./mvnw test`
2. Generar cobertura con JaCoCo: `./mvnw verify`

## 👩‍💻 Explicación del proyecto

Este proyecto simula una plataforma MOOC (Massive Open Online Course). Está desacoplado del framework y usa adaptadores
para Spring Boot.

### ⛱️ Contextos delimitados (Bounded Contexts)

* `Mooc`: Plataforma pública (usuarios, videos, notificaciones).
* `Backoffice`: Plataforma interna para gestión de contenido (usuarios, cursos, moderación).

### 🎯 Arquitectura Hexagonal y estructura de carpetas

La estructura del proyecto se basa en contextos delimitados y módulos:

```
src
|-- mooc                      # Contexto delimitado Mooc
|   |-- videos                # Módulo de videos
|   |   |-- application       # Capa de aplicación con comandos y casos de uso
|   |   |   |-- create
|   |   |   |   |-- CreateVideoCommand.java
|   |   |   |   |-- CreateVideoCommandHandler.java
|   |   |   |   |-- VideoCreator.java
|   |   |-- domain            # Capa de dominio con entidades, repositorios y lógica
|   |   |   |-- Video.java
|   |   |   |-- VideoId.java
|   |   |   |-- VideoRepository.java
|   |   |-- infrastructure    # Capa de infraestructura (implementaciones técnicas)
|   |   |   |-- persistence
|   |   |   |   |-- MySqlVideoRepository.java
|-- shared                   # Kernel compartido entre contextos
    |-- domain
    |-- infrastructure
```

### 📁 Patrón repositorio

Los repositorios se definen como interfaces en el dominio y solo exponen métodos mínimos (`save`, `findById`,
`searchByCriteria`).

### 🖇 Agregados

Todos los agregados extienden de una clase común `AggregateRoot` y encapsulan las reglas de consistencia.

### 📄 Bus de comandos (Command Bus)

Los comandos y sus handlers se registran mediante Spring o manualmente en la infraestructura.

### 📒 Bus de consultas (Query Bus)

Las consultas siguen la misma estructura que los comandos para asegurar separación CQRS.

### 🚧 Bus de eventos (Event Bus)

Los eventos de dominio se propagan en memoria o a sistemas externos como RabbitMQ.

## 📱 Monitoreo

Los eventos de dominio se exportan a Prometheus para observabilidad (si está configurado).

## 🧐 Contribuir

¡Se aceptan mejoras! Puedes añadir documentación Swagger, pruebas o refactorizar módulos.

## 🤩 Extra

Este proyecto está basado en:

* [🇪🇸 Arquitectura Hexagonal](https://pro.codely.tv/library/arquitectura-hexagonal/66748/about/)
* [🇪🇸 DDD y CQRS: Preguntas Frecuentes](https://codely.com/blog/ddd-cqrs-preguntas-frecuentes)

## 🌐 Visita nuestros cursos

* [Cursos en Codely](https://codely.com/cursos)
