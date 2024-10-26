package ar.edu.ottokrause.psr.collections;

public class IntegerLinkedList implements IntegerList {
    private IntegerNode head; // Nodo inicial
    private int size; // Tamaño de la lista

    // Constructor
    public IntegerLinkedList() {
        this.head = null; // Inicialmente, la lista está vacía
        this.size = 0; // Tamaño inicial
    }

    // Método para agregar un elemento al final
    @Override
    public void add(int value) {
        IntegerNode newNode = new IntegerNode(value);
        if (head == null) {
            head = newNode; // Si la lista está vacía, el nuevo nodo se convierte en head
        } else {
            IntegerNode current = head;
            // Recorrer hasta el final de la lista
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode); // Enlazar el nuevo nodo al final
        }
        size++;
    }

    // Método para obtener un elemento en una posición específica
    @Override
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        IntegerNode current = head;
        // Recorrer hasta el índice deseado
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getValue(); // Devolver el valor del nodo
    }

    // Método para obtener el tamaño de la lista
    @Override
    public int size() {
        return size;
    }
}
