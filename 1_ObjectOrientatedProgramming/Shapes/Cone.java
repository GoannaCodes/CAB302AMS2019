package oop.Shapes;

public class Cone implements Shape {
    private double h;
    private double r;
    public Cone(double radius, double height){
        //store given values for radius and height
        h = height;
        r = radius;
    }

    @Override
    public double volume() {
        return Math.PI * Math.pow(r, 2) * (h/3);
    }

    @Override
    public double surfaceArea() {
        //calculate value within sqrt - h^2 + r^2
        double sqrt = Math.pow(h, 2) + Math.pow(r, 2);
        //output area
        return (Math.PI * r) * (r + Math.sqrt(sqrt));
    }
}
