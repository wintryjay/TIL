package Ex12_Polymorphism;

// MS사 : 윈도우 10에서 사용될 프린터는 다음의 규격을 준수해야 합니다. Printable을 구현해 주세요.
// 아래아한글, MS Word, : 인쇄는 Printable의 Print만 호출하면 되는 군요. 알겠습니다.
// 삼성, 엡손 : 프린터는 Printable 인터페이스 규격에 맞춰 만들겠습니다.

interface Printable {
    void print(String doc);
}

class PrnDrvSamsung implements Printable {
    public void print(String doc) {
        System.out.println(doc + "\nFrom Samsung : Black-White Ver");
    }
}

class PrnDrvEpson implements Printable {
    public void print(String doc) {
        System.out.println(doc + "\nFrom Epson : Black-White Ver");
    }
}

public class Polymorphism2 {

    // 제 3의 워드프로세스로 가정
    public static void main(String[] args) {
        String doc = "프린터로 출력을 합니다.";

        Printable prn1 = new PrnDrvSamsung();
        prn1.print(doc);

        Printable prn2 = new PrnDrvEpson();
        prn2.print(doc);

    }
}
