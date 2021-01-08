package Ex08_Overriding;

class Animal {
    String name;
    int age;

    void printPet() {
        System.out.println("이름 :"+name);
        System.out.println("나이 :"+age);
    }
}

class Dog extends Animal {
    String variety;

    // 함수에 오버라이딩 된다.
    void printPet() {
        super.printPet(); // 부모 클래스에 있는 메서드 호출하는 방법 super.
                          // 이 분을 호출하지않으면 기능의 변경이 일어나고, 호출하면 기능의 추가로 볼 수 있다.
        System.out.println("종류 :"+variety);
    }
}

public class Pet {

    public static void main(String[] args) {

        Dog dog = new Dog();
        dog.name = "진돌이";
        dog.age = 5;
        dog.variety = "진돗개";
        dog.printPet();
    }
}
