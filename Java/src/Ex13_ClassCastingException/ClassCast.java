package Ex13_ClassCastingException;

// Compile을 해야 에러여부를 확인할 수 있다.
class PBoard { }

class CBoard extends PBoard { }

public class ClassCast {

    public static void main(String[] args) {
        PBoard sbd1 = new CBoard();
        CBoard sbd2 = (CBoard) sbd1; // OK!

        System.out.println("----------");

        PBoard ebd1 =new PBoard();
        CBoard ebd2 = (CBoard) ebd1; // Exception!
    }
}
