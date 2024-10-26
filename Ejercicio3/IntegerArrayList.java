import java.util.Arrays;

public class IntegerArrayList implements IntegerList {
    private int[] elements;
    private int size;

    // Constructor
    public IntegerArrayList() {
        elements = new int[0]; // Comenzamos con un arreglo vacío
        size = 0;
    }

    // Método para agregar un elemento
    @Override
    public void add(int value) {
        // Crear un nuevo arreglo con un tamaño mayor
        int[] newArray = new int[size + 1];
        // Copiar los elementos existentes al nuevo arreglo
        System.arraycopy(elements, 0, newArray, 0, size);
        // Agregar el nuevo elemento
        newArray[size] = value;
        // Actualizar la referencia del arreglo y el tamaño
        elements = newArray;
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
