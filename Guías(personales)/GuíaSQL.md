# ⚡ Clase Introductoria de SQL para Principiantes

## 🤖 ¿Qué es SQL y para qué se usa?

SQL (Structured Query Language) es el lenguaje estándar para comunicarse con bases de datos relacionales. 

💡 **Definición:** Lenguaje de programación para almacenar y procesar información en bases de datos relacionales.  

📈 **Ventaja:** Es declarativo: describes qué datos necesitas, no cómo obtenerlos.

---

## 🔧 Conceptos básicos de bases de datos relacionales

| Concepto        | Descripción                                                                                     |
|-----------------|-------------------------------------------------------------------------------------------------|
| **Tabla**       | Conjunto de datos estructurados en filas y columnas.                                            |
| **Fila / Registro** | Instancia de datos (una entrada concreta).                                                  |
| **Columna / Campo** | Atributo o categoría de datos (ej. “nombre”, “precio”).                                     |
| **Clave primaria**  | Campo (o conjunto de campos) que identifica **única** y **no nula** cada fila (`PRIMARY KEY`). |
| **Clave foránea**   | Campo que referencia la clave primaria de otra tabla, estableciendo una relación.           |

---

## 📋 Comandos básicos de consulta

```sql
SELECT columnas           -- Qué columnas obtener
FROM tabla                -- De qué tabla
WHERE condición           -- Filtrar filas
ORDER BY columna [DESC]   -- Ordenar resultados
LIMIT número              -- Límite de filas a devolver
UPDATE tabla              -- Qué tabla quieres actualizar
SET columas               -- Valores de las columnas a actualizar
GROUP BY columnas         -- Agrupa filas con base en columnas
AS alias                  -- Asigna un alias a una columna
HAVING condición          -- Filtrar resultados que utiliza GROUP BY
INNER JOIN tabla          -- Combinar filas de dos o más tablas, basándose en una columna común entre ellas
ON condición              -- Condición para unir dos o más tablas, va después de JOIN 
```
---
## 💾 Crear base de datos

```sql
CREATE DATABASE hello_mysql
```

---
## ⚙️ Crear tabla:
```sql
CREATE TABLE 'hello_mysql', 'clientes' (
    'user_id' INT NOT NULL AUTO_INCREMENT,
    'nombre' VARCHAR(50) NOT NULL,
    'apellido' VARCHAR(100) NULL,
    'edad' INT NULL,
    'ciudad' VARCHAR(50) NULL,
    'init_date' DATE NULL,
    'email' VARCHAR(100) NULL,
    PRIMARY KEY ('user_id'));
```
---
## 🔍 Consultas de ejemplo

| user_id | nombre | apellido  | edad | ciudad |init_date | email                                |
| -- | ------ | --------- | ---| ----------|------------|----------------------------- |
| 1  | Ana    | López     | 20 | Madrid    | 25-05-2020 | [ana.lopez@mail.com](mailto:ana.lopez@mail.com)     |
| 2  | Juan   | Pérez     | 23 | Valencia  | 22-04-2023 | [juanp@mail.com](mailto:juanp@mail.com)             |
| 3  | Luis   | García    | 35 | Sevilla   | 18-10-2024 | [luis.garcia@mail.com](mailto:luis.garcia@mail.com) |
| 4  | María  | Fernández | 45 | Madrid    | 1-08-2022  | [maria@mail.com](mailto:maria@mail.com)             |
| 5  | Luis   | Giménez   | 19 | Barcelona | 5-07-2025  | [lgimenez@mail.com](mailto:lgimenez@mail.com)       |



### 1. Todos los clientes:

```sql
SELECT * 
FROM clientes;
```

### 2. Nombre y ciudad de clientes en Madrid
```sql
SELECT nombre, ciudad
FROM clientes
WHERE ciudad = 'Madrid';
```

### 3. Clientes con apellido que empiece por “G”, orden descendente
```sql
SELECT nombre, ciudad
FROM clientes
WHERE apellido LIKE 'G%'
ORDER BY nombre DESC;
```

### 4. Primeros 3 clientes por id
```sql
SELECT id, nombre
FROM clientes
ORDER BY id
LIMIT 3;
```

### 5. Insertar nuevo cliente
```sql
INSERT INTO hello_mysql.clientes (nombre, apellido, edad, ciudad, init_date, email)
VALUES ('Carlos', 'Ruiz', 28, 'Málaga', '2021-11-16', 'c.ruiz@mail.com');
```
| user_id | nombre | apellido  | edad | ciudad |init_date | email                                |
| -- | ------ | --------- | ---| ----------|------------|----------------------------- |
| 1  | Ana    | López     | 20 | Madrid    | 25-05-2020 | [ana.lopez@mail.com](mailto:ana.lopez@mail.com)     |
| 2  | Juan   | Pérez     | 23 | Valencia  | 22-04-2023 | [juanp@mail.com](mailto:juanp@mail.com)             |
| 3  | Luis   | García    | 35 | Sevilla   | 18-10-2024 | [luis.garcia@mail.com](mailto:luis.garcia@mail.com) |
| 4  | María  | Fernández | 45 | Madrid    | 1-08-2022  | [maria@mail.com](mailto:maria@mail.com)             |
| 5  | Luis   | Giménez   | 19 | Barcelona | 5-07-2025  | [lgimenez@mail.com](mailto:lgimenez@mail.com)       |
| 6  | Carlos | Ruiz      | 28 | Malaga    | 16-11-2021 | [c.ruiz@mail.com](mailto:c.ruiz@mail.com)           |

