import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fpmislata.Ejercicios;

public class EjerciciosTest {

    Ejercicios exercises = new Ejercicios();

    Character character = 'p';
    Integer value = 7;
    List<Integer> listIntegers = List.of(1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 9, 10);
    List<String> listStrings = List.of("paco", "pepe", "juan", "luis", "jose", "carlos", "javier", "raul");

    @Test
    @DisplayName("Testing Exercise1")
    public void testSumIntenger() {

        // Arrange
        int expected = 70;

        // Act
        int result = exercises.sumInteger(listIntegers);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing Exercise2")
    public void testGetEvenIntegers() {

        // Arrange
        List<Integer> expected = List.of(2, 4, 6, 6, 8, 10);

        // Act
        List<Integer> result = exercises.getEvenIntegers(listIntegers);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Tsting Exercise3")
    public void testToUpperCase() {

        // Arrange
        List<String> expected = List.of("PACO", "PEPE", "JUAN", "LUIS", "JOSE", "CARLOS", "JAVIER", "RAUL");

        // Act
        List<String> result = exercises.toUpperCase(listStrings);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test Exercise3b")
    public void testCapitalize() {

        // Arrange
        List<String> expected = List.of("Paco", "Pepe", "Juan", "Luis", "Jose", "Carlos", "Javier", "Raul");

        // Act
        List<String> result = exercises.capitalize(listStrings);

        // Assert
        assertEquals(expected, result);

    }

    @Test
    @DisplayName("Test Exercise4")
    public void testGetMaxInteger() {

        // Arrange
        Integer expected = 10;

        // Act
        Integer result = exercises.getMaxInteger(listIntegers);

        // Assert
        assertEquals(expected, result);

    }

    @Test
    @DisplayName("Test Exercise5")
    public void testCountGreaterThan() {

        // Arrange
        long expected = 4;

        // Act
        long result = exercises.countGreaterThan(listIntegers, value);

        // Assert
        assertEquals(expected, result);

    }

    @Test
    @DisplayName("Test Exercise6")
    public void testConcat() {

        // Arrange
        String expected = "pacopepejuanluisjosecarlosjavierraul";

        // Act
        String result = exercises.concat(listStrings);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test Exercise7")
    public void testSquared() {

        // Arrange
        List<Integer> expected = List.of(1, 4, 9, 16, 25, 36, 36, 49, 64, 81, 81, 100);

        // Act
        List<Integer> result = exercises.squared(listIntegers);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test Exercise8")
    public void testRemoveDuplicates() {

        // Arrange
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Act
        List<Integer> result = exercises.removeDuplicates(listIntegers);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test Exercises9")
    public void testGetGreaterThan() {

        // Arrange
        Integer expected = 8;

        // Act
        Integer result = exercises.getFirstGreaterThan(listIntegers, value);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test Exercise9b")
    public void testGetGreaterThan2() {

        // Arrange
        Integer expected = 8;

        // Act
        Integer result = exercises.getFirstGreaterThan(listIntegers, value);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test Exercise10")
    public void testCountStartWith() {

        // Arrange
        long expected = 2;

        // Act
        long result = exercises.countStartWith(listStrings, character);

        // Assert
        assertEquals(expected, result);

    }
}
