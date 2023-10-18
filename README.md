# Proyecto2Programacion

Repositorio de GitHub para el proyecto de programación.

## Descripción del Proyecto

Este proyecto, desarrollado en el contexto de un curso de programación, utiliza conceptos de Programación Orientada a Objetos (POO) para emular el funcionamiento de una aplicación de citas. El objetivo es simular las interacciones y la gestión de usuarios en una plataforma de citas.

## Clases Principales

### Clase Usuario

La clase `Usuario` cumple una función central en el proyecto. En ella se implementan las lógicas de búsqueda y comparación entre los distintos usuarios. Además, esta clase contiene un atributo de clase `String[][]` en el que se definen todos los posibles intereses que los usuarios pueden tener. Esto facilita la inserción de nuevos intereses o la modificación de los existentes. 

### Clase menuPredeterminado

La clase `menuPredeterminado` se encarga de la interacción con el usuario a través de un menú de opciones. Estas opciones permiten a los usuarios realizar diferentes acciones, como buscar perfiles compatibles o modificar sus propios intereses. Esta clase implementa las llamadas a los métodos de la clase `Usuario` según las opciones seleccionadas por el usuario.

## Estructura del Proyecto

El proyecto está organizado en dos paquetes principales: `proyectoGestion` y `proyectoModelo`. Cada uno de estos paquetes contiene clases relacionadas con la gestión y el modelo de la aplicación, respectivamente.

## Clase Util

Además de las clases mencionadas anteriormente, el proyecto incluye una clase auxiliar llamada `Util`. Esta clase se utiliza para agrupar herramientas auxiliares que han sido útiles para agilizar la escritura del código y reducir redundancias. Por ejemplo, la clase `Util` contiene un método llamado `pedirString` que incluye un bloque Try-Catch y una expresión regular para evitar la entrada de espacios en blanco o números no deseados.

## Desafío Pendiente

En el componente `menuPredeterminado`, existe un desafío pendiente por resolver. Actualmente, al seleccionar la búsqueda por filtros, se obtienen usuarios que cumplen con los criterios de búsqueda, pero pueden no ser compatibles en términos de género u orientación sexual. El proyecto busca abordar este desafío y garantizar que los usuarios filtrados sean compatibles con el usuario que realiza la búsqueda.

Agradecemos tu interés en nuestro proyecto y esperamos que esta simulación de una aplicación de citas basada en POO sea de utilidad y aprendizaje. Si tienes sugerencias o preguntas, no dudes en contactarnos.
