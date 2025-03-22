package umg.edu.gt.test.EjercicioLinkedList;
import java.util.LinkedList;
import java.util.Iterator;
/**
 * Clase que contiene métodos para manipular listas enlazadas (LinkedList).
 */
public class EjercicioLinkedList {
    /**
     * Elimina los valores duplicados de una LinkedList<Integer>, dejando solo la primera aparición de cada número.
     *
     * @param lista la LinkedList de enteros con posibles duplicados
     * @return una nueva LinkedList<Integer> sin duplicados
     */
    public LinkedList<Integer> eliminarDuplicados(LinkedList<Integer> lista) {
        LinkedList<Integer> listaSinDuplicados = new LinkedList<>();
        for (Integer numero : lista) {
            if (!listaSinDuplicados.contains(numero)) {
                listaSinDuplicados.add(numero);
            }
        }
        return listaSinDuplicados;
    }
    /**
     * Invierte los elementos de una LinkedList<String> sin usar otra lista o ArrayList.
     *
     * @param lista la LinkedList de cadenas a invertir
     */
    public void invertirLista(LinkedList<String> lista) {
        int size = lista.size();
        for (int i = 0; i < size / 2; i++) {
            String temp = lista.get(i);
            lista.set(i, lista.get(size - 1 - i));
            lista.set(size - 1 - i, temp);
        }
    }
    /**
     * Intercala dos listas enlazadas ordenadas de enteros en una nueva LinkedList<Integer>.
     *
     * @param lista1 la primera LinkedList<Integer>
     * @param lista2 la segunda LinkedList<Integer>
     * @return una nueva LinkedList<Integer> con los elementos de ambas listas intercalados
     */
    public LinkedList<Integer> intercalarListas(LinkedList<Integer> lista1, LinkedList<Integer> lista2) {
        LinkedList<Integer> listaIntercalada = new LinkedList<>();
        Iterator<Integer> iter1 = lista1.iterator();
        Iterator<Integer> iter2 = lista2.iterator();
        
        while (iter1.hasNext() || iter2.hasNext()) {
            if (iter1.hasNext()) {
                listaIntercalada.add(iter1.next());
            }
            if (iter2.hasNext()) {
                listaIntercalada.add(iter2.next());
            }
        }
        
        return listaIntercalada;
    }
}