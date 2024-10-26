package ar.edu.ottokrause.psr.collections;

public class IntegerDoubleLinkedList implements IntegerList {
    private IntegerNode head; // Nodo inicial
    private IntegerNode tail; // Nodo final
    private int size; // Tamaño de la lista

    // Constructor
    public IntegerDoubleLinkedList() {
        this.head = null; // Inicialmente, la lista está vacía
        this.tail = null; // Inicialmente, la lista está vacía
        this.size = 0; // Tamaño inicial
    }

    // Método para agregar un elemento al final
    @Override
    public void add(int value) {
        IntegerNode newNode = new IntegerNode(value);
        if (tail == null) {
            head = newNode; // Si la lista está vacía, el nuevo nodo se convierte en head
            tail = newNode; // También es el tail
        } else {
            tail.setNext(newNode); // Enlazar el nuevo nodo al final
            newNode.setPrevious(tail); // Enlazar el nuevo nodo con el anterior
            tail = newNode; // Actualizar el tail
        }
        size++;
    }

    // Método para agregar un elemento al principio
    public void addFirst(int value) {
        IntegerNode newNode = new IntegerNode(value);
        if (head == null) {
            head = newNode; // Si la lista está vacía, el nuevo nodo se convierte en head
            tail = newNode; // También es el tail
        } else {
            newNode.setNext(head); // Enlazar el nuevo nodo al actual head
            head.setPrevious(newNode); // Enlazar el actual head con el nuevo nodo
            head = newNode; // Actualizar el head
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
