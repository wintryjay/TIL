package Ex04_Constructor.step1;

// 생성자를 통해 객체가 생성되면서 값이 할당될 수 있도록 만들어 보자.
class Book {
    String title; // 책 제목
    int price; // 책 가격
    int num; // 주문 수

    Book() {
        title = "자바 클래스 기초";
        price = 10000;
    }

    Book(String title, int price) {
        this.title = title;
        this.price = price;
    }

    void print(){
        System.out.println("제   목 : "+title);
        System.out.println("가   격 : "+price);
        System.out.println("주문수량 : "+num);
        System.out.println("합계금액 : "+price*num);
    }
}

public class MyBook {

    public static void main(String[] args) {
//        Book book = new Book();
        Book book = new Book("자바 디자인 패턴", 20000);
        book.num = 5;
        book.print();
    }
}
