#language: es
Feature: Registro, Actualización, Comprobación y Eliminación de una Mascota

  Scenario Outline: Ciclo de vida completo de una mascota en la API PetStore
    Given que el usuario se prepara para gestionar mascotas en la API PetStore
    When el usuario registra una nueva mascota con id "<idMascota>", categoría "<categoria>", nombre "<nombreMascota>" y etiqueta "<etiqueta>"
    And realiza una nueva consulta al sistema con el id "<idMascota>" de la mascota creada
    Then el usuario comprueba que la mascota "<nombreMascota>" ha sido creada en el sistema
    When el usuario modifica la mascota con id "<idMascota>" actualizando la categoría a "<categoriaActualizada>", el nombre a "<nombreMascotaActualizada>" y la etiqueta a "<etiquetaActualizada>"
    And realiza una nueva consulta al sistema con el id "<idMascota>" de la mascota modificada
    Then el usuario comprueba que la mascota ha sido modificada con el nombre "<nombreMascotaActualizada>" correctamente en el sistema
    When el usuario elimina el registro de la mascota con id "<idMascota>" del sistema
    And realiza una nueva consulta al sistema con el id "<idMascota>" de la mascota eliminada
    Then el sistema devuelve una respuesta 404 debido a que el registro ha sido eliminado correctamente

    Ejemplos:
      | idMascota | categoria | nombreMascota | etiqueta  | categoriaActualizada | nombreMascotaActualizada | etiquetaActualizada |
      | 655       | Felinos   | Mittens       | Doméstico | Felinos Exóticos     | Mittens Updated          | Adoptado            |
      | 656       | Caninos   | Rex           | Callejero | Caninos Grandes      | Rex Updated              | Rescatado           |

