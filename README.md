# Caso práctico #14 - Unidad 2

**Materia:** Estructuras de Datos  
**Lenguaje:** Java

## Descripción

Programa para registrar los boletos vendidos de un autobús y controlar la subida de pasajeros según su orden de llegada. Al final, permite consultar quiénes abordaron y quiénes faltan.

## Estructuras de datos

Se utiliza una **cola FIFO** para que el primer pasajero en llegar sea el primero en subir. También se utiliza una **lista enlazada** para guardar los boletos vendidos. No se usan arreglos para almacenar pasajeros.

## Funciones principales

- Registrar boletos con nombre y número de asiento.
- Registrar la llegada de pasajeros a la fila.
- Consultar la fila y los boletos vendidos.
- Subir pasajeros respetando el orden de llegada.
- Generar un checklist con los estados **PRESENTE**, **EN FILA** y **AUSENTE**.

## Archivos del programa

- `Main.java`: menú principal.
- `Pasajero.java`: información de cada pasajero.
- `Nodo.java`: conexión entre elementos.
- `ColaPasajeros.java`: controla el orden de la fila.
- `ListaBoletos.java`: guarda los boletos vendidos.
- `RegistroAutobus.java`: administra las operaciones y el checklist.

## Cómo ejecutar

Abrir el proyecto en **Visual Studio Code** y ejecutar `Main.java` con Java instalado. También se puede usar la terminal desde la carpeta principal:

```bash
javac -encoding UTF-8 -d out src/*.java
java -cp out Main
```

## Uso del programa

1. Registra los boletos vendidos con la opción **1** (nombre y asiento).
2. Registra las llegadas con la opción **2**, en el orden en que se forman los pasajeros.
3. Consulta la fila con la opción **3**.
4. Utiliza la opción **4** para abordar de uno en uno o la **7** para abordar a todos los que esperan.
5. Consulta la inspección final con la opción **6** para verificar quiénes están presentes, en fila o ausentes.

La opción **5** muestra los boletos vendidos y la **0** cierra el programa.
