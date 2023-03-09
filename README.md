# proyecto2Programacion

                                                 Repositorio de GitHub para el proyecto de programación.

Este código pretende, mediante el uso de la POO, emular el funcionamiento de una app de citas.

Para ello hemos creado dos clases: Usuario y menuPredeterminado.

La clase Usuario, por una parte, reúne las lógicas de búsqueda y comparación entre los distintos usuarios. 
Por otro lado, tiene definida un String [][] static como atributo de clase, en la cual definimos todos
los posibles intereses que puedan tener estos. Así, también agiliza la inserción de nuevos intereses
o modificaciones sobre estos mismos.

La clase menuPredeterminado es donde se implementan las llamadas a los métodos de la clase Usuario
mediante las opciones que vaya marcando el usuario. 

El proyecto esta dividido en dos paquetes proyectoGestion/proyectoModelo. Las dos tienen
una clase anexa que es Util, desde donde llamamos a las herramientas auxiliares para
que nos han servido tanto como para agilizar la escritura  del código, como para reducir redundancias. 

Ejemplo de esto sería las llamadas al método Util.pedirString que aparte de contener un bloque TryCatch
tiene una condición de expresión regular que no permiten la entrada de espacios en blanco o la inserción de números.

