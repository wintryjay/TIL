package Algorithm.LinkedList;
/*
# Question03. Reverse Linked Lists(ListNode, Pointer)
    Eng: Reverse a singly linked list.
    Kor: 연결된 단일 목록을 거꾸로 합니다.

    input:
        1->2->3->4->5->NULL
    output:
        5->4->3->2->1->NULL
 */
public class T03_ReverseLinkedLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        printNode(l1);
        ListNode head = reverseList(l1);
        printNode(head);
    }

    public static ListNode reverseList(ListNode current) {
        ListNode prev = null;
        ListNode next = null;
        while(current != null) {
            next = current.next; // 2 저장
            current.next = prev; // 1.next 는 null 로 설정
            prev = current; // prev 는 1로 설정
            current = next; // current 값을 2로 재설정
        }
        return prev;
    }

    public static void printNode(ListNode head) {
        System.out.println("printNode: ");
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
        System.out.println();
    }
}
