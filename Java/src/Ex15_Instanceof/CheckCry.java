package Ex15_Instanceof;

interface Cry {
    void cry();
}

class Cat implements Cry {

    @Override
    public void cry() {
        System.out.println("야옹");
    }
}

class Dog implements Cry {

    @Override
    public void cry() {
        System.out.println("멍멍");
    }
}

public class CheckCry {

    public static void main(String[] args) {

        // 슈퍼 클래스가 가리키고 있는 객체가 어떤건지 확인이 가능
        Cry test1 = new Cat();
        if(test1 instanceof Cat) {
            test1.cry();
        }else {
            System.out.println("고양이가 아닙니다.");
        }

        Cry test2 = new Dog();
        if(test2 instanceof Cat) {
            test2.cry();
        }else {
            System.out.println("고양이가 아닙니다.");
        }
    }
}
