import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ticket {

    private static int cantidad = 0;

    private int id;
    private String nombreCompleto;
    private String descripcion;
    private String fechaCreacion;
    private String fechaResolucion;

    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Ticket(String nombreCompleto, String descripcion) {
        cantidad++;
        this.id = cantidad;
        this.nombreCompleto = nombreCompleto;
        this.descripcion = descripcion;
        this.fechaCreacion = LocalDateTime.now().format(FORMATO_FECHA);
        this.fechaResolucion = null;
    }

    public int getId() {
        return id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public String getFechaResolucion() {
        return fechaResolucion;
    }

    public void setFechaResolucion(String fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }

    public void resolverTicket() {
        this.fechaResolucion = LocalDateTime.now().format(FORMATO_FECHA);
    }

    public String toString() {
        return "----------------------------------------\n" +
                "ID Ticket: " + id + "\n" +
                "Usuario: " + nombreCompleto + "\n" +
                "Descripción: " + descripcion + "\n" +
                "Fecha de Creación: " + fechaCreacion + "\n" +
                "Fecha de Resolución: " + (fechaResolucion == null ? "Pendiente" : fechaResolucion) + "\n" +
                "----------------------------------------";
    }
}
