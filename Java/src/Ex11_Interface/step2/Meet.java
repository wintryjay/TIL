package Ex11_Interface.step2;

interface Greet {
    void greet();
}
interface Bye extends Greet{
    void bye();
}

class Morning implements Bye {

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