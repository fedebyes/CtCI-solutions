package Ch2_Linked_Lists;

import CtCILibrary.CtCILibrary.*;
import CtCILibrary.CtCILibrary.AssortedMethods;


public class Q2_07 {




    public static void main(String[] args) {
        /* Create linked list */
        int[] vals = {-1, -2, 0, 1, 2, 3, 4, 5, 6, 7, 8};
        LinkedListNode list1 = AssortedMethods.createLinkedListFromArray(vals);

        int[] vals2 = {12, 14, 15};
        LinkedListNode list2 = AssortedMethods.createLinkedListFromArray(vals2);

        list2.next.next = list1.next.next.next.next;

        System.out.println(list1.printForward());
        System.out.println(list2.printForward());


        LinkedListNode intersection = findIntersection(list1, list2);


        System.out.println(intersection.printForward());
    }

    private static LinkedListNode findIntersection(LinkedListNode list1, LinkedListNode list2) {
        if(list1==null || list2==null)return null;
        LinkedListNode list1_copy=list1;
        LinkedListNode list2_copy=list2;
        Result r1= getLenghtAndTail(list1_copy);
        Result r2=getLenghtAndTail(list2_copy);
        if(r1.tail!=r2.tail) return null;
        LinkedListNode list3=new LinkedListNode();
        if(r1.size>r2.size) {
            for (int i=0;i< r1.size-r2.size;i++){
                list1=list1.next;

            }
        }else{
            for (int i=0;i< r2.size-r1.size;i++){
                list2=list2.next;
            }
        }
        while(list1!=list2){
            list1=list1.next;
            list2=list2.next;
        }



        //System.out.println(list3.printForward()+"ciao");
        return list1;

        //return null;

    }
    static class Result{
        public LinkedListNode tail;
        public int size;
        public  Result(LinkedListNode tail,int size){
            this.tail=tail;this.size=size;
        }
    }
    private static Result getLenghtAndTail(LinkedListNode l){
        int size=0;
        while(l!=null){size++;l=l.next; }
        return new Result(l,size);
    }
}
