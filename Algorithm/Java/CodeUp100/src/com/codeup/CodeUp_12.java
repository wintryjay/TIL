package com.codeup;

import java.util.Scanner;

public class CodeUp_12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float a = sc.nextFloat();
        String s = String.format("%.6f", a);
        System.out.println(s);
    }
}