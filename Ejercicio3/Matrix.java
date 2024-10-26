package ar.edu.ottokrause.psr.collections;

public class Matrix {
    private double[][] elements; // Matriz de elementos
    private int rows; // Número de filas
    private int columns; // Número de columnas

    // Constructor que inicializa la matriz con ceros
    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.elements = new double[rows][columns]; // Inicializa la matriz con ceros
    }

    // Constructor que recibe un arreglo de arreglos de doubles
    public Matrix(double[][] elements) {
        if (elements == null || elements.length == 0) {
            throw new IllegalArgumentException("El arreglo no puede ser nulo o vacío.");
        }
        this.rows = elements.length;
        this.columns = elements[0].length;
        this.elements = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            if (elements[i].length != columns) {
                throw new IllegalArgumentException("Todas las filas deben tener la misma longitud.");
            }
            System.arraycopy(elements[i], 0, this.elements[i], 0, columns);
        }
    }

    // Constructor de copia
    public Matrix(Matrix matrix) {
        this.rows = matrix.rows();
        this.columns = matrix.columns();
        this.elements = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(matrix.elements[i], 0, this.elements[i], 0, columns);
        }
    }

    // Devuelve el número de filas
    public int rows() {
        return this.rows;
    }

    // Devuelve el número de columnas
    public int columns() {
        return this.columns;
    }

    // Devuelve el valor en la posición especificada
    public double get(int row, int column) {
        validateIndices(row, column);
        return this.elements[row][column];
    }

    // Establece el valor en la posición especificada
    public void set(int row, int column, double value) {
        validateIndices(row, column);
        this.elements[row][column] = value;
    }

    // Valida los índices de fila y columna
    private void validateIndices(int row, int column) {
        if (row < 0 || row >= rows || column < 0 || column >= columns) {
            throw new IndexOutOfBoundsException("Índices fuera de rango.");
        }
    }

    // Método para sumar dos matrices
    public Matrix add(Matrix other) {
        if (other == null) {
            throw new IllegalArgumentException("La matriz a sumar no puede ser nula.");
        }
        if (this.rows != other.rows() || this.columns != other.columns()) {
            throw new IllegalArgumentException("Las matrices deben tener las mismas dimensiones.");
        }

        Matrix result = new Matrix(this.rows, this.columns);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                result.elements[i][j] = this.elements[i][j] + other.get(i, j);
            }
        }
        return result;
    }

    // Método para restar dos matrices
    public Matrix subtract(Matrix other) {
        if (other == null) {
            throw new IllegalArgumentException("La matriz a restar no puede ser nula.");
        }
        if (this.rows != other.rows() || this.columns != other.columns()) {
            throw new IllegalArgumentException("Las matrices deben tener las mismas dimensiones.");
        }

        Matrix result = new Matrix(this.rows, this.columns);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                result.elements[i][j] = this.elements[i][j] - other.get(i, j);
            }
        }
        return result;
    }

    // Método para multiplicar dos matrices
    public Matrix multiply(Matrix other) {
        if (other == null) {
            throw new IllegalArgumentException("La matriz a multiplicar no puede ser nula.");
        }
        if (this.columns != other.rows()) {
            throw new IllegalArgumentException("El número de columnas de la primera matriz debe ser igual al número de filas de la segunda.");
        }

        Matrix result = new Matrix(this.rows, other.columns()); // Crear nueva matriz para el resultado
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.columns(); j++) {
                for (int k = 0; k < this.columns; k++) {
                    result.elements[i][j] += this.elements[i][k] * other.get(k, j); // Sumar producto
                }
            }
        }
        return result; // Devolver la nueva matriz resultante
    }

    // Método para transponer la matriz
    public Matrix transpose() {
        Matrix result = new Matrix(this.columns, this.rows); // Crear nueva matriz transpuesta
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                result.elements[j][i] = this.elements[i][j]; // Asignar el elemento transpuesto
            }
        }
        return result; // Devolver la matriz transpuesta
    }

    // Método para verificar si la matriz es simétrica
    public boolean isSymmetric() {
        if (rows != columns) {
            return false; // Solo cuadradas pueden ser simétricas
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < i; j++) { // Solo verificar la parte superior del triángulo
                if (elements[i][j] != elements[j][i]) {
                    return false; // No es simétrica
                }
            }
        }
        return true; // Es simétrica
    }

    // Método para rotar la matriz a la izquierda
    public void rotateLeft() {
        double temp = elements[0][0]; // Almacena el primer elemento
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                elements[i][j] = elements[i][(j + 1) % columns]; // Mover a la izquierda
            }
        }
        elements[rows - 1][columns - 1] = temp; // Rellena la última posición
    }

    // Método para rotar la matriz a la derecha
    public void rotateRight() {
        double temp = elements[rows - 1][columns - 1]; // Almacena el último elemento
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = columns - 1; j >= 0; j--) {
                elements[i][j] = elements[i][(j - 1 + columns) % columns]; // Mover a la derecha
            }
        }
        elements[0][0] = temp; // Rellena la primera posición
    }
}
