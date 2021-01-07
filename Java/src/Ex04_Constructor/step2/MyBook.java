package Ex04_Constructor.step2;

class Book {
    String title;
    int price;

    Book(String title, int price) {
        this.title = title;
        this.price = price;
    }

    // 복제 생성자
    Book(Book copy) { // 매개변수가 자기 자신과 똑같은 클래스 타입의 변수
        title = copy.title;
        price = copy.price;
    }

    void print() {
        System.out.println("제   목 : " + title);
        System.out.println("가   격 : " + price);
    }
}

public class MyBook {
    public static void main(String[] args) {
//        Book book1 = new Book(); // 기본 생성자가 없기때문에 에러 발생
        Book book1 = new Book("자바 클래스 기초", 10000);
        book1.print();

        Book book2 = new Book(book1);
        book2.title = "자바 디자인 패턴"; // title을 새로 대입
        book2.print();


    }
}
