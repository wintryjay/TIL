package com.codeup;

import java.util.Scanner;

public class CodeUp_14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        char[] s = a.toCharArray();
        System.out.println(s[2]+" "+s[0]);
    }
}

// 아래의 풀이법은 입력을 2번 받아야 하기 때문에 안된다.
// 문제는 입력이 2개의 문자가 공백으로 구분되어 입력된다고 했기 때문에
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String a = sc.nextLine();
//        String b = sc.nextLine();
//        System.out.println(b+" "+a);
//    }
//}
