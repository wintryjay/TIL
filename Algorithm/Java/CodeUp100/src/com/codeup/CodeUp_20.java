package com.codeup;

import java.util.Scanner;

public class CodeUp_20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String[] s = a.split("[-]");
        int front = Integer.parseInt(s[0]);
        int back = Integer.parseInt(s[1]);
        System.out.println(String.format("%06d"+"%07d", front, back));
    }
}
