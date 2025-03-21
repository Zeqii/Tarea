package umg.edu.progra.listas;
/**
 *
 * @author Walter Cordova
 */
public class Lista {
    private Nodo primero;
    @Override
    public String toString() {
        return "=>" + primero;
    }
    /**
     * Constructor para inicializar una lista
     */
    public Lista() {
        primero = null;
    }
    /**
     * Devuelve el nodo inicial
     *
     * @return
     */
    public Nodo leerPrimero() {
        return primero;
    }
    /**
     * Inserta valores a la lista
     *
     * @param entrada
     */
    public void insertarCabezaLista(int entrada) {
        Nodo nuevo;
        nuevo = new Nodo(entrada);
        nuevo.enlace = primero;
        primero = nuevo;
    }
    /**
     * inserta un elemento a partir de anterior
     *
     * @param anterior
     * @param entrada
     */
    public void insertarLista(Nodo anterior, int entrada) {
        Nodo nuevo;
        nuevo = new Nodo(entrada);
        nuevo.enlace = anterior.enlace;
        anterior.enlace = nuevo;
    }
    /**
     * elimina el elemento entrada
     *
     * @param entrada
     */
    public void eliminar(int entrada) {
        Nodo actual, anterior;
        boolean encontrado;
        actual = primero;
        anterior = null;
        encontrado = false;
        // Bucle de búsqueda
        while ((actual != null) && !(actual.dato == entrada)) {
            if (!(actual.dato == entrada)) {
                anterior = actual;
                actual = actual.enlace;
            }
        }
        if (actual != null) {

            if (actual == primero) {
                primero = actual.enlace;
            } else {
                anterior.enlace = actual.enlace;
            }
            actual = null;
        }
    }
    /**
     * busca el elemento destino
     *
     * @param destino
     * @return
     */
    public Nodo buscarLista(int destino) {
        Nodo indice;
        for (indice = primero; indice != null; indice = indice.enlace) {
            if (indice.dato == destino) {
                return indice;
            }
        }
        return null;
    }
    /**
     * recorre la lista y muestra cada dato
     */
    public void visualizar() {
        Nodo n;
        n = primero;
        while (n != null) {
            System.out.print(n.dato + " ");
            n = n.enlace;
        }
        System.out.println();
    }
    /**
     * 1 - Método para invertir la lista enlazada
     */
    public void invertirLista() {
        Nodo actual = primero;
        Nodo anterior = null;
        Nodo siguiente = null;
        while (actual != null) {
            siguiente = actual.enlace;
            actual.enlace = anterior;
            anterior = actual; 
            actual = siguiente; 
        }
        primero = anterior; 
    }
    /**
     * 2 - Método para obtener el elemento en la posición n desde el final
     */
    public Integer obtenerDesdeElFinal(int n) {
        Nodo actual = primero;
        Nodo puntero = primero;

        for (int i = 0; i < n; i++) {
            if (puntero == null) return null; 
            puntero = puntero.enlace;
        }

        while (puntero != null) {
            actual = actual.enlace;
            puntero = puntero.enlace;
        }
        return actual != null ? actual.dato : null;
    }
    /**
     * 3 - Método para eliminar duplicados en una lista enlazada
     */
    public void eliminarDuplicados() {
        Nodo actual = primero;
        while (actual != null) {
            Nodo siguiente = actual;
            while (siguiente.enlace != null) {
                if (siguiente.enlace.dato == actual.dato) {
                    siguiente.enlace = siguiente.enlace.enlace; 
                } else {
                    siguiente = siguiente.enlace;
                }
            }
            actual = actual.enlace;
        }
    }
    /**
     * 4 - Método para obtener el tamaño de la lista enlazada
     */
    public int obtenerTamano() {
        int tamano = 0;
        Nodo actual = primero;
        while (actual != null) {
            tamano++;
            actual = actual.enlace;
        }
        return tamano;
    }
}