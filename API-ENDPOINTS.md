# Endpoints — PetStore API

**Base URL:** `https://petstore.swagger.io/v2`  
**Content-Type:** `application/json`

---

## 1. Creación de Mascota

| Campo       | Valor             |
|-------------|-------------------|
| **Método**  | `POST`            |
| **URL**     | `/pet`            |
| **Descripción** | Añadir una nueva mascota al sistema |

### Request Body

```json
{
  "id": 655,
  "category": {
    "id": 0,
    "name": "nombreCategoría"
  },
  "name": "nombreMascota",
  "photoUrls": [
    "string"
  ],
  "tags": [
    {
      "id": 0,
      "name": "nombreEtiqueta"
    }
  ],
  "status": "available"
}
```

### Respuestas

| Código | Descripción                                    |
|--------|------------------------------------------------|
| `200`  | OK — devuelve el mismo JSON enviado en la solicitud |
| `405`  | Invalid Input                                  |

---

## 2. Consultar Registro de Mascota

| Campo       | Valor             |
|-------------|-------------------|
| **Método**  | `GET`             |
| **URL**     | `/pet/{petId}`    |
| **Descripción** | Consulta del registro de una mascota |

### Parámetros de ruta

| Parámetro | Tipo      | Descripción        |
|-----------|-----------|--------------------|
| `petId`   | `integer` | ID de la mascota   |

### Respuestas

| Código | Descripción                                           |
|--------|-------------------------------------------------------|
| `200`  | Successful operation — JSON con la información de la mascota |
| `404`  | Pet not found                                         |

---

## 3. Actualizar Registro de Mascota

| Campo       | Valor             |
|-------------|-------------------|
| **Método**  | `PUT`             |
| **URL**     | `/pet`            |
| **Descripción** | Actualizar un registro de mascota existente |

### Request Body

```json
{
  "id": 655,
  "category": {
    "id": 0,
    "name": "categoriaActualizada"
  },
  "name": "nombreActualizado",
  "photoUrls": [
    "string"
  ],
  "tags": [
    {
      "id": 0,
      "name": "etiquetaActualizada"
    }
  ],
  "status": "available"
}
```

### Respuestas

| Código | Descripción                                          |
|--------|------------------------------------------------------|
| `200`  | OK — JSON con la información actualizada de la mascota |
| `400`  | Invalid ID supplied                                  |
| `404`  | Pet not found                                        |
| `405`  | Validation exception                                 |

---

## 4. Eliminar Registro de Mascota

| Campo       | Valor             |
|-------------|-------------------|
| **Método**  | `DELETE`          |
| **URL**     | `/pet/{petId}`    |
| **Descripción** | Eliminar un registro de mascota del sistema |

### Parámetros de ruta

| Parámetro | Tipo      | Descripción                        |
|-----------|-----------|------------------------------------|
| `petId`   | `integer` | ID de la mascota a eliminar        |
| `api_key` | `string`  | Clave de autenticación (opcional)  |

### Respuesta exitosa `200`

```json
{
  "code": 200,
  "type": "unknown",
  "message": "idDelRegistroEliminado"
}
```

### Respuestas

| Código | Descripción          |
|--------|----------------------|
| `200`  | OK — JSON con código, tipo y mensaje del ID eliminado |
| `400`  | Invalid ID supplied  |
| `404`  | Pet not found        |
