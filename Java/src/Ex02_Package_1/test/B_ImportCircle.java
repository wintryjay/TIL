package Ex02_Package_1.test;

import Ex02_Package_1.team1.Circle;

public class B_ImportCircle {
    public static void main(String[] args) {
        Circle c1= new Circle();
        c1.setRad(3.5);
        System.out.println("반지름 3.5의 원의 넓이는 "+ c1.getArea());

        Circle c2= new Circle();
        c2.setRad(5.5);
        System.out.println("반지름 5.5의 원의 둘레는 "+ c2.getArea());
    }
}
