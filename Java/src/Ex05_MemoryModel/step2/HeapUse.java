package Ex05_MemoryModel.step2;

class Book {
    String title;
}
// book1 과 book2는 서로 다른 객체를 참조
public class HeapUse {

    public static void main(String[] args) {
        Book book1 = new Book();
        Book book2 = new Book();

        book1.title = "자바 클래스 기초";
        book2.title = "자바 디자인 패턴";

        System.out.println(book1.title);
        System.out.println(book2.title);

        book1 = null;
        book2 = null;
    }
}
