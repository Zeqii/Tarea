class Nodo {
    constructor(dato, enlace = null) {
        this.dato = dato;
        this.enlace = enlace;
    }
    toString() {
        return `${this.dato} => ${this.enlace}`;
    }
    leerDato() {
        return this.dato;
    }
    siguiente() {
        return this.enlace;
    }
}
class Lista {
    constructor() {
        this.primero = null;
    }
    leerPrimero() {
        return this.primero;
    }
    // Inserta un nuevo nodo al inicio de la lista
    insertarCabezaLista(entrada) {
        const nuevo = new Nodo(entrada, this.primero);
        this.primero = nuevo;
    }
    // Inserta un nuevo nodo después de un nodo existente
    insertarLista(anterior, entrada) {
        const nuevo = new Nodo(entrada, anterior.enlace);
        anterior.enlace = nuevo;
    }
    // Elimina un nodo que contiene el dato especificado
    eliminar(entrada) {
        let actual = this.primero;
        let anterior = null;
        while (actual !== null && actual.dato !== entrada) {
            anterior = actual;
            actual = actual.enlace;
        }
        if (actual !== null) {
            if (actual === this.primero) {
                this.primero = actual.enlace;
            } else {
                anterior.enlace = actual.enlace;
            }
        }
    }
    // Busca un nodo que contiene el dato especificado
    buscarLista(destino) {
        let indice = this.primero;
        while (indice !== null) {
            if (indice.dato === destino) {
                return indice;
            }
            indice = indice.enlace;
        }
        return null;
    }
    // Visualiza todos los elementos de la lista
    visualizar() {
        let n = this.primero;
        const elementos = [];
        while (n !== null) {
            elementos.push(n.dato);
            n = n.enlace;
        }
        console.log(elementos.join(' '));
    }
    // Representación de la lista como cadena
    toString() {
        return `=> ${this.primero}`;
    }
    // Método para invertir la lista enlazada
    invertir() {
        let anterior = null;
        let actual = this.primero;
        let siguiente = null;
        while (actual !== null) {
            siguiente = actual.enlace; // Guardar el siguiente nodo
            actual.enlace = anterior; // Invertir el enlace
            anterior = actual; // Mover el anterior un paso hacia adelante
            actual = siguiente; // Mover el actual un paso hacia adelante
        }
        this.primero = anterior; // Actualizar la cabeza de la lista
    }
    // Método para eliminar duplicados de la lista
    eliminarDuplicados() {
        let actual = this.primero;
        const valores = new Set();
        let anterior = null;
        while (actual !== null) {
            if (valores.has(actual.dato)) {
                anterior.enlace = actual.enlace; // Eliminar el nodo duplicado
            } else {
                valores.add(actual.dato); // Agregar el valor al conjunto
                anterior = actual; // Mover el anterior un paso hacia adelante
            }
            actual = actual.enlace; // Mover el actual un paso hacia adelante
        }
    }
    // Método para obtener el n-ésimo elemento desde el final
    obtenerDesdeElFinal(n) {
        let total = 0;
        let actual = this.primero;
        // Primero, contar el número de nodos
        while (actual !== null) {
            total++;
            actual = actual.enlace;
        }
        if (n > total) return null; // Si n es mayor que el tamaño de la lista
        actual = this.primero;
        for (let i = 1; i < total - n + 1; i++) {
            actual = actual.enlace; // Avanzar hasta el n-ésimo desde el final
        }
        return actual; // Retornar el n-ésimo nodo desde el final
    }
}
// Ejemplo de uso
const lista = new Lista();
lista.insertarCabezaLista(3);
lista.insertarCabezaLista(2);
lista.insertarCabezaLista(1);
lista.insertarCabezaLista(2); // Duplicado
lista.insertarCabezaLista(3); // Duplicado
console.log("Lista inicial:");
lista.visualizar();
lista.eliminarDuplicados();
console.log("\nDespués de eliminar duplicados:");
lista.visualizar();
const nodo2 = lista.buscarLista(2);
if (nodo2) {
    lista.insertarLista(nodo2, 5);
}
console.log("\nDespués de insertar 5 después del 2:");
lista.visualizar();
lista.invertir();
console.log("\nDespués de invertir la lista:");
lista.visualizar();
const nDesdeElFinal = 2;
const nodoDesdeElFinal = lista.obtenerDesdeElFinal(nDesdeElFinal);
console.log(`\nEl ${nDesdeElFinal}-ésimo elemento desde el final es: ${nodoDesdeElFinal ? nodoDesdeElFinal.dato : 'null'}`);
lista.eliminar(5);
console.log("\nDespués de eliminar el 5:");
lista.visualizar();
lista.eliminar(1);
console.log("\nDespués de eliminar la cabeza (1):");
lista.visualizar();
console.log("\nRepresentación toString:");
console.log(lista.toString());