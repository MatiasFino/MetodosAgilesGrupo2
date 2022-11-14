package Email;

import com.sistema.ayudantes.sistayudantes.Email.EmailService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailServiceTest {

    @Test
    void notificarAyudante() {
        EmailService test = new EmailService();
        int resultado = test.notificarAyudante("JuanferQuintero", "MetodosAgiles");
    assertEquals(200,resultado);
    }
}