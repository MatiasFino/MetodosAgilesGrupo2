package com.sistema.ayudantes.sistayudantes.Email;

import com.sistema.ayudantes.sistayudantes.Materia;
import com.sistema.ayudantes.sistayudantes.Postulante;

public class EmailSender {

    public static int notificarAyudante(Postulante postulante, Materia materia) {
        try {
            EmailService emailSend = EmailService.getInstance();
            String emailHTML = ConfirmationEmail.buildEmail(
                    postulante.getApellido_nombre(),
                    materia.getNombre(),
                    Integer.toString(postulante.getId()),
                    Integer.toString(materia.getId())
            );
            emailSend.sendEmail(postulante.getEmail(), emailHTML);
            return 200;
        } catch (Exception e) {
            return 500;
        }
    }
}
