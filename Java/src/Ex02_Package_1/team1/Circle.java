package Ex02_Package_1.team1;

public class Circle {
    final double PI = 3.14;
    double rad;

    public void setRad(double r) {
        rad = r;
    }

    // 원의 넓이 반환
    public double getArea(){
        return (rad*rad)*PI;
    }
}
