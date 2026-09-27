public class ListaEnlazadaSimple {

    // Atributo principal de la lista
    private NodoLista primero;

    // Constructor
    public ListaEnlazadaSimple() {
        primero = null;
    }

    // Getters y Setters
    private NodoLista getPrimero() {
        return primero;
    }

    private void setPrimero(NodoLista primero) {
        this.primero = primero;
    }

    // Operación para verificar si está vacía
    public boolean estaVacia() {
        return primero == null;
    }

    // Insertar al final de la lista de resueltos
    public void insertarFin(Ticket ticket) {
        NodoLista nodo = new NodoLista(ticket);
        if (estaVacia()) {
            setPrimero(nodo);
            return;
        }
        NodoLista temp = primero;
        while (temp.getSiguiente() != null) {
            temp = temp.getSiguiente();
        }
        temp.setSiguiente(nodo);
    }

    // Buscar un ticket resuelto por su ID único
    public Ticket buscarPorId(int id) {
        if (estaVacia()) {
            return null;
        }
        NodoLista temp = primero;
        while (temp != null) {
            if (temp.getTicket().getId() == id) {
                return temp.getTicket();
            }
            temp = temp.getSiguiente();
        }
        return null;
    }

    // Mostrar todos los tickets resueltos
    public void mostrarLista() {
        if (estaVacia()) {
            System.out.println("No hay tickets resueltos en el historial.\n");
            return;
        }
        NodoLista temp = primero;
        while (temp != null) {
            System.out.println(temp.getTicket());
            temp = temp.getSiguiente();
        }
    }

    // Clase interna Nodo
    public class NodoLista {

        private Ticket ticket;
        private NodoLista siguiente;

        public NodoLista(Ticket ticket) {
            this.ticket = ticket;
            this.siguiente = null;
        }

        public Ticket getTicket() {
            return ticket;
        }

        public void setTicket(Ticket ticket) {
            this.ticket = ticket;
        }

        public NodoLista getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(NodoLista siguiente) {
            this.siguiente = siguiente;
        }
    }
}
