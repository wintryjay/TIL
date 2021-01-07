package Ex01_Class_3;

// 클래스에 필드만 있는 경우(데이터만 있는 경우)
class Book{
    String title;
    String author;
    int price;
}

public class MyBook {
    public static void main(String[] args) {
        // 객체 생성
        Book book = new Book();

        // 필드 접근
        book.title="클래스의 기초";
        book.author="홍길동";
        book.price=10000;

        System.out.println(book.title+", "+book.author+", "+book.price);
    }
}
