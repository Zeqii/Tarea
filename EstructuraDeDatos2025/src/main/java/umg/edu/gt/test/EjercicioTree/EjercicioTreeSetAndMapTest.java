package umg.edu.gt.test.EjercicioTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios.EjercicioTreeSetAndMap;
import umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios.Evento;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class EjercicioTreeSetAndMapTest {
    private EjercicioTreeSetAndMap ejercicio;
    @BeforeEach
    public void setUp() {
        ejercicio = new EjercicioTreeSetAndMap(); // Inicializa una nueva instancia antes de cada prueba
    }
    @Test
    public void testAgregarYObtenerVersion() {
        ejercicio.agregarVersion("System.out.println('Hola Mundo');");
        ejercicio.agregarVersion("System.out.println('Hola Java');");
        assertEquals("System.out.println('Hola Mundo');", ejercicio.obtenerVersion(1));
        assertEquals("System.out.println('Hola Java');", ejercicio.obtenerUltimaVersion());
    }
    @Test
    public void testAgregarEvento() {
        Evento evento = new Evento(LocalDateTime.of(2025, 5, 10, 10, 0), "Conferencia de Java", "Auditorio A");
        ejercicio.agregarEvento(evento);
        
        assertEquals(evento, ejercicio.obtenerProximoEvento());
    }
    @Test
    public void testEliminarEventosPasados() {
        ejercicio.agregarEvento(new Evento(LocalDateTime.of(2022, 1, 1, 10, 0), "Evento Pasado", "Sala 1"));
        ejercicio.agregarEvento(new Evento(LocalDateTime.of(2025, 5, 10, 10, 0), "Evento Futuro", "Auditorio A"));
        ejercicio.eliminarEventosPasados(); // Elimina eventos pasados
        // Verificamos que el evento pasado fue eliminado
        assertEquals(1, ejercicio.eventos.size()); // Debería quedar solo el evento futuro
        assertEquals("Evento Futuro, 2025-05-10T10:00, Auditorio A", ejercicio.obtenerProximoEvento().toString());
    }
    @Test
    public void testContarFrecuenciaPalabras() {

    }
}