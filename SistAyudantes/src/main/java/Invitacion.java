import java.util.UUID;

public class Invitacion {
    private String nombre;
    private String mail;
    private String materia;

    private UUID token;

    public Invitacion(String nombre, String mail, String materia, UUID token) {
        this.nombre = nombre;
        this.mail = mail;
        this.materia = materia;
        this.token = token;
    }

    public void cargarAyudantes(){
        // la idea es leer el excel, ir creando un nuevo objeto Invitacion y meterlo en la bdd

        /**
         * Invitacion invitacion = new Invitacion(nombre,mail,materia,UUID.randomUUID());
         * insertarEnBDD(invitacion);
         */
    }
}
