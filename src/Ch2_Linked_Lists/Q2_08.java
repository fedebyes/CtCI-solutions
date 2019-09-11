package Ch2_Linked_Lists;
import CtCILibrary.CtCILibrary.*;
import CtCILibrary.CtCILibrary.AssortedMethods;
public class Q2_08 {


    public static void main(String[] args) {
        int list_length = 100;
        int k = 10;

        // Create linked list
        LinkedListNode[] nodes = new LinkedListNode[list_length];
        for (int i = 0; i < list_length; i++) {
            nodes[i] = new LinkedListNode(i, null, i > 0 ? nodes[i - 1] : null);
        }
        System.out.println(nodes[0].printForward());

        // Create loop;
        nodes[list_length - 1].next = nodes[list_length - k];

        LinkedListNode loop = FinxxdBeginning(nodes[0]);

        if (loop == null) {
            System.out.println("No Cycle.");
        } else {
            System.out.println(loop.data);
        }
    }

    private static LinkedListNode FinxxdBeginning(LinkedListNode l) {

        LinkedListNode s=l;
        LinkedListNode f=l;
        //if(f!=null)f=f.next;
        while(f!=null){

            s=s.next;
            f=f.next.next;
            if(s==f)break;
        }
        while(l!=f){l=l.next;f=f.next;}
        return l;
    }
}
