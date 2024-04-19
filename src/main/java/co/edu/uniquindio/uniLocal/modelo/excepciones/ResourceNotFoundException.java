package co.edu.uniquindio.uniLocal.modelo.excepciones;

public class ResourceNotFoundException extends Exception {
    public ResourceNotFoundException(String idRecurso) {
        super("No se encontró un recurso con el id " + idRecurso);
    }
}
