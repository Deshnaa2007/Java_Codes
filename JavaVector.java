import java.util.Vector;

class VectorException extends Exception {
    public VectorException(String message) {
        super(message);
    }
}

class Vector3D {

    double a, b, c;

    public Vector3D() {
        a = 0;
        b = 0;
        c = 0;
    }

    public Vector3D(double x, double y, double z) throws VectorException {

        if (Double.isNaN(x) || Double.isNaN(y) || Double.isNaN(z)) {
            throw new VectorException("Invalid vector value");
        }

        a = x;
        b = y;
        c = z;
    }

    public Vector3D plus(Vector3D v) throws VectorException {

        if (v == null) {
            throw new VectorException("Cannot add null vector");
        }

        return new Vector3D(a + v.a, b + v.b, c + v.c);
    }

    public Vector3D minus(Vector3D v) throws VectorException {

        if (v == null) {
            throw new VectorException("Cannot subtract null vector");
        }

        return new Vector3D(a - v.a, b - v.b, c - v.c);
    }

    public double dot(Vector3D v) throws VectorException {

        if (v == null) {
            throw new VectorException("Invalid vector for dot product");
        }

        return a * v.a + b * v.b + c * v.c;
    }

    void printVector() {
        System.out.println("<" + a + ", " + b + ", " + c + ">");
    }
}

public class JavaVector {

    public static void main(String[] args) {

        Vector<Vector3D> list = new Vector<>();

        try {

            Vector3D v1 = new Vector3D(2, 3, 4);
            Vector3D v2 = new Vector3D(1, 5, 2);
            Vector3D v3 = new Vector3D(7, 1, 6);

            list.add(v1);
            list.add(v2);
            list.add(v3);

            System.out.println("3D Vector List:");

            for (int i = 0; i < list.size(); i++) {
                list.get(i).printVector();
            }

            System.out.println("\nVector Operations");

            Vector3D resultAdd = list.get(0).plus(list.get(1));
            System.out.print("Add Result: ");
            resultAdd.printVector();

            Vector3D resultSub = list.get(0).minus(list.get(1));
            System.out.print("Subtract Result: ");
            resultSub.printVector();

            double resultDot = list.get(0).dot(list.get(1));
            System.out.println("Dot Product: " + resultDot);

            Vector3D temp = null;
            list.get(0).plus(temp);

        }
        catch (VectorException e) {
            System.out.println("Vector Error: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
