package com.sistema.ayudantes.sistayudantes.Email;

import com.sistema.ayudantes.sistayudantes.Materia;
import com.sistema.ayudantes.sistayudantes.Postulante;
import java.util.UUID;

public class EmailSender {

    public static int notificarAyudante(Postulante postulante, Materia materia, UUID token) {
        EmailService emailSend = EmailService.getInstance();
        String emailHTML = ConfirmationEmail.buildEmail(
                postulante.getApellido_nombre(),
                materia.getNombre(),
                Integer.toString(postulante.getId()),
                Integer.toString(materia.getId()),
                token.toString()
        );
        emailSend.sendEmail(postulante.getEmail(), emailHTML);
        return 200;
    }

    public static int expiracionInvitacion (String nombreAyudante, String nombreMateria, String email) {
        EmailService emailService = EmailService.getInstance();
        String emailHTML = ExpirationEmail.buildEmail(nombreAyudante, nombreMateria);
        emailService.sendEmail(email, emailHTML);
        return 200;
    }
}
