package org.example;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        // CASO PRACTICO 1
        // Lista de alumnos de ejemplo
        List<Alumno> alumnos = List.of(
                new Alumno("Ana", 9.0, "Matematica"),
                new Alumno("Juan", 6.5, "Matematica"),
                new Alumno("Lucia", 8.5, "Historia"),
                new Alumno("Pablo", 7.0, "Historia"),
                new Alumno("Maria", 9.5, "Fisica"),
                new Alumno("Diego", 5.0, "Fisica"),
                new Alumno("Sofia", 8.0, "Matematica")
        );
        System.out.println("===CASO PRACTICO 1===");
        // 1.1) Nombres de alumnos aprobados en mayúsculas y ordenados
        System.out.println("1.1) Aprobados (mayusculas y ordenados):");
        List<String> aprobados = alumnos.stream()
                .filter(a -> a.getNota() >= 7)
                .map(a -> a.getNombre().toUpperCase())
                .sorted()
                .toList();
        aprobados.forEach(System.out::println);

        // 1.2) Promedio general de notas
        double promedio = alumnos.stream()
                .mapToDouble(Alumno::getNota)
                .average()
                .orElse(0.0);
        System.out.println("\n1.2) Promedio general de notas: " + promedio);

        //  1.3️) Agrupar alumnos por curso
        Map<String, List<Alumno>> agrupadosPorCurso = alumnos.stream()
                .collect(Collectors.groupingBy(Alumno::getCurso));

        System.out.println("\n1.3) Alumnos agrupados por curso:");
        agrupadosPorCurso.forEach((curso, lista) -> {
            System.out.println(curso + ": " + lista);
        });

        // 1.4️) Los 3 mejores promedios
        List<Alumno> top3 = alumnos.stream()
                .sorted(Comparator.comparingDouble(Alumno::getNota).reversed())
                .limit(3)
                .toList();

        System.out.println("\n1.4) Top 3 mejores promedios:");
        top3.forEach(System.out::println);


        // CASO PRACTICO 2
        List<Producto> productos = List.of(
                new Producto("Notebook", "Electronica", 450.0, 10),
                new Producto("Mouse", "Electronica", 25.0, 50),
                new Producto("Teclado", "Electronica", 70.0, 30),
                new Producto("Escritorio", "Muebles", 200.0, 5),
                new Producto("Silla", "Muebles", 150.0, 8),
                new Producto("Lampara", "Iluminacion", 120.0, 20),
                new Producto("Foco LED", "Iluminacion", 40.0, 100)
        );
        System.out.println("\n\n===CASO PRACTICO 2===");
        // 2.1) Productos con precio > 100, ordenados por precio descendente
        List<Producto> caros = productos.stream()
                .filter(p -> p.getPrecio() > 100)
                .sorted(Comparator.comparingDouble(Producto::getPrecio).reversed())
                .toList();

        System.out.println("2.1) Productos con precio mayor a 100 (orden descendente):");
        caros.forEach(System.out::println);
        System.out.println();

        // 2.2) Agrupar productos por categoría y calcular el stock total
        Map<String, Integer> stockPorCategoria = productos.stream()
                .collect(Collectors.groupingBy(
                        Producto::getCategoria,
                        Collectors.summingInt(Producto::getStock)
                ));

        System.out.println("2.2) Stock total por categoria:");
        stockPorCategoria.forEach((categoria, totalStock) ->
                System.out.println(categoria + ": " + totalStock)
        );
        System.out.println();

        // 2.3) Generar un String con nombre y precio separados por ";"
        String listado = productos.stream()
                .map(p -> p.getNombre() + " - $" + p.getPrecio())
                .collect(Collectors.joining(", "));

        System.out.println("2.3) Listado de productos (nombre y precio):");
        System.out.println(listado);
        System.out.println();

        // 2.4) Calcular precio promedio general
        double promedioGeneral = productos.stream()
                .mapToDouble(Producto::getPrecio)
                .average()
                .orElse(0.0);

        System.out.println("2.4) Precio promedio general: $" + promedioGeneral);

        // 2.4) Precio promedio por categoría
        Map<String, Double> promedioPorCategoria = productos.stream()
                .collect(Collectors.groupingBy(
                        Producto::getCategoria,
                        Collectors.averagingDouble(Producto::getPrecio)
                ));

        System.out.println("2.4) Precio promedio por categoria:");
        promedioPorCategoria.forEach((categoria, promedioProductos) ->
                System.out.println(categoria + ": $" + promedio)
        );

        // CASO PRACTICO 3
        List<Libro> libros = List.of(
                new Libro("El Quijote", "Cervantes", 863, 45.0),
                new Libro("Cien Anios de Soledad", "Garcia Marquez", 471, 50.0),
                new Libro("Cronica de una Muerte Anunciada", "Garcia Marquez", 128, 25.0),
                new Libro("Rayuela", "Cortazar", 600, 42.0),
                new Libro("Ficciones", "Borges", 224, 35.0),
                new Libro("El Aleph", "Borges", 146, 30.0),
                new Libro("La Ciudad y los Perros", "Vargas Llosa", 350, 40.0)
        );
        System.out.println("\n\n===CASO PRACTICO 3===");
        // 3.1) Títulos de libros con más de 300 páginas, ordenados alfabéticamente
        List<String> titulosLargos = libros.stream()
                .filter(l -> l.getPaginas() > 300)
                .map(Libro::getTitulo)
                .sorted()
                .toList();

        System.out.println("3.1) Libros con mas de 300 paginas (ordenados alfabeticamente):");
        titulosLargos.forEach(System.out::println);
        System.out.println();

        // 3.2) Promedio de páginas de todos los libros
        double promedioPaginas = libros.stream()
                .mapToInt(Libro::getPaginas)
                .average()
                .orElse(0.0);

        System.out.println("3.2) Promedio de paginas: " + promedioPaginas);
        System.out.println();

        // 3.3) Agrupar libros por autor y contar cuántos libros tiene cada uno
        Map<String, Long> librosPorAutor = libros.stream()
                .collect(Collectors.groupingBy(
                        Libro::getAutor,
                        Collectors.counting()
                ));

        System.out.println("3.3) Cantidad de libros por autor:");
        librosPorAutor.forEach((autor, cantidad) ->
                System.out.println(autor + ": " + cantidad)
        );
        System.out.println();

        // 3.4) Obtener el libro más caro
        libros.stream()
                .max(Comparator.comparingDouble(Libro::getPrecio))
                .ifPresent(l -> System.out.println("3.4) Libro mas caro: " + l));

        // CASO PRACTICO 4
        List<Empleado> empleados = List.of(
                new Empleado("Ana", "Recursos Humanos", 2500.0, 35),
                new Empleado("Juan", "Sistemas", 3200.0, 29),
                new Empleado("Luca", "Sistemas", 1800.0, 26),
                new Empleado("Carlos", "Ventas", 2100.0, 41),
                new Empleado("Mara", "Ventas", 2700.0, 30),
                new Empleado("Pablo", "Contabilidad", 1950.0, 45),
                new Empleado("Sofia", "Contabilidad", 3100.0, 27)
        );
        System.out.println("\n\n===CASO PRACTICO 4===");

        // 4.1) Empleados con salario > 2000, ordenados por salario descendente
        List<Empleado> mejorPagados = empleados.stream()
                .filter(e -> e.getSalario() > 2000)
                .sorted(Comparator.comparingDouble(Empleado::getSalario).reversed())
                .toList();

        System.out.println("4.1) Empleados con salario mayor a 2000 (orden descendente):");
        mejorPagados.forEach(System.out::println);
        System.out.println();

        // 4.2) Salario promedio general
        double promedioSalario = empleados.stream()
                .mapToDouble(Empleado::getSalario)
                .average()
                .orElse(0.0);

        System.out.println("4.2) Salario promedio general: $" + promedioSalario);
        System.out.println();

        // 4.3) Agrupar por departamento y calcular suma de salarios
        Map<String, Double> salarioPorDepartamento = empleados.stream()
                .collect(Collectors.groupingBy(
                        Empleado::getDepartamento,
                        Collectors.summingDouble(Empleado::getSalario)
                ));

        System.out.println("4.3) Suma de salarios por departamento:");
        salarioPorDepartamento.forEach((depto, suma) ->
                System.out.println(depto + ": $" + suma)
        );
        System.out.println();

        // 4.4) Nombres de los 2 empleados más jóvenes
        List<String> jovenes = empleados.stream()
                .sorted(Comparator.comparingInt(Empleado::getEdad))
                .limit(2)
                .map(Empleado::getNombre)
                .toList();

        System.out.println("4.4) Los 2 empleados más jovenes:");
        jovenes.forEach(System.out::println);

    }
}
