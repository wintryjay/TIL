package Algorithm.Java.StringAndArray;
/*
# Question10. PlusOne(= LinkedList:AddToNumbers)
    Eng: Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.
         The digits are stored such that the most significant digit is at the head of the list,
         and each element in the array contains a single digit.
         You may assume the integer does not contain any leading zero, except the number 0 itself.
    Kor: 음이 아닌 정수를 나타내는 소수 자릿수의 비어 있지 않은 배열이 주어지면, 정수로 1을 증가시킵니다.
         숫자는 목록의 맨 앞에 가장 중요한 숫자가 저장되고 배열의 각 요소에는 한 개의 숫자가 포함됩니다.
         정수에는 숫자 0 자체를 제외한 선행 0이 없다고 가정할 수 있습니다.
    ex1)
    input: [1,2,3]
    output: [1,2,4]
    ex2)
    input: [9,9,9]
    output: [1,0,0,0]
 */
public class T09_PlusOne {

    public static void main(String[] args) {
        int[] digits = {1,2,3};
//    int[] digits = {9,9,9};
//        int[] digits = {9,8,9};
//        int[] digits = {8,9,9};
//        int[] digits = {0,0,1};
//        int[] digits = {0,0};
//        int[] digits = {9,0,0,9};
//        int[] digits = {2,1,9,9,9};


        int[] result = plusOne(digits);
        for(int i : result) System.out.println("val :"+ i);
    }

    public static int[] plusOne(int[] digits) {

        // 1. data structure
        int index = digits.length-1; // 2
        int carry = 1;

        // 2. for, while
        while(index >=0 && carry>0) {

            digits[index] = (digits[index]+1) % 10; // 10으로 나눈 나머지

            if(digits[index]==0) {
                carry=1;
            }else {
                carry=0;
            }

            --index;
        }

        if(carry == 1) {
            digits = new int[digits.length+1]; // {0,0,0,0}
            digits[0] = 1;
        }
        return digits;
    }

}
