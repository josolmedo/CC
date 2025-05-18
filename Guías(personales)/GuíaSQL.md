# Clase Introductoria de SQL para Principiantes

## 1. ¿Qué es SQL y para qué se usa?

SQL (Structured Query Language) es el lenguaje estándar para comunicarse con bases de datos relacionales.  
- **Definición:** Lenguaje de programación para almacenar y procesar información en bases de datos relacionales.  
- **Uso principal:**  
  - **SELECT:** consultar datos.  
  - **INSERT:** añadir nuevos registros.  
  - **UPDATE:** modificar registros existentes.  
  - **DELETE:** eliminar registros.  
- **Ventaja:** Es declarativo: describes qué datos necesitas, no cómo obtenerlos.

---

## 2. Conceptos básicos de bases de datos relacionales

| Concepto        | Descripción                                                                                     |
|-----------------|-------------------------------------------------------------------------------------------------|
| **Tabla**       | Conjunto de datos estructurados en filas y columnas.                                            |
| **Fila / Registro** | Instancia de datos (una entrada concreta).                                                  |
| **Columna / Campo** | Atributo o categoría de datos (ej. “nombre”, “precio”).                                     |
| **Clave primaria**  | Campo (o conjunto de campos) que identifica **única** y **no nula** cada fila (`PRIMARY KEY`). |
| **Clave foránea**   | Campo que referencia la clave primaria de otra tabla, estableciendo una relación.           |

---

## 3. Comandos básicos de consulta

```sql
SELECT columnas        -- Qué columnas obtener
FROM tabla             -- De qué tabla
WHERE condición        -- Filtrar filas
ORDER BY columna [DESC]-- Ordenar resultados
LIMIT número           -- Límite de filas a devolver


```

## 4. Crear tabla:
```sql
CREATE TABLE 'hello_mysql', 'users' (
    'user_id' INT NOT NULL AUTO_INCREMENT,
    'name' VARCHAR(50) NOT NULL,
    'surname' VARCHAR(100) NULL,
    'age' INT NULL,
    'init_date' DATE NULL,
    'email' VARCHAR(100) NULL,
    PRIMARY KEY ('user_id'));
```