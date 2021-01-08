package Ex10_AbstractClass;

abstract class Animal {
    int age;
    abstract void cry();
}
// 자기 상황에 맞게 고쳐서 사용하라고, 두루뭉실하게 메서드만 정해놓은것
// 동물이 울지 않으면 이상하기때문에 이건 꼭 구현해라라는 의미로
// Animal을 상속받은 모든 객체들은 cry()을 구현하라고 강제하는 것

class Dog extends Animal {

    @Override
    void cry() {
        System.out.println("멍멍");
    }
}

class Cat extends Animal {

    @Override
    void cry() {
        System.out.println("야옹");
    }
}
public class AbstractClass {

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.cry();

        Cat cat = new Cat();
        cat.cry();
    }
}
