package Ch3;
import CtCILibrary.CtCILibrary.AssortedMethods;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class MyQueue<T>{
    Stack s1=new Stack();
    Stack s2= new Stack();
    Integer size=0;
    int active_i=1;

    private void ChangeActive() {
        Stack active;
        Stack deactive;

        if(active_i==2){active=s1; deactive=s2;active_i=1;
            System.out.println("activating 1");}
        else{active=s2; deactive=s1;active_i=2;System.out.println("activating 2");}
        while(!deactive.isEmpty()){
            active.push(deactive.pop());

        }
    }
    public void add(T v) {
        if (active_i == 1) {
            s1.push(v);
        } else {
            ChangeActive();
            s1.push(v);
        }
        size++;

        System.out.println(s1+"");
        System.out.println(s2+"");
    }

    public T remove(){
        if(active_i==1)ChangeActive();
        size--;
        T r= (T) s2.pop();
        System.out.println(s1+"");
        System.out.println(s2+"");
    return r;}

    public Integer size() {
        return  size;
    }
    public T peek(){
        if (active_i == 2) {

        } else {
            ChangeActive();

        }

      return (T) s2.peek();
    }
}


public class Q3_04 {
    public static void main(String[] args) {
        MyQueue<Integer> my_queue = new MyQueue<Integer>();

        // Let's test our code against a "real" queue
        Queue<Integer> test_queue = new LinkedList<Integer>();

        for (int i = 0; i < 100; i++) {
            int choice = AssortedMethods.randomIntInRange(0, 10);
            if (choice <= 5) { // enqueue
                int element = AssortedMethods.randomIntInRange(1, 10);
                test_queue.add(element);
                my_queue.add(element);
                System.out.println("Enqueued " + element);
            } else if (test_queue.size() > 0) {
                int top1 = test_queue.remove();
                int top2 = my_queue.remove();
                if (top1 != top2) { // Check for error
                    System.out.println("******* FAILURE - DIFFERENT TOPS: " + top1 + ", " + top2);
                }
                System.out.println("Dequeued " + top1);
                //System.out.println("Dequeued really " + top2);
            }

            if (test_queue.size() == my_queue.size()) {
                if (test_queue.size() > 0 && test_queue.peek() != my_queue.peek()) {
                    System.out.println("******* FAILURE - DIFFERENT TOPS: " + test_queue.peek() + ", " + my_queue.peek() + " ******");
                }
            } else {
                System.out.println("******* FAILURE - DIFFERENT SIZES ******");
            }
        }
    }
}
