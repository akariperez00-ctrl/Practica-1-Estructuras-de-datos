public class ListaEnlazadaSimple {

    
    private NodoLista primero;

   
    public ListaEnlazadaSimple() {
        primero = null;
    }

  
    private NodoLista getPrimero() {
        return primero;
    }

    private void setPrimero(NodoLista primero) {
        this.primero = primero;
    }

   
    public boolean estaVacia() {
        return primero == null;
    }

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
