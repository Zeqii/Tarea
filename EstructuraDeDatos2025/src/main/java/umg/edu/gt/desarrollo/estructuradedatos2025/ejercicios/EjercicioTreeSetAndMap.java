package umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;
class Evento implements Comparable<Evento> {
    LocalDateTime fecha;
    String nombre;
    String ubicacion;
    public Evento(LocalDateTime fecha, String nombre, String ubicacion) {
        this.fecha = fecha;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }
    @Override
    public int compareTo(Evento otro) {
        return this.fecha.compareTo(otro.fecha);
    }
    @Override
    public String toString() {
        return nombre + ", " + fecha + ", " + ubicacion;
    }
}
public class EjercicioTreeSetAndMap {
    private TreeMap<Integer, String> versiones;
    private TreeSet<Evento> eventos;
    private int contadorVersion;
    public EjercicioTreeSetAndMap() {
        versiones = new TreeMap<>();
        eventos = new TreeSet<>();
        contadorVersion = 1;
    }
    // Ejercicio 1: Análisis de Frecuencia de Palabras
    public void contarFrecuenciaPalabras(String archivo) {
        TreeMap<String, Integer> frecuenciaPalabras = new TreeMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] palabras = linea.toLowerCase().replaceAll("[^a-záéíóúñ ]", "").split("\\s+");
                for (String palabra : palabras) {
                    if (!palabra.isEmpty()) {
                        frecuenciaPalabras.put(palabra, frecuenciaPalabras.getOrDefault(palabra, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Map.Entry<String, Integer> entry : frecuenciaPalabras.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    // Ejercicio 2: Rastreador de Versiones de Código
    public void agregarVersion(String contenido) {
        versiones.put(contadorVersion++, contenido);
    }
    public String obtenerVersion(int version) {
        return versiones.get(version);
    }
    public String obtenerUltimaVersion() {
        return versiones.lastEntry().getValue();
    }
    public void eliminarVersion(int version) {
        versiones.remove(version);
    }
    // Ejercicio 3: Sistema de Gestión de Eventos
    public void agregarEvento(Evento evento) {
        eventos.add(evento);
    }
    public Evento obtenerProximoEvento() {
        return eventos.first();
    }
    public void mostrarEventos() {
        for (Evento evento : eventos) {
            System.out.println(evento);
        }
    }
    public void eliminarEventosPasados() {
        Iterator<Evento> iter = eventos.iterator();
        while (iter.hasNext()) {
            if (iter.next().fecha.isBefore(LocalDateTime.now())) {
                iter.remove();
            }
        }
    }
    public static void main(String[] args) {
        EjercicioTreeSetAndMap ejercicio = new EjercicioTreeSetAndMap();
        Scanner scanner = new Scanner(System.in);
        // Menú de opciones
        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Contar frecuencia de palabras desde un archivo");
            System.out.println("2. Agregar versión de código");
            System.out.println("3. Obtener versión específica");
            System.out.println("4. Obtener última versión");
            System.out.println("5. Agregar evento");
            System.out.println("6. Mostrar próximos eventos");
            System.out.println("7. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la ruta del archivo: ");
                    String archivo = scanner.nextLine();
                    ejercicio.contarFrecuenciaPalabras(archivo);
                    break;
                case 2:
                    System.out.print("Ingrese el contenido de la versión: ");
                    String contenido = scanner.nextLine();
                    ejercicio.agregarVersion(contenido);
                    break;
                case 3:
                    System.out.print("Ingrese el número de versión: ");
                    int version = scanner.nextInt();
                    System.out.println("Contenido de la versión " + version + ": " + ejercicio.obtenerVersion(version));
                    break;
                case 4:
                    System.out.println("Última versión: " + ejercicio.obtenerUltimaVersion());
                    break;
                case 5:
                    System.out.print("Ingrese el nombre del evento: ");
                    String nombreEvento = scanner.nextLine();
                    System.out.print("Ingrese la fecha y hora del evento (YYYY-MM-DD HH:MM): ");
                    String fechaHora = scanner.nextLine();
                    LocalDateTime fecha = LocalDateTime.parse(fechaHora.replace(" ", "T"));
                    System.out.print("Ingrese la ubicación del evento: ");
                    String ubicacion = scanner.nextLine();
                    ejercicio.agregarEvento(new Evento(fecha, nombreEvento, ubicacion));
                    break;
                case 6:
                    System.out.println("Próximo evento: " + ejercicio.obtenerProximoEvento());
                    ejercicio.mostrarEventos();
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}