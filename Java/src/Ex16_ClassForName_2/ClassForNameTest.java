package Ex16_ClassForName_2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassForNameTest {

    public static void main(String[] args) throws ClassNotFoundException {

        Class strClass = Class.forName("MyBook");

        Constructor[] cons = strClass.getConstructors();
        for(Constructor c : cons) {
            System.out.println(c);
        }
        System.out.println("-------------------------");
        Field[] fields = strClass.getFields();
        for(Field f : fields) {
            System.out.println(f);
        }
        System.out.println("-------------------------");
        Method[] methods = strClass.getMethods();
        for(Method m : methods) {
            System.out.println(m);
        }
    }
}
