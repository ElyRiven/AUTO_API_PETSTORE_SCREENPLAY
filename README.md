# Automatización de la API PetStore con Serenity BDD — Patrón Screenplay

## Descripción

Este proyecto implementa la automatización de pruebas E2E sobre la [**API pública de PetStore**](https://petstore.swagger.io/), una API REST de referencia para pruebas de backend. Las pruebas están diseñadas con el patrón **Screenplay** sobre el framework **Serenity BDD**, combinando **Cucumber** para la definición de escenarios en lenguaje Gherkin y **REST Assured** para las interacciones HTTP. El objetivo es validar de forma automatizada y reproducible el ciclo de vida completo de una mascota: creación, consulta, actualización y eliminación (CRUD).

---

## Estructura del proyecto

```
AUTO_API_PETSTORE_SCREENPLAY/
├── build.gradle                        # Configuración de dependencias y plugins de Gradle
├── serenity.properties                 # Configuración de Serenity (nombre del proyecto)
├── gradle.properties                   # Propiedades globales de Gradle
├── settings.gradle                     # Nombre del proyecto Gradle
├── API-ENDPOINTS.md                    # Documentación de los endpoints consumidos
├── HU-001.md                           # Documentación de la historia de usuario a automatizar
└── src/
    └── test/
        ├── java/
        │   └── org/example/
        │       ├── runners/            # Suite runner (JUnit Platform + Cucumber engine)
        │       │   └── TestRunnerCrudMascotaApi.java
        │       ├── stepdefinitions/    # Definiciones de pasos: conectan Gherkin con las tareas Screenplay
        │       │   └── CrudMascotaStepDefinitions.java
        │       ├── tasks/              # Tareas Screenplay: encapsulan las interacciones con la API
        │       │   ├── CrearMascota.java
        │       │   ├── ConsultarMascota.java
        │       │   ├── ActualizarMascota.java
        │       │   └── EliminarMascota.java
        │       ├── questions/          # Preguntas Screenplay: extraen datos de las respuestas HTTP
        │       │   ├── CodigoRespuesta.java
        │       │   └── NombreMascotaEnRespuesta.java
        │       ├── models/             # Modelos de datos que representan el cuerpo de las peticiones
        │       │   └── Mascota.java
        │       ├── hooks/              # Configuración de contexto para los escenarios
        │       │   └── ConfigurarApi.java
        │       └── utils/              # Constantes compartidas (URL base, endpoints, nombre del actor)
        │           └── Constantes.java
        └── resources/
            └── features/               # Escenarios de prueba en lenguaje Gherkin
                └── gestion_mascota.feature
```

> Los reportes generados por Serenity se publican en `target/site/serenity/` tras cada ejecución.

---

## Escenarios de prueba

El archivo `gestion_mascota.feature` define un **Scenario Outline** que cubre el ciclo de vida completo de una mascota en la API PetStore:

1. **Crear** una nueva mascota con id, categoría, nombre y etiqueta.
2. **Consultar** el registro recién creado y verificar su nombre.
3. **Actualizar** la categoría, el nombre y la etiqueta de la mascota.
4. **Consultar** el registro actualizado y verificar los nuevos datos.
5. **Eliminar** la mascota del sistema.
6. **Consultar** el registro eliminado y verificar que la API devuelve un `404`.

---

## Ejecución

Este proyecto consume directamente la API pública de PetStore (`https://petstore.swagger.io/v2`), por lo que **no requiere levantar ningún servidor local** ni configuración adicional de entorno.

Para ejecutar las pruebas, basta con correr el siguiente comando en la raíz del proyecto:

```bash
gradle clean test
```

Este comando limpia compilaciones anteriores, ejecuta todos los escenarios definidos en `src/test/resources/features/` y genera automáticamente los reportes de Serenity al finalizar.

---

## Reportes

Serenity genera un reporte HTML completo con el resultado de cada escenario, el detalle de cada paso ejecutado y la trazabilidad hacia los escenarios Gherkin.

Una vez finalizada la ejecución, se puede acceder a los reportes mediante el archivo:

```
target/site/serenity/index.html
```
