package oop.Shapes;

public class Tetrahedron implements Shape {
    private double edge;
    public Tetrahedron(double edge) {
        //set given value of edge and store into this.edge
        this.edge = edge;
    }


    @Override
    public double volume() {
        //cube value of edge
        double side = Math.pow(edge, 3);
        //calculate volume of shape
        return side / (6 * Math.sqrt(2));
    }

    @Override
    public double surfaceArea() {
        //square value of edge
        double side = Math.pow(edge, 2);
        return Math.sqrt(3) * side;
    }
}
