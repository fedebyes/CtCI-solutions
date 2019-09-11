package Ch2_Linked_Lists;
import CtCILibrary.CtCILibrary.*;
import CtCILibrary.CtCILibrary.AssortedMethods;
import java.lang.Math;
public class Q2_05 {

    public static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2){

        return intToLinkedList(linkedListToInt(l1)+linkedListToInt(l2));
    }
    private static int linkedListToInt(LinkedListNode l1){
        int number=0;
        int count=0;
        while(l1!=null){

            int a= l1.data* (int) Math.pow(10,count);
            number=number+a;
            l1=l1.next;
            count++;
        }
        System.out.println(number);
        return number;
    }
    private static LinkedListNode intToLinkedList(int n){
        LinkedListNode node=null;
        while(n>0){
            if(node==null){
                node=new LinkedListNode();
            }else{
                node.data=n%10;
                node.next=new LinkedListNode();
                n=n/10;
            }
        }
        node.next=null;
        return node;

    }


    public static void main(String[] args) {
        LinkedListNode lA1 = new LinkedListNode(9, null, null);
        LinkedListNode lA2 = new LinkedListNode(9, null, lA1);
        LinkedListNode lA3 = new LinkedListNode(9, null, lA2);

        LinkedListNode lB1 = new LinkedListNode(1, null, null);
        LinkedListNode lB2 = new LinkedListNode(0, null, lB1);
        LinkedListNode lB3 = new LinkedListNode(0, null, lB2);

        LinkedListNode list3 = addLists(lA1, lB1);

        System.out.println("  " + lA1.printForward());
        System.out.println("+ " + lB1.printForward());
        System.out.println("= " + list3.printForward());

        int l1 = linkedListToInt(lA1);
        int l2 = linkedListToInt(lB1);
        int l3 = linkedListToInt(list3);

        System.out.print(l1 + " + " + l2 + " = " + l3 + "\n");
        System.out.print(l1 + " + " + l2 + " = " + (l1 + l2));
    }

}