### 6. Actualizar ciudad de id = 5
```sql
UPDATE clientes
SET ciudad = 'Bilbao'
WHERE id = 5;
```
### 7. Eliminar cliente id = 2
```sql
DELETE FROM clientes
WHERE id = 2;
```

---

## 🎯 Filtrado avanzado con operadores

### Operadores comunes

| Operador | Descripción                        | Ejemplo                         |
|----------|------------------------------------|---------------------------------|
| `=`      | Igual a                            | `ciudad = 'Madrid'`            |
| `!=` o `<>` | Distinto de                    | `ciudad != 'Madrid'`           |
| `>`      | Mayor que                          | `id > 3`                        |
| `<`      | Menor que                          | `id < 3`                        |
| `>=`     | Mayor o igual                      | `id >= 2`                       |
| `<=`     | Menor o igual                      | `id <= 4`                       |
| `LIKE`   | Coincidencia parcial               | `apellido LIKE 'G%'`           |
| `IN`     | Dentro de un conjunto              | `ciudad IN ('Madrid', 'Sevilla')` |
| `BETWEEN`| Dentro de un rango (inclusive)     | `id BETWEEN 2 AND 4`           |

---

## 🪜 Funciones de agregación

Las funciones de agregación trabajan sobre conjuntos de filas y devuelven un solo valor.

| Función   | Descripción                     |
|-----------|---------------------------------|
| `COUNT()` | Cuenta filas                    |
| `SUM()`   | Suma valores                    |
| `AVG()`   | Promedio                       |
| `MIN()`   | Valor mínimo                    |
| `MAX()`   | Valor máximo                    |

### Ejemplo:
```sql
SELECT COUNT(*) AS total_clientes
FROM clientes;
```

- ¿Qué hace? Cuenta todas las filas de la tabla clientes.

`COUNT(*) cuenta cuántos registros hay en total.`
`AS total_clientes le pone un alias (nombre temporal) a la columna del resultado.`

Resultado ejemplo:
| total\_clientes |
| --------------- |
| 5               |


```sql
SELECT ciudad, COUNT(*) AS clientes_por_ciudad
FROM clientes
GROUP BY ciudad;
```

- ¿Qué hace? Agrupa los registros por la columna ciudad.

Para cada ciudad, cuenta cuántos clientes hay, devuelve una tabla con:

`El nombre de cada ciudad.`
`La cantidad de clientes en esa ciudad.`
| ciudad   | clientes\_por\_ciudad |
| -------- | --------------------- |
| Madrid   | 2                     |
| Sevilla  | 1                     |
| Valencia | 2                     |

---

## 🧲 Agrupaciones con GROUP BY y filtros con HAVING

- `GROUP BY:` agrupa resultados según una o más columnas.
- `HAVING:` filtra grupos (se usa después de **GROUP BY**)

```sql
SELECT ciudad, COUNT(*) AS total
FROM clientes
GROUP BY ciudad
HAVING total > 1;
```
✅ ¿Qué hace cada parte?

| Línea                              | Explicación                                                         |
| ---------------------------------- | ------------------------------------------------------------------- |
| `SELECT ciudad, COUNT(*) AS total` | Selecciona la ciudad y la cantidad de clientes en esa ciudad.       |
| `FROM clientes`                    | Usa la tabla `clientes`.                                            |
| `GROUP BY ciudad`                  | Agrupa los registros por ciudad (una fila por ciudad).              |
| `HAVING total > 1`                 | Filtra los grupos y **solo muestra ciudades con más de 1 cliente**. |


📊 Resultado de la consulta:

| ciudad   | total |
| -------- | ----- |
| Madrid   | 2     |


---

## 🧱 Relaciones entre tablas con JOIN

- Tipos principales de `JOIN:`

| Tipo de JOIN | Descripción                                                             |
| ------------ | ----------------------------------------------------------------------- |
| `INNER JOIN` | Solo filas que coinciden en ambas tablas.                               |
| `LEFT JOIN`  | Todas las filas de la tabla izquierda + coincidencias.                  |
| `RIGHT JOIN` | Todas las filas de la tabla derecha + coincidencias.                    |
| `FULL JOIN`  | Todas las filas de ambas tablas (si está disponible en tu sistema SQL). |

- Ejemplo: Supón dos tablas 

`clientes(id, nombre)`  
`ordenes(id, cliente_id, producto)`

```sql
SELECT clientes.nombre, ordenes.producto
FROM clientes
INNER JOIN ordenes
ON clientes.id = ordenes.cliente_id;
```
📘 Explicación detallada:

| Parte del código                           | Significado                                                                                             |
| ------------------------------------------ | ------------------------------------------------------------------------------------------------------- |
| `SELECT clientes.nombre, ordenes.producto` | Selecciona las columnas que se mostrarán: el nombre del cliente y el producto que pidió.                |
| `FROM clientes`                            | Especifica la tabla principal: `clientes`.                                                              |
| `INNER JOIN ordenes`                       | Realiza una **unión interna**: solo combinará las filas donde hay coincidencias.                        |
| `ON clientes.id = ordenes.cliente_id`      | Define la condición para unir: el ID del cliente debe coincidir con el campo `cliente_id` en `ordenes`. |

🧾 Ejemplo:

Tabla `clientes:`

| id | nombre |
| -- | ------ |
| 1  | Ana    |
| 2  | Luis   |
| 3  | Marta  |

Tabla `ordenes`

| id | producto | cliente\_id |
| -- | -------- | ----------- |
| 1  | Laptop   | 1           |
| 2  | Teclado  | 2           |
| 3  | Ratón    | 1           |

📊 Resultado:

| nombre | producto |
| ------ | -------- |
| Ana    | Laptop   |
| Luis   | Teclado  |
| Ana    | Ratón    |

---