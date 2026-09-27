import java.util.ArrayList;

public class ColaDinamica {

    private ArrayList<Ticket> cola;

    public ColaDinamica() {
        cola = new ArrayList<>();
    }

    public boolean estaVacia() {
        return cola.isEmpty();
    }

    public void insertar(Ticket ticket) {
        cola.add(ticket);
    }

    public Ticket eliminar() {
        if (estaVacia()) {
            System.out.println("La cola de tickets pendientes está vacía.\n");
            return null;
        }
        return cola.removeFirst();
    }

    public Ticket verFrente() {
        if (estaVacia()) {
            System.out.println("La cola de tickets pendientes está vacía.\n");
            return null;
        }
        return cola.getFirst();
    }
}