package Ch2_Linked_Lists;

import CtCILibrary.CtCILibrary.*;


public class Q2_01_Remove_Dups {
    public static void deleteDups(LinkedListNode head){
        LinkedListNode previous=head;
        LinkedListNode current=previous.next;
        while(current!=null){
            LinkedListNode runner=head;
            while(runner!=current){
                if(runner.data==current.data){
                    LinkedListNode tmp=current.next;
                    previous.next=tmp;
                    break;
                }
                runner=runner.next;
            }
            if(runner==current){
                previous=current;
                current=current.next;
            }
        }

    }

    public static void main(String[] args) {
        LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
        LinkedListNode head = first;
        LinkedListNode second = first;
        for (int i = 1; i < 8; i++) {
            second = new LinkedListNode(i % 2, null, null);
            first.setNext(second);
            second.setPrevious(first);
            first = second;
        }
        System.out.println(head.printForward());
        deleteDups(head);
    }

}
