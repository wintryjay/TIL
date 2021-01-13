package Algorithm.LinkedList;
/*
# Question 01. Add Two Numbers(ListNode)
    Eng: You are given two non-empty linked lists representing two non-negative integers.
         The digits are stored in reverse order, and each of their nodes contains a single digit.
         Add the two numbers and return the sum as a linked list.
         You may assume the two numbers do not contain any leading zero, except the number 0 itself.
    Kor: 음이 아닌 두 개의 정수를 나타내는 두 개의 비어 있지 않은 연결 리스트가 제공됩니다.
         숫자는 역순으로 저장되며 각 노드에는 한 자릿수가 포함됩니다.
         두 숫자를 추가하고 합계를 연결 목록으로 반환합니다.
         숫자 0 자체를 제외한 두 숫자에 선행 0이 포함되어 있지 않다고 가정할 수 있습니다.

    input:
        l1 = [2,4,3];
        l2 = [5,6,2];
    output:
        [7,0,6];
 */

import java.util.List;

class ListNode {

    int val;
    ListNode next;
    ListNode(int x) {
        this.val = x;
    }
}

public class T01_AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(2);

        ListNode node = solve(l1, l2);
        while(node !=null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode solve(ListNode l1, ListNode l2) {
        // 1. dummy data
        ListNode newHead = new ListNode(0);
        ListNode p1=l1, p2=l2, p3=newHead;
        int carry = 0;

        // 2.
        while(p1 != null || p2 !=null) {
            if(p1 != null) {
                carry += p1.val;
                p1 = p1.next;
            }
            if(p2 != null) {
                carry += p2.val;
                p2 = p2.next;
            }
            p3.next = new ListNode(carry%10);
            p3 = p3.next;
            carry /=10;
        }
        if(carry ==1) p3.next = new ListNode(1);
        return newHead.next;
    }

}
