package oop.Shapes;

public class MainTest {
    public static void main(String[] args){
        //testing for tetrahedron
        Shape a = new Tetrahedron(5);
        System.out.println(a.volume());
        System.out.println(a.surfaceArea());

        //testing for cone calculations
        Shape b = new Cone(10, 3);
        System.out.println(b.volume());
        System.out.println(b.surfaceArea());
    }
}
