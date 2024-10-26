public class IntegerArrayList2 implements IntegerList {
    private int[] elements;
    private int size;
    private static final int INITIAL_CAPACITY = 10; // Capacidad inicial

    // Constructor
    public IntegerArrayList2() {
        elements = new int[INITIAL_CAPACITY]; // Comenzamos con un arreglo de capacidad inicial
        size = 0;
    }

    // Método para agregar un elemento
    @Override
    public void add(int value) {
        // Si el tamaño alcanzó la capacidad, duplicar el tamaño del arreglo
        if (size >= elements.length) {
            int newCapacity = elements.length * 2; // Duplicar la capacidad
            int[] newArray = new int[newCapacity];
            System.arraycopy(elements, 0, newArray, 0, elements.length);
            elements = newArray;
        }
        // Agregar el nuevo elemento
        elements[size] = value;
        size++;
    }

    // Método para obtener un elemento en una posición específica
    @Override
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        return elements[index];
    }

    // Método para obtener el tamaño del arreglo
    @Override
    public int size() {
        return size;
    }
}
