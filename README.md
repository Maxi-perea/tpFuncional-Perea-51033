# 🧠 Programación Funcional en Java — Casos Prácticos con Streams

Este proyecto contiene **4 ejercicios prácticos** diseñados para aplicar los conceptos de **Streams**, **expresiones lambda** y **Collectors** en Java.  
Cada caso aborda un escenario diferente, demostrando cómo reemplazar código imperativo por un enfoque **declarativo, claro y eficiente**.

---

## 🚀 Ejecución del Proyecto

### 🛠️ Requisitos
- **Java 8 o superior** (`java -version`)
- IDE recomendado: **IntelliJ IDEA**, **Eclipse**, **NetBeans** o **VS Code con extensión Java**
- Alternativamente, se puede ejecutar desde consola.

### ▶️ Cómo ejecutar
1. Clonar o descargar el repositorio.  
2. Abrir el proyecto en tu IDE o terminal.  
3. Compilar las clases:
   ```bash
   javac *.java

## 📘 Descripción de los Casos Prácticos

### 🧩 Caso 1: Estudiantes
**Clase:** `Estudiante(nombre, carrera, promedio, edad)`

**Objetivos:**
1. Obtener la lista de estudiantes con promedio mayor a 8, ordenados por promedio descendente.  
2. Agrupar los estudiantes por carrera y calcular el promedio general de cada grupo.  
3. Obtener el estudiante con el promedio más alto.  
4. Generar una lista con los nombres de los estudiantes en mayúsculas.  

**Conclusiones esperadas:**
- Aplicar operaciones de filtrado, ordenamiento y agrupamiento.  
- Usar `Collectors` para cálculos estadísticos.  
- Practicar el uso de lambdas y Streams para manipular colecciones.


---

### 🛒 Caso 2: Productos
**Clase:** `Producto(nombre, categoria, precio, stock)`

**Objetivos:**
1. Listar los productos con precio mayor a 100, ordenados por precio descendente.  
2. Agrupar productos por categoría y calcular el stock total.  
3. Generar un `String` separando con “;” cada producto que contenga nombre y precio, usando `map + collect(joining)`.  
4. Calcular el precio promedio general y por categoría.  

**Conclusiones esperadas:**
- Aplicar programación funcional en un contexto real.  
- Generar reportes y estadísticas con Streams.  
- Consolidar el uso de lambdas, collectors y manipulación funcional de listas.


---

### 📚 Caso 3: Libros
**Clase:** `Libro(titulo, autor, paginas, precio)`

**Objetivos:**
1. Listar los títulos de los libros con más de 300 páginas, ordenados alfabéticamente.  
2. Calcular el promedio de páginas de todos los libros.  
3. Agrupar los libros por autor y contar cuántos libros tiene cada uno.  
4. Obtener el libro más caro de la lista.  

**Conclusiones esperadas:**
- Practicar operaciones de `filter`, `map`, `sorted` y `collect`.  
- Manejar promedios y máximos con Streams.  
- Entender la agrupación con `Collectors.groupingBy()` y `counting()`.


---

### 👔 Caso 4: Empleados
**Clase:** `Empleado(nombre, departamento, salario, edad)`

**Objetivos:**
1. Obtener la lista de empleados cuyo salario sea mayor a 2000, ordenados por salario descendente.  
2. Calcular el salario promedio general.  
3. Agrupar los empleados por departamento y calcular la suma de salarios de cada uno.  
4. Obtener los nombres de los 2 empleados más jóvenes.  

**Conclusiones esperadas:**
- Aplicar operaciones de filtro, ordenamiento y límite.  
- Calcular promedios y sumatorias con collectors.  
- Practicar `groupingBy` con collectors anidados como `summingDouble`.  

