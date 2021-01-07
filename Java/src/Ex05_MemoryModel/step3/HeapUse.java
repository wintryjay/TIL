package Ex05_MemoryModel.step3;

class Book{
    String title;
}

public class HeapUse {

    public static void main(String[] args) {
        Book book1 = new Book(); // book1 참조변수는 새로운 객체가 만들어져 만들어 힙에 있는 객체를 참조
        book1.title = "자바 클래스 기초";

        Book book2 = book1; // book2 도 똑같은 객체를 참조하고 있음

        System.out.println(book1.title);
        System.out.println(book2.title);
        System.out.println("========="); // 2개다 똑같은 객체를 참조하고 있음을 알 수 있다.

        book2.title = "자바 디자인 패턴"; // 서로 같은 객체를 참조하고 있기 때문에 둘 다 바뀐다.
        System.out.println(book1.title);
        System.out.println(book2.title);
    }
}
