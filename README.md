# didactic-carnival
Obligatorio Programación 1

El objetivo del siguiente Java es emular la base de datos de un hospital e implementar el programa en UML.

Se guiará al usuario a través de un menú interactivo en una Terminal.

Cómo ejecutar el principal:

-Posicionarse dentro de Carpeta/

-Ingresar:

            javac uy/edu/um/fium/prog1/oblig/Principal.java 

-Ingresar:

            java uy.edu.um.fium.prog1.oblig.Principal

El programa debería comezar.

Restricciones a tener en cuenta:

Cuando se ingrese una especialidad para un empleado del tipo Médico, dispone de las siguientes opciones, con acentos:

-Pediatría
-Cardiología
-Ginecología
-Clínica
-Cirugía
-Anestesiología
-Gastroenterología
-Neurología

Luego, para ingresar fechas, se requiere que el año sea ingresado con cuatro dígitos, mientras que el día y el mes pueden ser ingresados o con 2 o con 1 dígito.
Ejemplos válidos:             Ejemplos no válidos.

-01/01/1998                   -01/01/98     
-4/3/1998                     -4/3/998
-04/5/1768
-6/09/2013


Se intentó utilizar varias máscaras para que el año pudiese expresarse con sólo las dos últimas cifras, pero no se pudo implementar pues se creaba el año 20XX, que no
representaba la realidad.

Adicionalmente, si se quiere agilizar la prueba, en el comienzo de Principal.java, se incluyen los 5 empleados dados a probar comentados. Descomentar y listo.

Se adjuntan fotos mostrando la terminal corriendo el código de manera exitosa.
Fue una versión levemente anterior. Se cometió un error al agregar los estudios de Susana Huguet (se puso 1 en vez de y, lo que lleva a que aparezca que no haya realizado ningún estudio). También se editó para que aparezca correctamente el enunciado de qué empleados cumplen qué día (Se había utilizado una variable que contenía información temporal para posibilitar el algoritmo y mejor reflejar la realidad). 
