package Ch2_Linked_Lists;
import CtCILibrary.CtCILibrary.*;
public class Q2_04 {

    public static LinkedListNode createLinkedList() {
        /* Create linked list */
        int[] vals = {3, 5, 8, 5, 10, 2, 1};
        LinkedListNode head = new LinkedListNode(vals[0], null, null);
        LinkedListNode current = head;
        for (int i = 1; i < vals.length; i++) {
            current = new LinkedListNode(vals[i], null, current);
        }
        return head;
    }
    public static LinkedListNode partition(LinkedListNode node,int x) {
        LinkedListNode before_start=null;
        LinkedListNode after_start=null;
        LinkedListNode before_end=null;
        LinkedListNode after_end=null;

        while(node!=null){
            LinkedListNode next=node.next;
            node.next=null;
            if(node.data<x){
                if(before_start==null){
                    before_start=node;
                    before_end=before_start;
                }else{
                    before_end.next=node;
                    before_end=node;
                }

            }
            else{
                if(after_start==null){
                    after_start=node;
                    after_end=after_start;
                }else{
                    after_end.next=node;
                    after_end=node;
                }
            }
            node=next;
        }
            if(before_start==null){
                return after_start;
            }
            before_end.next=after_start;

            return before_start;
        }






    public static void main(String[] args) {
        System.out.println(createLinkedList().printForward());

        /* Partition */
        LinkedListNode hA = partition(createLinkedList(), 5);


        /* Print Result */
        System.out.println(hA.printForward());

    }



}
