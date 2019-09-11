package Ch2_Linked_Lists;
import CtCILibrary.CtCILibrary.*;
import CtCILibrary.CtCILibrary.AssortedMethods;

import java.util.Hashtable;

public class Q2_06 {

    public static void main(String[] args) {
        int max = 11;
        for (int length = 1; length < max; length++) {
            LinkedListNode[] nodes = new LinkedListNode[length];
            for (int i = 0; i < length; i++) {
                nodes[i] = new LinkedListNode(i >= length / 2 ? length - i - 1 : i, null, null);
            }

            for (int i = 0; i < length; i++) {
                if (i < length - 1) {
                    nodes[i].setNext(nodes[i + 1]);
                }
                if (i > 0) {
                    nodes[i].setPrevious(nodes[i - 1]);
                }
            }
            for (int i = -1; i < length; i++) {
                if (i >= 0) {
                    nodes[i].data++; // Ruin palindrome
                }

                LinkedListNode head = nodes[0];
                System.out.println(head.printForward());
                boolean resultA = isPalindrome(head);
                //boolean resultB = QuestionB.isPalindrome(head);
                //boolean resultC = QuestionC.isPalindrome(head);
                System.out.println("A: " + resultA);
                //System.out.println("B: " + resultB);
                //System.out.println("C: " + resultC);

                if (i >= 0) {
                    nodes[i].data--;
                }
            }
        }
    }

    private static boolean isPalindrome(LinkedListNode head) {
        Hashtable<Integer,Integer> h = new Hashtable<>();
        while(head!=null){
            if(!h.containsKey(head.data))h.put(head.data,1);
            else h.put(head.data,h.get(head.data)+1);
            head=head.next;
        }
        int count=0;
        for (int i: h.keySet()){
            if(h.get(i)%2==1)count++;
            if(count>1)return false;
        }
        return true;
    }
}
