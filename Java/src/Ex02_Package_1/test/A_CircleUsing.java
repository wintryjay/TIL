package Ex02_Package_1.test;

public class A_CircleUsing {

    public static void main(String[] args) {
        Ex02_Package_1.team1.Circle c1= new Ex02_Package_1.team1.Circle();
        c1.setRad(3.5);
        System.out.println("반지름 3.5의 원의 넓이는 "+ c1.getArea());

        Ex02_Package_1.team2.Circle c2= new Ex02_Package_1.team2.Circle();
        c2.setRad(3.5);
        System.out.println("반지름 3.5의 원의 둘레는 "+ c2.getPerimeter());
    }
}
