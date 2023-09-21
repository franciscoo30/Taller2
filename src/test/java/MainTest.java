import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void obtenerUltimoEspacio() {
        String[][] registro = {
                {"Persona 1", "casado", "25"},
                {"Persona 2", "soltero", "30"},
                {null, null, null},
                {null, null, null},
        };

        int resultado = Main.obtenerUltimoEspacio(registro);


        assertEquals(2, resultado);
    }

    @Test
    void espaciosOcupados() {

        String[][] registro = {
                {"Persona 1", "casado", "25"},
                {"Persona 2", "soltero", "30"},
                {null, null, null},
                {null, null, null},
        };


        int resultado = Main.espaciosOcupados(registro);

        assertEquals(2, resultado);
    }

    @Test
    void pedirInput() {
        int resultado = Main.pedirInput();

        assertEquals(3, resultado);
    }
}
