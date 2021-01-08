package Ex11_Interface.step1;

interface Greet {
    void greet();
}
interface Bye {
    void bye();
}

class Morning implements Greet, Bye {

    @Override
    public void greet() {
        System.out.println("안녕하세요!");
    }

    @Override
    public void bye() {
        System.out.println("안녕히계세요.");
    }
}
public class Meet {

    public static void main(String[] args) {
        Morning morning = new Morning();
        morning.greet();
        morning.bye();
    }
}
