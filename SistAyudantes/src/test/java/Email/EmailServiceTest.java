package Email;

import com.sistema.ayudantes.sistayudantes.Email.EmailSender;
import com.sistema.ayudantes.sistayudantes.Materia;
import com.sistema.ayudantes.sistayudantes.Postulante;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

class EmailServiceTest {

    @Test
    void notificarAyudante() {
        Postulante testPostulante = new Postulante(1, 'A', "Test Tester", "metodosagiles2022@gmail.com", 0, 1);
        Materia testMateria = new Materia(2, "Análisis Matemático II", 0, 0);
        int resultado = EmailSender.notificarAyudante(testPostulante, testMateria, UUID.randomUUID());
        assertEquals(200,resultado);
    }
}