# Ejercicio LinkedList
## Descripción
Este proyecto contiene una clase `EjercicioLinkedList` que implementa varios métodos para manipular listas enlazadas (LinkedList) en Java. Los métodos implementados son:
1. **Eliminar Duplicados**: Un método que recibe una `LinkedList<Integer>` y elimina los valores duplicados, dejando solo la primera aparición de cada número.
2. **Invertir Lista**: Un método que invierte los elementos de una `LinkedList<String>` sin utilizar otra lista o `ArrayList`.
3. **Intercalar Listas**: Un método que toma dos listas enlazadas ordenadas de enteros y devuelve una nueva `LinkedList<Integer>` con los elementos de ambas listas intercalados en orden.
## Proceso de Prueba
Se han implementado pruebas unitarias utilizando JUnit para validar el correcto funcionamiento de los métodos de la clase `EjercicioLinkedList`. Las pruebas incluyen:
- **testEliminarDuplicados**: Verifica que el método `eliminarDuplicados` funcione correctamente.
- **testInvertirLista**: Asegura que el método `invertirLista` invierta correctamente los elementos de la lista.
- **testIntercalarListas**: Comprueba el método `intercalarListas`. Este test está diseñado para fallar intencionadamente para demostrar la funcionalidad de las pruebas.
