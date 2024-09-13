import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.fpmislata.Ejercicios;

public class EjeciciosTest {

    static Ejercicios ejercicios;

    @BeforeAll
    public static void setUp() {
        ejercicios = new Ejercicios();
    }

    @Test
    public void testSumaEnteros() {
        List<Integer> listaEnteros = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        assertEquals(55, ejercicios.sumaEnteros(listaEnteros));
    }
}
