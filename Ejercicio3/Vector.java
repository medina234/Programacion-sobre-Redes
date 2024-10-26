public class Vector {
    private double[] coordinates;

    // Constructor que crea un vector con coordinateCount dimensiones en 0
    public Vector(int coordinateCount) {
        this.coordinates = new double[coordinateCount];
    }

    // Constructor que inicializa el vector con un arreglo de coordenadas
    public Vector(double[] coordinates) {
        this.coordinates = coordinates.clone(); // Clonamos el arreglo para evitar mutaciones externas
    }

    // Método para obtener la coordenada i-ésima
    public double getCoordinate(int index) {
        if (index < 0 || index >= coordinates.length) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        return coordinates[index];
    }

    // Método para calcular la norma del vector
    public double norm() {
        double sum = 0;
        for (double coord : coordinates) {
            sum += coord * coord;
        }
        return Math.sqrt(sum);
    }

    // Método para sumar dos vectores
    public Vector add(Vector aVector) {
        if (this.coordinates.length != aVector.coordinates.length) {
            throw new IllegalArgumentException("Los vectores deben tener la misma dimensión");
        }
        double[] resultCoords = new double[this.coordinates.length];
        for (int i = 0; i < resultCoords.length; i++) {
            resultCoords[i] = this.coordinates[i] + aVector.getCoordinate(i);
        }
        return new Vector(resultCoords);
    }

    // Método para calcular el producto escalar
    public double dotProduct(Vector aVector) {
        if (this.coordinates.length != aVector.coordinates.length) {
            throw new IllegalArgumentException("Los vectores deben tener la misma dimensión");
        }
        double result = 0;
        for (int i = 0; i < this.coordinates.length; i++) {
            result += this.coordinates[i] * aVector.getCoordinate(i);
        }
        return result;
    }

    // Método para mostrar el vector (opcional)
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        for (int i = 0; i < coordinates.length; i++) {
            sb.append(coordinates[i]);
            if (i < coordinates.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
