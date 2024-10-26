public class Vector3D {
    private double x;
    private double y;
    private double z;

    // Constructor por defecto
    public Vector3D() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    // Constructor con parámetros
    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Método para obtener la coordenada x
    public double getX() {
        return this.x;
    }

    // Método para obtener la coordenada y
    public double getY() {
        return this.y;
    }

    // Método para obtener la coordenada z
    public double getZ() {
        return this.z;
    }

    // Método para calcular la norma del vector
    public double norm() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    // Método para sumar dos vectores
    public Vector3D add(Vector3D aVector) {
        return new Vector3D(this.x + aVector.getX(), this.y + aVector.getY(), this.z + aVector.getZ());
    }

    // Método para calcular el producto escalar
    public double dotProduct(Vector3D aVector) {
        return this.x * aVector.getX() + this.y * aVector.getY() + this.z * aVector.getZ();
    }

    // Método para mostrar el vector (opcional)
    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
