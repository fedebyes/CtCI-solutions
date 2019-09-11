package Ch2_Linked_Lists;

import CtCILibrary.CtCILibrary.*;


public class Q2_02_nthToLast {

    public static LinkedListNode nthToLast(LinkedListNode head, int k) {
        LinkedListNode p = head;
        int count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }
        int index = 0;
        p = head;
        while (p != null) {
            if (index == count - k) break;
            else {
                index++;
                p = p.next;
            }

        }
        return p;

    }


    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3};
        LinkedListNode head = AssortedMethods.createLinkedListFromArray(array);
        for (int i = 0; i <= array.length + 1; i++) {
            LinkedListNode node = nthToLast(head, i);
            String nodeValue = node == null ? "null" : "" + node.data;
            System.out.println(i + ": " + nodeValue);
        }
    }
}