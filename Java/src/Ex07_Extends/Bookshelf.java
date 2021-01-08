package Ex07_Extends;

class Book {
    String title;

    void printBook() {
        System.out.println("제   목 : "+title);
    }
}

class Novel extends Book {
    String writer;

    void printNov() {
        printBook();
        System.out.println("저   자 : "+writer);
    }
}

class Magazine extends Book {
    int day;

    void printMagazine() {
        printBook();
        System.out.println("발 매 일 : "+day+"");
    }
}

public class Bookshelf {

    public static void main(String[] args) {

        // Novel 에는 title이 없지만, Book을 상속받았기 때문에 변수를 사용할 수 있다.
        Novel nov = new Novel();
        nov.title = "홍길동전";
        nov.writer = "허균";

        //
        Magazine mag = new Magazine();
        mag.title = "월간 자바";
        mag.day = 20;

        nov.printNov();
        System.out.println();
        mag.printMagazine();
    }
}
