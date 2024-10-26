package ar.edu.ottokrause.psr.collections;

public class Main {
    public static void main(String[] args) {
        double[][] elementsA = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        Matrix matrixA = new Matrix(elementsA);
        
        // Multiplicación de matrices
        Matrix matrixB = new Matrix(elementsA); // Usamos la misma matriz para simplificar
        Matrix product = matrixA.multiply(matrixB);
        
        System.out.println("Producto de las matrices:");
        printMatrix(product);
        
        // Transposición
        Matrix transposed = matrixA.transpose();
        System.out.println("Matriz transpuesta:");
        printMatrix(transposed);
        
        // Verificación de simetría
        boolean isSymmetric = matrixA.isSymmetric();
        System.out.println("¿Es la matriz simétrica? " + isSymmetric);
        
        // Rotar a la izquierda
        matrixA.rotateLeft();
        System.out.println("Matriz después de rotar a la izquierda:");
        printMatrix(matrixA);
        
        // Rotar a la derecha
        matrixA.rotateRight();
        System.out.println("Matriz después de rotar a la derecha:");
        printMatrix(matrixA);
    }

    // Método para imprimir la matriz
    private static void printMatrix(Matrix matrix) {
        for (int i = 0; i < matrix.rows(); i++) {
            for (int j = 0; j < matrix.columns(); j++) {
                System.out.print(matrix.get(i, j) + " ");
            }
            System.out.println();
        }
    }
}
