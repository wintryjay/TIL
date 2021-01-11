package Algorithm.Java.StringAndArray;

import java.util.HashSet;
import java.util.Set;

/*
# Question07. Jewels And Stones (HashSet, 중복 허용하지 않는다.)
    Eng: You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
         Each character in S is a type of stone you have. You want to know how many of the stones you have also jewels.
         The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive,
         so "a" is considered a different type of stone from "A".
    Kor: 보석의 종류를 나타내는 J와 여러분이 가지고 있는 돌을 나타내는 S가 주어집니다.
         S의 각 문자는 당신이 가지고 있는 돌의 한 종류입니다. 보석도 몇 개나 가지고 있는지 알고 싶으실 겁니다.
         J의 문자는 구별이 보장되며, J와 S의 문자는 모두 문자입니다. 글자는 대소문자를 구분하기 때문에 "a"는 "A"와 다른 유형의 돌로 간주됩니다.

    input: J="aA", S="aAAbbbb"
    output: 3
 */
public class T06_JewelsAndStones {

    public static void main(String[] args) {
        String J = "aA", S = "aAAbbbb";
        System.out.println(solve(J, S));
    }
    public static int solve(String jew, String stone) {
        Set<Character> set = new HashSet<>();
        for(char jewel : jew.toCharArray()) {
            set.add(jewel); // a, A 가 들어간다.
        }

        int count = 0;
        for (char stoneChar :  stone.toCharArray()) {
            System.out.println("stoneChar: "+stoneChar);
            if(set.contains(stoneChar)) {
                count++;
            }
        }
        return count;
    }
}
